Feature: Test Create and Get 

Scenario Outline: Create Request using POST method
Given Construct Input Payload with "<name>"  "<description>" "<domainKey>"
When I send the Request using "CreateAPI" resources and "POST" Method 
Then I verify the Status code as 200  

Examples:
	|name 	 | description |domainKey		   |
	|TestSensivity |  Intel Data.CRM.MAG Account |ra6a3959e9bde14993|




Scenario: Get information using GET method
Given construct request using tag name as QueryParam "abc"
When I send the Request using "GETAPI" resource and "GET" Method 
Then I verify the Status code for GET as 200 
