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
        products.add(new Product(newId, productName, price));
    }

    public void removeProduct(Product product){
        products.remove(product);
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
