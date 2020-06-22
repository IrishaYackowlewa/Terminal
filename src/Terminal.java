public interface Terminal {
    void checkBalance () throws Exception;

    void withdrawMoney (int sum) throws Exception;

    void replenishAccount(int sum) throws Exception;
}
