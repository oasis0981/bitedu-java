package student.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GisaQuizDB {
    public String solveQuiz1(){
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student",
                    "root",
                    "0000"
            );
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "" +
                ""

        return
    }

    public String solveQuiz2(){

        return
    }

    public String solveQuiz3(){

        return
    }

    public String solveQuiz4(){

        return
    }
}
