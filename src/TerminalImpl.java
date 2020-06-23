class TerminalImpl implements Terminal{
    private final TerminalServer server;
    private final PinValidator pinValidator;

    TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public void checkBalance () throws Exception{
        if (pinValidator.isValid()){
            System.out.println(server.getBalance());
        }
        else throw new AccountIsLockedException();
    }

    @Override
    public void withdrawMoney (int sum) throws Exception{
        if (pinValidator.isValid()){
            server.withdrawMoney(sum);
        }
        else throw new AccountIsLockedException();
    }

    @Override
    public void replenishAccount(int sum) throws Exception{
        if (pinValidator.isValid()){
            server.replenishAccount(sum);
        }
        else throw new AccountIsLockedException();
    }

}

