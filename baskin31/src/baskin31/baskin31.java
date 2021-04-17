package baskin31; 
import java.util.Scanner;
 
public class baskin31 {
    
    static Scanner s = new Scanner(System.in);
    static int meWin = 0;
    static int comWin = 0;
 
    public static void main(String[] args) {
        
        while(true)
        {
            System.out.println("==== ����Ų���31 ���� ====");
            System.out.println();
            System.out.println("1. ���ӽ���");
            System.out.println("2. ���� ����");
            System.out.println("3. ���� ��");
            System.out.print("\n> ");
            
            int menuSelect = s.nextInt();
            
            if(menuSelect == 1) {
              game();
            } else if(menuSelect == 2) {
                System.out.println("\n=== SCORE ====\n");    
                System.out.println("Me Win: " + meWin);
                System.out.println("Com Win: " + comWin);
                if (meWin == 0 && comWin == 0)
                    System.out.println("���� ������ �������� �����̱���? ������ ���� �غ�����!");
                System.out.println();
            } else if(menuSelect == 3) {
                System.out.println("\n�÷��� ���ּż� �����մϴ�!");
                System.exit(0);
            }
            else {
                System.out.println("��ȣ�� �Է� ���ּ���! (1~3)\n");
            }                        
        }
 
    }
    
    public static void game()
    {
        System.out.println();
        System.out.println("<< ���ӽ��� >>");
        
        int lastNum = 0;        
        
        while(true) {    
            
            // =======����� ��=========
            int userNum = 1;
            while(true) {
                
                System.out.print("��ȣ �Է�(1~3) >> ");
                userNum = s.nextInt();
                
                if (1 <= userNum && userNum <= 3)
                    break;
                else
                    System.out.println("���ڸ� �ٽ� �Է��ϼ���. (1~3)\n");
            }                
            
            // ���� ��ġ��(���)
            for(int i = (lastNum + 1); i <= lastNum + userNum; i++) {
                
                if ( i > 31 ) {
                    break;
                }
                System.out.println(i + " " + "!");                 
            }
            
            lastNum += userNum;
            if (lastNum >= 31) {
                //System.out.println(lastNum);
                System.out.println("\n����� �й��Դϴ�. ����Ų�� �¸��Դϴ�.\n");
                comWin++;
                break;
            }
                
            System.out.println();
                
            // =======����Ų ��=========           
            System.out.println("����Ų ��!");
            
            int comNum = 0;
            
            if ( lastNum == 27 )    // lasNum�� 27�϶� ������ 3(28, 29, 30)
                comNum = 3;
            else if ( lastNum == 28 )    // lasNum�� 28�϶� ������ 2(29, 30)
                comNum = 2;
            else if ( lastNum == 29 )    // lasNum�� 29�϶� ������ 1(30)
                comNum = 1;
            else
                comNum = (int)( Math.random() * (3 - 1 + 1)  + 1 );    // 1~3
            
            // ���� ��ġ��(��)
            for(int i = (lastNum + 1); i <= lastNum + comNum; i++) {
                        
                if ( i > 31 ) {
                    break;
                }
                System.out.println(i + " " + "!");      
            }
            
            lastNum += comNum;
            
            if (lastNum >= 31) {
                System.out.println("\n ����Ų�� �й��Դϴ�. ����� �¸��Դϴ�.\n");
                meWin++;
                break;
            }
                
            System.out.println();
        }
    }
 
}