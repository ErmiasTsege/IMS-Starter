
# Inventory Management System

An Inventory Management System made using the concepts of Object Oriented Analysis and Design.
  JAVA code is written in the eclipse editor and the MySql database is used to store data. The interface is console-based. 
  This project was designed during the QA JAVA script training program.

The Class Diagram of the project is also provided along with the Database Schema file. 
-ERD and UML diagrams can be found at the resource folder, src/main/resources

Topics Covered-
Classes and Objects, Inheritance, ArrayList, implementing Interface, Enums,JDBC, unit testing, Mockito testing suit, Maven, User-defined exception and Exception handling

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

What things you need to install the software and how to install them
1) Install the following software:
  - Java SE Development kit 14+ (JDK 14)
  - After installing JDK 14, install JRE 14
  - Then install eclipse IDE
  - Then finally install MySql open source database.
  
2) Open eclipse IDE --> Open Project and browse to the download folder named "Your Project Name" and select it. it will load the JAVA project
3) Before running the code and connecting to the database
   make sure to install and update MAVEN to the current/recent version.
4) Insert your database credentials in the file 
    db.properties
    Host: localhost
    Port: ****
    Database: ims
    User Name: ****
    password: ****

### Running the code
The code is designed based on multi-tiered architecture
 see the diagram at resource folder at src/main/resources

The code has three parts:
 -POJO
 -business layer 
 -data layer
The entire code can be run using the Runner.java file

#### Interfaces
The code runs from the console:
The following messages will run after successfully running the project:

Welcome to the Inventory Management System!
Select the tables then the CRUD operations you want to perform in that table.

Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
ORDERLINE: Order lines of items
STOP: To close the application

Invalid selection please try again
customer
What would you like to do with customer:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection

e.g see the file orderline.png at src/main/resources

## Running the tests
 -Unit testing 
 Junit and Mockito are used to test the code.
 
1) Unit testing applied to test the controller class in the business logic part
  "assertEqual" method from unit testing was applied 
   to test the validity of each method in the control classes
2)  Mockito testing framework was applied to test the DAO part of the business logic code.
  This testing method was used to test all the methods inside the DAO using the dummy object concept provided by Mockito unit testing Frame work. 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

***Ermias Tsege** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments
     I would like to thank my instructors Davis, Alan, Renolds, Edward, Walker, Alexander, Walsh, Morgan, Ryan Wright, and the entire QA community for their support and guidance throughout the program.
     I would like to extend my deepest gratitude to Infosys for giving me this training opportunity. 
