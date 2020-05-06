package BDD.object;

import java.sql.Date;

public class ObservationS {
    private Date date;
    private String type;
    private String remarque;

    public ObservationS(Date date, String type, String remarque) {
        this.date = date;
        this.type = type;
        this.remarque = remarque;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Date getDate() {
        return date;
    }

    public String getRemarque() {
        return remarque;
    }

    public String getType() {
        return type;
    }
}
