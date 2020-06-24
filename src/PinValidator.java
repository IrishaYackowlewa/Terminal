import java.util.Timer;
import java.util.TimerTask;

public class PinValidator {
    private final int pin = 3582;
    private final int maxNumAttempts = 3;

    private int numAttempts = 1;
    private boolean block = false;

    private Timer timer = new Timer();
    private Long startTime;
    private final static long TIME = 5*1000;

    public boolean isBlock() {
        return block;
    }

    public boolean checkValid (int pin) throws Exception{
        if (block)
            throw new AccountIsLockedException();
        if (this.pin == pin){
            numAttempts = 0;
            return true;
        }
        else {
            if (numAttempts < maxNumAttempts){
                numAttempts++;
                throw new IncorrectPinCodeException();
            }
            else {
                block = true;
                startTime = System.currentTimeMillis();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        block = false;
                        numAttempts = 0;
                    }
                }, TIME);
                throw new AccountIsLockedException();
            }
        }
    }

    public void stillTimeLeft (){
        System.out.println("Извините. Система заблокированна. Попробуйте еще раз через " + (TIME + startTime -
                System.currentTimeMillis())/1000 + " cек.");
    }

    public void closeTimer(){
        timer.cancel();
    }
}
