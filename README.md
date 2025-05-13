I will be creating classes that would resonate a bank account. The classes I would make are mainBankAccount (the parent class/superclass) and savingsAccount (the subclass).
The mainBankAccount will have methods that would function like any other bank account. For example, it will have functions where you can pay a bill, deposit money, withdraw money, a split money calculator, and a function where a manager can organize bank accounts by first name (this can only be used if the client name is "manager").

Creating a mainBankAccount (example):
mainBankAccount jen = new mainBankAccount(String clientName, double amount);

If clientName is not given, it will be defaulted to "user".
If amount is not given, it will be defaulted to 0.
Functions that are in the mainBankAccount:
Constructor, setters/getters, deposit(), withDraw(), splitCalculator(), toString(), equals(), compareTo(), payBill(), and organizeByFirstName().
The functions listed above are described in more detail in the classes.

The savingsAccount will inherit from the mainBankAccount class. It will have access to the functions in the mainBankAccount. It has an instance variable that takes in a double representing the growth rate. It has a withDraw() method that works like the one in the mainBankAccount; however, it will tax 7 percent from the withdrawal amount. It also has a growthEstimate() method that gives the client a prediction of how much their money will grow in n years (where n is the number of years). It also has its own toString() method like the mainBankAccount.

Creating a savingsAccount:
savingsAccount alice = new savingsAccount(String clientName, double amount, double growth);

Growth rate is yearly.
If growth is not given, it will default to 13 percent.

Keep in mind when inputting the growth amount: if you want to have a 12 percent growth rate, you must enter the number 12, not 0.12.

New/Overridden Functions that are in the savingsAccount:
Constructor, setters/getters, withDraw(), toString(), and growthEstimate().
The functions listed above are described in more detail in the classes.

There is also a BankAccountInterface which just includes the methods that need to be created: a deposit() function, a withdraw() function, and the Comparable interface.
