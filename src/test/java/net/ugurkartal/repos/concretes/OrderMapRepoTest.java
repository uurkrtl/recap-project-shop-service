package net.ugurkartal.repos.concretes;

import net.ugurkartal.entities.Order;
import net.ugurkartal.entities.Product;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapRepoTest {

    @Test
    void testAddOrder() {
        //Arrange
        Product product = new Product(1, "Product1", 10);
        Order order = new Order(1,product,1,10);
        OrderMapRepo orderMapRepo = new OrderMapRepo();

        //Act
        orderMapRepo.addOrder(order);
        List<Order> allOrdersAfterAddition = orderMapRepo.getAllOrders();

        //Assert
        assertThat(allOrdersAfterAddition).isNotNull().hasSize(1).containsExactly(order);
    }

    @Test
    void testRemoveOrder() {
        //Arrange
        Product product = new Product(1, "Product1", 10);
        Order order = new Order(1,product,1,10);
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        orderMapRepo.addOrder(order);

        //Act
        orderMapRepo.removeOrder(order.id());
        List<Order> allOrdersAfterDeletion = orderMapRepo.getAllOrders();

        //Assert
        assertThat(allOrdersAfterDeletion).isNotNull().hasSize(0);
    }

    @Test
    void testGetAllOrders() {
        Product product1 = new Product(1, "Product1", 10);
        Product product2 = new Product(1, "Product2", 20);
        Order order1 = new Order(1,product1,1,10);
        Order order2 = new Order(1,product2,1,20);
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        orderMapRepo.addOrder(order1);
        orderMapRepo.addOrder(order2);

        List<Order> expectedOrders = Arrays.asList(order1,order2);

        //Act
        List<Order> actualOrders = orderMapRepo.getAllOrders();

        //Assert
        assertThat(actualOrders).isNotNull().hasSize(2).containsExactlyElementsOf(expectedOrders);
    }

    @Test
    void getByIdOrder() {
        //Arrange
        Product product1 = new Product(1, "Product1", 10);
        Product product2 = new Product(1, "Product2", 20);
        Order expectedOrder = new Order(1,product1,1,10);
        Order otherOrder = new Order(1,product2,1,20);
        OrderMapRepo orderMapRepo = new OrderMapRepo();
        orderMapRepo.addOrder(expectedOrder);
        orderMapRepo.addOrder(otherOrder);

        //Act
        Order actualOrder = orderMapRepo.getByIdOrder(1);

        //Assert
        assertThat(actualOrder).isNotNull().isEqualTo(expectedOrder);
    }
}