package net.ugurkartal.repos.concretes;

import net.ugurkartal.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductRepo() {
        this.products = new ArrayList<>();
    }

    public void addProduct(String productName, double price){
        long newId = products.isEmpty() ? 1 : products.getLast().id() + 1;
        Product newProduct = new Product(newId, productName, price);
        products.add(newProduct);
        System.out.println("Product added successfully");
    }

    public void removeProduct(long productId){
        for (Product product : products){
            if (product.id() == productId){
                products.remove(product);
                System.out.println("Product deleted");
                return;
            }
        }
        System.out.println("Product number is wrong");
    }

    public List<Product> getAllProducts (){
        return products;
    }

    public Product getByIdProduct (long productId){
        for (Product product : products){
            if (product.id() == productId){
                return product;
            }
        }
        return null;
    }
}
