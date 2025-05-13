/*
 * Name: Zi Hao Chen (Jary Chen)
 * 
 * I will be creating classes that would resonate a bank account, the classes I would make is a mainBankAccount(the parent class/super class) and  savingsAccount(the sub class).
 * The mainBankAccount will have methods that would function like any other bank account. For example, it will have functions where you can pay a bill, deposit money, 
 * withdraw money, a split money calculator and a function where a manager can organzize bank accounts by first name (this can only be used if client name is "manager").
 * creating a mainBankAccount(example):
 * mainBankAccount jen = new mainBankAccount(String clientName, double amouunt);
 *      -if clientName is not given it will be defulted to "user"
 *      -if Amount is not given it will be defulted to 0
 * Functions that are in the mainBankAccount: constructor, setters/getters, deposit(), withDraw(), splitCalculator(), toString(), equals(), compareTo(), payBill(), and organizeByFirstName().
 * THE FUNCTIONS LISTED ABOVE ARE DESCRIBED IN MORE DETAIL IN THE CLASSES.
 * 
 * The savings account will inherit from the mainBankAccount class, it will have access to the fucntions in the mainBankAccount, it has a instance varible that takes ina double representing growth
 * rate. It has a withDraw() method that works like the one in the mainBankAccount, however it will tax 7 percent from the withdraw amount. It also has a growth estimate method
 * that gives the client a prediction of how much their money will grow in int n year(where n is the number of years). It also has its own toString() method like the mainBankAccount.
 * creating a savingsAccount:
 * savingsAccount alice = new savingsAccount(String clientName, double amount, double growth);
 *      -growth rate is yearly
 *      -if growth is not given it will defult to 13 percent
 *      -keep in mind when inputing the growth amount, if you want to have a 12 percent growth rate you must enter the number 12 not 0.12
 * New/Overriden Functions that are in the savingsAccount: contructor, setters/getters, withDraw(), toString(), and growthEstimate().
 * THE FUNCTIONS LISTED ABOVE ARE DESCRIBED IN MORE DETAIL IN THE CLASSES.
 * 
 * There is also a BankAccountInterface which just includes the methods that need to be created(a deposit function, a withdraw function and the comparable interface).
 */

import java.util.ArrayList;
public class testerExamples {

    public static void main(String[] args) {

        //TESTING FOR THE MAIN BANK ACCOUNT
        //creating objects
        mainBankAccount bob = new mainBankAccount("Bob", 0);
        mainBankAccount jary = new mainBankAccount("Jary", 1200);
        mainBankAccount jen = new mainBankAccount("Jen");
        mainBankAccount user = new mainBankAccount(85);

        //testing getters
        System.out.println(bob.getAmount());
        System.out.println(user.getClientName());

        //testing setters
        bob.setAmount(800);
        System.out.println(bob.getAmount());
        user.setAmount(20);
        System.out.println(user.getAmount());

        //testing toString() method
        System.out.println(bob.toString());
        System.out.println(jen.toString());

        //testing equals() method
        jary.setAmount(800);
        System.out.println(bob.equals(jary));
        System.out.println(jen.equals("hello"));
        System.out.println(jary.equals(user));

        //teseting compareTo() method
        System.out.println(bob.compareTo(jary));
        System.out.println(jen.compareTo(user));

        //testing deposit() and withdraw() function
        jen.deposit(30);
        jen.withdraw(5);
        jary.deposit(60);

        //teseting split() method
        user.setAmount(70);
        user.splitCalculator(3, 30);
        jen.setAmount(2);
        jen.splitCalculator(2, 4);

        //testing paybill() method
        bob.setAmount(500);
        System.out.println(bob.payBill("enbridge", 150));
        System.out.println(bob.getAmount());
        System.out.println(bob.payBill("rogers", 380));

        //teseting organizeByFirstName()
        ArrayList<mainBankAccount> names = new ArrayList<>();
        mainBankAccount bankOwner = new mainBankAccount("manager");

        names.add(bob);
        names.add(jary);
        names.add(user);
        names.add(jen);

        System.out.println(bankOwner.organizeByFirstName(names));

        mainBankAccount jeff = new mainBankAccount("jeff");

        System.out.println(jeff.organizeByFirstName(names));

        //TESTING FOR THE SAVINGS ACCOUNT
        //creating objects
        savingsAccount alice = new savingsAccount("alice", 40,15);
        savingsAccount donald = new savingsAccount("donald",20,10);
        savingsAccount jason = new savingsAccount("jason",500);

        //testing getters
        System.out.println(alice.getAmount());
        System.out.println(donald.getClientName());
        System.out.println(jason.getGrowth());

        //teseting setter
        donald.setGrowth(9);
        System.out.println(donald.getGrowth());

        //testing withdraw()
        jason.withdraw(30);
        System.out.println(jason.getAmount());
        alice.withdraw(44);

        //testing toString() method
        jason.setAmount(0);
        System.out.println(jason.toString());
        System.out.println(donald.toString());

        //testing growthEstimate()
        jason.setAmount(500);
        System.out.println(alice.growthEstimate(3));
        System.out.println(donald.growthEstimate(2));
        System.out.println(jason.growthEstimate(4));
    }
}
