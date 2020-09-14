# Repository of SOAR 2020

We expect you to have some applications installed on your computers for exercise sessions of the Software Architecture course since we will not do any installations during exercise sessions.

We suggest two options:
1. You can **use a virtual machine** that we prepared for you. The applications you will need this semester is installed and configured for you. You need to install VirtualBox (6.1.12) to run your virtual machine instance.
    * [Download VirtualBox](https://www.virtualbox.org/wiki/Downloads)
    * [Download virtual machine image](https://drive.google.com/file/d/14AuCug-E9ENhNJzSORQnu13-rwpCuczG/view?usp=sharing) All passwords are "1234".
    * How to install VirtualBox on [Windows](https://www.virtualbox.org/manual/UserManual.html#installation_windows), [Mac OS X](https://www.virtualbox.org/manual/UserManual.html#installation-mac), and [Linux](https://www.virtualbox.org/manual/UserManual.html#install-linux-host)?
2. You can **install the applications** on to your computer. Here is the list of applications and their versions:
    * [JDK 8 (version 8u251)](https://www.oracle.com/java/technologies/javase/javase8u211-later-archive-downloads.html)
    * [Apache NetBeans (version 12.0)](https://netbeans.apache.org/download/index.html)
    * Payara Server (5.201) - You should install it inside NetBeans. Instructions are below.

### Need a help with the VirtualBox?
Check [here](https://www.virtualbox.org/manual/UserManual.html) or [VMFAQ.pdf](https://github.com/doplab/SOAR/blob/master/2020/VMFAQ.pdf).

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
