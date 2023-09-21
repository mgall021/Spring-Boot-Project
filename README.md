# Spring Boot Mini Project

## Description

Welcome to my E-commerce marvel, forged in Java and Spring Boot! This petite yet powerful backend, hosted on Tomcat, unveils a REST API that seamlessly interfaces with an H2 database. It empowers customers to explore products, make purchases (still in development), manage accounts, and execute various shopping operations with finesse.

## User Stories

1. **Customer Registration**: As a customer, I want to create an account on the platform with my email address and password.
2. **Customer Login**: As a customer, I want to log in to my account using my email address and password.
3. **Product Browsing**: As a customer, I want to browse the list of products available on the platform.
4. **Product Details**: As a customer, I want to view the details of a product, including its name and description.
5. **View Cart**: As a customer, I want to view my list of items.
6. **Customer Management**: As a logged-in customer, I want to view and update my profile information, including my name and email address.
7. **Product Management**: As a logged-in administrator, I want to manage products, including adding, updating, and deleting them.
8. **Customer Details**: As an administrator, I want to view detailed information about a customer, including their name and email address.

### Data Model
![Picture of ERD model](https://raw.githubusercontent.com/mgall021/Spring-Boot-Project/fc6e4e926a3f4d60f9533866ee269c462116ca69/Screenshot%202023-09-20%20at%204.44.58%20AM.png)

- A Customer can have one CustomerProfile, which contains information like their first name and last name.
- A Customer can have multiple Product entries, indicating the products associated with that customer.
- A Product can have multiple Location entries, which represent the locations associated with that product.

## Technologies Used

- **Java**: The primary programming language used for developing the application.
- **Spring Boot**: A powerful framework for building Java applications, providing features like RESTful web services, security, and data access.
- **IntelliJ IDEA**: An integrated development environment (IDE) for Java development.
- **H2 Database**: An in-memory relational database used for storing application data during development.
- **JWT Tokens (JSON Web Tokens)**: A method for securely transmitting information between parties as a JSON object.
- **Lombok**: A library that simplifies Java code by automatically generating getter, setter, and other boilerplate code.
- **ChatGPT**: Used to debug and to create params for certain methods.

## Getting Started

- The project was created using Spring Initializer.

## API Endpoints

- URL 'http://localhost:9094/api/products/'

- `/auth/customers/register`: Create a new customer account.
- `/auth/customers/login`: Log in to a customer account.
- `/products/`: Get a list of all products.
- `/products/{productId}`: Get details of a specific product.
- `/products/`: Create a new product (Administrator).
- `/products/{productId}`: Update a product (Administrator).
- `/products/{productId}`: Delete a product (Administrator).

## Acknowledgments

Special thanks to my fellow classmates for helping me:
- Kairo
- Julian
- Rick
