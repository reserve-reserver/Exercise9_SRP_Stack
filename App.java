import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BikeRental bikeRental = new BikeRental();

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add Registered Users");
            System.out.println("2. Remove Registered Users");
            System.out.println("3. View Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. Demo the Bike Rental System");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 5:
                    bikeRental.simulateApplicationInput(); // 运行租赁演示
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}