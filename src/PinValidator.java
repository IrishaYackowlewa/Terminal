
public class PinValidator {
    private final int pin = 3582;
    private final int maxNumAttempts = 3;

    private int numAttempts = 0;
    private boolean valid = false;

    public boolean isValid() {
        return valid;
    }

    public boolean checkValid (int pin){
        if (this.pin == pin){
            numAttempts = 0;
            valid = true;
            return true;
        }
        else {
            if (numAttempts < maxNumAttempts){
                numAttempts++;
                valid = false;
                return false;
            }
            //else {
                //внести время блокировки...
            //}
        }
        return false;//кинуть исключение что что-то случилось
    }
}
