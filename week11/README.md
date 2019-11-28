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
Through our messaging system, everybody will be able to log in and post messages in real-time.

To create our project using Netbeans, we will follow the steps below:
1. Open Netbeans
2. Create a New Project (File > New Project > Java with Maven > Web Application)
3. Let's call it "SoAr_sockets_week11", click on _Finish_. Our project is ready!
4. Separate our source code into packages. In order to have a better understanding of our code, we will separate each part of into packages. For this project, we will use two different packages:
   - Server (com.mycompany.server)
   - Client (com.mycompany.client)

## Server
The server Endpoint will consist in a simple POJO (Plain Old Java Object) with the adequate annotations. To create the server Endpoint, we have to add a new class to our project. Luckily, Netbeans allows us to generate new Endpoints. To do it, we have to Right click on our project > New > Other > Web > WebSocket Endpoint

<img src="https://github.com/doplab/soar-tp/blob/master/week11/images/endpoint.png?raw=True" alt="ServerEndPoint">

Now, we can add the additional methods and mention their role through annotations

>The Web Socket Endpoint represents an object that can handle websocket conversations. Developers may extend this class in order to implement a programmatic WebSocket endpoint. The Endpoint class holds lifecycle methods that may be overridden to intercept websocket open, error and close events.
> https://docs.oracle.com/javaee/7/api/javax/websocket/Endpoint.html

The required annotations for our project are the following:
- @serverEndpoint: This class level annotation declares that the class it decorates is a WebSocket endpoint that will be deployed and made available in the URI-space of a WebSocket server. The annotation allows the developer to define the URL (or URI template) which this endpoint will be published, and other important properties of the endpoint to the websocket runtime, such as the encoders it uses to send messages.
  
- @OnOpen: is used to annotate a method which will be called after WebSocket connection in opened. The method linked to this annotation takes two parameters: 
  - Session: the session that has just been activated
  - EndpointConfig(optional): the configuration used to configure the endpoint
  
- @OnClose: this method is called immediately prior to the session with the remote peer being closed. It is called whether the session is being closed because the remote peer initiated a close and sent a close frame, or whether the local websocket container or this endpoint requests to close the session. The method linked to this annotation takes two parameters:
  - Session: the session about to be closed
  - closeReason: the reason the session was closed.

- @OnMessage: this method-level annotation can be used for a Java method to receive incoming WebSocket messages. 
  
- @OnError: a method with @OnError is invoked when there is a problem with the communication

## Client

To communicate with the WebSocket server, the client has to initiate the WebSocket connection by sending an HTTP request to a server. This is called the *Handshake phase*. Except for this phase, the WebSocket protocol is totally independent from _HTTP_.
For this exercise session, we will use Javascript to create a WebSocket client. But first of all, we need to create the User Interface for our chat. To make it simple, we will only create two JSP pages and a servlet.


# JMS 

1. Open **NeatBeans IDE**    
2. Start the __Payara Server__    
3. Once Payara Server started, right-click on Payara Server and click on **View Domain Admin Console**    
4. You'll see the __Payara Server Console__ on your browser    
5. Click on **JMS Resource >> Connection Factories >> New**    
6. Write __jms/MyJMSExerciseConnectionFactory__ to JNDI Name and select **javax.jms.ConnectionFactory** from Resource Type list. Then, just click on OK    
7. Click on __JMS Resource >> Destination Resources >> New__    
8. Select **javax.jms.Queue** from Resource Type, write __jms/MyJMSExerciseQueue__ to JNDI Name and **myQueue** to Pyhsical Destination Name. Then, just click on OK    
9. Create a new __Enterprise Application Client__    

As you implement a JMS sender and a JMS receiver classes, you will need to import packages. Don't forget to check correct import statements! Here are the import statements you will need:    

For JMSSender.java class    
- javax.annotation.Resource    
- javax.jms.ConnectionFactory    
- javax.jms.JMSProducer    
- javax.jms.JMSContext    
- javax.jms.Queue    

For JMSReceiver.java class    
- javax.annotation.Resource    
- javax.jms.ConnectionFactory    
- javax.jms.JMSConsumer    
- javax.jms.JMSContext    
- javax.jms.Queue    

## Implementing JMS Sender (**JMSSender.java**)    
1. Add two private class variables called __connectionFactory__ type of **ConnectionFactory** and __queue_ type of **Queue**    
2. Add @Resource annotation for the class variable __connectionFactory__, define a mappedName and it's value should be the name of the connection factory (**jms/MyJMSExerciseConnectionFactory**)    
3. Add @Resource annotation for the class variable __queue__, define a mappedName and it's value should be the name of the queue (**jms/MyJMSExerciseQueue**)    
4. Write a main method    
5. Create a local variable called __jmsContext__ (type of **JMSContext**) and initialize it by calling __createContext()__ method of **connectionFactory** instance    
6. Create a local variable called __jmsProducer__ (type of **JMSProducer**) and initialize it by calling __createProducer()__ method of **jmsContext** instance    
7. Create a local String variable called __message__ and initialize it as you wish (i.e. "Hello JMS!")    
8. Tell the user that you're sending a message (Hint: print it!)
9. Call the **send(...)** method __jmsProducer__ using **queue** and __message__
10. Tell the user that the message is sent

# Implementing JMS Receiver (**JMSReceiver.java**)    
1. Add two private class variables called __connectionFactory__ type of **ConnectionFactory** and __queue_ type of **Queue**    
2. Add @Resource annotation for the class variable __connectionFactory__, define a mappedName and it's value should be the name of the connection factory (**jms/MyJMSExerciseConnectionFactory**)    
3. Add @Resource annotation for the class variable __queue__, define a mappedName and it's value should be the name of the queue (**jms/MyJMSExerciseQueue**)    
4. Write a main method    
5. Create a local variable called __jmsContext__ (type of **JMSContext**) and initialize it by calling __createContext()__ method of **connectionFactory** instance    
6. Create a local variable called __jmsConsumer__ (type of **JMSConsumer**) and initialize it by calling __createConsumer__ method of **jmsContext** instance using __queue__    
7. Tell the user that you're receiving message from JMS    
8. Create a local String variable called **message** and initialize it by calling __receiveBody(String.class)__ method of **jmsConsumer** instance    
9. Tell the user that you received the message and show the message    


#### Clean and Build your project, then Run JMSSender and JMSReceiver respectively!    

