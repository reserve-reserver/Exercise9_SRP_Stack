import java.util.Scanner;

public  class UserSystem{

    static class RegisteredUsers {
        private String fullName;
        private String emailAddress;
        private String dateOfBirth;
        private String cardNumber;
        private String cardExpiryDate;
        private String cardProvider;
        private String cvv;
        private String userType;
        private String[] lastThreeTrips = new String[3];

        public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth,
                               String cardNumber, String cardExpiryDate, String cardProvider,
                               String cvv, String userType, String[] lastThreeTrips) {
            this.fullName = fullName;
            this.emailAddress = emailAddress;
            this.dateOfBirth = dateOfBirth;
            this.cardNumber = cardNumber;
            this.cardExpiryDate = cardExpiryDate;
            this.cardProvider = cardProvider;
            this.cvv = cvv;
            this.userType = userType;
            this.lastThreeTrips = lastThreeTrips;
        }

        public String getFullName() { return fullName; }
        public String getEmailAddress() { return emailAddress; }
        public String getDateOfBirth() { return dateOfBirth; }
        public String getCardNumber() { return cardNumber; }
        public String getCardExpiryDate() { return cardExpiryDate; }
        public String getCardProvider() { return cardProvider; }
        public String getCvv() { return cvv; }
        public String getUserType() { return userType; }
        public String[] getLastThreeTrips() { return lastThreeTrips; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegisteredUsers[] users = new RegisteredUsers[100];
        int userCount = 0;
        boolean running = true;

        while (running) {
            System.out.println("\n=== 用户管理系统 ===");
            System.out.println("1. 添加用户");
            System.out.println("2. 查看用户");
            System.out.println("3. 退出");
            System.out.print("请选择: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("请输入数字！");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("姓名: ");
                    String name = scanner.nextLine();
                    System.out.print("邮箱: ");
                    String email = scanner.nextLine();
                    // 其他字段...

                    String[] trips = {"北京", "上海", "广州"};
                    users[userCount] = new RegisteredUsers(
                            name, email, "2000-01-01", "1234567890123456",
                            "12/25", "Visa", "123", "普通用户", trips
                    );
                    userCount++;
                    System.out.println("添加成功！");
                    break;

                case 2:
                    for (int i = 0; i < userCount; i++) {
                        System.out.println("用户" + (i+1) + ": " + users[i].getFullName());
                    }
                    break;

                case 3:
                    System.out.println("再见！");
                    running = false;
                    break;
            }
        }

        scanner.close(); // 在循环结束后再关闭
    }
}
