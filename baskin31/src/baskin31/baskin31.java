package baskin31; 
import java.util.Scanner;
 
public class baskin31 {
    
    static Scanner s = new Scanner(System.in);
    static int meWin = 0;
    static int comWin = 0;
 
    public static void main(String[] args) {
        
        while(true)
        {
            System.out.println("==== 베스킨라빈스31 게임 ====");
            System.out.println();
            System.out.println("1. 게임시작");
            System.out.println("2. 게임 점수");
            System.out.println("3. 게임 끝");
            System.out.print("\n> ");
            
            int menuSelect = s.nextInt();
            
            if(menuSelect == 1) {
              game();
            } else if(menuSelect == 2) {
                System.out.println("\n=== SCORE ====\n");    
                System.out.println("Me Win: " + meWin);
                System.out.println("Com Win: " + comWin);
                if (meWin == 0 && comWin == 0)
                    System.out.println("아직 게임을 시작하지 않으셨군요? 게임을 먼저 해보세요!");
                System.out.println();
            } else if(menuSelect == 3) {
                System.out.println("\n플레이 해주셔서 감사합니다!");
                System.exit(0);
            }
            else {
                System.out.println("번호를 입력 해주세요! (1~3)\n");
            }                        
        }
 
    }
    
    public static void game()
    {
        System.out.println();
        System.out.println("<< 게임시작 >>");
        
        int lastNum = 0;        
        
        while(true) {    
            
            // =======사용자 턴=========
            int userNum = 1;
            while(true) {
                
                System.out.print("번호 입력(1~3) >> ");
                userNum = s.nextInt();
                
                if (1 <= userNum && userNum <= 3)
                    break;
                else
                    System.out.println("숫자를 다시 입력하세요. (1~3)\n");
            }                
            
            // 숫자 외치기(사람)
            for(int i = (lastNum + 1); i <= lastNum + userNum; i++) {
                
                if ( i > 31 ) {
                    break;
                }
                System.out.println(i + " " + "!");                 
            }
            
            lastNum += userNum;
            if (lastNum >= 31) {
                //System.out.println(lastNum);
                System.out.println("\n당신의 패배입니다. 베스킨의 승리입니다.\n");
                comWin++;
                break;
            }
                
            System.out.println();
                
            // =======베스킨 턴=========           
            System.out.println("베스킨 턴!");
            
            int comNum = 0;
            
            if ( lastNum == 27 )    // lasNum이 27일때 무조건 3(28, 29, 30)
                comNum = 3;
            else if ( lastNum == 28 )    // lasNum이 28일때 무조건 2(29, 30)
                comNum = 2;
            else if ( lastNum == 29 )    // lasNum이 29일때 무조건 1(30)
                comNum = 1;
            else
                comNum = (int)( Math.random() * (3 - 1 + 1)  + 1 );    // 1~3
            
            // 숫자 외치기(컴)
            for(int i = (lastNum + 1); i <= lastNum + comNum; i++) {
                        
                if ( i > 31 ) {
                    break;
                }
                System.out.println(i + " " + "!");      
            }
            
            lastNum += comNum;
            
            if (lastNum >= 31) {
                System.out.println("\n 베스킨의 패배입니다. 당신의 승리입니다.\n");
                meWin++;
                break;
            }
                
            System.out.println();
        }
    }
 
}