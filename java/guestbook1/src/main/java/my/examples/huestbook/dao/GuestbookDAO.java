package my.examples.huestbook.dao;

import my.examples.huestbook.servlet.Guestbook;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDAO {
    private String dbURL = "jdbc:mysql://localhost:3306/connectdb?useSSL=false& serverTimezone=UTC";
    private String dbId = "root";
    private String dbPassword = "root";

    public List<Guestbook> getGuestbookList(String pg){
        List<Guestbook> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs =null;


        // 카운트 추가해주기
        conn = DbUtil.connect(dbURL, dbId, dbPassword);
        String sql = "SELECT rownum, id, name, content, regdate\n" +
                "FROM(SELECT ROW_NUMBER() OVER (ORDER BY id DESC) AS rownum,id, name, content,regdate\n" +
                "       FROM guestbook ) subquery WHERE rownum BETWEEN ? and ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,(Integer.parseInt(pg)*10-9)+"");
            ps.setString(2,Integer.parseInt(pg)*10+"");
            rs = ps.executeQuery();

            while(rs.next()){
                Guestbook guestbook = new Guestbook();
                guestbook.setId(rs.getLong("id"));
                guestbook.setName(rs.getString("name"));
                guestbook.setContent(rs.getString("content"));
                Date dbDate = rs.getDate("regdate");
                guestbook.setRownum(rs.getInt("rownum"));
                java.util.Date date = new java.util.Date(dbDate.getTime());
                LocalDateTime ldt = date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                guestbook.setRegate(ldt);
                list.add(guestbook);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn, ps,rs);
        }

        return list;
    }

    public int addGuestbook(Guestbook guestbook){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.connect(dbURL,dbId,dbPassword);
            String sql =  "insert into guestbook (id, name, content, regdate)\n" +
                    "values (null, ?, ?, now())";
            ps = conn.prepareStatement(sql);
            ps.setString(1,guestbook.getName());
            ps.setString(2,guestbook.getContent());
            count=ps.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            DbUtil.close(conn, ps);
        }

        return count;

    }
    public int deleteGuestbook(Long id){
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DbUtil.connect(dbURL, dbId, dbPassword);
            String sql = "delete from guestbook where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            count = ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DbUtil.close(conn, ps);
        }
        return count;
    }
}
