import java.util.Date;

/**
 * Created by Jasmin on 1/16/2017.
 */
public class History {

    public static final String TABLE_NAME = "history";
    public static final String COLUMN_ID = "_id";   //primary key
    public static final String COLUMN_TRANS_NUMBER = "trans_number";
    public static final String COLUMN_TRANS_PRICE= "trans_price";
    public static final String COLUMN_TRANS_DETAILS = "trans_details";

    private int id, number;
    private double price;
    private float rating;
    private Date date;
    private String comment;

    public History() {

    }

    public History(int number, Date date) {
        this.number = number;
        this.date = date;
    }

    public History(int number, Date date, double price) {
        this.number = number;
        this.date = date;
        this.price = price;
    }

    public History(int trans_number, double trans_price, String trans_details) {
        this.number = trans_number;
        this.price = trans_price;
        this.comment = trans_details;
    }
    
    public History(int trans_number, double trans_price, float rating, Date date, String comment) {
        this.number = trans_number;
        this.price = trans_price;
        this.rating = rating;
        this.date = date;
        this.comment = comment;
    }

    public int getTrans_number() {
        return number;
    }

    public void setTrans_number(int trans_number) {
        this.number = trans_number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String details) {
        this.comment = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
