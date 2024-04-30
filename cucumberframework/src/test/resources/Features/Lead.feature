Feature: lead functionlity



@test3
Scenario: create lead with mandatory fields TC01
Given user should be on login page 
When user enters valid credentials
And click on login button
When user click on new lead link
And fill all mandatory fields and click on save button
Then lead should be created succefully


@test3
Scenario: create lead with mandatory fields TC02
Given user should be on login page 
When user enters valid credentials
And click on login button
When user click on new lead link
And fill all mandatory fields and click on save button
Then lead should be created succefully



@test4
Scenario: create lead with mandatory fields with steps parameterization
Given user should be on login page 
When user enters valid credentials
And click on login button
When user creates multiple leads with "<lastname>" and "<company>"  and verified
|lastname | company |
| Modi    |  BJP    |
| Rahul   |Congress |
| Sharad  |  NCP    |

And click on logout