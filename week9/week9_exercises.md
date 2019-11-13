# Software architecture
# Week 9 - JSP/JSF

# Requirements
1. Netbeans 11
2. Java Development Kit 8
3. Payara Server

# Sample project

To introduce the principle of JSP and JSF, we will create a simple web project using these technologies.
We will create our project using Netbeans and we will deploy it on a Payara server.

The goal of this project is to create a simple page containing a form. We will use this form to register employees.
Each employee should have an First name, last name and a position.

## JavaServer Page


## JavaServer Faces

> JavaServer Faces (JSF) is a user interface (UI) framework for Java web applications. It is designed to significantly ease the burden of writing and maintaining applications that run on a Java application server and render their UIs back to a target client.

JSF is based on the Model-View-Controller (MVC) Pattern.

To create our project using Netbeans, we will follow the steps below:
1. Open Netbeans
2. Create a New Project (File > New Project > Java with Maven > Web Application)
3. Let's call it "Sample_JSF", click on _Finish_. Your project is ready!
4. Separate our source code into packages. In order to have a better understanding of our code, we will separate each part of our code into packages. For this project, we will create 3 differents packages:
   - Beans (com.mycompany.beans)

5. Now, we can create our bean. It will contain the properties of our employees (First name, last name, position). To create a new bean, we have to right click on the bean package(com.mycompany.beans) and click on _New > Other > JavaServer Faces > JSF CDI Bean_.
   We will call it _EmployeeBean_
> A managed bean is a POJO (Plain Old Java Object) that can be used to store data, and is managed by the container (e.g., the Payara server) using the JSF framework.
> 
> A POJO is essentially a Java class that contains a public, no argument constructor and conforms to the JavaBeans naming conventions for its properties.

6. Once the bean is created, we have to add the annotation `@ManagedBean`, then we have to add the attributes of _Employee_ and generate the Getters and Setters.
   Each employee should have the following attributes:
   ```JAVA
   private String firstName, lastname, position;
   ```
   To generate the getters and setters using Netbeans, you can Right-click on each attributes and click on _Insert code_ > Getter and Setter > _Select the attributes_ > Click on Generate
`ManagedBean`: allows you to specify to the server that this bean is now managed by JSF. It simply means that JSF will use this bean as a template associated with one or more views.
> To view the Javadoc for all JSF 2.1 annotations, see the [Faces Managed Bean Annotation Specification](http://javaserverfaces.java.net/nonav/docs/2.1/managed-bean-javadocs/index.html).
7. Creating the view: For this project, we will create two Facelets (Facelets are just XHTML pages with JSF tags): createEmployee and welcomeEmployee.
   _createEmployee_ will contains the form to create a new employee.
   _welcomeEmployee_ will show us the attributes defined in our bean.
   
   Netbeans makes it easy for us to create facelets by allowing us to use pre-designed templates
   To create a new Facelet based on a defined template, we have to Right click on _Web Pages_> New > Other > JavaServer Faces > Facelets Template
   Name your template and select a Layout style, then click on Finish.




## Difference between JSP and JSF
> JSP technology is part of the Java technology family. JSP pages are compiled into servlets and may call JavaBeans components (beans) or Enterprise JavaBeans components (enterprise beans) to perform processing on the server. As such, JSP technology is a key component in a highly scalable architecture for web-based applications.

 _http://www.oracle.com/technetwork/java/faq-137059.html_

>JavaServer Faces technology is a framework for building user interfaces for web applications. JavaServer Faces technology includes:
> * A set of APIs for: representing UI components and managing their state, handling events and input validation, defining page navigation, and supporting internationalization and accessibility.
> * A JavaServer Pages (JSP) custom tag library for expressing a JavaServer Faces interface within a JSP page.

_https://jcp.org/en/introduction/faq_


## Resources
[Official documentation of JSF tags](https://docs.oracle.com/javaee/6/javaserverfaces/2.1/docs/vdldocs/facelets/)


# Exercises

1. Create a simple landing page using JSP. The page should contains a header, a content div and a footer
2. Add a form: the purpose of our project is to create a new user (first name, last name, email address, password)
3. Persist the newly created user in a H2 database

