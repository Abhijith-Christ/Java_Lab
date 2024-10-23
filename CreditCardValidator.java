import java.util.Scanner;

public class CreditCardValidator {

    private String cardNumber;

    // Constructor to accept the credit card number
    public CreditCardValidator(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    // Method to check if the card number has 8 or 9 digits
    public boolean isValidCardNumber() {
        return this.cardNumber.matches("\\d{8,9}");
    }

    // Method to remove the last digit from the valid card number and return the removed digit
    public int removeLastDigit() {
        return Character.getNumericValue(this.cardNumber.charAt(this.cardNumber.length() - 1));
    }

    // Method to reverse the remaining digits
    public String reverseDigits(String cardNumber) {
        return new StringBuilder(cardNumber).reverse().toString();
    }

    // Method to double the digits in odd-numbered positions
    public String doubleOddPositionDigits(String cardNumber) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < cardNumber.length(); i++) {
            char digitChar = cardNumber.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            
            // Double the digit if it is in an odd-numbered position (1-based index)
            if (i % 2 == 0) { 
                digit *= 2;

                // If the doubled digit is two digits, sum the digits together
                if (digit > 9) {
                    digit = digit / 10 + digit % 10;
                }
            }

            // Append the modified or unmodified digit to the result
            result.append(digit);
        }

        return result.toString();
    }

    // Method to sum up all digits in the card number
    public int sumOfDigits(String cardNumber) {
        int sum = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            sum += Character.getNumericValue(cardNumber.charAt(i));
        }
        return sum;
    }

    // Method to subtract the last digit of the modified card number (after Step a) from 10
    public int subtractLastDigitFromTen(String modifiedCardNumber) {
        int lastDigit = Character.getNumericValue(modifiedCardNumber.charAt(modifiedCardNumber.length() - 1));
        return 10 - lastDigit;
    }

    public void processCard() {
        Scanner scanner = new Scanner(System.in);
        
        String modifiedCardNumber = "";
        String reversedCardNumber = "";
        String finalCardNumber = "";
        int removedLastDigit = 0;
        int totalSum = 0;
        int result = 0;

        int step = 1;
        while (step <= 6) {
            System.out.println("\nPerforming Step " + step + ":");
            switch (step) {
                case 1:
                    // Step a: Remove the last digit and store the removed last digit
                    removedLastDigit = removeLastDigit();
                    modifiedCardNumber = this.cardNumber.substring(0, this.cardNumber.length() - 1); // Remove last digit from card number
                    System.out.println("Card number after removing the last digit: " + modifiedCardNumber);
                    System.out.println("Removed last digit: " + removedLastDigit);
                    break;

                case 2:
                    // Step b: Reverse the remaining digits
                    reversedCardNumber = reverseDigits(modifiedCardNumber);
                    System.out.println("Card number after reversing the digits: " + reversedCardNumber);
                    break;

                case 3:
                    // Step c: Double the digits in odd-numbered positions
                    finalCardNumber = doubleOddPositionDigits(reversedCardNumber);
                    System.out.println("Card number after doubling digits in odd-numbered positions: " + finalCardNumber);
                    break;

                case 4:
                    // Step d: Add up all the digits
                    totalSum = sumOfDigits(finalCardNumber);
                    System.out.println("Sum of all digits: " + totalSum);
                    break;

                case 5:
                    // Step e: Subtract the last digit of modifiedCardNumber from 10
                    result = subtractLastDigitFromTen(modifiedCardNumber);
                    System.out.println("10 minus the last digit of the modified card number: " + result);
                    break;

                case 6:
                    // Step f: Compare the result with the originally removed last digit
                    if (result == removedLastDigit) {
                        System.out.println("The card is valid.");
                    } else {
                        System.out.println("The card is invalid.");
                    }
                    break;

                default:
                    System.out.println("Invalid step.");
                    break;
            }
            step++;
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your credit card number:");
        String inputCardNumber = scanner.nextLine();

        CreditCardValidator validator = new CreditCardValidator(inputCardNumber);

        if (validator.isValidCardNumber()) {
            validator.processCard();
        } else {
            System.out.println("Invalid credit card number. It must have 8 or 9 digits.");
        }

        scanner.close();
    }
}
