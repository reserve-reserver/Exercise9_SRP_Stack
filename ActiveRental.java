import java.time.LocalDateTime;

public class ActiveRental {
    private String bikeID;
    private String userEmail;
    private LocalDateTime tripStartTime;

    // 构造方法：创建一条租赁记录
    public ActiveRental(String bikeID, String userEmail, LocalDateTime tripStartTime) {
        this.bikeID = bikeID;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
    }

    // Getter 方法
    public String getBikeID() { return bikeID; }
    public String getUserEmail() { return userEmail; }
    public LocalDateTime getTripStartTime() { return tripStartTime; }

    // 打印格式
    @Override
    public String toString() {
        return "Bike ID: " + bikeID + "\nUser Email: " + userEmail + "\nTrip Start Time: " + tripStartTime;
    }
}