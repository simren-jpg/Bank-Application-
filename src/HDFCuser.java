import java.util.Objects;
import java.util.UUID;

public class HDFCuser implements Bank {

    // Attributes
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;
    // Create getters and setters for all function


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accpuntNo) {
        this.accountNo = accpuntNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        HDFCuser.rateOfInterest = rateOfInterest;
    }

    public HDFCuser(String name, double balance, String enteredPassword) {
        this.name =  name;
        this.balance = balance;
        this.password = enteredPassword;
        this.rateOfInterest = 6.5;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }
    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance+=amount;
        return "Your amount has been Credited, Your New Balance is "+String.valueOf(balance);
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword, password)){
            if(amount>balance){
                return "Opps!! Insuficient Money :(";
            }
            else{
                balance-=amount;
                return "Your amount has been Debited, Your New Balance is "+String.valueOf(balance);
            }
        }
        else
            return "Wrong password, Try again..";
    }

    @Override
    public double calculateInterest(int years) {
        double interest = balance*years*rateOfInterest/100;
        return interest;
    }
}

