package bitedu.bipa.lesson3;

import java.sql.*;

public class GisaDAO {
    // DB 관련 작업 전용 클래스

    // 1번 문제
    public int selectQuiz1(String sql) throws SQLException, ClassNotFoundException {
        int stdNo = 0;
        Connection con = this.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                stdNo = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

       return stdNo;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        String jdbcURL = "jdbc:mysql://localhost:3306/student";
        String driver = "com.mysql.cj.jdbc.Driver";
        String id = "root";
        String password = "0000";

        Class.forName(driver);
        con = DriverManager.getConnection(jdbcURL,id,password);
        return con;
    }
}
