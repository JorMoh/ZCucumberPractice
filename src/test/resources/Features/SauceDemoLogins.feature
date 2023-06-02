@Regression @Login
Feature: SauceLogin
As a sauceDemo user,
I want to be able to login,
so that I can browse items.

Background: 
Given user navigates to SauceDemo website


Scenario: Log in with valid Creds
When user enters a valid username "standard_user" in the username field
And user enters a valid password "secret_sauce" in the password field
And user clicks on the login button
Then user should be logged in successfully

Scenario: Log in with invalid user
When user enters an invalid username "invalid_user" in the username field
And user enters a valid password "secret_sauce" in the password field
And user clicks on the login button
Then user should not log in
And user should get the message “Epic sadface: Username and password do not match any user in this service”

Scenario: Log in with lockedout user
When user enters a locked out username "locked_out_user" in the username field
And user enters a valid password "secret_sauce" in the password field
And user clicks on the login button
Then user should not log in
And user should get the message  “Epic sadface: Sorry, this user has been locked out.”



