@tag 
Feature: BAHMNI EMR FOR CLINICS New Patient Page 

Background: BAHMNI EMR FOR CLINICS Welcome page 
	Given user on BAHMNI welcome page 
	When user clicks Clinical Service option 
	And user enters username "superman" 
	And user enters password "Admin123" 
	And user selects location "Bahmni Clinic" 
	When user clicks on Login 
	When user clicks Registration option 
	
@tag7 
Scenario Outline: Verify New Patient page 
	When user clicks Create New option 
	And user enters firstname "<firstname>" 
	And user enters lastname "<lastname>" 
	And user selects gender "<gender>" 
	And user selects birthdate "<birthdate>" 
	When user clicks on Save 
	Then page should create patinet Id 
	
	Examples: 
		| firstname | lastname  | gender | birthdate  |
		| Niranjan  | Acharya   | Male   | 17-10-1996 |
		| Sayeed    | Khan      | Male   | 15-06-1996 |
		| Seetha    | Ram       | Female | 15-08-2000 |
		