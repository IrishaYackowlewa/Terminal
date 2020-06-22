class TerminalImpl implements Terminal{
    private final TerminalServer server;
    private final PinValidator pinValidator;

    TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    public void checkBalance () throws Exception{
        if (pinValidator.isValid()){
            System.out.println(server.getBalance());
        }
        else throw new Exception();//уточнить какой именно нет доступа
    }

    public void withdrawMoney (int sum) throws Exception{
        if (pinValidator.isValid()){
            server.withdrawMoney(sum);
        }
        else throw new Exception();//уточнить какой именно нет доступа
    }

    public void replenishAccount(int sum) throws Exception{
        if (pinValidator.isValid()){
            server.replenishAccount(sum);//возвращает сумму
        }
        else throw new Exception();//уточнить какой именно нет доступа
    }

}

