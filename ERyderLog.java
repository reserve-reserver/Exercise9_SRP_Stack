import java.time.LocalDateTime;

public class ERyderLog {
    private String log;
    private String event;
    private LocalDateTime timeStamp;

    public ERyderLog(String log, String event) {
        this.log = log;
        this.event = event;
        this.timeStamp = LocalDateTime.now();
    }

    public String getLog() {
        return log;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return log + " - " + event + " - " + timeStamp;
    }
}
