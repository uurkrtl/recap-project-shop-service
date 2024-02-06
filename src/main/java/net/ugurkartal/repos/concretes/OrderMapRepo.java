package net.ugurkartal.repos.concretes;

import net.ugurkartal.entities.Order;
import net.ugurkartal.repos.abstracts.OrderRepo;
import net.ugurkartal.services.LoggerService;

import java.util.ArrayList;
import java.util.List;

public class OrderMapRepo implements OrderRepo {
    private List<Order> orders;
    private LoggerService loggerService;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public OrderMapRepo(LoggerService loggerService) {
        this.orders = new ArrayList<>();
        this.loggerService = loggerService;
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(long orderId) {
        for (Order order : orders){
            if (order.id() == orderId){
                loggerService.addLog(order.product(), "Stock increase (Order cancellation)", order.quantity());
                orders.remove(order);
                System.out.println("Transaction successful");
                return;
            }
        }
        System.out.println("Order not found");
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public Order getByIdOrder(long orderId) {
        for (Order order : orders){
            if (order.id() == orderId){
                return order;
            }
        }
        return null;
    }
}
