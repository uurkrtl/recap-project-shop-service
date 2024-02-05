package net.ugurkartal.repos.concretes;

import net.ugurkartal.entities.Product;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void testGetAllProducts() {
        //Arrange
        Product product1 = new Product(1,"Product1", 5);
        Product product2 = new Product(2, "Product2", 10);
        List<Product> expectedProducts = Arrays.asList(product1, product2);

        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct("Product1", 5);
        productRepo.addProduct("Product2", 10);

        //Act
        List<Product> actualProducts = productRepo.getAllProducts();

        //Assert
        assertThat(actualProducts).isNotNull().hasSize(2).containsExactlyElementsOf(expectedProducts);
    }

    @Test
    void testAddProduct() {
        //Arrange
        Product product1 = new Product(1,"Product", 5);
        ProductRepo productRepo = new ProductRepo();

        //Act
        productRepo.addProduct("Product", 5);
        List<Product> allProductsAfterAddition = productRepo.getAllProducts();

        //Assert
        assertThat(allProductsAfterAddition).isNotNull().hasSize(1).containsExactly(product1);

    }

    @Test
    void testRemoveProduct() {
        //Arrange
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct("Product", 5);

        //Act
        productRepo.removeProduct(1);
        List<Product> allProductsAfterDeletion = productRepo.getAllProducts();

        //Assert
        assertThat(allProductsAfterDeletion).isNotNull().hasSize(0);
    }

    @Test
    void getByIdProduct() {
        //Arrange
        Product expectedProduct = new Product(1,"Product1", 5);
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct("Product1", 5);
        productRepo.addProduct("Other product", 10);

        //Act
        Product actualProduct = productRepo.getByIdProduct(1);

        //Assert
        assertThat(actualProduct).isNotNull().isEqualTo(expectedProduct);
    }
}