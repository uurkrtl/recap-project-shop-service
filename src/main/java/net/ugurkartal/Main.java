package net.ugurkartal;

import net.ugurkartal.repos.concretes.OrderMapRepo;
import net.ugurkartal.repos.concretes.ProductRepo;
import net.ugurkartal.services.ShopService;

public class Main {
    public static void main(String[] args) {
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        ProductRepo productRepo = new ProductRepo();
        ShopService shopService = new ShopService(orderMapRepo, productRepo);


        productRepo.addProduct("Computer");
        productRepo.addProduct("Keyboard");
        productRepo.addProduct("Mouse");

        shopService.newOrder(1);
        shopService.newOrder(2);
        shopService.newOrder(4);

        System.out.println("All orders: " + orderMapRepo.getAllOrders());
        System.out.println("All products: " + productRepo.getAllProducts());
    }
}