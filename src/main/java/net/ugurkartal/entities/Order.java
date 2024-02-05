package net.ugurkartal.entities;

public record Order(
        long id,
        Product product,
        int quantity,
        double totalPrice
) {
}
