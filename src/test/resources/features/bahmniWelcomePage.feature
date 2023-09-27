#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag 
Feature: BAHMNI EMR FOR CLINICS 

Background: BAHMNI EMR FOR CLINICS Welcome page 
	Given user on BAHMNI welcome page 
	
@tag1
Scenario: Verify Welcome page 
	#Given user on BAHMNI welcome page 
	When user gets the title of the page 
	Then page title should be "Bahmni" 

@tag2
Scenario: Click on Clinical Service in welcome page 
	#Given user on BAHMNI welcome page 
	And user finds "Clinical Service" option 
	When user clicks Clinical Service option 
	Then page should navigate to Login Page 