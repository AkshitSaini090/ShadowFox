import java.util.Scanner;

public class EnhancedCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Display menu
            System.out.println("\n===== Enhanced Console Calculator =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Exponentiation");
            System.out.println("7. Temperature Conversion (Celsius to Fahrenheit)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            // Read user choice
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    performAddition(scanner);
                    break;
                case 2:
                    performSubtraction(scanner);
                    break;
                case 3:
                    performMultiplication(scanner);
                    break;
                case 4:
                    performDivision(scanner);
                    break;
                case 5:
                    performSquareRoot(scanner);
                    break;
                case 6:
                    performExponentiation(scanner);
                    break;
                case 7:
                    performTemperatureConversion(scanner);
                    break;
                case 8:
                    System.out.println("Exiting... Thank you for using the calculator!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
    
    // Method to perform addition
    private static void performAddition(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        double result = num1 + num2;
        System.out.println("Result: " + result);
    }
    
    // Method to perform subtraction
    private static void performSubtraction(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        double result = num1 - num2;
        System.out.println("Result: " + result);
    }
    
    // Method to perform multiplication
    private static void performMultiplication(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        double result = num1 * num2;
        System.out.println("Result: " + result);
    }
    
    // Method to perform division
    private static void performDivision(Scanner scanner) {
        System.out.print("Enter dividend: ");
        double dividend = scanner.nextDouble();
        System.out.print("Enter divisor: ");
        double divisor = scanner.nextDouble();
        
        if (divisor == 0) {
            System.out.println("Error! Division by zero is not allowed.");
        } else {
            double result = dividend / divisor;
            System.out.println("Result: " + result);
        }
    }
    
    // Method to perform square root
    private static void performSquareRoot(Scanner scanner) {
        System.out.print("Enter a number: ");
        double num = scanner.nextDouble();
        
        if (num < 0) {
            System.out.println("Error! Square root of a negative number is not defined.");
        } else {
            double result = Math.sqrt(num);
            System.out.println("Square root: " + result);
        }
    }
    
    // Method to perform exponentiation
    private static void performExponentiation(Scanner scanner) {
        System.out.print("Enter base number: ");
        double base = scanner.nextDouble();
        System.out.print("Enter exponent: ");
        double exponent = scanner.nextDouble();
        
        double result = Math.pow(base, exponent);
        System.out.println("Result: " + result);
    }
    
    // Method to perform temperature conversion (Celsius to Fahrenheit)
    private static void performTemperatureConversion(Scanner scanner) {
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }
}
