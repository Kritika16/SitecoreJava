# SitecoreJava
## Author: Kritika DATE: 17/02/2021

This Project contains the 1st 2 assignmets for Sitecore: Duck Duck Go and Expedia Website
Maven Project has been used to create the tests
POM framework has been used to write the locators

###FrameWork

####TEST/JAVA
There are 4 Packages created inside test/java
1. com.sitecore.Pages  : This contains the pages of DuckDuckGo website and Expedia.com and their methods are written using Page Object Model
2. library: This has the screen shot method utility file and the Config reader to read the data in the config file
3. Runner : This is the basic runner class to run the tests with tags and generate reports
4. Stepdefinations: This contains implementation of the feature files

#####TEST/RESOURCES
This has the chromedriver driver inside the driver folder

######OTHER FOLDERS
CONFIGURATION: This contains the config file where all the URLS and chromedriver paths have been defined
FEATURES: This contains all the feature files
SCREENSHOTS: Contains all the screenshots taken during execution
TARGET: All the reports that are generated are stored here

POM.xml Has all the dependencies that are needed to execute the project

#######WHAT WILL BE NEEDED TO EXECUTE THIS PROJECT

JAVA and Elipse should be installed on the system

1. Goto CONFIGURATION folder and open the config file: Update the chromedriver path 
2. Install the plugin for the feature file 
URL: http://cucumber.github.io/cucumber-eclipse/update-site/ 
Steps todo it: Goto Help--> Install new software:: paste this url and download the software

HOW TO RUN: Goto Runner class:: Select the tag depending on which testcase you want to run: 
@DuckDuckGoTestFeature  : To run the 1st Assignment
@ExpediaTestFeature  	: To run the 2nd Assignmet

WHAT ELSE COULD HAVE BEEN DONE : Since it was not mentioned hence I have written what else could have been added
1. Add logs using Log4j
2. Add the screenshots in the report itself
3. Use POM with Page Factory
