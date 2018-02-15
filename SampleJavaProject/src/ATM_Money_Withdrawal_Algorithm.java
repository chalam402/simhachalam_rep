import java.util.Scanner;

public class ATM_Money_Withdrawal_Algorithm {

      public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);

            int money[] = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 }; // money to disbursed

            int withdraw_amt = 0; // For store withdrawl amount

            int i = 0, r;

            System.out.print(" Enter An Amount to Withdrawal : "); 

            withdraw_amt = sc.nextInt();

            while(withdraw_amt >0){

                  r=withdraw_amt/money[i]; // Withdrawl amount devided by each money sets on above

                  withdraw_amt= withdraw_amt%money[i]; //a reminder will set again withdrawal amount.

                  System.out.println(" Please Collect note of "+money[i]+" rupees : "+r);

              i++;

            }

            System.out.println(" THANKS FOR USING OUR ATM SERVICE ");

      }

}
