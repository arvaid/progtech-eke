package hu.uni.eszterhazy.warehouse.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private final List<Transaction> transactionList = new ArrayList<>();
    
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }
    
    public void cancelTransaction(Transaction transaction) {
        // TODO: cancel transaction
    }
    
    public int getTotalCost() {
        int total = 0;
        for (Transaction transaction : transactionList) {
            total += transaction.getTotalCost();
        }
        return total;
    }
}
