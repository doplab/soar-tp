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


## Modularity and Unit Testing

#### Opening the project on NetBeans IDE
1. **File** > **Open Project** >>>
2. Navigate to `week5>SimpleUnitTests`

## Remote invocation and transactions
#### Opening the project on NetBeans IDE
1. **File** > **Open Project** >>>
2. Navigate to `week5>tutorial-examples-master`
