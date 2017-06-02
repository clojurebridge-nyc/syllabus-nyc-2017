# Getting Set Up

## Requirements

Everyone in the workshop should have a laptop. If it is running Windows, it should be running Windows 7 or above. If it is running OS X, it should be running 10.8 "Mountain Lion" or above. If it is running Linux, you are probably fine.

If anyone attending does not have access to a laptop running one of the above choices, let the instructors know. You can either pair with someone else, or we can provide a virtual machine that you can run if you have a laptop.

## What we are installing

By the end of these instructions, you will have the following installed:

* Git, a program for managing your program's code
* Java, a "virtual machine" that Clojure runs atop of
* Leiningen, a tool for running Clojure programs
* Nightcode, an editor for Clojure and other programming languages
* Quil, a Clojure library for creating interactive drawings and animations

## Instructions by operating system

Choose your operating system to get setup instructions:

* [OS X](#os-x-setup)
* [Ubuntu (Linux)](#ubuntu-setup)
* [Windows via Chocolatey package manager](#windows-choco-setup)
* [Windows](#windows-setup)

<div style="page-break-after: always;"></div>

# <a name="os-x-setup"></a>OS X Setup

* Start a terminal
* Install Git
* Configure Git
* Make sure Java is installed
* Install Leiningen
* Install Nightcode
* Test your setup

## Starting a terminal

For these instructions, and for much of the class, you will need to have a terminal, or command line, open. This is a text-based interface to talk to your computer, and you can open it by running Terminal.app, which is found under `/Applications/Utilities`. If you have never used the terminal before, you may want to spend some time [reading up on command-line basics](http://blog.teamtreehouse.com/command-line-basics).

Go ahead and open your terminal now. It should look something like this:

![blank terminal](img/os_x/blank_terminal.png)

The prompt (where you will type your commands) may look different: it usually shows the computer name and user name, as well as the folder or directory you are currently in.

For the rest of this setup, I will tell you to run commands in your terminal. When I say that, I mean "type the command into the terminal and press the Return key."

<div style="page-break-after: always;"></div>

## Install Git

To see if you have git installed type in: `git --version` If you have `git version 1.9.3 (Apple Git-50)` or above you should be fine.

If not, visit [git-scm.com](http://git-scm.com/). Click "Downloads for Mac". The Git installer may begin downloading automatically. If it does not, click the manual download link. Once the download has finished, open __~/Downloads__ in Finder and double-click the downloaded file (named something like __git-2.0.1-intel-universal-snow-leopard.dmg__). This will mount the disk image and open a new Finder window. Double-click the installer package (named something like __git-2.0.1-intel-universal-snow-leopard.pkg__). You may be told that the installer can't be opened because it is from an unidentified developer. If so, click "OK", then right-click (or control-click) the file and select "Open" from the contextual menu. You may be warned again that the installer is from an unidentified developer, but this time you'll have the option to click "Open". Do so. This will launch the installer. Follow its directions, and enter your password when prompted to do so. Once you have finished this process it's safe to unmount the disk image (by clicking the eject button in the Finder sidebar) and delete the file from the Downloads folder.

## Configure Git

If you've used Git before then you should already have user.name and user.email configured.
Otherwise, type this in the terminal:

```bash
git config --global user.name "Your Actual Name"
git config --global user.email "Your Actual Email"
```
TIP: Use the same email address for git, github, and ssh.

Verify by typing this in the terminal:

`git config --get user.name`
Expected result:
`your name`

`git config --get user.email`
Expected result:
`your email address`

## Making sure Java is installed

> If you have OS X version 10.11 (El Capitan), you don't have Java installed.
> You need to install Java as well.
> Download Java from <http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html> and follow the instruction.
> If you have a trouble, the article, <http://osxdaily.com/2015/10/17/how-to-install-java-in-os-x-el-capitan/>, may help.


Run `java -version` in your terminal. If you do not have Java installed, OS X will prompt you to install it. Follow all of the directions OS X gives you, then return to this part of the tutorial and run `java -version` again.

If Java is installed, you will see something like this in your terminal:

![Java version](img/os_x/java_version.png)

The details of Java's version may differ from what you see above; that is perfectly fine.

## Install Leiningen

Leiningen is a tool used on the command line to manage Clojure projects.

To install `lein`, execute the following commands in your terminal; you will be prompted to enter your password for at least the first command starting with `sudo` (The `%` character is a typical commandline prompt, don't type it):

```bash
% curl https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein > lein
% sudo mkdir -p /usr/local/bin/
% sudo mv lein /usr/local/bin/lein
% sudo chmod a+x /usr/local/bin/lein
```
Check that you can now see the command:
```bash
% which lein
/usr/local/bin/lein
```
If you don't see `/usr/local/bin/lein` as above, do this next:
```bash
% export PATH=$PATH:/usr/local/bin
```
Now run `which lein` and you should see the `lein` command.

After you set up Leiningen as above, run the `lein version` command. This should take a while to run, as it will download some resources it needs the first time. If it completes successfully, you are golden! If not, ask an instructor for help.

## Install Nightcode

Download the latest version for Mac from the [Nightcode site](https://sekao.net/nightcode/) and open the .dmg file to install.

## Test your setup

You have set up Java, Leiningen, Nightcode, and Git on your computer--all the tools you will need for this workshop. Before starting, we need to test them out.

#### Cloning our github repository

Go to your terminal and run the following command:

```bash
git clone https://github.com/ClojureBridge/welcometoclojurebridge
```

This will clone `welcometoclojurebridge` repository which includes
sample Clojure apps.
Your terminal should look similar to this picture:

![Testing git clone](img/os_x/testing-git-clone.png)

<div style="page-break-after: always;"></div>

#### Testing `lein repl`

Then run the command:

```bash
cd welcometoclojurebridge
```

This will take you to the directory with the source code. After that completes, run:

```bash
lein repl
```

This could take a long time, and will download many other pieces of code apps rely on. You should see lines that start with `Retrieving ...` on your screen. When it finishes, your terminal should look like the following:

![Testing lein repl](img/os_x/testing-lein-repl.png)

This is starting a REPL, which we will learn about soon. It's a special terminal for Clojure. At the REPL prompt, type `(+ 1 1)` and press Return. Did you get the answer `2` back? You will learn more about that in the course. For now, press the Control button and D button on your keyboard together (abbreviated as Ctrl+D). This should take you out of the Clojure REPL and back to your normal terminal prompt. Then, the terminal will show you the following message: `user=> Bye for now!`

<div style="page-break-after: always;"></div>

#### Testing Nightcode

Open the Nightcode application. At the bottom left of the screen, type `(+ 1 1)` into the window.

<img src="img/nightcode-repl.png" alt="Testing Nightcode" width="500">

If you see the result, 2, that worked, great!

<div style="page-break-after: always;"></div>

#### Testing apps

Now we will open and run the sample Clojure apps in Nightcode.
On the top left corner, click "Import" then find the directory,
`welcometoclojurebridge`, which was created when you ran
`git clone` command. Click "Open."
In the project directory tree on the left, click on `src` - `welcometoclojurebridge` - `core.clj`. The `core.clj` file will be opened on the right side.
This is a Clojure program.

<img src="img/nightcode-click-import.png" alt="Testing apps - click import" width="500">
<img src="img/nightcode-open-project.png" alt="Testing apps - open welcometoclojurebridge" width="500">
![Testing apps - core.clj](img/nightcode-welcometoclojurebridge-core.png)


The next step is to run the code shown in the window.
Click "Run with REPL" on the bottom of the right side.
It may take a while.
Eventually, repl will start and show a prompt on the bottom of the window.
Once, you see the prompt, click "Reload" button.


![Testing apps - start repl](img/nightcode-welcometoclojurebridge-run-with-repl.png)
![Testing apps - repl started](img/nightcode-repl-started.png)
![Testing apps - repl reload](img/nightcode-repl-reload.png)


You should see a fun welcome message.

![Testing apps - welcome](img/testing-welcomeclojurebridge.png)


Let's try one more sample.
In the directory tree on the left, click on
`welcometoclojurebridge` - `src` - `clojurebridge-turtle` -
`walk.clj`. The `walk.clj` file will open on the right side.
Like we did before, click "Reload" button.

![Testing apps - walk code](img/nightcode-turtle-walk.png)
![Testing apps - walk reload](img/nightcode-turtle-walk-reload.png)


An initial image of the turtles app should pop up.
A small triangle on the center is the *turtle*.


Type `(forward 40)` on the repl at the bottom of the window.
You should see the turtle moved upword:

![Testing apps - forward](img/nightcode-turtle-forward-40.png)



#### Success!

Congratulations! You have opened and run your first Clojure apps, and
your install and setup are all completed!


If you want to know what the turtle (*a small triangle*) can do,
see [Turtle App API](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE.md) and
[How to Walk Turtles](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE-SAMPLES.md) for more information.

<div style="page-break-after: always;"></div>

# <a name="ubuntu-setup"></a>Ubuntu (Linux) Setup

* Start a terminal
* Install Git
* Configure Git
* Make sure Java is installed
* Install Leiningen
* Install Nightcode
* Test your setup

## Starting a terminal

For these instructions, and for much of the class, you will need to have a terminal, or command line, open. This is a text-based interface to talk to your computer, and you can open it by clicking "Dash Home" and typing `Terminal`. You can also open a terminal at any time by pressing `CTRL-ALT-T`. If you have never used the terminal before, you may want to spend some time [reading up on command-line basics](http://blog.teamtreehouse.com/command-line-basics).

Go ahead and open your terminal now. It should look something like this:

![blank terminal](img/ubuntu/blank_terminal.png)

The prompt (where you will type your commands) may look different: it usually shows the computer name and user name, as well as the folder or directory you are currently in.

For the rest of this setup, I will tell you to run commands in your terminal. When I say that, I mean "type the command into the terminal and press the Return key."

## Installing Git

See if you already have Git installed with `git version`.
If the `git` command is not found, install it with this command in the terminal:

```bash
sudo apt-get install git
```

## Configure Git

If you've used Git before then you should already have user.name and user.email configured.
Otherwise, type this in the terminal:

```bash
git config --global user.name "Your Actual Name"
git config --global user.email "Your Actual Email"
```

TIP: Use the same email address for git, github, and ssh.

Verify by typing this in the terminal:

`git config --get user.name`
Expected result:
`your name`

`git config --get user.email`
Expected result:
`your email address`


## Making sure Java is installed

Run `java -version` in your terminal. If you do not have Java installed, Ubuntu will prompt you to install it. It should look something like this:

![no java](img/ubuntu/no_java.png)

Follow all of the directions Ubuntu gives you, selecting the package "openjdk-7-jre" then return to this part of the tutorial and run `java -version` again.

If Java is installed, you will see something like this in your terminal:

![Java version](img/ubuntu/java_version.png)

The details of Java's version may differ from what you see above; that is perfectly fine.

## Install Leiningen

Leiningen is a tool used on the command line to manage Clojure projects.

Go to the [Leiningen website](http://leiningen.org/). You will see a link to the `lein` script under the "Install" heading. Right-click that link and choose "Save Link As...". Save it in your Downloads directory.

![Leiningen site](img/leiningen_site.png)
![Leiningen site](img/lein_install.png)

After that, run the following commands in your terminal. You will be prompted to enter your password.

```
sudo mkdir -p /usr/local/bin/
sudo mv ~/Downloads/lein* /usr/local/bin/lein
sudo chmod a+x /usr/local/bin/lein
export PATH=$PATH:/usr/local/bin
```

After you run the above commands, run the `lein version` command. It should take a while to run, as it will download some resources it needs the first time. If it completes successfully, you are golden! If not, ask an instructor for help.

<div style="page-break-after: always;"></div>

## Install Nightcode

Download the latest version for Linux (deb) from the [Nightcode site](https://sekao.net/nightcode/).

```
sudo dpkg -i Nightcode-2.3.3.deb
```

Replace 2.3.3 with the version number downloaded.

If you are using Fedora, Red Hat or the like, downlown the Linux (rpm) version.

```
rpm -ivh Nightcode-2.3.3.rpm
```

If the above are not usable on your computer, download the Jar version and run using the `java` command:

```bash
cd ~/Downloads/
java -jar Nightcode-2.3.3.jar
```

## Testing your setup

You have set up Java, Leiningen, Nightcode, and Git on your computer--all the tools you will need for this course. Before starting, we need to test them out.

#### Cloning out github repository

Go to your terminal and run the following command:

```bash
git clone https://github.com/ClojureBridge/welcometoclojurebridge
```

This will clone `welcometoclojurebridge` repository which includes sample Clojure apps.
Your terminal should look similar to this picture:

![Testing git clone](img/ubuntu/testing-git-clone.png)

#### Testing `lein repl`

Then run the command:

```bash
cd welcometoclojurebridge
```

This will take you to the directory with the source code. After that completes, run:

```bash
lein repl
```

This could take a long time, and will download many other pieces of code it relies on. You should see lines that start with `Retrieving ...` on your screen. When it finishes, your terminal should look like the following:

![Testing lein repl](img/ubuntu/testing-lein-repl.png)

This is starting a REPL, which we will learn about soon. It's a
special terminal for Clojure. At the REPL prompt, type `(+ 1 1)` and
press Return. Did you get the answer `2` back? You will learn more
about that in the course. For now, press the Control button and D
button on your keyboard together (abbreviated as Ctrl+D). This should
take you out of the Clojure REPL and back to your normal terminal
prompt. Then, the terminal will show you the following message: `user=> Bye for now!`


#### Testing Nightcode

If Nightcode isn't started yet or closed, open it by typing the command on terminal:

```bash
java -jar nightcode-2.3.3-standalone.jar
```

At the bottom left of the screen, type `(+ 1 1)` into the window. It should look like the following image:

<img src="img/nightcode-repl.png" alt="Testing Nightcode" width="500">

If you see the result, 2, that worked, great!


### Testing apps

Now we will open and run the sample Clojure apps in Nightcode.
On the top left corner, click "Import" then find the directory,
`welcometoclojurebridge`, which was created when you ran
`git clone` command. Click "Open."
In the project directory tree on the left, click on `src` - `welcometoclojurebridge` - `core.clj`. The `core.clj` file will be opened on the right side.
This is a Clojure program.

<img src="img/nightcode-click-import.png" alt="Testing apps - click import" width="500">
<img src="img/nightcode-open-project.png" alt="Testing apps - open welcometoclojurebridge" width="500">
![Testing apps - core.clj](img/nightcode-welcometoclojurebridge-core.png)


The next step is to run the code shown in the window.
Click "Run with REPL" on the bottom of the right side.
It may take a while.
Eventually, repl will start and show a prompt on the bottom of the window.
Once, you see the prompt, click "Reload" button.


![Testing apps - start repl](img/nightcode-welcometoclojurebridge-run-with-repl.png)
![Testing apps - repl started](img/nightcode-repl-started.png)
![Testing apps - repl reload](img/nightcode-repl-reload.png)


You should see a fun welcome message.

![Testing apps - welcome](img/testing-welcomeclojurebridge.png)


Let's try one more sample.
In the directory tree on the left, click on
`welcometoclojurebridge` - `src` - `clojurebridge-turtle` -
`walk.clj`. The `walk.clj` file will open on the right side.
Like we did before, click "Reload" button.

![Testing apps - walk code](img/nightcode-turtle-walk.png)
![Testing apps - walk reload](img/nightcode-turtle-walk-reload.png)


An initial image of the turtles app should pop up.
A small triangle on the center is the *turtle*.


Type `(forward 40)` on the repl at the bottom of the window.
You should see the turtle moved upword:

![Testing apps - forward](img/nightcode-turtle-forward-40.png)



#### Success!

Congratulations! You have opened and run your first Clojure apps, and
your install and setup are all completed!

If you want to know what the turtle (*a small triangle*) can do,
see [Turtle App API](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE.md) and
[How to Walk Turtles](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE-SAMPLES.md) for more information.

<div style="page-break-after: always;"></div>

# <a name="windows-choco-setup"></a>Windows via Chocolatey package manager

[Chocolatey](https://chocolatey.org/) is a Windows package manager providing installation facilities similar to Mac and Linux. "The sane way to manage software on Windows"

* Install Chocolatey
* Start a command prompt
* Install Git
* Configure Git
* Install Java
* Install Leiningen
* Install Nightcode
* Test your setup
* Troubleshooting

## Install Chocolatey

Follow the instructions on Chocolatey's [install page](https://chocolatey.org/install).

Make sure you are in an *administrative shell* as detailed in their first step. After installing Chocolatey, close and open a new administrative shell in order to use it.


## Installing Git

See if you already have Git installed at the command prompt with the command `git --version`.

If you need to install it, open an administrative shell and type:

```
choco install git --params "/GitAndUnixToolsOnPath /NoAutoCrlf"
```

Close and open the administrative shell, so it can pick the updated PATH environment.

After installation, try the `git --version` command in a new command prompt window. If you see a version number, git
was installed correctly.

If you've used Git before then you should already have user.name and user.email configured.
Otherwise, type this in the command prompt:

## Configure Git

```
git config --global user.name "Your Actual Name"
git config --global user.email "Your Actual Email"
```
TIP: Use the same email address for git, github, and ssh.

Verify by typing this in the command prompt:

`git config --get user.name`
Expected result:
`your name`

`git config --get user.email`
Expected result:
`your email address`


## Install Java

To install, open an administrative shell and type:

```
choco install jdk8
```

After installation, try the `java -version` command in a new command prompt window. If you see a version number, java
was installed correctly.


## Install Leiningen

Leiningen is a tool used on the command line to manage Clojure projects.

Download and run the [installer](https://bitbucket.org/djpowell/leiningen-win-installer/downloads/leiningen-installer-1.0.exe) for Windows.


## Install Nightcode

Go to the [Nightcode](https://sekao.net/nightcode/) site and get the lastest version for Windows.


## Test your setup

You have set up Java, Leiningen, Nightcode, and Git on your computer--all the tools you will need for this workshop. Before starting, we need to test them out.


#### Cloning our github repository

Go to your command prompt and run the following command:


```bash
git clone https://github.com/ClojureBridge/welcometoclojurebridge
```

This will clone `welcometoclojurebridge` repository which includes sample Clojure apps.
Your command prompt should look similar to this picture:

![Testing git clone](img/win/testing-git-clone.png)

Then run the command:

```bash
cd welcometoclojurebridge
```

This will take you to the folder with the source code. After that completes, run:

```bash
lein repl
```

This could take a long time, and will download many other pieces of code it relies on. You should see lines that start with `Retrieving ...` on your screen. When it finishes, your command propmpt should look like the following:

![Testing lein repl](img/win/testing-lein-repl.png)

This is starting a REPL, which we will learn about soon. It's a
special command prompt for Clojure. At the REPL prompt, type `(+  1
1)` and hit enter. Did you get the answer `2` back? You will learn
more about that in the course. For now, press the Control button and D
button on your keyboard together (abbreviated as Ctrl+D). This should
take you out of the Clojure REPL and back to your normal command
prompt. Then, the command prompt will show you the following message: `user=> Bye for now!`


#### Testing Nightcode

Open Nightcode

At the bottom left of the screen, type `(+ 1 1)` into the window. It should look like the following image:

<img src="img/nightcode-repl.png" alt="Testing Nightcode" width="500">

If you see the result, 2, that worked, great!


#### Testing apps

Now we will open and run the sample Clojure apps in Nightcode.
On the top left corner, click "Import" then find the directory,
`welcometoclojurebridge`, which was created when you ran
`git clone` command. Click "Open."
In the project directory tree on the left, click on `src` - `welcometoclojurebridge` - `core.clj`. The `core.clj` file will be opened on the right side.
This is a Clojure program.

<img src="img/nightcode-click-import.png" alt="Testing apps - click import" width="500">
<img src="img/nightcode-open-project.png" alt="Testing apps - open welcometoclojurebridge" width="500">
![Testing apps - core.clj](img/nightcode-welcometoclojurebridge-core.png)


The next step is to run the code shown in the window.
Click "Run with REPL" on the bottom of the right side.
It may take a while.
Eventually, repl will start and show a prompt on the bottom of the window.
Once, you see the prompt, click "Reload" button.


![Testing apps - start repl](img/nightcode-welcometoclojurebridge-run-with-repl.png)
![Testing apps - repl started](img/nightcode-repl-started.png)
![Testing apps - repl reload](img/nightcode-repl-reload.png)


You should see a fun welcome message.

![Testing apps - welcome](img/testing-welcomeclojurebridge.png)


Let's try one more sample.
In the directory tree on the left, click on
`welcometoclojurebridge` - `src` - `clojurebridge-turtle` -
`walk.clj`. The `walk.clj` file will open on the right side.
Like we did before, click "Reload" button.

![Testing apps - walk code](img/nightcode-turtle-walk.png)
![Testing apps - walk reload](img/nightcode-turtle-walk-reload.png)

An initial image of the turtles app should pop up.
A small triangle on the center is the *turtle*.


Type `(forward 40)` on the repl at the bottom of the window.
You should see the turtle moved upword:

![Testing apps - forward](img/nightcode-turtle-forward-40.png)



#### Success!

Congratulations! You have opened and run your first Clojure apps, and
your install and setup are all completed!


If you want to know what the turtle (*a small triangle*) can do,
see [Turtle App API](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE.md) and
[How to Walk Turtles](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE-SAMPLES.md) for more information.


### Troubleshooting

* Leiningen Windows Installer has an issue that it doesn't install
  lein.bat correctly. This causes curl.exe to fail downloading files
  with th error below. Skip the Leiningen Windows Installer. Download
  lein.bat from leiningen.org and run self-installer.

> error:0307A071:bignum routines:BN_rand_range:too many iterations.

<div style="page-break-after: always;"></div>

# <a name="windows-setup"></a>Windows Setup

* Start a command prompt
* Install Git
* Configure Git
* Install Java
* Install Leiningen
* Install Nightcode
* Test your setup
* Troubleshooting

## Starting a command prompt

For these instructions, and for much of the class, you will need to have a command prompt open. This is a text-based interface to talk to your computer. Go to the "Windows" screen (the "Start Screen") and type "command". Choose the "Command Prompt" program, like in this screenshot:

![Starting a command prompt](img/win8/starting-command-prompt.png)

When you choose "Command Prompt," your screen should look similar to this:

![Command prompt](img/win8/command-prompt.png)

If you have never used the command prompt before, you may want to spend some time [reading up on command prompt basics](http://dosprompt.info/). For the rest of this setup, I will tell you to run commands in your command prompt. When I say that, I mean "type the command into the command prompt and press the Return key."

On other operating systems, the command prompt is called the terminal. We will use the terms terminal, command prompt, and command line interchangably.

## Installing Git

See if you already have Git installed at the command prompt with the command `git --version`.
If not, download it from the [git-scm.com Windows download page](http://git-scm.com/download/win) and run the executable to install.

After installation, try the `git --version` command in a new command prompt window. If you see a version number, git
was installed correctly.

If you see a message that says, `'git' is not recognized as an internal or external command`,
try these steps to update your PATH variable properly:
* Right-click "My Computer" and select "Properties".
* Click the "Advanced Tab" and then the "Environment Variables" button.
* Highlight the PATH entry and click "Edit".
* Scroll to the end of this value and check for a file path at the end that includes "...\Git...".
* If that path existed:
  * Click "Okay" until the "My Computer" dialog box is closed.
  * Open a new command prompt window and try `git --version` again. If that does not succeed, restart your computer and
    try again.
* If that path did not exist:
  * If you did not change the install location of git during installation, add ";C:\Program Files (x86)\Git\cmd" to the
    end of the line. Make sure you add the semi-colon between file paths and the line includes no spaces between paths.
  * Click "Okay" until the "My Computer" dialog box is closed.
  * Open a new command prompt window and try `git --version` again. If that does not succeed, restart your computer and
    try again.

If you've used Git before then you should already have user.name and user.email configured.
Otherwise, type this in the command prompt:

## Configure Git

```
git config --global user.name "Your Actual Name"
git config --global user.email "Your Actual Email"
```
TIP: Use the same email address for git, github, and ssh.

Verify by typing this in the command prompt:

`git config --get user.name`
Expected result:
`your name`

`git config --get user.email`
Expected result:
`your email address`


## Install Java

Go to [the Leiningen Windows installer site](http://leiningen-win-installer.djpowell.net/). You should see two links, one for installing Java and another for "leiningen-win-installer." Click the Java link. Then, you should see a screen like the following:

![First page of Java download](img/win/java-download1.png)

Click the button above "Java Platform (JDK)," as you can see in the above picture. Then you will come to a page that will have the following table on it:

![Second page of Java download](img/win/java-download2.png)

Click the radio button to accept the license agreement, and then download one of the two Windows choices. If you are running 32-bit Windows, choose "Windows x86." If you are running 64-bit Windows, choose "Windows x64."

If you do not know if you are running 32-bit or 64-bit Windows, go to the "Windows" screen (the "Start Screen") and type "system." Choose "System." (If that does not work, type "Control Panel" and choose "System" from the Control Panel screen.) You should see a window like the following:

![Windows My Computer properties](img/win8/system-properties.png)

You should see if you are running 32- or 64-bit Windows beside "System Type."

Once you have downloaded the right Java version, run the executable you downloaded to install Java. Follow the installation wizard.

## Install Leiningen

Leiningen is a tool used on the command line to manage Clojure projects.

> see troubleshooing for leiningen installation

Next, go back to [the Leiningen Windows installer site](http://leiningen-win-installer.djpowell.net/) and download the file linked as "leiningen-win-installer." Run this executable and follow the "Detailed installation" section at the Leiningen Windows Installer site. At the end of the installation, leave "Run a Clojure REPL" checked before you click "Finish." If a terminal window opens that looks like the one on the Leiningen Windows installer site, then you are good to go.


## Install Nightcode

Download the lastest version (2.3.3) for Windows from the [Nightcode site](https://sekao.net/nightcode/). Click on downloaded file to install.

## Test your setup

You have set up Java, Leiningen, Nightcode, and Git on your computer--all the tools you will need for this workshop. Before starting, we need to test them out.


#### Cloning out github repository

Go to your command prompt and run the following command:


```bash
git clone https://github.com/ClojureBridge/welcometoclojurebridge
```

This will clone `welcometoclojurebridge` repository which includes sample Clojure apps.
Your command prompt should look similar to this picture:

![Testing git clone](img/win/testing-git-clone.png)

Then run the command:

```bash
cd welcometoclojurebridge
```

This will take you to the folder with the source code. After that completes, run:

```bash
lein repl
```

This could take a long time, and will download many other pieces of code it relies on. You should see lines that start with `Retrieving ...` on your screen. When it finishes, your command propmpt should look like the following:

![Testing lein repl](img/win/testing-lein-repl.png)

This is starting a REPL, which we will learn about soon. It's a
special command prompt for Clojure. At the REPL prompt, type `(+  1
1)` and hit enter. Did you get the answer `2` back? You will learn
more about that in the course. For now, press the Control button and D
button on your keyboard together (abbreviated as Ctrl+D). This should
take you out of the Clojure REPL and back to your normal command
prompt. Then, the command prompt will show you the following message: `user=> Bye for now!`


#### Testing Nightcode

At the bottom left of the screen, type `(+ 1 1)` into the window. It should look like the following image:

<img src="img/nightcode-repl.png" alt="Testing Nightcode" width="500">

If you see the result, 2, that worked, great!

<div style="page-break-after: always;"></div>

#### Testing apps

Now we will open and run the sample Clojure apps in Nightcode.
On the top left corner, click "Import" then find the directory,
`welcometoclojurebridge`, which was created when you ran
`git clone` command. Click "Open."
In the project directory tree on the left, click on `src` - `welcometoclojurebridge` - `core.clj`. The `core.clj` file will be opened on the right side.
This is a Clojure program.

<img src="img/nightcode-click-import.png" alt="Testing apps - click import" width="500">
<img src="img/nightcode-open-project.png" alt="Testing apps - open welcometoclojurebridge" width="500">
![Testing apps - core.clj](img/nightcode-welcometoclojurebridge-core.png)


The next step is to run the code shown in the window.
Click "Run with REPL" on the bottom of the right side.
It may take a while.
Eventually, repl will start and show a prompt on the bottom of the window.
Once, you see the prompt, click "Reload" button.


![Testing apps - start repl](img/nightcode-welcometoclojurebridge-run-with-repl.png)
![Testing apps - repl started](img/nightcode-repl-started.png)
![Testing apps - repl reload](img/nightcode-repl-reload.png)


You should see a fun welcome message.

![Testing apps - welcome](img/testing-welcomeclojurebridge.png)


Let's try one more sample.
In the directory tree on the left, click on
`welcometoclojurebridge` - `src` - `clojurebridge-turtle` -
`walk.clj`. The `walk.clj` file will open on the right side.
Like we did before, click "Reload" button.

![Testing apps - walk code](img/nightcode-turtle-walk.png)
![Testing apps - walk reload](img/nightcode-turtle-walk-reload.png)

An initial image of the turtles app should pop up.
A small triangle on the center is the *turtle*.


Type `(forward 40)` on the repl at the bottom of the window.
You should see the turtle moved upword:

![Testing apps - forward](img/nightcode-turtle-forward-40.png)



#### Success!

Congratulations! You have opened and run your first Clojure apps, and
your install and setup are all completed!


If you want to know what the turtle (*a small triangle*) can do,
see [Turtle App API](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE.md) and
[How to Walk Turtles](https://github.com/ClojureBridge/welcometoclojurebridge/blob/master/outline/TURTLE-SAMPLES.md) for more information.


### Troubleshooting

* Leiningen Windows Installer has an issue that it doesn't install
  lein.bat correctly. This causes curl.exe to fail downloading files
  with th error below. Skip the Leiningen Windows Installer. Download
  lein.bat from leiningen.org and run self-installer.

> error:0307A071:bignum routines:BN_rand_range:too many iterations.
