Feature: Authenticate login page

Scenario: login with username tomsmith and password SuperSecretPassword!
Given user given with brower open and auth page lunched
When user enter username tomsmith and password SuperSecretPassword!
Then user logins with message You logged into a secure area!

Scenario: login with username wronguser and password wrongpassword
Given user given with brower open and auth page lunched
When user enter username wronguser and password wrongpassword
Then user logins or fails with message Your username is invalid!

Scenario: login with username wronguser and password SuperSecretPassword
Given user given with brower open and auth page lunched
When user enter username wronguser and password SuperSecretPassword!
Then user logins or fails with message Your username is invalid!

Scenario: login with username tomsmithand password wrongpassword
Given user given with brower open and auth page lunched
When user enter username tomsmith and password wrongpassword
Then user logins or fails with message Your password is invalid!