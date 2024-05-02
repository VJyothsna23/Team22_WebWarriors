@LMS @UAd 
Feature: Add new user 

Background: Validating Add new user page 
	Given Admin is on Add new user page 
	
@UA_1 
Scenario: Validate User Details Popup window 
	Then Admin should see pop up open for user details with First Name,Middle name, Last Name,Location,phone, email, linkedin url, User Role, Role status,visa status,Undergraduate, postgraduate,time zone,user comments and user fields along with Cancel,Submit and close buttons 
	
@UA_2 
Scenario: Validate input fields and text boxes in user details form 
	Then Admin should see  text boxes for the fields First Name, Middle name, Last Name, Location, phone, email,linkedin url, Undergraduate, postgraduate,time zone ,user comments and drop downs for the fields User Role, Role status, visa status on user details pop up 
	
@UA_3 
Scenario:
Check if user is created when only mandatory fields are entered with valid data 
	When Admin enters mandatory fields in the form and clicks on submit button 
	Then Admin gets message User added Successfully 
	
@UA_4 
Scenario:
Check if user is created when only optional fields are entered with valid data 
	When Admin skips to add value in mandatory field 
	Then Admin gets error message and user is not created 
	
@UA_5 
Scenario:
check if user is created when invalid data is entered in all of the fields 
	When Admin enters invalid data in all of the  fields in the form and clicks on submit button 
	Then Admin gets error message and user is not created 
	
@UA_6 
Scenario: Empty form submission 
	When Admin clicks on submit button without entering data 
	Then Admin gets error message and user is not created 
	
	#Scenario Outline: Checking if user is created  with invalid data
	#Given Admin is on Add new user page
	#When Admin enters "<firstname>", "<middlename>","<lastname>","<location>","<phonenumber>","<linkedinUrl>","<email>","<undergraduate>","<postgraduate>","<timezone>","<usercomments>","<userrole>","<userrolestatus>","<uservisastatus>"
	#Then Admin gets success message  and user is created for valid values
	#And Admin gets error message and  user is not created for invalid values
	#Examples:
	#| firstname | middlename | lastname | location | phonenumber | linkedinUrl         | email          | undergraduate | postgraduate | timezone | usercomments | userrole | userrolestatus | uservisastatus |
	#| Joanna    | Lydia      | John     | Dunwoody |  1234567890 | linkedin.com/Joanna | Jojo@gmail.com | BE            | ME           | EST      | Good         | R02      | Active         | GC-EAD         |
	#| Joanna    | Lydia      |          | Dunwoody |  1543454541 | linkedin.com/Joanna |                | BE            |              | EST      |              | R01      | Active         |                |
	#| Joa       | Ly47       | jid@45   |   464677 | 489@114541  | linkedin.com.Joanna | jo@lydia.jo    | BE            | ME           | MST      | Good         | R02      | Active         | GC-EAD         |
	#|           |            |          |          |             |                     |                |               |              |          |              |          |                |                |
	#row1 -enter mandatory fields
	#row2 -skip to add value in mandatory fields
	#row3- enter invalid data
	#row4 -without entering any data
@UA_7 
Scenario: Check if the user details are added in data table 
	When Admin clicks Close Icon on User Details form 
	Then User Details popup window should be closed without saving 
	
@UA_8 
Scenario: Check if the user details are added in data table 
	When Admin clicks Cancel button on User Details form 
	Then User Details popup window should be closed without saving 
	#Scenario: Check if the user details are added in data table
	# Given  Admin is on Add new user page
	#When Fill in all the fields with valid values and click submit
	#Then The newly added user should be present in the data table in Manage User page
