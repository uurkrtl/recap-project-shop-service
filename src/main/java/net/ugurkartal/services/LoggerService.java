package net.ugurkartal.services;

import net.ugurkartal.entities.Product;
import net.ugurkartal.entities.StockLog;

import java.util.ArrayList;
import java.util.List;

public class LoggerService {
    private List<StockLog> stockLogs;

    public LoggerService(){
        this.stockLogs = new ArrayList<>();
    }

    public void addLog(Product product, String changeType, int changeAmount){
        long newId = stockLogs.isEmpty() ? 1 : stockLogs.getLast().logId() + 1;
        stockLogs.add(new StockLog(newId, product, changeType, changeAmount));
    }

    public List<StockLog> getAllInventoryLogs(){
        return stockLogs;
    }
}
