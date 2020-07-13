package MySqlTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 特定のQueryのStatementを用意して実行するクラス (Data Access Object)
 */
public class TestUserDAO {
    String name = "";
    String password = "";

    /**
     * Select with user_name and password column
     * @param name     : String to identify user_name column
     * @param password : String to identify password column
     */
    public void select(String name, String password) {
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();
        String sql ="select * from test_table where user_name=? and password=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString (2, password);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("user_name"));
                System.out.println(rs.getString("password"));
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        }

        try {
            con.close() ;
        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }


    /**
     * Select all records
     */
    public void selectAll() {
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();
        String sql ="select * from test_table";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("user_name"));
            System.out.println(rs.getString("password"));
        }
        } catch (SQLException e ) {
            e.printStackTrace();
       }
       try {
            con.close() ;
        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }

    /**
     * Select with user_name
     * @param name : String to identify user_name column
     */
    public void selectByName(String name) {
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();
        String sql ="select * from test_table where user_name=?";

        try {
        PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("user_name"));
            System.out.println(rs.getString("password"));
        }
        } catch (SQLException e ) {
            e.printStackTrace();
       }
       try {
            con.close() ;
        } catch (SQLException e ) {
           e.printStackTrace();
        }
    }

    /**
     * Select with password
     * @param password : String to identify password column
     */
    public void selectByPassword(String password) {
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();
        String sql ="select * from test_table where password=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString (1, password);
            ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("user_name"));
            System.out.println(rs.getString("password"));
        }
        } catch (SQLException e ) {
            e.printStackTrace();
       }
       try {
            con.close() ;
        } catch (SQLException e ) {
           e.printStackTrace();
        }
    }

    /**
     * Update user_name by current user_name and new user_name
     * @param oldName : 変更を行いたいレコードの現在のuser_name
     * @param newName : 変更後のuser_name
     */
    public void updateUserNameByUserName(String oldName, String newName) {
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();
        String sql ="update test_table set user_name=? where user_name=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newName);
            ps.setString (2, oldName);
            int i=ps.executeUpdate();
        if (i>0) {
            System.out.println(i + "件更新されました");
        }else{
            System.out.println("該当するデータはありませんでした");
        }
        } catch (SQLException e ) {
            e.printStackTrace();
       }

       try {
            con.close() ;
        } catch (SQLException e ) {
            e.printStackTrace();
        }
    }

    /**
     * Insert record
     * @param user_id  : String to set to user_id column
     * @param name     : String to set to user_name column
     * @param password : String to set to password column
     */
    public void insert(int user_id, String name, String password) {
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();
        String sql ="insert into test_table values(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setString(2, name);
            ps.setString (3, password);
            int i=ps.executeUpdate();
        if (i>0) {
            System.out.println(i + "件登録されました");
        }
        } catch (SQLException e ) {
            e.printStackTrace();
       }
       try {
            con.close() ;
        } catch (SQLException e ) {
           e.printStackTrace();
        }
    }
}