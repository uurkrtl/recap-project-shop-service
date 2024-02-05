package net.ugurkartal.repos.abstracts;

import net.ugurkartal.entities.Order;

import java.util.List;

public interface OrderRepo {
    void addOrder(Order order);
    void removeOrder(long orderId);
    List<Order> getAllOrders ();
    Order getByIdOrder (long orderId);
}