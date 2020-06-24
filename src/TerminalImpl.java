class TerminalImpl implements Terminal{
    private final TerminalServer server;
    private final PinValidator pinValidator;

    TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public void checkBalance () throws Exception{
        if (!pinValidator.isBlock()){
            System.out.println(server.getBalance());
        }
        else throw new AccountIsLockedException();
    }

    @Override
    public void withdrawMoney (int sum) throws Exception{
        if (!pinValidator.isBlock()){
            server.withdrawMoney(sum);
        }
        else throw new AccountIsLockedException();
    }

    @Override
    public void replenishAccount(int sum) throws Exception{
        if (!pinValidator.isBlock()){
            server.replenishAccount(sum);
        }
        else throw new AccountIsLockedException();
    }

    public void stillTimeLeft (){
        pinValidator.stillTimeLeft();
    }

    public void close (){
        pinValidator.closeTimer();
    }

}

