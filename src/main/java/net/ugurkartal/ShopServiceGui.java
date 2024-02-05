package net.ugurkartal;

import net.ugurkartal.entities.Order;
import net.ugurkartal.entities.Product;
import net.ugurkartal.repos.concretes.OrderMapRepo;
import net.ugurkartal.repos.concretes.ProductRepo;
import net.ugurkartal.services.ShopService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShopServiceGui {
    static Scanner scanner = new Scanner(System.in);
    static OrderMapRepo orderMapRepo = new OrderMapRepo();
    static ProductRepo productRepo = new ProductRepo();
    static ShopService shopService = new ShopService(orderMapRepo, productRepo);
    public static void main(String[] args) throws InterruptedException, IOException {
        showMenu();

        /*
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

        orderMapRepo.removeOrder(2);
        System.out.println(orderMapRepo.getAllOrders());

         */
    }

    public static void showMenu() throws InterruptedException, IOException {
        System.out.println(
                "\n**Product Management**\n" +
                        "\t11: New product\n" +
                        "\t12: Remove product\n" +
                        "\t13: Products list\n" +
                        "\t14: Product by Id\n" +
                        "**Order Management**\n" +
                        "\t21: New order\n" +
                        "\t22: Update order quantity\n" +
                        "\t23: Cancel order\n" +
                        "\t24: Orders list\n" +
                        "\t25: Order by Id\n" +
                        "9: Exit"
        );
        System.out.println("Please enter transaction number: ");
        int transactionNo = 0;
        try {
            transactionNo = scanner.nextInt();
            if ((transactionNo !=9 && transactionNo < 11) || (transactionNo > 14 && transactionNo < 21) || transactionNo > 25){
                throw new InputMismatchException();
            }
        }catch (InputMismatchException ex){
            System.out.println("You entered the wrong number");
            Thread.sleep(2000);
            showMenu();
        }
        if (transactionNo ==9){
            Runtime.getRuntime().exit(0);
        }else {
            takeAction(transactionNo);
        }
    }

    public static void takeAction (int transactionNo) throws InterruptedException, IOException {
        switch (transactionNo){
            case 11:
                System.out.println("**New Product**");
                System.out.println("Product name: ");
                String productName = scanner.next();
                System.out.println("Product price: ");
                int productPrice = scanner.nextInt();
                productRepo.addProduct(productName, productPrice);
                pressAnyKey();
            case 12:
                System.out.println("**Remove Product**");
                System.out.println("ID of the product to be deleted: ");
                int deleteId = scanner.nextInt();
                productRepo.removeProduct(deleteId);
                pressAnyKey();
            case 13:
                System.out.println("**Products List**");
                System.out.println("ID\tProduct Name\tPrice");
                for (Product product : productRepo.getAllProducts()){
                    System.out.printf("%d\t%s\t\t%.2f\n", product.id(), product.name(), product.price());
                }
                pressAnyKey();
            case 14:
                System.out.println("**Product Details**");
                System.out.println("Product ID: ");
                int searchProductId = scanner.nextInt();
                Product product = productRepo.getByIdProduct(searchProductId);
                System.out.println("ID\tProduct Name\tPrice");
                System.out.printf("%d\t%s\t\t%.2f\n", product.id(), product.name(), product.price());
                pressAnyKey();
            case 21:
                System.out.println("**New Order**");
                System.out.println("Product ID: ");
                int newOrderProductId = scanner.nextInt();
                System.out.println("Quantity: ");
                int newOrderQuantity = scanner.nextInt();
                shopService.newOrder(newOrderProductId, newOrderQuantity);
                pressAnyKey();
            case 22:
                System.out.println("**Update Quantity Of Order**");
                System.out.println("Product ID: ");
                int updateOrderProductId = scanner.nextInt();
                System.out.println("New quantity: ");
                int updateOrderQuantity = scanner.nextInt();
                shopService.updateOrderQuantity(updateOrderProductId, updateOrderQuantity);
                pressAnyKey();
            case 23:
                System.out.println("**Cancel Order**");
                System.out.println("Order id to be canceled: ");
                int cancelOrderId = scanner.nextInt();
                orderMapRepo.removeOrder(cancelOrderId);
                pressAnyKey();
            case 24:
                System.out.println("**Orders List**");
                System.out.println("ID\tProduct Name\tQuantity\tTotal Price");
                for (Order order : orderMapRepo.getAllOrders()){
                    System.out.printf("%d\t%s\t%d\t%.2f\n", order.id(), order.product().name(), order.quantity(), order.totalPrice());
                }
                pressAnyKey();
            case 25:
                System.out.println("**Order Details**");
                System.out.println("Order ID: ");
                int searchOrderId = scanner.nextInt();
                Order order = orderMapRepo.getByIdOrder(searchOrderId);
                System.out.println("ID\tProduct Name\tQuantity\tTotal Price");
                System.out.printf("%d\t%s\t%d\t%.2f\n", order.id(), order.product().name(), order.quantity(), order.totalPrice());
                pressAnyKey();
        }
    }
    public static void pressAnyKey() throws IOException, InterruptedException {
        System.out.println("Press any key to continue");
        System.in.read();
        scanner.nextLine();
        showMenu();
    }
}