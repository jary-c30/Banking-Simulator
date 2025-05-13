public class savingsAccount extends mainBankAccount {

    //instance varibles
    private double growth;

    //constructor that takes in String name, double amount and double growth
    public savingsAccount(String name, double amount, double growth) {
        super(name, amount);
        this.growth = growth / 100;
    }

    //contructor that take in String name, double amount and sets the defult growth to 13 percent
    public savingsAccount(String name, double amount) {
        super(name, amount);
        this.growth = 0.13;
    }

    //setter sets growth amount
    public void setGrowth(double growth) {
        this.growth = growth / 100;
    }

    //getter gets growth amount
    public double getGrowth() {
        return this.growth * 100;
    }

    /*
     * withdraw() method takes in a double takeOut, if takeOut
     * amount is greater than the amount in bank it will print an
     * error message, other wise it will withdraw the give amount with
     * a 7 percent tax deduction.
     */
    @Override
    public void withdraw(double takeOut) {

        if (getAmount() < takeOut) {
            System.out.println("unfortuntely you dont have that amount to withdraw");
        }
        else {
            System.out.println("you have successfully withdrawed $" + (takeOut) + ", but after a 7 percent tax deduction you will recieve $" + (takeOut - (0.07 * takeOut)));
            setAmount(getAmount() - takeOut);
        }
    }

    /*
     * toString() method returns a string. If current amount is 0
     * than it returns a string leting client know they dont have moeny in the bank.
     * Otherwise it returns a summary of the current amount in the saving account and 
     * the current growth rate.
     */
    @Override
    public String toString() {

        if (getAmount() == 0) {
            return "you currently dont have any moeny in the bank";
        }

        return "you currently have $" + getAmount() + " with a " + (this.growth * 100) + " precent yearly growth rate"; 
    }

    /*
     * growthEstimate() method takes in int years
     * it returns a double of how much the money will grow
     * in the given years inputed.
     */
    public double growthEstimate(int years) {
        return getAmount() * (Math.pow(1 + this.growth, years));
    }
}
