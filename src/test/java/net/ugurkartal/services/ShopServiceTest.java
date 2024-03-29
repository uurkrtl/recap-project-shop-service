package net.ugurkartal.services;

import net.ugurkartal.entities.Order;
import net.ugurkartal.entities.Product;
import net.ugurkartal.repos.concretes.OrderMapRepo;
import net.ugurkartal.repos.concretes.ProductRepo;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void testNewOrder() {
        //Arrange
        OrderMapRepo orderMapRepo = new OrderMapRepo(new LoggerService());
        ProductRepo productRepo = new ProductRepo(new LoggerService());
        LoggerService loggerService = new LoggerService();
        ShopService shopService = new ShopService(orderMapRepo, productRepo, loggerService);
        productRepo.addProduct("Product", 10, 10);

        Product product = new Product(1, "Product", 10, 10);
        Order expectedOrder = new Order(1, product, 1, 10);

        //Act
        shopService.newOrder(1, 1);
        List<Order> allProductsAfterAddition = orderMapRepo.getAllOrders();

        //Assert
        assertThat(allProductsAfterAddition).isNotNull().hasSize(1).containsExactly(expectedOrder);
    }

    @Test
    void testNewOrder_StockControl() {
        //Arrange
        OrderMapRepo orderMapRepo = new OrderMapRepo(new LoggerService());
        ProductRepo productRepo = new ProductRepo(new LoggerService());
        LoggerService loggerService = new LoggerService();
        ShopService shopService = new ShopService(orderMapRepo, productRepo, loggerService);
        productRepo.addProduct("Product", 10, 10);

        Product product = new Product(1, "Product", 10, 10);
        Product expectedProduct = new Product(1, "Product", 10, 9);

        //Act
        shopService.newOrder(1, 1);
        List<Product> allProductsAfterOrder = productRepo.getAllProducts();

        //Assert
        assertThat(allProductsAfterOrder).isNotNull().hasSize(1).containsExactly(expectedProduct);
    }

    @Test
    void testNewOrder_StockControl_whenNoStock_thenNoOrder() {
        //Arrange
        OrderMapRepo orderMapRepo = new OrderMapRepo(new LoggerService());
        ProductRepo productRepo = new ProductRepo(new LoggerService());
        LoggerService loggerService = new LoggerService();
        ShopService shopService = new ShopService(orderMapRepo, productRepo, loggerService);
        productRepo.addProduct("Product", 10, 10);

        Product product = new Product(1, "Product", 10, 10);
        Product expectedProduct = new Product(1, "Product", 10, 10);

        //Act
        shopService.newOrder(1, 11);
        List<Product> allProductsAfterOrder = productRepo.getAllProducts();

        //Assert
        assertThat(allProductsAfterOrder).isNotNull().hasSize(1).containsExactly(expectedProduct);
    }

    @Test
    void testUpdateOrderQuantity() {
        //Arrange
        OrderMapRepo orderMapRepo = new OrderMapRepo(new LoggerService());
        ProductRepo productRepo = new ProductRepo(new LoggerService());
        LoggerService loggerService =new LoggerService();
        ShopService shopService = new ShopService(orderMapRepo, productRepo, loggerService);
        productRepo.addProduct("Product", 10, 10);
        shopService.newOrder(1, 10);

        Product product = new Product(1, "Product", 10, 10);
        Order expectedOrder = new Order(1, product, 5, 50);

        //Act
        shopService.updateOrderQuantity(1, 5);
        List<Order> allProductsAfterUpdate = orderMapRepo.getAllOrders();

        //Assert
        assertThat(allProductsAfterUpdate).isNotNull().hasSize(1).containsExactly(expectedOrder);
    }
}