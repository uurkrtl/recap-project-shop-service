package net.ugurkartal;

import net.ugurkartal.repos.concretes.OrderMapRepo;
import net.ugurkartal.repos.concretes.ProductRepo;
import net.ugurkartal.services.ShopService;

public class Main {
    public static void main(String[] args) {
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        ProductRepo productRepo = new ProductRepo();
        ShopService shopService = new ShopService(orderMapRepo, productRepo);


        productRepo.addProduct("Computer", 1000);
        productRepo.addProduct("Keyboard", 15);
        productRepo.addProduct("Mouse", 5);

        shopService.newOrder(1, 5);
        shopService.newOrder(2, 20);
        shopService.newOrder(4, 10);

        System.out.println("All orders: " + orderMapRepo.getAllOrders());
        System.out.println("All products: " + productRepo.getAllProducts());

        shopService.updateOrderQuantity(1, 10);
        System.out.println("All orders: " + orderMapRepo.getAllOrders());
    }
}