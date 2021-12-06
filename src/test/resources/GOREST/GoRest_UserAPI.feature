Feature: GoRest User api testcases including POST,PUT, GET and Delete methods

  Background: GoRest User API authentication token is valid

  Scenario Outline: Test the process flow of User API
    Given  User api is working and returning 200 status code
    When   User wants to add new user with <name>, <email>, <gender> and <status>
    And    System can verify the new user is added successfully
    Then   System should cleanUp new user data
    And    System should verify that test data user is removed successfully
    Examples:
      | name         | email                  | gender   | status   |
      | "TestUserQ"  | "ksjlksj@demo.com"     | "male"   | "active" |
      | "TestUser34" | "uoiuoou@demo.com"     | "female" | "active" |
      | "TestUser89" | "kjkuuiu8980@demo.com" | "male"   | "active" |

  Scenario Outline: Process flow to update user information
    Given User api is working and returning 200 status code
    When  User wants to add new user with <name>, <email>, <gender> and <status>
    Then  User wants to update the <updatedEmail> in user details
    And   System can verify the new user is added successfully
    Then  System should cleanUp new user data
    And  System should verify that test data user is removed successfully

    Examples:
      | name        | email              | gender | status   | updatedEmail        |
      | "TestUserQ" | "tQAUser@demo.com" | "male" | "active" | "tesAUser@demo.com" |





