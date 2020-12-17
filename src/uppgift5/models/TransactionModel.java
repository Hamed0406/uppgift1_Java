package uppgift5.models;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/17/2020
 */
public class TransactionModel {
    private final SimpleStringProperty transaction;
    private final SimpleStringProperty date;

    public TransactionModel(String  transaction, String date) {
        this.transaction = new SimpleStringProperty(transaction);
        this.date =new SimpleStringProperty(date);
    }

    public String getTransaction() {
        return transaction.get();
    }

    public SimpleStringProperty transactionProperty() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction.set(transaction);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    @Override
    public String toString() {
        return "TransactionModel{" +
                "transaction=" + transaction +
                ", date=" + date +
                '}';
    }
}
