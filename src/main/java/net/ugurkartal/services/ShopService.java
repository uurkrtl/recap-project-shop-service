package net.ugurkartal.services;

import net.ugurkartal.entities.Order;
import net.ugurkartal.entities.Product;
import net.ugurkartal.repos.abstracts.OrderRepo;
import net.ugurkartal.repos.concretes.ProductRepo;

public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public void newOrder(long productId, int quantity){
        long newId = orderRepo.getAllOrders().isEmpty() ? 1 : orderRepo.getAllOrders().getLast().id() + 1;
        Product product = productRepo.getByIdProduct(productId);
        if (product != null){
            if (product.stockAmount() - quantity < 0){
                System.out.println("Not enough stock. Current stock: " + product.stockAmount());
            }else {
                orderRepo.addOrder(new Order(newId, product, quantity, quantity * product.price()));
                productRepo.addProductWithId(product.id(), product.name(), product.price(), product.stockAmount() - quantity);
                productRepo.removeProduct(productId);
                System.out.println("Order created: " + product.name());
            }

        }else {
            System.out.println("Product could not be added: Not available");
        }
    }

    public void updateOrderQuantity (long orderId, int newQuantity){
        for (Order order : orderRepo.getAllOrders()){
            if (order.id() == orderId){
                orderRepo.addOrder(new Order(order.id(), order.product(),newQuantity, order.product().price() * newQuantity));
                orderRepo.removeOrder(order.id());
                System.out.println("Order quantity updated");
                return;
            }
                System.out.println("Order number is wrong");
        }
    }
}
