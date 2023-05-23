package student.manager;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCenter {
    public static void main(String[] args) throws IOException {
        List<List<String>> csvList = new ArrayList<>();
        File csv = new File("lottoExample/Abc1115.csv");
//            String path = "lottoExample/Abc1115.txt";
        BufferedReader reader;
        String line ;

        try {
            reader = new BufferedReader(new FileReader(csv));
            while ((line = reader.readLine()) != null) {
                String[] lineArr = line.split(",");
                List<String> aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
//                System.out.println(line);
            }
            System.out.println(csvList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    public void startTest() {
        System.out.println("시험지를 배부합니다.");
        ArrayList<StudentVO> data = null;
        data = this.readyData();
        System.out.println("시험을 시작합니다.");
        GisaQuiz quiz = new GisaQuiz(data);
        String answer = quiz.solveQuiz1();
        this.submitAnswer(1, answer);
        answer = quiz.solveQuiz2();
        this.submitAnswer(2, answer);
        answer = quiz.solveQuiz3();
        this.submitAnswer(3, answer);
        answer = quiz.solveQuiz4();
        this.submitAnswer(4, answer);
        System.out.println("답안지를 모두 제출합니다.");
        System.out.println("시험을 종료합니다.");
    }

    private ArrayList<StudentVO> readyData() {
        return null;
    }

    private void submitAnswer(int num, String answer){

    }
}
