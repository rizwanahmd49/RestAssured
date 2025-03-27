Feature: Validate user details on ReqRes ApI
  Background: API prerequisites for all the scenarios
    Given I have BaseURI "" for ReqRes ApI
    And I have BasePath "/api"

  Scenario: Validate user details on ReqRes ApI
    When I send a GET request to "https://reqres.in/api/users/2"
    Then the status code should be 200

Feature: User Validation API

  Scenario: Valid user login
    Given the API endpoint "/login"
    When I send a POST request with valid credentials
    Then the response status code should be 200
    And the response should contain a valid authentication token

  Scenario: Invalid user login
    Given the API endpoint "/login"
    When I send a POST request with invalid credentials
    Then the response status code should be 401
    And the response should contain an error message

  Scenario: Missing credentials
    Given the API endpoint "/login"
    When I send a POST request without credentials
    Then the response status code should be 400
    And the response should contain a validation error message
