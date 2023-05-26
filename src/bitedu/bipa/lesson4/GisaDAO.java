package bitedu.bipa.lesson4;

import java.sql.*;

public class GisaDAO {
    // DB 관련 작업 전용 클래스

    // 1번 문제
    public int selectQuiz1(String sql) throws SQLException {
        int stdNo = 0;
        Connection con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            stdNo = rs.getInt(1);
        }
        ConnectionManager.closeConnection(rs, stmt, con);


       return stdNo;
    }

    public int selectQuiz2(String sql) throws SQLException, ClassNotFoundException {
        int score = 0;
        Connection con = ConnectionManager.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                score = rs.getInt(1);
            }
            rs.close();
            stmt.close();
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return score;
    }

    public int selectQuiz3(String sql){
        int sum = 0;
        Connection con = ConnectionManager.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                sum+= rs.getInt(1);
            }
            rs.close();
            stmt.close();
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return sum;
    }

    public int selectQuiz4(String sql){
        int cnt = 0;
        Connection con = ConnectionManager.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                if (rs.getInt(2) >= 50) {
                    cnt ++;
                }
            }
            rs.close();
            stmt.close();
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return cnt;
    }


}
