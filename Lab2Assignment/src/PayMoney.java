import java.util.Scanner;

public class PayMoney {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {//closes scanner.

            System.out.println("Enter the size of transaction array");
            int sizeOfArray = scanner.nextInt();

            System.out.println("Enter the values of array");
            int[] arr = new int[sizeOfArray];
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = scanner.nextInt();//10,20,30
            }

            System.out.println("Enter the total no of targets that needs to be achieved");
            int noOfTargets = scanner.nextInt();

            while (noOfTargets > 0) {
                boolean targetAchieved = false;
                System.out.println("Enter the value of target");
                int target = scanner.nextInt();//17

                int total = 0;
                for (int i = 0; i < sizeOfArray; i++) {
                    if (total >= target) {
                        System.out.println("Target achieved after " + (i + 1) + " transactions\n");
                        targetAchieved = true;
                        break;
                    }
                    total += arr[i];
                }
                if (!targetAchieved) System.out.println("Given target is not achieved ");
                noOfTargets--;
            }
        } catch (Exception e) {
            //error
        }
    }
}
