import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Denomination {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter the size of currency denominations");
            int noOfDenominations = sc.nextInt();
            Integer[] denominations = new Integer[noOfDenominations];

            System.out.println("Enter the currency denominations value");
            for (int i = 0; i < noOfDenominations; i++) {
                denominations[i] = sc.nextInt();
            }

            System.out.println("Enter the amount you want to pay");
            int amountToPay = sc.nextInt();

            int[] payableDenominations = new int[noOfDenominations];

            amountToPay = findDenominations(payableDenominations, denominations, amountToPay);

            printDenominations(denominations, amountToPay, payableDenominations);
        } catch (Exception e) {
            //
        }
    }

    private static int findDenominations(int[] tempDenPayable, Integer[] denominations, int amountToPay) {
        Arrays.sort(denominations, Collections.reverseOrder());
        for (int i = 0; i < denominations.length; i++) {
            tempDenPayable[i] = amountToPay / denominations[i];
            amountToPay -= tempDenPayable[i] * denominations[i];
        }
        return amountToPay;
    }

    private static void printDenominations(Integer[] denominations, int tempAmt, int[] tempDenPayable) {
        if (tempAmt != 0) {
            System.out.println("Sorry! You cannot make exact payment");
        } else {
            System.out.println("Your payment approach in order to give min no of notes will be");
            for (int i = 0; i < tempDenPayable.length; i++) {
                if (tempDenPayable[i] > 0)
                    System.out.println(denominations[i] + ":" + tempDenPayable[i]);
            }
        }
    }
}
