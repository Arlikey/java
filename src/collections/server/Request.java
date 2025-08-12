package collections.server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Request {
    private LocalDateTime requestTime;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private String request;

    private DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:A");

    public Request(String request) {
        this.requestTime = LocalDateTime.now();
        this.request = request;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public String getRequest() {
        return request;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public String getRequestInfo() {
        return "\n\tRequest: " + request
                + " | Request Time: " + requestTime.format(pattern)
                + " | Start Time: " + startTime.format(pattern)
                + " | Finish Time: " + (finishTime != null ? finishTime.format(pattern) : "not yet processed");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request request1)) return false;
        return Objects.equals(requestTime, request1.requestTime)
                && Objects.equals(startTime, request1.startTime)
                && Objects.equals(finishTime, request1.finishTime)
                && Objects.equals(request, request1.request)
                && Objects.equals(pattern, request1.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestTime, startTime, finishTime, request, pattern);
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestTime=" + requestTime +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", request='" + request + '\'' +
                '}';
    }
}
