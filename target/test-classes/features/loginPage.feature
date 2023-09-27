@tag 
Feature: BAHMNI EMR FOR CLINICS Login Page 

Background: BAHMNI EMR FOR CLINICS Welcome page 
	Given user on BAHMNI welcome page 
	And user finds "Clinical Service" option 
	When user clicks Clinical Service option 
	Then page should navigate to Login Page 
	
@tag3 
Scenario: Verify Login page 
	Given user on BAHMNI login page 
	And user enters username "superman" 
	And user enters password "Admin123" 
	And user selects location "Bahmni Clinic" 
	When user clicks on Login 
	Then page should navigate to "dashboard" Page 