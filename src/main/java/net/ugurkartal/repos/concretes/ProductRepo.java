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

    public void addProduct(String productName, double price, int stockAmount){
        long newId = products.isEmpty() ? 1 : products.getLast().id() + 1;
        Product newProduct = new Product(newId, productName, price, stockAmount);
        products.add(newProduct);
        System.out.println("Product added successfully");
    }

    public void addProductWithId(long id, String productName, double price, int stockAmount){
        Product newProduct = new Product(id, productName, price, stockAmount);
        products.add(newProduct);
    }

    public void removeProduct(long productId){
        for (Product product : products){
            if (product.id() == productId){
                products.remove(product);
                System.out.println("Transaction successful");
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

    public void productEntry (long productId, int addedAmount){
        for (Product product : products){
            if (product.id() == productId){
                Product newProduct = new Product(product.id(), product.name(), product.price(), product.stockAmount() + addedAmount);
                products.add(newProduct);
                products.remove(product);
                System.out.println("New stock added to the product");
                return;
            }
        }
        System.out.println("Product ID is incorrect");
    }

    public void unsaledStockIssue(long productId, int reducedAmount){
        for (Product product : products){
            if (product.id() == productId){
                if (product.stockAmount() >= reducedAmount){
                    Product newProduct = new Product(product.id(), product.name(), product.price(), product.stockAmount() - reducedAmount);
                    products.add(newProduct);
                    products.remove(product);
                    System.out.println("Stock quantity updated");
                }else {
                    System.out.println("Stock quantity is incorrect. Current stock: " + product.stockAmount());
                }
                return;
            }
        }
        System.out.println("Product ID is incorrect");
    }
}