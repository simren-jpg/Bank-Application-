import java.util.Objects;
import java.util.UUID;

public class SBIuser implements Bank{
    // Attributes
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;
    // Create getters and setters for all function
    public SBIuser(String name, double balance, String enteredPassword){
        // Given By user itself
        this.name =  name;
        this.balance = balance;
        this.password = enteredPassword;

        // Assigned by the bank
        this.rateOfInterest = 6.5;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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
        SBIuser.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance += amount;
        return "Amount has been Credited..." + "New Balance is "+String.valueOf(balance);
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword, password)){
            //double remainingAmount = balance - amount;
            if(amount > balance){
                return "Sorry ! Insufficient Money ";
            }
            else{
                balance -= amount;
                return "Lots Of Money";
            }
        }
        else{
            return "Opps!! You have entered wrong password...";
        }
    }

    @Override
    public double calculateInterest(int years) {
        double interest = (balance*years*rateOfInterest)/100;
        return interest;
    }
}
