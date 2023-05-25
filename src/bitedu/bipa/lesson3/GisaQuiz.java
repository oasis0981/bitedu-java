package bitedu.bipa.lesson3;


import bitedu.bipa.lesson2.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class GisaQuiz {
    private GisaDAO dao;
    public GisaQuiz(){
        dao = new GisaDAO();
    }

    public String solveQuiz1() throws SQLException, ClassNotFoundException {
        String answer = null;

        // 로직 처리(SQL)
        StringBuffer sb = new StringBuffer("select id from studentinfo ");
        sb.append("where reg = 'B' ");
        sb.append("order by (kor+eng) desc, id asc limit 4,1");
        String sql = sb.toString();

        int stdNo = dao.selectQuiz1(sql);
        answer = String.valueOf(stdNo);

        return answer;
    }

    public String solveQuiz2(){
        String answer = null;


        return answer;
    }
    public String solveQuiz3(){
        String answer = null;


        return answer;
    }
    public String solveQuiz4(){
        String answer = null;


        return answer;
    }
}
