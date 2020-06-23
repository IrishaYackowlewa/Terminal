import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TerminalServer server = new TerminalServer();
        PinValidator pinVal = new PinValidator();
        TerminalImpl user = new TerminalImpl(server,pinVal);

        Scanner in = new Scanner(System.in);
        System.out.println("Пожалуйста, введите пин-код: ");
	    int pin = in.nextInt();
	    boolean f = true;
        while (f){
            try {
                if (pinVal.checkValid(pin)){
                    System.out.println("Выберете нужное действие ");
                    System.out.println("1 - Посмотреть баланс ");
                    System.out.println("2 - Пополнить счет ");
                    System.out.println("3 - Снять деньги ");
                    System.out.println("4 - Завершить обслуживание ");
                    int flag = in.nextInt();
                     switch (flag){
                         case (1):
                             try {
                                 user.checkBalance();
                             } catch (AccountIsLockedException e) {
                                 System.out.println("Извините. Система заблокированна. Попробуйте еще раз через ");
                             } catch (Exception e) {
                                 e.printStackTrace();//////
                             }
                             break;
                         case (2):
                             System.out.println("Введите сумму: ");
                             int amount = in.nextInt();
                             try {
                                 user.replenishAccount(amount);
                             } catch (AccountIsLockedException e) {
                                 System.out.println("Извините. Система заблокированна. Попробуйте еще раз через ");
                             } catch (Exception e) {
                                 e.printStackTrace();////
                             }
                             break;
                         case (3):
                             System.out.println("Введите сумму, которую хотите снять: ");
                             int sum = in.nextInt();
                             try {
                                 user.withdrawMoney(sum);
                             } catch (AccountIsLockedException e) {
                                 System.out.println("Извините. Система заблокированна. Попробуйте еще раз через ");
                             } catch (Exception e) {
                                 e.printStackTrace();////
                             }
                             break;
                         case (4):
                             f = false;
                             break;
                     }
                }
                else {
                    System.out.println("Некорректный пин-код");
                    System.out.println("Пожалуйста, введите пин-код еще раз: ");
                    pin = in.nextInt();
                }
            } catch (AccountIsLockedException e) {
                System.out.println("Извините. Система заблокированна. Попробуйте еще раз через ");
            } catch (Exception e) {
                System.out.println("Ошибка системы. Попробуйте еще раз.");
            }
        }
    }
}
