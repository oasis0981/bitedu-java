package Baseball.add;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameService {
    public static void main(String[] args) {
        GameService gs = new GameService();
        gs.makeSystemNum();
        gs.getUserNumber();

    }

    private List<Integer> systemNumber;
    private List<Integer> userNumber;

    public int random(){
        Random rnd = new Random();
        int random = rnd.nextInt(9);
        return random;
    }


    public void makeSystemNum(){
        Random ran = new Random();
        int firstNum = ran.nextInt(8);
        while (systemNumber.size() < 5){

            if (systemNumber.isEmpty()){
                systemNumber.add(firstNum + 1);
            }

            int containNum = random();
            if (systemNumber.contains(containNum)){
                continue;
            }else {
                systemNumber.add(containNum);
            }
        }
    }

    public void getUserNumber() {
        Scanner sc = new Scanner(System.in);
        int userNum = sc.nextInt();
        String number = Integer.toString(userNum);
        for (int i = 0; i < 4; i++){
            char user = number.charAt(i);
            int num = Character.getNumericValue(user);
            if (userNumber.contains(num)) {
                return;
            }else {
                userNumber.add(num);
            }
        }
    }

    public void startGame(){

    }
}