package my.examples.jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlExam01 {
    public static void main(String args[]) throws Exception{


        // 2. 커넥션과 관련된 interface를 선언한다
        // JDBC URL은 DMBS마다 형식이 다르다.
        // 커넥션은 반드시 finally에서 close한다.
        Connection conn = null;

        //3. SQL을 실행하기 위한 interface를 선언한다.
        // Connection에게 sql을 DMBS로 보내달라고 보냄.
        // DBMS는 SQL을 준비해주고 ps는 준비된 sql을 참조
        PreparedStatement ps = null;
        // Statement 사용XXXXXXXXXXXXXXXXXXXXXXX

        //4. 결과를 읽어오기 위한 interface를 선언.
        // SQL이 실행된 결과를 ResultSet이 하나씩 가져옴
        ResultSet rs = null;

        try {
            // 1. Driver 등록
            Class.forName("com.mysql.jdbc.Driver");

            //5. SQL 준비한다.
            String sql = "SELECT role_id, description FROM ROLE where role_id=?";

            // 커넥션을 연결한다.(db와 접속)
            // H2에 접속하기 위한 Connection 인스턴스 리턴
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/docker","root","password");

            //db에 sql을 준비해달ㄹ라고 한다.
            // ps는 db안에서 준비된 sql을 참조하는 변수.
            ps = conn.prepareStatement(sql);
            ps.setInt(1,100); // 바인딩 한다.

            //준비된 sql을 실행하게 한다. 실행한 결과는 dbms에 있다.
            // rs는 실행된 결과를 참조하는 변수
            // executeQuery() : select문 실행, executeUpdate() : insert, update, delete
            rs = ps.executeQuery();

            // 한건의 data를 읽어온다. 한건의 data는 여러개의 컬럼으로 구성되어 있다.
            // next()가 호출되면 한건을 읽어오는데 그 결과는 ResultSet이 가지고 있다.
            if(rs.next()){
                int roleId = rs.getInt(1);
                String des = rs.getString(2);
                System.out.println(roleId+", "+des);
            }else
                System.out.println("데이터가 없다.");

        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            conn.close();
            ps.close();
            rs.close();
        }

    }
}
