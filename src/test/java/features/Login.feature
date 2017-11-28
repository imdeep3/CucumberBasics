Feature: Verify login on Test Demo site

  Scenario: verify with valid login and password
    Given We are at the Login Page of the demo site
    And We enter following as admin
      | username | password |
      | admin    | Password |
    And We click on login button
    Then We should reach userform page

#  Scenario Outline: verify with example login and password
#    Given We are at the Login Page of the demo site
#    And We enter <username> and <password> as admin
#    And We click on login button
#    Then We should reach userform page
#    Examples:
#      | username        | password        |
#      | adminUsername   | adminPassword   |
#      | managerUsername | managerPassword |
