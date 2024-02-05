package net.ugurkartal.repos.concretes;

import net.ugurkartal.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo {
    private List<Order> orders;

    public OrderListRepo() {
        this.orders = new ArrayList<>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }

    public List<Order> getAllOrders (){
        return orders;
    }

    public Order getByIdOrder (long orderId){
        for (Order order : orders){
            if (order.id() == orderId){
                return order;
            }
        }
        return null;
    }
}
