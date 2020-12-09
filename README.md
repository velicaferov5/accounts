Project implemented as API in MVC structure as API to set accounts of customers and monitor transactions
API allows to insert, get accounts and customer.
Account have:
ID
Balance
Transactions

Customer have:
ID
Name
Surname
Account list

Requirement to run (Java version): 11

Definition of Architecture:
API has been developed in REST-ful architecture to provide services with JSON output.
Spring Boot (2.3.4 release) framework has been used to benefit it's rich, lightweight features, Spring data, Oath2, REST and etc. 
Maven has been used to easily add and resolve dependencies, automatically build application. 
Customer and Account models have been set to manage data in API.
All services and controllers have been tested using JUnit (4.13 version).
org.mockito.Mockito framework used to mock data in tests.
spring-boot's oauth2-client is used to authenticate user to access API.

REST-ful services in API:
URL: /api/
Input: none
Output: none
Type: Any
Use: To print API is working

URL: /api/account/new/{customerId}/{initialCredit}
Input: customerId (int), initialCredit (int)
Output: Account
Type: POST
Use: New Account (and Customer if not exist)

URL: /api/customer/get/{customerId}
Input: customerId (int)
Output: Customer
Type: GET
Use: Get customer by ID