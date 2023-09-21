package firman.lasaman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * description of class Main 
 *
 * @author firman.lasaman
 * @version v1.0.0
 */
public class Main {
    /**
     * main method
     * @param args args
     */
    public static void main(String[] args) {

        Map<String, Double> model = new HashMap<>();
        model.put("Redmi 4A", 4199.00);
        model.put("Redmi 4X", 6199.00);
        model.put("Redmi Note 4X", 7599.00);
        model.put("Mi Max 2", 12590.00);
        model.put("Mi Mix 2", 24700.00);

        List<Map.Entry<String, Double>> modelList = new ArrayList<>(model.entrySet());

        char buyAgain;
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            TransactionDetail transactionDetail = new TransactionDetail();
            System.out.println("Welcome to Lazada Online Ordering System");
            System.out.print("Enter your Customer name: ");
            transactionDetail.setName(scanner.nextLine());
            System.out.print("Shipping address: ");
            transactionDetail.setAddress(scanner.nextLine());
            System.out.println("Select your Xiaomi Phone : ");
            showModel(model);
            do {
                System.out.print("Xiaomi model choice (1-5): ");
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice > 1 && choice <= modelList.size()) {
                    break;
                }
            } while (true);

            transactionDetail.setModel(modelList.get(choice - 1).getKey());
            System.out.print("Enter number of items: ");
            transactionDetail.setQuantity(scanner.nextInt());
            scanner.nextLine();
            do {
                System.out.print("Credit card number : ");
                transactionDetail.setCreditCard(scanner.nextLine());
                if (verifyCreditCard(transactionDetail.getCreditCard().trim())) {

                    transactionDetail.setGrossAmount(modelList.get(choice - 1).getValue());
                    transactionDetail.setVat();
                    transactionDetail.setTotalPrice();
                    break;
                } else {
                    System.out.println("Credit card number is not valid");
                }
            } while (true);
            System.out.println("\n" + transactionDetail.toStringDetail());
            System.out.print("Do you want to buy again? (y/n) : ");
            buyAgain = scanner.next().charAt(0);
            scanner.nextLine();
        } while (buyAgain == 'y' || buyAgain == 'Y');

        scanner.close();
    }

    // iterating showing model
    /**
     * iterating showing model
     * @param model map
     */
    public static void showModel(Map<String, Double> model) {
        int count = 1;
        for (Map.Entry<String, Double> entry : model.entrySet()) {
            System.out.println(count + " - " + entry.getKey() + " " + entry.getValue());
            count++;
        }
    }

    // create luhn algorithm for verifying credit card with 16 digit
    /** 
     * verify credit card
     * @param cardNumber number
     * @return boolean
     */
    public static boolean verifyCreditCard(String cardNumber) {
       return luhnAlgorithm(cardNumber.chars().map(Character::getNumericValue).toArray()) && cardNumber.length() == 16;
    }

    // implementing luhn algorithm
    /**
     * luhn algorithm
     * @param ints array
     * @return boolean
     */
    public static boolean luhnAlgorithm(int[] ints) {
        int sum = 0;
        boolean alternate = false;
        for (int i = ints.length - 1; i >= 0; i--) {
            int n = ints[i];
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        return (sum % 10 == 0);
    }
}