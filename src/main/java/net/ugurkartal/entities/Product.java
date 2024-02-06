package net.ugurkartal.entities;

public record Product(
        long id,
        String name,
        double price,
        int stockAmount
) {
}