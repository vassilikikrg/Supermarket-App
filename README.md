# Supermarket-App 🛒
This is a comprehensive e-commerce website for a supermarket chain that provides a range of functionalities to both customers and administrators, enabling a seamless shopping experience.

🧑🏽 **Customers** can:
1. Browse Products: Customers can view a wide range of products available in the supermarket. The website allows users to explore the entire product catalog effortlessly.
2. Filter Products: Customers can conveniently filter products based on price and category. This feature enables users to narrow down their search and find products that align with their preferences.
3. View Product Details: Customers can access detailed information about a specific product. This includes product descriptions, pricing, availability, and other relevant details.
4. Purchase Products: After choosing the desired product, customers can purchase it by selecting the preferred store. The website dynamically updates the availability of products based on each supermarket, ensuring a smooth purchasing process.
5. View the Shopping Cart: Customers can add products to their shopping cart, view the contents, and modify the quantity of each item. This feature enables users to manage their selections before proceeding to the checkout.
6. Place Orders: Customers can finalize their purchase by making an order. They will be required to log in and provide their card information for secure transactions. This ensures a seamless and secure checkout experience.
7. Register & Login: Customers can create an account, log in, and register their personal information. This authentication process enables secure access to additional features, such as placing orders.

👔 **Admins** can:

1. Login: Administrators can log in to the website using their unique credentials. This secure login ensures that only authorized personnel can access the administrator functionalities.
2. Add New Products: Administrators can add new products to the supermarket catalog. This feature allows for easy expansion of the product offerings and ensures that customers have access to the latest items.
3. Restock Products: Administrators can manage the inventory by restocking products to specific stores. This functionality ensures that each store has an adequate supply of products, maintaining a consistent availability for customers.

## Installation

You first need to clone the project to get a local copy. Then, in order to run it using only the terminal, make sure to have installed [Maven](https://maven.apache.org/download.cgi) from the official website. 

Check that maven is installed using the command   
```
mvn -version 
```
If you encounter any problems, please consider this question at Stack Overflow-> https://stackoverflow.com/questions/19090928/mvn-command-is-not-recognized-as-an-internal-or-external-command .

Move to the folder of the project and run 
```
mvn package
```
in order to create the executable jar file.
## Usage
Move to the **target** folder of the project and run the following command 
```
java -jar Supermarket-0.0.1-SNAPSHOT.jar
```
The website now is running at **http://localhost:8080** and its home page is at **http://localhost:8080/home**

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Security](https://spring.io/projects/spring-security) - The authentication and access-control framework used
* [JPA](https://www.oracle.com/java/technologies/persistence-jsp.html) - The API used for object-relational mappings and for managing persistent objects
* [MySQL](https://www.mysql.com/) - The RDBMS used to store the data
* [Thymeleaf](https://www.thymeleaf.org/) - The Java template engine

 ## License

This project is licensed under the GNU General Public License - see the [LICENSE](LICENSE) file for details
