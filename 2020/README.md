# Repository of SOAR 2020

| Week # | Version # | Exercise |
|---|---|---|
| Week 3 | Version 1 | [Code](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_w3) - [Solution](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_v1) |
| Week 4 | Version 1 | [Code](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_w4) - [Solution](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_v1) |
| Week 5 | Version 2 | [Code](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_w5) - [Solution](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_v2) |
| Week 6 | Version 3 | [Code](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_w6) - [Solution](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_v3) |
| Week 9 | Database | [Queries + Solutions](https://github.com/doplab/soar-tp/blob/master/2020/ShoppingWebsite_w9/exercises.sql) |
| Week 10 | Version 4 | [Code](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_w10) - [Solution](https://github.com/doplab/soar-tp/tree/master/2020/ShoppingWebsite_v4) |
| Week 11 | Web Socket | [Code](https://github.com/doplab/soar-tp/tree/master/2020/Week_11) - No Solution |
| Week 12 | JMS, TCP, and UDP | [Code](https://github.com/doplab/soar-tp/tree/master/2020/Week_12) - No Solution |
| Week 13 | Web Service | No Code - [Solution](https://github.com/doplab/soar-tp/tree/master/2020/Week_13) |
| Week 14 | RESTful Web Service <br> Microservice| [Code for CRUD <br> Solution for RESTful](https://github.com/doplab/soar-tp/tree/master/2020/Week_14) |

---

You can **install the applications** on to your computer. Here is the list of applications and their versions:
    * [JDK 8 (version 8u251)](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html)
    * [Apache NetBeans (version 12.0)](https://netbeans.apache.org/download/index.html)
    * Payara Server (5.201) - You should install it inside NetBeans. Instructions are below.

### How to install Payara Server inside the NetBeans?
1. Go to "Services" tab on the Netbeans (If you do not see "Services" tab, click on Windows > Reset Windows)
2. Right click on "Servers"
3. Click on "Add server"
4. Choose **Payara Server** from the server list
5. Choose an "Installation Location" (and make sure there is no space in the installation path)
Please note, if you remove the Payara Server folder later, you wo not be able to use it anymore
6. Choose "Local Domain"
7. Below "Choose Payara Server 5.201", you will see "Download" option, click it and wait for NetBeans to download and install Payara Server. (this will take some time)
8. After it is done, click "Next"
9. Leave the "Domain" as it is (i.e. “domain1”), type a user name and password (if you want to)
