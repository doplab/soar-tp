# Software architecture
# Week 11 - Web sockets and JMS

# Requirements
1. Netbeans 11
2. Java Development Kit 8
3. Payara Server


# Asynchronous methods (Transactions)

# Webservices with JAX-WS

In this exercise, we will create a project that implements webservices using Java API for XML Web Services. In this project, we will deploy the Web Service and create a client which makes a request to our web services and display the result.

Let's create a new project (Web Application) called `JAX-WS` in Netbeans.

To create a new Webservice, right-click on your project > New > Web Services > Web Service. Let's call it `SimpleCalculator` and let's save it under `com.mycompany.jax.ws` and implement the `Web Service as Stateless Session Bean`.
<>


## Common errors
- `package javax.jws does not exist`: Make sure that you use `jdk 1.8`. To change the JDK version for your project, you have to right-click on the project > Properties > Build > Compile > Java Platform. Select the right JDK version

# Webservices with JAX-RS