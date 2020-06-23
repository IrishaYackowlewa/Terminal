class Exceptions  extends Exception{
    public Exceptions() {
    }

    public Exceptions(String sms) {
        super(sms);
    }
}

class AccountIsLockedException  extends Exceptions{
}

//class IncorrectPinCodeException  extends Exceptions{
//}

//class NoAccessException  extends Exceptions{
//}

class NotEnoughMoneyException  extends Exceptions{
}

class IncorrectAmountException  extends Exceptions{
}

class NegativeAmountException  extends Exceptions{
}