package net.ugurkartal.entities;

public record StockLog(
        long logId,
        Product product,
        String changeType,
        int changeAmount
) {
}