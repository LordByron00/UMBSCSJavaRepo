package progLanguages.bank;

import java.util.Date;

public class transaction {
    private String action;
    private double value;
    private Date date;

    public transaction(String action, double value) {
        this.action = action;
        this.value = value;
        this.date = new Date();
    }

    public String getAction() {
        return this.action;
    }

    public double getValue() {
        return this.value;
    }

    public Date getDate() {
        return this.date;
    }
}
