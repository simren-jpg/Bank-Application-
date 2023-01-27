import java.sql.SQLOutput;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Kindly Enter Your Name");
        String name = sc.next();
        System.out.println("Kindly Set your password");
        String password = sc.next();
        System.out.println("Kindly Enter your Initial balance");
        double balance = sc.nextDouble();
        SBIuser user = new SBIuser(name, balance, password);

        // Add Money
        String msg = user.addMoney(100000);
        System.out.println(msg);

        // Withdraw money
        System.out.println("Kindly Enter the amount you want to withdraw");
        int money = sc.nextInt();
        System.out.println("Enter your password...");
        String pass = sc.next();
        System.out.println(user.withdrawMoney(money, pass));

        // rate of interest
        //System.out.println(user.calculateInterest(10));
    }
}