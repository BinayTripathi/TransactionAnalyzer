# TransactionAnalyzer


[![Java](https://img.shields.io/badge/Java-java-blue.svg?style=plastic)](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) | ![GitHub language count](https://img.shields.io/github/languages/count/BinayTripathi/ServiceVictoria-ChildrenInQueue.svg) | ![GitHub top language](https://img.shields.io/github/languages/top/BinayTripathi/ServiceVictoria-ChildrenInQueue.svg) |![GitHub repo size in bytes](https://img.shields.io/github/repo-size/BinayTripathi/ServiceVictoria-ChildrenInQueue.svg) 


---------------------------------------

## Repository codebase
 
The repository consists of projects as below:


| # |Project Name | Project detail| Environment |
| ---| ---  | ---            | --- |
| 1 | TransactionAnalyzer| To analyze sequential transaction to obtain relative balance| [![.Java](https://img.shields.io/badge/Java-9-blue.svg?style=plastic)](https://start.spring.io/)|

### Summary

The overall objective of the applications :
```
>   To demonstrate a simple application design

>   Effective usage of Java 8/9 stream features for better readibility and performance

>  Used guice as a light weight dependency injection framework.
 
>  Facade design pattern is used to hide the internal complexity. Class TransactionAnalyzerImpl handles the complete orchastration for the execution flow
  
>  Integration test case to demonstrate the working application


```


### Application design detail

>   The application consists of 
*  A client executable jar (\TransactionAnalyzer-0.0.1-SNAPSHOT.jar)

### Setup detail

##### Environment Setup detail

> Download/install   	
>	1.	[![Maven](https://img.shields.io/badge/Mavan-3.6.3-blue.svg?style=plastic)](https://maven.apache.org/download.cgi) to build project and run test suite
>   
>   2. [![Java](https://img.shields.io/badge/Java-1.8_-blue.svg?style=plastic)](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) to run the project
>   

##### Project Setup detail

>   1. Please clone or download the repository from [![github](https://img.shields.io/badge/git-hub-blue.svg?style=plastic)](https://github.com/BinayTripathi/TransactionAnalyzer) 
>   
#####  To build / run the application

>   1. Open a new command prompt and browse to the root folder ( **TransactionAnalyzer** ) of the application 
>   
>   2. Enter following command to build the project : **mvn clean install** 
>   
>   3. Enter following command to run the project with its default configuration: **java -jar target\TransactionAnalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar accountId:ACC334455 from:20/10/2018 12:00:00 to:20/10/2018 19:00:00**
>   
##### To open the project in Eclipse
>   1. Open **Eclipse** .
>   2. Select **File** ->  **Import** and then select **Existing Maven Projects**
>   3. Browse to  **TransactionAnalyzer** select pom.xml and click **Finish** to import the project.
>   4. Run/Debug the project

### Support or Contact

Having any trouble? Please read out this [documentation](https://github.com/BinayTripathi/AccountBrowser/blob/master/README.md) or [contact](mailto:binay.mckv@gmail.com) and to sort it out.

  [![HitCount](http://hits.dwyl.com/BinayTripathi/TransactionAnalyzer.svg)](http://hits.dwyl.com/BinayTripathi/AccountBrowser) | ![GitHub contributors](https://img.shields.io/github/contributors/BinayTripathi/AccountBrowser)|
 | --- | --- |



