@loginpage
Feature: login functionlity


Scenario: verify_Title_TC01
Given user should be on login page 
And user can verify title

Scenario: verify_Logo_TC02
Given user should be on login page 
And user can verify logo

Scenario: verify_keyModule_text_TC03
Given user should be on login page 
And user can verify keymodule text

Scenario Outline: verify_all_login_page_texts_TC04
Given user should be on login page 
And user can verify existing text "<Text>"
Examples:
|Text|
|Key Modules|
|vtiger CRM Add-ons|
|:: Sales Force Automation|
| vtiger Customer Portal|


Scenario: valid login
Given user should be on login page
When user enters valid credentials
And click on login button
Then user should be navigated to home page
And user can click logout link


Scenario Outline: Invalid login
Given user should be on login page
When user enters userid as "<userid>" and password as "<password>" credentials
And click on login button
And user can validate error message on login page
Examples: 
|userid |password |
|admin1 | pwd1    |
|admin2 | pwd2    |
|admin3 | pwd3    |