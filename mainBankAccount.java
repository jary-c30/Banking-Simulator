import java.util.ArrayList;
import java.util.Collections;

public class mainBankAccount implements BankAccountInterface {

    //instance varibles
    private String clientName;
    private double amount;

    //contructor takes in String client name and a double amount.
    public mainBankAccount(String clientName, double amount) {
        this.clientName = clientName;
        this.amount = amount;
    }

    //contructor takes in double amount, and sets the client name to "user" if not client name is inputed
    public mainBankAccount(double amount) {
        this.amount = amount;
        this.clientName = "user";
    }

    //contructor takes in a String clientName and sets the amount to 0.
    public mainBankAccount(String clientName) {
        this.clientName = clientName;
        this.amount = 0.0;
    }

    //getter returning clients name
    public String getClientName() {
        return this.clientName;
    }

    //getter returning amount in account
    public double getAmount() {
        return this.amount;
    }

    //setter sets clients name
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    //setter sets new amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /*
     * this deposit() function takes in a double putIn and adds the inputed 
     * amount with the amount in the account already. It returns a 
     * print statement telling how much money is after the transaction.
     */
    @Override
    public void deposit(double putIn) {
        this.amount = this.amount + putIn;

        System.out.println("your current amount is: $" + this.amount);
    }

    /*
     * this withdraw function takes in a double takeOut and withdraws the
     * amount inputed, however if the money inputed is greater than the amount
     * in the account it will give error message, if not than it withdraws the inputed
     * amount as will as giving a message of how much is left after the transaction.
     */
    @Override
    public void withdraw(double takeOut) {

        if (this.amount < takeOut) {
            System.out.println("unfortuntely our system will not allow this due to the reason that you are $" + (takeOut - this.amount) + "short");
        }
        else {
            this.amount = this.amount - takeOut;
            System.out.println("your with amount is $" + takeOut + " after withdraw the current amount in your bank is: $" + this.amount);
        }
    }

    /*
     * this splitCalculator() function takes in an int numOfPeople and double withdrawAmount
     * it will give an error message if withdraw amount is larger than the money in the account,
     * if numOfPeople is less than 1, it will give a message that the withdraw amount is given
     * to yourself. if not it will give an exact amount of how much eac person gets.
     */
    public void splitCalculator(int numOfPeople, double withdrawAmount) {
        
        if (this.amount < withdrawAmount) {
            System.out.println("please deposit $" + (withdrawAmount - this.amount) + " to make this happen");
        }
        else if (numOfPeople <= 0) {
            System.out.println("you get " + withdrawAmount + " all to yourself");
        }
        else {
            System.out.println("each person would be getting $" + (withdrawAmount / numOfPeople));
        }
    }

    /*
     * returns a String detailing the clients name as well as how much they have in the bank,
     * it gives a string detailing if they have money in the account or not.
     */
    @Override
    public String toString() {

        if (this.amount == 0) {
            return "Hello " + this.clientName + " you current dont have any money in the bank, please deposit money to make account more useful";
        }

        return "Hello " + this.clientName + " you currently have $" + this.amount + " in the account";   
    }

    /*
     * equals() method takes in an Object other and checks if 
     * other is a mainBankAccount obj, if it is than it returns
     * true or false depending if both Objects have the same amount
     * in the account.     
     */
    @Override
    public boolean equals(Object other) {

        if (!(other instanceof mainBankAccount)) {
            return false;
        }

        mainBankAccount otherCopy = (mainBankAccount) other;

        return this.amount == otherCopy.amount;
    }

    /*
     * compareTo() function takes in mainBankAccount other and
     * check both amounts, if they are the same it returns 0,
     * if other is less that this it return 1, otherwise it 
     * returns -1 
     */
    @Override
    public int compareTo(mainBankAccount other) {
        if (this.equals(other)) {
            return 0;
        }

        else if (this.amount > other.amount) {
            return 1;
        }

        return -1;

    }

    /*
     * payBill() function takes a String company and double amoutnOwwed
     * returns a string if paying the bill lead to dept, if not it returns
     * a String telling the user the transaction was successful.
     */
    public String payBill(String company, double amountOwed) {

        this.amount = this.amount - amountOwed;
        if (this.amount < 0) {
            return "$" + amountOwed + " has been sent to " + company +  ". However, you are currently now $" + (this.amount) + " in dept, please load more money into the account";
        }

        return "Success!. your bill has been paid to " + company + ".";
    }

    /*
     * organizeByFirstName() funtion takes in a ArrayList<mainBankAccount> info
     * and returns a new Arraylist of the names in alphabetical based on the first character
     * of the name. However in order for the function to work the client name must be manager
     * other wise it will return a arraylist saying your unauthorized.
     */
    public ArrayList<String> organizeByFirstName(ArrayList<mainBankAccount> info) {

        ArrayList<String> names = new ArrayList<>();

        if (this.clientName == "manager") { 

            for (int i = 0; i < info.size(); i++) {
                mainBankAccount nameGetter = info.get(i);
                names.add(nameGetter.getClientName());
            }

            for (int i = 0; i < names.size() - 1; i++) {
                for (int j = 0; j < names.size() - 1 - i; j++) {

                    String name1 = names.get(j);
                    String name2 = names.get(j+1);

                    if(name1.charAt(0) > name2.charAt(0)) {
                        Collections.swap(names, j, j + 1);
                    }
                }
            }
            return names;
        }    
        
        names.add("unauthorized");
        return names;
    }

}
