# spring-project-qa
This is my second individual project for QA.
This README.md file will focus just on the back-end of the project.

Here you will find a link to my Jira board: https://josephp123.atlassian.net/jira/software/projects/QSP/boards/4/backlog
Here you will find the link to repository on GitHub: https://github.com/JPxotwod/spring-project-qa
ALL DOCUMENTATION AND SO ON WILL BE FOUND IN THIS REPO.

Coverage: 93.4%.

Project Brief:

The purpose of this document is to outline the individual project specification that you will be working on during the training. This project will involve concepts from all core training modules; more specifically, this will involve:

Agile & Project Management,
Databases & Cloud Fundamentals,
Java SE/EE,
Front-End Development,
Automated Testing.

The individual project can be on any subject you deem fit of encapsulating all aspects of the aforementioned modules. This could be a business case, such as a library or supermarket system, or something to do with a hobby of yours – as long as the application is CRUD functional.

This is purposefully open as we want to endorse creativity and give you an opportunity to do a project that you have full command over.

Your front-end and back-end must be linked together and fully functional, please bear this in mind when organising your time.

Introduction:

The aim and objective of this project was to create a CRUD application that encapsulated all of the core modules covered over the last 9 weeks.
We were given a project specification that contained a variety of user requirements and targets that we had to meet.

Project Management - a fully expanded, up-to-date and relevant Jira board, clear documentation for designs, risk assessments etc. and code integrated into a version control system.

Databases - a relational database to store persistent data from the project.

Java SE and Spring Boot - a functional application, containing a CRUD controller, created in OOP language which meets specification requirements and is in line with Kanban.

Testing - Appropriate levels of test coverage on back-end using JUnit, MockMVC and Mockito.

Front-End Development - Functioning front-end website with API integration (details will be within another README.md).


Planning Resources:

Using Jira, I created a Kanban Boaard and Roadmap modelled as a SCRUM aswell as creating User Stories and Epics in order to help break down and organise the project into smaller and more manageable objectives.
Within the User Stories, I created linked child issues for the front and back-end of my project to help the structure of the build. In total I have 4 Epics, all with multiple User Stories. An example will be shown within my presentation which you will also be able to find within this repository.
Throughout the project I completed various sprints, with issues being grouped into different sections, often based on priority or requirements.


Git and GitHub:

Using Git throughout the project meant that I was able to save code regularly on their relevant branches, utilising the method of version source control.
This meant that my work was frequently backed up, in case of any potential problems.
For my project, I set up two Git repositories: one for front-end and one for back-end. Screenshots containing the Network Graph for each repository will also be found in the presentation.
*Presentation will be found in the back-end repository*


Databases:

For my back-end, two databases were used in the project, a local H2 databases which is used for testing the back-end and a MySQL database for the storing of persistent data from our application.
H2: The H2 database was created with the player-schema.sql for testing purposes.
MySQL: The layout of my database can be seen within my Git repo and will be shown within my presentation.


Back-End + Testing:

The back-end of my project was created using Java, utilising a Spring Boot framework, and was made sure to meet the requirements of the project specification.
The testing carried out for my back-end was both integration and unit testing.

Integration testing was carried out using MockMVC to make sure the program was working. MockMVC was used to create a mocked controller class and would perform mock HTTP requests as like a user of a particular program, ultimately testing the outcomes of each request.
Unit testing was carried out with JUnit and Mockito to test each part of the program, making sure individual parts were working as they should.


Front-End will be covered in a separate README.md in the appropriate repository.

Downloaded software, tools and technologies:
Version Control System - Git,
Source Code Management - GitHub,
Kanban Board - Jira,
Database - MySQL Server 5.7+ (local or cloud hosted),
Back-end Programming Language - Java,
API Development Platform - Spring,
Front-end web technologies - HTML, CSS, JavaScript,
Build Tool - Maven,
Unit Testing - JUnit,
Integration Testing - Mockito,