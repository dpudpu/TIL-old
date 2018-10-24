package student.management.dao;

import student.management.dto.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private String dbURL;
    private String dbId;
    private String dbPassword;

    public int addStudent(Student student){
        int result=0;
        Connection conn = null;
        PreparedStatement ps = null;


        try {
            String sql ="insert into student(name, korean, english,math)\n" +
                    "VALUES (?,?,?,?)";
            conn=DbUtil.connect(dbURL,dbId, dbPassword);
            ps=conn.prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setInt(2,student.getKorean());
            ps.setInt(3,student.getEnglish());
            ps.setInt(4,student.getMath());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtil.close(conn,ps);
        }

        return result;
    }

    public List<Student> getList(){
        List<Student> list=new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        try {
            conn = DbUtil.connect(dbURL, dbId, dbPassword);
            String sql = "SELECT name, korean, english, math FROM student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Student student=new Student();
                student.setName(rs.getString("name"));
                student.setKorean(rs.getInt("korean"));
                student.setEnglish(rs.getInt("english"));
                student.setMath(rs.getInt("math"));
                list.add(student);
            }
        }catch (SQLException e) {
                e.printStackTrace();
        }


        return list;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
}
