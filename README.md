# Supermarket-App
## Installation

You first need to clone the project to get a local copy. Then, in order to run it using only the terminal, make sure to have installed `Maven` from the official website (https://maven.apache.org/download.cgi). 

Check that maven is installed correctly using the command   
```bash
mvn -version 
```
If you encounter any problems, please consider this question at Stack Overflow-> https://stackoverflow.com/questions/19090928/mvn-command-is-not-recognized-as-an-internal-or-external-command .

Move to the folder of the project and run 
```bash
mvn package
```
in order to create the executable jar file.
## Usage
Move to the **target** folder of the project and run the following command 
```bash
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
  
