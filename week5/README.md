# Software Architecture
# Week 5

# Quick reminder
## How to install Git
### On Mac OS
The easiest way to install Git on a Mac is via the stand-alone installer:
1. Download the latest [Git for Mac installer](https://sourceforge.net/projects/git-osx-installer/files/).

2. Follow the prompts to install Git.

3. Open a terminal and verify the installation was successful by typing `git --version`:

```shell
$ git --version
git version 2.9.2
```

4. Configure your Git username and email using the following commands, replacing Emma's name with your own. These details will be associated with any commits that you create:

```shell
$ git config --global user.name "Emma Paris"
$ git config --global user.email "eparis@atlassian.com"
```
5. (Optional) To make Git remember your username and password when working with HTTPS repositories, configure the git-credential-osxkeychain helper.

__Install Git with Homebrew__

If you have installed Homebrew to manage packages on OS X, you can follow these instructions to install Git:

1. Open your terminal and install Git using Homebrew:
```shell
$ brew install git
```
2. Verify the installation was successful by typing which `git --version`:
```shell
$ git --version
git version 2.9.2
```
3. Configure your Git username and email using the following commands, replacing Emma's name with your own. These details will be associated with any commits that you create:
```shell
$ git config --global user.name "Emma Paris"
$ git config --global user.email "eparis@atlassian.com"
```
4. (Optional) To make Git remember your username and password when working with HTTPS repositories, install the [git-credential-osxkeychain helper](https://www.atlassian.com/git/tutorials/install-git#install-the-git-credential-osx).

### Install Git on Windows
1. Download the latest [Git for Windows installer](https://git-for-windows.github.io/).

2. When you've successfully started the installer, you should see the Git Setup wizard screen. Follow the Next and Finish prompts to complete the installation. The default options are pretty sensible for most users.

3. Open a Command Prompt (or Git Bash if during installation you elected not to use Git from the Windows Command Prompt).

4. Run the following commands to configure your Git username and email using the following commands, replacing Emma's name with your own. These details will be associated with any commits that you create:
```shell
$ git config --global user.name "Emma Paris"
$ git config --global user.email "eparis@atlassian.com"
```
5. Optional: Install the Git credential helper on Windows

Bitbucket supports pushing and pulling over HTTP to your remote Git repositories on Bitbucket. Every time you interact with the remote repository, you must supply a username/password combination. You can store these credentials, instead of supplying the combination every time, with the [Git Credential Manager for Windows](https://github.com/Microsoft/Git-Credential-Manager-for-Windows).

## Setting up the tools

#### Download the projects
1. Clone the project repository (https://github.com/doplab/soar-tp.git)
2. In your terminal, move to the newly created folder ("Enter the name of the folder")
3. Create a new project on your Gitlab account 
4. Link the project to your newly created repository by doing: `git remote add origin <link-to-your-repo>` 
5. Make your changes, then push to your repository: `git push -u origin master`

#### Using Source Tree
1. Click **File** > **Clone / New* 
2. Enter the URL below to **Source Path / URL** and choose a **Destination Path** and **Clone** the project.
https://github.com/doplab/soar-tp.git

### Installing Payara Server
1. Open Netbeans
2. Go to Services tab on Netbeans (If you don't see **Services** tab, click on **Windows** > **Reset Windows**)
3. Right click on **Servers**
4. Click on **Add server**
5. From the server list, choose **Payara Server**
6. Choose an **Installation Location** (and make sure there is no space in the installation path)
Please note, if you remove the Payara Server folder later, you won’t be able to use it anymore.
7.	Choose **Local Domain**
8.	Below **Choose server to download**, you will see **Download** option, click it and wait for NetBeans to download and install Payara Server. (this will take some time)
9.	After it is done, click **Next**
10.	Leave the **Domain** as it is (“domain1”), type a user name and password (if you want to)
11.	**Finish**

### Starting Payara Server
1.	Go to Services tab
2.	Expand Servers, there you should have Payara Server
3.	Right-click on Payara Server and Start
 
### Opening a project on NetBeans
1. File >> Open Project
2. Navigate to your project
Running a project (for EJB exercises)
1.	Right-click on the project >> **Run**
2.	When you run an EJB project for the first time you will be prompt to select a deployment server. Select **Payara Server** and **Remember in Current IDE Session** or **Remember Permanently**. 
3.	NetBeans will run the application and direct you to **localhost:8080/<project_name>**


## Modularity and Unit Testing

#### Requirements
1. Netbeans IDE
2. JUnit

#### Opening the project on NetBeans IDE
1. **File** > **Open Project** >>>
2. Navigate to `week5>SimpleUnitTests`

## EJB Exercises

#### Requirements
1. Netbeans IDE
2. Payara Server

#### Opening the project on NetBeans IDE
1. **File** > **Open Project** >>>
2. Navigate to `week5>tutorial-examples-master`

