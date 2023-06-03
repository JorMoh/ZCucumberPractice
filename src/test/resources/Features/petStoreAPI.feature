@api
Feature: Tests for Swagger pet store
Description: Testing creating and retrieving pets

Background: 
Given the base url is: https://petstore.swagger.io/v2

Scenario: create a pet
Given you create a pet with id3465XXX and you give the pet a name booboo in the request body status is available
Then verify status code is200 and the content type is application/json.

Scenario: retrieve a pet
Given you perform a get request to retrieve the pest you created in the former scenario
Then verify status code is200, content type is json and status is: available. 

Scenario: get an unvailable pet
Given you perform a get request to find a pet with ID7867864
Then verify status code is404, content type is json and message is Pet not found.


