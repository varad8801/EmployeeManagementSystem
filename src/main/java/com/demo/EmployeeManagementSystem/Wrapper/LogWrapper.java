package demo.EmployeeManagementSystem.Wrapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWrapper {
    private LocalDateTime timestamp;
    private String details;

    public LogWrapper(LocalDateTime timestamp, String details) {
        this.timestamp = timestamp;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return timestamp.format(formatter);
    }
}
