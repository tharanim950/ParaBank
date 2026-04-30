package models;

public class Transaction {
    private String date;
    private String description;
    private String amount;
    private String type;

    public Transaction(String date, String description, String amount, String type) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
    }

    public String getDate() { return date; }
    public String getDescription() { return description; }
    public String getAmount() { return amount; }
    public String getType() { return type; }


}
