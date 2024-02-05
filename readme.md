
## Coding: ProductRepo

Create a class  `ProductRepo`  that contains a list of  `Product`  objects.

-   Step 1: Create a record  `Product`  with the necessary attributes.
-   Step 2: Implement the  `ProductRepo`  class with a list to store products.
-   Step 3: Implement methods to add, remove, and get products (single product and all products).

## [](https://github.com/neuefische/hh-java-24-1-handouts/blob/main/2-Object-orientation/09-Recap-Project/challenges.md#coding-orderlistrepo)Coding: OrderListRepo

Create a class  `OrderListRepo`  that contains a list of  `Order`  objects.

-   Step 1: Create a record  `Order`  with the necessary attributes.
-   Step 2: Implement the  `OrderListRepo`  class with a list to store orders.
-   Step 3: Implement methods to add, remove, and (single order and all orders).

## [](https://github.com/neuefische/hh-java-24-1-handouts/blob/main/2-Object-orientation/09-Recap-Project/challenges.md#coding-shopservice)Coding: ShopService

Create a class  `ShopService`  through which we can place new orders.

-   Step 1: Implement a method to place a new order.
-   Step 2: Check if the ordered products exist. If not, print a System.out.println message.

## [](https://github.com/neuefische/hh-java-24-1-handouts/blob/main/2-Object-orientation/09-Recap-Project/challenges.md#coding-orderrepointerface)Coding: OrderRepoInterface

-   Step 1: Create an  `OrderRepo`  interface with the methods from the OrderListRepo (add, remove, and getSingle, getAll).

## [](https://github.com/neuefische/hh-java-24-1-handouts/blob/main/2-Object-orientation/09-Recap-Project/challenges.md#coding-ordermaprepo)Coding: OrderMapRepo

-   Create a class  `OrderMapRepo`  through which we can place new orders.
-   This class should also implement the  `OrderRepo`  interface.
-   In the main method, create either the  `OrderMapRepo`  or the  `OrderListRepo`  and pass it to the constructor of  `ShopService`  (as a constructor parameter that uses the interface).

## Bonus: Price, Quantity

For those with prior knowledge or additional interest in challenges.

-   Add a price to the product and a total price for an order.
-   Allow the user to specify and modify the quantity of products in an order.

## Bonus: Tests

-   Write meaningful tests for the classes  `ProductRepo`,  `OrderListRepo`, and  `ShopService`.
-   Use assertj matchers in your tests.