package labreport3;

import java.util.Random;
import java.util.Scanner;

public class Money {

    private int cents;
    static int sum = 0;

    public Money() {
        Random r = new Random();
        cents = r.nextInt(99001 + 1000);
    }

    public Money(int money) {
        cents = money;
    }

    public Money(int[] money) {
        for (int i : money) {
            cents += money[i];
        }

    }

    public int getMoney() {
        return cents;
    }

    public void setMoney(int money) {
        cents = money;
    }

    public static void addMoney(Money m) {
        sum += m.getMoney();
    }

    //method to test static variable sum
    public int getSum() {
        return sum;
    }

    public String toString() {

        int amount = sum;
        double amount_point = sum;

        int[] notesAndCoins = {10000, 5000, 2000, 1000, 500, 100, 50, 20, 10, 5, 1};
        int rm100 = 0, rm50 = 0, rm20 = 0, rm10 = 0, rm5 = 0, rm1 = 0, cent50 = 0, cent20 = 0, cent10 = 0, cent5 = 0, cent1 = 0;

        for (int i = 0; i < notesAndCoins.length; i++) {

            while (amount >= notesAndCoins[i]) {
                amount -= notesAndCoins[i];

                switch (i) {
                    case 0 ->
                        rm100++;
                    case 1 ->
                        rm50++;
                    case 2 ->
                        rm20++;
                    case 3 ->
                        rm10++;
                    case 4 ->
                        rm5++;
                    case 5 ->
                        rm1++;
                    case 6 ->
                        cent50++;
                    case 7 ->
                        cent20++;
                    case 8 ->
                        cent10++;
                    case 9 ->
                        cent5++;
                    case 10 ->
                        cent1++;

                }
            }

        }
        String sum_money = "Amount = " + sum + " cents \t(RM" + amount_point / 100 + ")\n\n";

        String txt100 = String.format("%-15s quantity = %d\n", "RM100", rm100);
        String txt50 = String.format("%-15s quantity = %d\n", "RM50", rm50);
        String txt20 = String.format("%-15s quantity = %d\n", "RM20", rm20);
        String txt10 = String.format("%-15s quantity = %d\n", "RM10", rm10);
        String txt5 = String.format("%-15s quantity = %d\n", "RM5", rm5);
        String txt1 = String.format("%-15s quantity = %d\n", "RM1", rm1);
        String txt_50 = String.format("%-15s quantity = %d\n", "50 cents", cent50);
        String txt_20 = String.format("%-15s quantity = %d\n", "20 cents", cent20);
        String txt_10 = String.format("%-15s quantity = %d\n", "10 cents", cent10);
        String txt_5 = String.format("%-15s quantity = %d\n", "5 cents", cent5);
        String txt_1 = String.format("%-15s quantity = %d\n", "1 cents", cent1);

        return sum_money + txt100 + txt50 + txt20 + txt10 + txt5 + txt1 + txt_50 + txt_20 + txt_10 + txt_5 + txt_1;

    }

    public static void main(String[] args) {

//testing static sum
        Money m = new Money(10000);
        System.out.println(m.getMoney());

        Money n = new Money(22438);
        System.out.println(n.getMoney());
        System.out.println(n.getSum());
        System.out.println(m.getSum());

// objects m & n do not "posess" the sum cuz sum is Money class' variable, sum is untouched by any objects created from Money's blueprint.
        addMoney(m);
        addMoney(n);

        System.out.println(m.getSum());
        System.out.println(n.getSum()); //m & n gives the same output for getSum()

        System.out.println(m.toString()); // segregating sum amount of money
    }

}
