import java.time.LocalDateTime;


public class Statistics {
    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;

    public LocalDateTime getMinTime() {
        return minTime;
    }

    public LocalDateTime getMaxTime() {
        return maxTime;
    }

    public Statistics() {
        this.totalTraffic = 0;
        this.minTime = LocalDateTime.MAX;
        this.maxTime = LocalDateTime.MIN;
    }

    public void addEntry(LogEntry logEntry) {
        if (minTime.compareTo(logEntry.getDateAndTime()) > 0) {minTime = logEntry.getDateAndTime();}
        if (maxTime.compareTo(logEntry.getDateAndTime()) < 0) {maxTime = logEntry.getDateAndTime();}
    }
    public double getTrafficRate (long totalTraffic) {
        return totalTraffic / (maxTime.getHour() - minTime.getHour());
    }
}

