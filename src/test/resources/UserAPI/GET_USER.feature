
  Feature: GET User API test cases

    Background: USER api is working as expected.

      Scenario: User api call with list of all users
        Given  System calls user api with valid url
        When   User api return response with status code 200
        Then   System should validate api response with list of users


