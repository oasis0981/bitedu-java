package student.manager;

import bitedu.bipa.test.LottoBall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GisaQuiz {
    private ArrayList<StudentVO> dataList;

    public GisaQuiz(ArrayList<StudentVO> dataList) {
        this.dataList = dataList;
    }

    public String solveQuiz1(){

        // 지역코드 B 인것만 임시 배열 생성
        ArrayList<StudentVO> tmpList = new ArrayList<>();
        for (StudentVO student: dataList){
            if (student.getLocCode().equals("B")){
                tmpList.add(student);
            }
        }

        // 국어+영어 점수로 내림차순 정렬
        tmpList.sort(new Comparator<>() {
            @Override
            public int compare(StudentVO s1, StudentVO s2) {
                int order = Integer.compare(s2.getKor() + s2.getEng(), s1.getKor() + s1.getEng());
                if (order == 0){
                    order = Integer.compare(s1.getStdNo(), s2.getStdNo());
                }
                if (order == 0){
                    order = s1.getEmail().compareTo(s2.getEmail());
                }
                return order;
            }
        });

//        for (StudentVO st: tmpList) {
//            System.out.print(st.getStdNo() + " ");
//            System.out.println(st.getKor() + st.getEng());
//        }

        // 정답 배열에 생성 후 5번째 학생을 추가
        ArrayList<StudentVO> ansList = new ArrayList<>();
        int selectedNum = tmpList.get(4).getEng() + tmpList.get(4).getKor();

        // 동점자 확인
        for (StudentVO student: tmpList){
            if (student.getKor() + student.getEng() == selectedNum){
                ansList.add(student);
            } else if (student.getKor() + student.getEng() < selectedNum){
                break;
            }
        }

        System.out.print("문제 1의 정답은 ");

        // 정답 문자열 생성
        String answer = "";
        for (StudentVO student: ansList){
            answer += (student.getStdNo()+ " ");
        }

        System.out.println(answer);

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
