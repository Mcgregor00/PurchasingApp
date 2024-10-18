package org.ulpgc.is1.model;

import java.time.LocalDate;

public class Discount {
    private LocalDate from;
    private LocalDate to;
    private int percentage;

    public Discount(LocalDate from, LocalDate to, int percentage) {
        this.from = from;
        this.to = to;
        this.percentage = percentage;
    }

    public boolean isValid()  {
        LocalDate currentDate = LocalDate.now();
        return (currentDate.isEqual(from) || currentDate.isAfter(from)) &&
                (currentDate.isEqual(to) || currentDate.isBefore(to));
    }
    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public float getPercentage() {
        return (float) percentage / 100;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
