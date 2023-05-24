package student.manager;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class FileSaveDB {
    public static void main(String[] args) {
        Connection conn = null;
        File csv = new File("Abc1115.csv");
        BufferedReader reader;
        String line ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    "0000"
            );

            System.out.println("연결 성공");

            String sql = "" +
                    "INSERT INTO studentinfo (id, email, kor, eng, math, sci, hist, total, teacher, acc, reg) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            int rows= 0;
            reader = new BufferedReader(new FileReader(csv));
            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split(",");
                pstmt.setString(1, lineArr[0]);
                pstmt.setString(2, lineArr[1]);
                pstmt.setString(3, lineArr[2]);
                pstmt.setString(4, lineArr[3]);
                pstmt.setString(5, lineArr[4]);
                pstmt.setString(6, lineArr[5]);
                pstmt.setString(7, lineArr[6]);
                pstmt.setString(8, lineArr[7]);
                pstmt.setString(9, lineArr[8]);
                pstmt.setString(10, lineArr[9]);
                pstmt.setString(11, lineArr[10]);
                rows = pstmt.executeUpdate();
            }
            System.out.println("저장된 행 수 : " + rows);

            pstmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException ignored) {
                }
            }
    }
}

}
