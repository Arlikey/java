package collections.db;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Fine {
    private final String fineId;
    private FineType type;
    private double amount;
    private LocalDateTime date;
    private String description;

    public Fine(FineType type, double amount, String description, LocalDateTime date) {
        this.fineId = UUID.randomUUID().toString();
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date == null ? LocalDateTime.now() : date;
    }

    public String getFineId() {
        return fineId;
    }

    public FineType getType() {
        return type;
    }

    public void setType(FineType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fine fine)) return false;
        return Double.compare(amount, fine.amount) == 0
                && Objects.equals(fineId, fine.fineId)
                && type == fine.type
                && Objects.equals(date, fine.date)
                && Objects.equals(description, fine.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fineId, type, amount, date, description);
    }

    @Override
    public String toString() {
        return "Fine{" +
                "fineId='" + fineId + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
