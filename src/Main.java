import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TerminalServer server = new TerminalServer();
        PinValidator pinVal = new PinValidator();
        TerminalImpl user = new TerminalImpl(server,pinVal);

        Scanner in = new Scanner(System.in);
        System.out.println("Пожалуйста, введите пин-код: ");
	    int pin = in.nextInt();
	    boolean repeat = true;
        while (repeat) {
            try {
                if (pinVal.checkValid(pin)) {
                    System.out.println("Выберете нужное действие ");
                    System.out.println("1 - Посмотреть баланс ");
                    System.out.println("2 - Пополнить счет ");
                    System.out.println("3 - Снять деньги ");
                    System.out.println("4 - Завершить обслуживание ");
                    int flag = in.nextInt();
                    switch (flag) {
                        case (1):
                            user.checkBalance();
                            break;
                        case (2):
                            System.out.println("Введите сумму: ");
                            int amount = in.nextInt();
                            user.replenishAccount(amount);
                            break;
                        case (3):
                            System.out.println("Введите сумму, которую хотите снять: ");
                            int sum = in.nextInt();
                            user.withdrawMoney(sum);
                            break;
                        case (4):
                            repeat = false;
                            in.close();
                            pinVal.timer.cancel();//бред... бредятина
                            break;
                    }
                } else {
                    System.out.println("Некорректный пин-код");
                    System.out.println("Пожалуйста, введите пин-код еще раз: ");
                    pin = in.nextInt();
                }
            } catch (AccountIsLockedException e) {
                System.out.println("Извините. Система заблокированна. Попробуйте еще раз через ");
                pin = in.nextInt();
            } catch (NotEnoughMoneyException e) {
                System.out.println("Недостаточно денег на счете");
            } catch (IncorrectAmountException e) {
                System.out.println("Сумма должна быть кратна 100");
            } catch (NegativeAmountException e) {
                System.out.println("Сумма не должна быть отрицательной");
            } catch (Exception e) {
                System.out.println("Ошибка системы. Попробуйте еще раз.");
            }
        }
    }
}
