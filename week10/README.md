# Software architecture
# Week 10 - Asynchronous methods, Web sockets and JMS

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
3. Let's call it "SoAr_sockets_week10", click on _Finish_. Your project is ready!
4. Separate our source code into packages. In order to have a better understanding of our code, we will separate each part of our code into packages. For this project, we will use two different packages:
   - Server (com.mycompany.server)
   - Client (com.mycompany.client)

## Server
The server Endpoint will consist in a simple POJO (Plain Old Java Object) with the adequate annotations. To create the server Endpoint, we have to add a new class to our project. Luckily, Netbeans allows us to generate new Endpoints. To do it, we have to Right click on our project > New > Other > Web > WebSocket Endpoint

<img src="https://github.com/doplab/soar-tp/blob/master/week10/images/endpoint.png?raw=True" alt="ServerEndPoint">

Now, we can add the additional methods and mention their role through annotations

>The Web Socket Endpoint represents an object that can handle websocket conversations. Developers may extend this class in order to implement a programmatic websocket endpoint. The Endpoint class holds lifecycle methods that may be overridden to intercept websocket open, error and close events.
> https://docs.oracle.com/javaee/7/api/javax/websocket/Endpoint.html

The required annotations for our project are the following:
- @serverEndpoint: 
- @OnOpen: is used to annotate a method which will be called after WebSocket connection in opened. The method linked to this annotation takes two parameters: 
  - Session: the session that has just been activated
  - EndpointConfig(optional): the configuration used to configure the endpoint
- @OnClose: this method is called immediately prior to the session with the remote peer being closed. It is called whether the session is being closed because the remote peer initiated a close and sent a close frame, or whether the local websocket container or this endpoint requests to close the session. The method linked to this annotation takes two parameters:
  - Session: the session about to be closed
  - closeReason: the reason the session was closed.
- @OnMessage: this method level annotation can be used to make a Java method receive incoming web socket messages. 

## Client

# JMS