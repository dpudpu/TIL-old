package my.examples.huestbook.dao;

import java.sql.*;

public class DbUtil {

    public static Connection connect(String dbUrl, String dbId, String dbPassword) throws RuntimeException{
        Connection conn=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbId, dbPassword);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(conn,ps);
    }



}
