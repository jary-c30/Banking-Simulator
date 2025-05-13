interface BankAccountInterface extends Comparable<mainBankAccount>{

    //putting the amount of money the user wants to put in
    void deposit(double putIn);

    //taking out money depending on how much the user wants
    void withdraw(double takeOut);
    
}