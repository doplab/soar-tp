# Software architecture
# Week 11 - Web sockets and JMS

# Requirements
1. Netbeans 11
2. Java Development Kit 8
3. Payara Server
4. Web socket API


# Asynchronous methods

# Web sockets

Web socket provides a persistent connection between a client and a server. It's an alternative to the limitation of efficient communication between the server and the web browser. It works on the underlying TCP/IP connections and provides **bi-directional**, **full-duplex**, **low-latency** and **real-time** client/server communications.

The Expert Group that defined the Java API for websocket (JSR) 356 wanted to support patterns and techniques that are common to Java EE developers. As a consequence, JSR 356 leverages annotations and injection.

In this exercise session, we will create a real-time chat web application based on the Java API for Websockets.
Through our messaging system, everybody will be able to login an post messages in real-time.

To create our project using Netbeans, we will follow the steps below:
1. Open Netbeans
2. Create a New Project (File > New Project > Java with Maven > Web Application)
3. Let's call it "SoAr_sockets_week11", click on _Finish_. Your project is ready!
4. Separate our source code into packages. In order to have a better understanding of our code, we will separate each part of our code into packages. For this project, we will use two different packages:
   - Server (com.mycompany.server)
   - Client (com.mycompany.client)

## Server
The server Endpoint will consist in a simple POJO (Plain Old Java Object) with the adequate annotations. To create the server Endpoint, we have to add a new class to our project. Luckily, Netbeans allows us to generate new Endpoints. To do it, we have to Right click on our project > New > Other > Web > WebSocket Endpoint

<img src="https://github.com/doplab/soar-tp/blob/master/week11/images/endpoint.png?raw=True" alt="ServerEndPoint">

Now, we can add the additional methods and mention their role through annotations

>The Web Socket Endpoint represents an object that can handle websocket conversations. Developers may extend this class in order to implement a programmatic websocket endpoint. The Endpoint class holds lifecycle methods that may be overridden to intercept websocket open, error and close events.
> https://docs.oracle.com/javaee/7/api/javax/websocket/Endpoint.html

The required annotations for our project are the following:
- @serverEndpoint: This class level annotation declares that the class it decorates is a web socket endpoint that will be deployed and made available in the URI-space of a web socket server. The annotation allows the developer to define the URL (or URI template) which this endpoint will be published, and other important properties of the endpoint to the websocket runtime, such as the encoders it uses to send messages.
  
- @OnOpen: is used to annotate a method which will be called after WebSocket connection in opened. The method linked to this annotation takes two parameters: 
  - Session: the session that has just been activated
  - EndpointConfig(optional): the configuration used to configure the endpoint
  
- @OnClose: this method is called immediately prior to the session with the remote peer being closed. It is called whether the session is being closed because the remote peer initiated a close and sent a close frame, or whether the local websocket container or this endpoint requests to close the session. The method linked to this annotation takes two parameters:
  - Session: the session about to be closed
  - closeReason: the reason the session was closed.

- @OnMessage: this method level annotation can be used to make a Java method receive incoming web socket messages. 
  
- @OnError: A method with @OnError is invoked when there is a problem with the communication

## Client

# JMS



# Future Exercise

1. Create a new Java application.    

2. Create a class called **FactorialFuture**. Add followings:    
2.1. A private instance variable called __executor__ and initialize it with **Executors.newSingleThreadExecutor()**    
2.2. A public method called __calculateFactorial__, which takes a parameter called **number** (is type of Integer). The method returns a value which is a type of __Future\<Integer\>__.    
2.3. The body of the method should be as follows:    
````
return executor.submit(() -> {    
    Thread.sleep(1000);    
    int fact = 1;    
    for (int i = 1; i <= number; i++) {    
        fact *= i;    
    }    
    return fact;    
});    
````

3. In the main method, create a __FactorialFuture__ object. Declare at least 2 **Future\<Integer\>** variables and initialize them by calling __calculateFactorial__ method of **FactorialFuture** class.

4. Implement the following simple algorithm.
````
f1,f2 <- Future<Integer>
while f1 and f2 are not done
    if f1.isDone then print "F1 is done"
    else print "F1 is not done"
    if f2.isDone then print "F2 is done"
    else print "F2 is not done"
    Thread.sleep(300) // add this line as it is
result1 <- f1.get
result2 <- f2.get
print result1 and result2
System.exit(0) // add this line as it is
````

5. Import statements should be as follows:
5.1. In class __FactorialFuture__
- java.util.concurrent.ExecutorService
- java.util.concurrent.Executors
- java.util.concurrent.Future
5.2. In the **MainClass**
- java.util.concurrent.ExecutionException
- java.util.concurrent.Future

6. Don't forget to add catch/throw statements when it's needed.

7. RUN your code!
