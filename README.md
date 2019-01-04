# Parental Control Service


A simple service that returns whether a movie can be watch for given parental control level setting.

The ParentalControlService needs to be initialized with an implementation of a MovieService that actually knows what is the
parental control level of a given movie. For testing purposes one can use the dummy implementation provided within the
code - MovieServiceImpl. This service contains a fixed set of movies that are initialized in the constructor. For more
realistic scenarios consider loading data from DB.


# How to run 

The project is build using Gradle and uses Java 8. To simplest way to run the tests is to import a new gradle project 
and configure it so that gradle wrapper to build it.


