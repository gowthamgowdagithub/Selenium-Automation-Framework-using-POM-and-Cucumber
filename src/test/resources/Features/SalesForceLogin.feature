Feature: SalesForce Login TestCases

Scenario: Login salesforce with correct username and empty password

Given the URL "https://login.salesforce.com/"
When i entered in "LoginPage"
When i entered username as "katte@tekarch.com"
When i entered password as ""
When i click on the login button
Then i should get an error message as "Please enter your password."


Scenario: Login salesforce with correct username and password

Given the URL "https://login.salesforce.com/"
When i entered in "LoginPage"
When i entered username as "katte@tekarch.com"
When i entered password as "@dummu$G879"
When i click on the login button
When i entered in "HomePage"
Then i should see homepage


Scenario: Check username is displayed and remember me checkbox is selected

Given the URL "https://login.salesforce.com/"
When i entered in "LoginPage"
When i entered username as "katte@tekarch.com"
When i entered password as "@dummu$G879"
When i click on the remember me check Box
When i click on login button
When i entered in "HomePage"
When i see the homepage 
When i click on usermenudropdown
When i click on logout
When i entered the "LoginPage"
Then i should see username displayed as "katte@tekarch.com"
And i should also see the remember me checkbox is checked


Scenario: Click on forget password link

Given the URL "https://login.salesforce.com/"
When i entered in "LoginPage"
When i entered username as "katte@tekarch.com"
When i click on forget password link
When i entered in "ForgetPasswordPage"
When i entered the username as "katte@tekarch.com"
When i click on continue button
When i entered in "CheckYourEmailPage"
Then i should see the message displayed as "We’ve sent you an email with a link to finish resetting your password. Can’t find the email? Try checking your spam folder. If you still can’t log in, have us resend the email or contact your Salesforce administrator."


Scenario: Login with invalid username and password

Given the URL "https://login.salesforce.com/"
When i entered in "LoginPage"
When i entered username as "123"
When i entered password as "12132"
When i click on login button
Then i should get an error message as "Please check your username and password. If you still can't log in, contact your Salesforce administrator."