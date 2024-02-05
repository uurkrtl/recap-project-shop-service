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

    public void newOrder(long productId){
        long newId = orderRepo.getAllOrders().isEmpty() ? 1 : orderRepo.getAllOrders().getLast().id() + 1;
        Product product = productRepo.getByIdProduct(productId);
        if (product != null){
            orderRepo.addOrder(new Order(newId, product));
            System.out.println("Product added: " + product.name());
        }else {
            System.out.println("Product could not be added: Not available");
        }
    }
}
