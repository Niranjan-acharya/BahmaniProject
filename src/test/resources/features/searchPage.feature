@tag 
Feature: BAHMNI EMR FOR CLINICS Search Page 

Background: BAHMNI EMR FOR CLINICS Welcome page 
	Given user on BAHMNI welcome page 
	When user clicks Clinical Service option 
	And user enters username "superman" 
	And user enters password "Admin123" 
	And user selects location "Bahmni Clinic" 
	When user clicks on Login 
	When user clicks Registration option 
	
@tag6 
Scenario: Verify to create new patietnt page 
	And user finds Create New option 
	When user clicks Create New option 
	Then page should navigate to "NEW PATIENT" Page3 
	
Scenario Outline: Search Patient page using ID
	When user clicks search option 
	And user enters patient id "<id>" 
	When user clicks searchID option 
	Then results should be "<result>" patient
	
	Examples: 
		| id 		| result  		 |
		| ABC200002 | ABC200002   	 | 
		| ABC200008 | Could not find |

Scenario Outline: Search Patient page using Name
	When user clicks search option 
	And user enters patient name "<name>" 
	When user clicks searchName option 
	Then results should be "<name>" and "<result>" table
	
	Examples: 
		| name	  | result  	|
		| Niranjan | ABC200002  | 
		| xxxxx | No results found |
		| Acharya | ABC200005  | 
	