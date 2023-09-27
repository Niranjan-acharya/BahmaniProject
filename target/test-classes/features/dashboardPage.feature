@tag 
Feature: BAHMNI EMR FOR CLINICS Dashboard Page 

Background: BAHMNI EMR FOR CLINICS Welcome page 
	Given user on BAHMNI welcome page 
	When user clicks Clinical Service option 
	And user enters username "superman" 
	And user enters password "Admin123" 
	And user selects location "Bahmni Clinic" 
	When user clicks on Login 
	
@tag5 
Scenario: Verify Dashboard page 
	Given user on BAHMNI Dashboard page 
	And user finds "Registration" option2
	When user clicks Registration option 
	Then page should navigate to "search" Page2 