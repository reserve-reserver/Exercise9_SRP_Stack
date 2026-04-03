import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Stack<ERyderLog> logStack = new Stack<>();
    public static Queue<BikeRequest> bikeRequest = new ArrayDeque<>();

    public static void viewSystemLogs() {
        System.out.println("\n===== System Logs =====");
        if (logStack.isEmpty()) {
            System.out.println("No logs");
        } else {
            for (int i = logStack.size() - 1; i >= 0; i--) {
                System.out.println(logStack.get(i));
            }
        }
        System.out.println("======================\n");
    }

    public static void manageRequestsMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Manage Requests =====");
            System.out.println("1. View Queue");
            System.out.println("2. Remove First");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n===== Requests =====");
                    if (bikeRequest.isEmpty()) {
                        System.out.println("No requests");
                    } else {
                        int count = 1;
                        for (BikeRequest req : bikeRequest) {
                            System.out.println(count++ + ". " + req);
                        }
                    }
                    System.out.println("====================\n");
                    break;
                case 2:
                    BikeRequest removed = bikeRequest.poll();
                    if (removed != null) {
                        System.out.println("\nRemoved: " + removed);
                    } else {
                        System.out.println("\nQueue is empty");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\nInvalid choice");
            }
        }
    }

    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Admin Panel =====");
            System.out.println("1. Add Test Log");
            System.out.println("2. Add Test Request");
            System.out.println("3. View System Logs");
            System.out.println("4. Manage Requests");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    logStack.push(new ERyderLog("BR001", "Bike rented"));
                    System.out.println("\nLog added");
                    break;
                case 2:
                    bikeRequest.add(new BikeRequest("test@test.com", "Campus"));
                    System.out.println("\nRequest added");
                    break;
                case 3:
                    viewSystemLogs();
                    break;
                case 4:
                    manageRequestsMenu();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("\nInvalid choice");
            }
        }
    }

    public static void main(String[] args) {
        adminMenu();
    }
}
