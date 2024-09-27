package StarlightCoffee;
import java.util.Scanner;

public class StarlightCoffee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Declare a scanner

        printHeading();
        // Print out the banner

        System.out.print("What is your name? ");
        String name = scan.nextLine();
        System.out.println("");
        System.out.println("What kind of coffee do you want?");
        System.out.println("1. Americano\n2. Italiano\n3. Esspresso\n4. Cappuchino");
        System.out.print("Enter the number of your choice: ");
        int coffeeChoice = scan.nextInt();
        // Basic print and ask for input

        System.out.println("");
        System.out.println("What size do you want?");
        System.out.println("1. Tall\n2. Grande\n3. Venti");
        System.out.print("Enter the number of your choice: ");
        int size = scan.nextInt();
        // Basic print and ask for input

        System.out.println("");
        System.out.print("How many extra shots of espresso would you like? ");
        int espressoShot = scan.nextInt();
        // Basic print and ask for input

        double drinkCost = calculateDrinkCost(coffeeChoice, size, espressoShot);
        // Declare and calculation drinkCost using calculateDrinkCost function

        scan.nextLine();               // Skip a line so I won't have any integer misinput
        System.out.println("");
        System.out.print("Are you a member of Starlight Stars (y or n)? ");
        String membership = scan.nextLine();
        double membershipDiscount = 0;
        // Basic print and ask for input

        if (membership.equalsIgnoreCase("y")) {
            membershipDiscount = drinkCost * 0.10;
        } else if (membership.equalsIgnoreCase("n")) {
            membershipDiscount = 0;
        }
        // If else for user's membership discount

        System.out.println("");
        System.out.println("What size tip would you like to leave?\n1. Good service - 10%\n2. Great service - 15%\n3. Outstanding service - 20%");
        System.out.print("Enter the number of your choice: ");
        int tipChoice = scan.nextInt();
        System.out.println("");
        // Basic print and ask for input

        double tip = calculateTip(tipChoice, drinkCost);
        // Calculate tip using function

        double tax = (drinkCost - membershipDiscount)*0.085;
        // Calculate tax

        printBill(name,drinkCost,membershipDiscount,tip,tax);
        // Using printBill function to print the bill perfectly

        scan.close();
        // Close scanner for safety
    }

    public static void printHeading() {
        System.out.println("************************************************************");
        System.out.println("          STARLIGHT COFFEE POINT-OF-SALE SYSTEM");
        System.out.println("************************************************************");
        // Using void function to avoid input and return while printing the banner
    }

    public static double calculateDrinkCost(int coffeeChoice, int size, int espressoShot) { 
        double coffeeCost = 0;
        double upCharge = 0;
        // Initialize for switch-case

        switch (coffeeChoice) {
            case 1:
                coffeeCost = 2.25;
                break;
            case 2:
                coffeeCost = 2.75;
                break;
            case 3:
                coffeeCost = 3.50;
                break;
            case 4:
                coffeeCost = 3.75;
                break;
        }
        // Using switch-case to determine how much coffee cost

        switch (size) {
            case 1:
                upCharge = 0;
                break;
            case 2:
                upCharge = 0.20;
                break;
            case 3:
                upCharge = 0.40;
                break;
        }
        // Using switch-case to determine how much upcharge

        return coffeeCost * upCharge + coffeeCost + 0.50 * espressoShot;
        // Return the drink cost
    }

    public static double calculateTip (int tipChoice, double drinkCost) { 
        double tip = 0;
        // Initialize for switch-case
        switch (tipChoice) { 
            case 1:
                tip = 0.10;
                break;
            case 2:
                tip = 0.15;
                break;
            case 3:
                tip = 0.20;
                break;
        }
        // Using switch-case to calculate based on user choice
        return tip * drinkCost;             // Return tip value
    }

    public static void printBill (String name, double drinkCost, double membershipDiscount, double tip, double tax) {
        System.out.println("Here is your bill, " + name);
        System.out.printf("Beverage        $ %.2f\n",drinkCost);
        System.out.printf("Club Discount   $ %.2f\n",membershipDiscount);
        System.out.printf("Tip Amount      $ %.2f\n",tip);
        System.out.printf("Taxes           $ %.2f\n",tax);
        System.out.printf("Total           $ %.2f\n",(drinkCost - membershipDiscount + tip + tax));
        System.out.println("");
        System.out.println("Thank you for choosing Starlight Coffee!");
        // Print all the output
    }
}