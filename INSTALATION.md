Installation and First Execution For Mac and Windows (Chrome and Firefox)

1- Install Java SE Development Kit 13.0.1. (You need to have jdk installed ) if not : https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5672538.html

2- Download Eclipse for EE Devs : https://www.eclipse.org/downloads/packages/release/mars/r/eclipse-ide-java-ee-developers
(You could run the project with any other IDE but I'll be doing step by step for Eclipse only since it handles the auto-downloading of requirements automatically)

3- Install Eclipse and launch the workbench in the default location > Launch > Workbench

4- Go to Window > Show View > Git Repositories > in URI just add my repo https://github.com/L4mPi2/aequilibrium.git and then click Next (It's gonna ask for your github credentials). Now you have the project installed in your Eclipse

5- Install TestNG plugin : Go to Help>Install new software> click Add button > A window opens with 2 inputs Name and Location : input TestNG in name input, and input http://beust.com/eclipse in Location > OK  > You're gonna see the TestNG plugin , go click on it > Next > Next > Agree with the license > Finish > Install Anyway > Restart now

6- Go to /src/test/java/testCases and open the TestsRunner.java class

7-Right click on the file and Run as Java Application (The first test handles the validation of every single element of the login page so you're gonna see the page standing still but the test is working validating every element. Also, since I failed a locator on purpose to grab a Screenshot and I also set an implicit wait when an element is not found, you're gonna see that this part takes a couple of seconds.)
The same happens with the glitch_user. When running the login test that tries different combinations of users and passwords, the glith_user comes with a delay as well, inherent to the SwagLabs application itself.

8- Go to the project and right-click > Refresh and then Go to  /Reports/ExtentReports.html > Righ Click > Open With > Web Browser and you're gonna see the fancy Extent Reports with the screenshots and the charts and all that data.
You can also right-click the file and go to properties and find the location to open the Reports in another tab.

9- Go to /FailedTestsScreenshots/ and under that folder you're gonna be storing all the Screenshots of failed tests.

10- Go to src/test/java/testCases and find the LoginTestSuite.java, right-click on it and run as TestNG test (This is another way to run the test suite). 
10.5 -There is a third way to run the tests, through maven , just go to the right click run as > maven build...> first clean > then install> then compile, then test and, maven is gonna be handling the whole execution. I use maven to load dependencies dynamically as well, so you don't have to be downloading jar files to handle functionalities. Totally Optional, but still works.

11- Thanks for your time. Any Doubts just contact me whenever you need.
