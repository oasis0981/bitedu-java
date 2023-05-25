package bitedu.bipa.lesson2;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseWork {

    public void insertData(ArrayList<StudentDTO> data) throws SQLException, ClassNotFoundException {
        // DB에 1000개의 record(DTO)를 저장 : 데이터는 만들지 않음
        // 데이터를 받아서 DB 관련 작업을 할 예정
        System.out.println(data.size());
        System.out.println(data.get(0));
        this.testConnection();
        this.insert(data);

    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con= null;
        String jdbcURL = "jdbc:mysql://localhost:3306/student";
        String driver = "com.mysql.cj.jdbc.Driver";
        String id = "root";
        String password = "0000";

        Class.forName(driver);
        con = DriverManager.getConnection(jdbcURL,id,password);

        return con;
    }

    public void testConnection(){
        try {
            Connection con = this.getConnection();
            if (con != null) {
                System.out.println("연결됨");
                con.close();
            } else {
                System.out.println("failed");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(ArrayList<StudentDTO> list) throws SQLException, ClassNotFoundException {
        Connection con = this.getConnection();

        //SQL 작성
        String sql = "" +
                "INSERT INTO studentinfo VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        // 쿼리 전송 통로 생성
        PreparedStatement pstmt = con.prepareStatement(sql);

        for(StudentDTO dto: list) {
            // 통로를 통해서 쿼리 실행
            pstmt.setInt(1, dto.getStdNo());
            pstmt.setString(2, dto.getEmail());
            pstmt.setInt(3, dto.getKor());
            pstmt.setInt(4, dto.getEng());
            pstmt.setInt(5, dto.getMath());
            pstmt.setInt(6, dto.getSci());
            pstmt.setInt(7, dto.getHist());
            pstmt.setInt(8, dto.getTotal());
            pstmt.setString(9, dto.getTeacherCode());
            pstmt.setString(10, dto.getAccCode());
            pstmt.setString(11, dto.getLocCode());
            pstmt.executeUpdate();
        }


        // 통로 정리
        pstmt.close();

        // 커넥션 정리
    }

    public ArrayList<StudentDTO> getStudentData() throws SQLException, ClassNotFoundException {

        ArrayList<StudentDTO> data = new ArrayList<>();

        //DB의 데이터를 가져와서 List로 변경

        // 커넥션생성
        Connection con = this.getConnection();

        // 쿼리 생성
        String sql = "select * from studentinfo";

        // 쿼리 통로 생성
        Statement stmt = con.createStatement();

        // 쿼리 실행
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            // 쿼리 결과 받고 처리하기(list로 변경)
            StudentDTO student = new StudentDTO(
                rs.getInt("id"), rs.getString("email"), rs.getInt("kor"),
                    rs.getInt("eng"), rs.getInt("math"), rs.getInt("sci"), rs.getInt("hist"),
                    rs.getInt("total"), rs.getString("teacher"), rs.getString("acc"), rs.getString("reg")
            );
            data.add(student);
        }

        System.out.println("data 받아옴: " + data.size());
        // 통로 정리
        stmt.close();

        // 커넥션 정리
        con.close();


        return data;
    }
}
