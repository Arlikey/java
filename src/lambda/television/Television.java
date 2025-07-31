package lambda.television;

import java.util.Objects;

public class Television {
    private String model;
    private int year;
    private double price;
    private double diagonal;
    private double refreshRate;
    private String manufacturer;
    private boolean isSmartTV;

    public Television() {
    }

    public Television(String model, int year, double price, double diagonal, double refreshRate, String manufacturer, boolean isSmartTV) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.diagonal = diagonal;
        this.refreshRate = refreshRate;
        this.manufacturer = manufacturer;
        this.isSmartTV = isSmartTV;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1926) this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) this.price = price;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        if (diagonal > 0) this.diagonal = diagonal;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(double refreshRate) {
        if (refreshRate > 0) this.refreshRate = refreshRate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isSmartTV() {
        return isSmartTV;
    }

    public void setSmartTV(boolean smartTV) {
        isSmartTV = smartTV;
    }

    public double getScore() {
        double score = diagonal + refreshRate * 0.2;
        if (isSmartTV) score += 10;
        score -= price * 0.01;
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television that)) return false;
        return year == that.year
                && Double.compare(price, that.price) == 0
                && Double.compare(diagonal, that.diagonal) == 0
                && Double.compare(refreshRate, that.refreshRate) == 0
                && isSmartTV == that.isSmartTV
                && Objects.equals(model, that.model)
                && Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year, price, diagonal, refreshRate, manufacturer, isSmartTV);
    }

    @Override
    public String toString() {
        return "Television{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", diagonal=" + diagonal +
                ", refreshRate=" + refreshRate +
                ", manufacturer='" + manufacturer + '\'' +
                ", isSmartTV=" + isSmartTV +
                '}';
    }
}
