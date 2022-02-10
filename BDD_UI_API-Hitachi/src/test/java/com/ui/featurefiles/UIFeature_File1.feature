Feature: Test the Performance of the provided website

Scenario: Test the Performance of the provided website
Given I Launch the browser and enter the application URL 
When I enter the input details and hit start test
Then I verify the InProgress Page
Then I verify the Results in ResultPage
Then I Take the screenshot of ResultPage
Then I Close the Driver

