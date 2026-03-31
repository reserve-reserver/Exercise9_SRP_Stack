import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class BikeRental {
    // 用 LinkedList 存正在进行的租赁（作业要求）
    private LinkedList<ActiveRental> activeRentals = new LinkedList<>();
    private List<String> registeredUsers = List.of("john.doe@outlook.com", "admin@njit.edu"); // 模拟已注册用户

    // 模拟完整租赁流程（对应视频里的 Demo）
    public void simulateApplicationInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This is a simulation of the bike rental process.");
        System.out.print("State if the user is a registered user (true/false): ");
        boolean isRegistered = scanner.nextBoolean();
        scanner.nextLine(); // 吃掉换行

        if (!isRegistered) {
            System.out.println("Please register first!");
            return;
        }

        // 输入用户邮箱和取车地点
        System.out.print("Enter the email address of the user: ");
        String userEmail = scanner.nextLine();
        System.out.print("Enter the location of the bike: ");
        String location = scanner.nextLine();

        // 1. 分析请求
        System.out.println("\nSimulating the analysis of the rental request...");
        if (!registeredUsers.contains(userEmail)) {
            System.out.println("User not registered!");
            return;
        }
        System.out.println("Welcome back, " + userEmail + "!");

        // 2. 验证地点是否有可用车
        Bike availableBike = null;
        for (Bike bike : BikeDatabase.getBikes()) {
            if (bike.isAvailable() && bike.getLocation().equals(location)) {
                availableBike = bike;
                break;
            }
        }
        if (availableBike == null) {
            System.out.println("No bikes available at this location!");
            return;
        }
        System.out.println("A bike is available at the location you requested.");

        // 3. 预约车辆
        System.out.println("\nSimulating bike reservation...");
        availableBike.setAvailable(false); // 标记为不可用
        ActiveRental rental = new ActiveRental(availableBike.getBikeID(), userEmail, LocalDateTime.now());
        activeRentals.add(rental); // 加入 LinkedList
        System.out.println("Please follow the on-screen direction to locate your bike and start your trip.");

        // 4. 查看正在进行的租赁
        System.out.println("\nDisplaying the active rentals...");
        System.out.println("Active Rentals:");
        System.out.println("Bikes Currently In Use:");
        for (ActiveRental r : activeRentals) {
            System.out.println(r);
        }

        // 5. 模拟结束行程
        System.out.println("\nSimulating trip end...");
        Iterator<ActiveRental> iterator = activeRentals.iterator();
        while (iterator.hasNext()) {
            ActiveRental r = iterator.next();
            if (r.getBikeID().equals(availableBike.getBikeID())) {
                iterator.remove(); // 从 LinkedList 移除
                // 把车改回可用
                for (Bike b : BikeDatabase.getBikes()) {
                    if (b.getBikeID().equals(r.getBikeID())) {
                        b.setAvailable(true);
                        b.setLastUsedTime(LocalDateTime.now());
                    }
                }
            }
        }
        System.out.println("Trip ended. Bike returned successfully!");
    }
}