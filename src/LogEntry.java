import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogEntry {

    private final String ipAddress;
    private final LocalDateTime dateAndTime;
    private final HttpMethods method;
    private final String requestPath;
    private final int statusCode;
    private final int dataSize;
    private final String referer;
    private final UserAgent userAgent;

    public LogEntry(String[] lineFragments) {
        this.ipAddress = lineFragments[0];
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy:HH:mm:s", Locale.ENGLISH);
        this.dateAndTime= LocalDateTime.parse(lineFragments[3].replaceAll("\\/", "-")
                .replaceAll("\\[", ""), dateTimeFormatter);
        this.method = HttpMethods.valueOf(lineFragments[5].replaceAll("\"",""));
        this.requestPath = lineFragments[6];
        this.statusCode = Integer.parseInt(lineFragments[8]);
        this.dataSize = Integer.parseInt(lineFragments[9]);
        this.referer = lineFragments[10];
        this.userAgent = new UserAgent(lineFragments[10]);
        }


    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public HttpMethods getMethod() {
        return method;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getDataSize() {
        return dataSize;
    }

    public String getReferer() {
        return referer;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }
}