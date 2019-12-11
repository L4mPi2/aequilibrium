# aequilibrium
Automation

General Considerations

>Why POM? : Despite en extremely limited Test Suite, I've opted to follow the Page Object Model Design Pattern, therefore the tests use the methods of this page object class whenever they need to interact with the UI of that page, the benefit is that if the UI changes for the page, the tests themselves don’t need to be changed, only the code within the page object needs to change. Subsequently all changes to support that new UI are located in one place. This way we keep our tests and element locators separately, this will keep code clean and easy to understand and maintain. Another important advantage is our Page Object Repository is Independent of Automation Tests. Keeping separate repository for page objects helps us to use this repository for different purposes with different frameworks like, we are able to integrate this repository with other tools like JUnit/NUnit/PhpUnit as well as with TestNG/Cucumber/etc. Test cases become short and optimized as we are able to reuse page object methods in the POM classes. Any change in UI can easily be implemented, updated and maintained into the Page Objects and Classes.
------------------------------------------------------------------------------------------------------------------------------
>The Layout

>The base file has all the reusable methods, handles the webdrivers execution, loads the properties file, takes screenshots and initializes the reports as well. This file is located under src/main/java/resources , it doesn't have a main method because it's not a runnable file, it serves as a source for the runnable files. Paths are set with the user.dir property so you don't need to hardcode anything at all. 
In this src/main/java/resources you're gonna find data.properties files as well, this file contains sensible editable data that is gonna be loaded by the base file and is gonna be used by the other classes where data needs to be accessed, for example: instead of hardcoding URL, usernames, passwords any data that the test need, this data is gonna be accessible by the methods through the base file and used as inputs within the tests. This allows you to handle these kinds of data from a centralized location without having to edit every test if you need to change any of them. A good example would be if you have many different environments: with this method, you only need to change the URL in this file and that would be it.

> By default the test suite is running on Chrome but if you want to run the same suite on Firefox just go to the data.properties file and change the key browser=chrome to browser=firefox and the "if" in the base file is gonna run the tests on Firefox this time, change back to browser=chrome if you want chrome back.

> chromedriver and geckodriver are being called dynamically so you don't have to download and install them.

> Reports are gonna be auto-generated after the first run under /Reports/ExtentReports.html and the Screenshots are gonna be stored under /FailedTestsScreenshots/, I've added a timestamp and the test name to every single Screenshot to avoid overwriting them. Once a report is generated you're gonna see that it is an interactive HTML where you can check for further details, you have pie charts and more cool stuff.

>The Objects Repository Pages are located under src/main/java/PageObjects. Right there you're gonna find the different pages with there objects. I'll be accessing all of these by creating an object of any of these classes whenever I need to locate an element. This way the code looks neater and also more scalable, for example, if you need to change any locator, it's easier to find it by page.

> You're gonna find the tests themselves under src/test/java/testCases . Right there, there are 2 files: The TestsRunner.java and the LoginTestSuite.java. They both trigger all the tests but in a different way: The TestsRunner.java is a java application so you just go  right-click button and Run as java Application.
The LoginTestSuite.java has all the code but this is a TestNG file so you run it by right-clicking and run 1 TestNG test.
There is a third way to run the tests, through maven , just go to the right click run as > maven build...> first clean > then install> then compile, then test and maven is gonna be handling the whole execution. I use maven to load dependencies dynamically as well, so you don't have to be downloading jar files to handle functionalities.

> I added a couple more tests like a happy path to purchase 2 items in order to make the automation last a little bit longer. I've failed 2 test on purpose to grab screenshots, I've commented the code explaining how I failed on purpose using dummy locators or wrong assertions. You're gonna find these comments in the LoginTestSuite.java class.
------------------------------------------------------------------------------------------------------------------------------
