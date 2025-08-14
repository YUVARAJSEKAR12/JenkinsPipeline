Feature: Sample test api

  Background: setbase url
    Given Set Base url to "https://rahulshettyacademy.com"

	@Postmethod
  Scenario: get service model
    Given Set base path "/Library/Addbook.php"
    Then Set headers
      | Content-Type | application/json |
   # Then Generete Oauth Token
    Then Set input payload from path "C:\Users\HP\eclipse-workspace\Develop\new\new\oct\API_Cucumber\src\test\resources\Payload\book.json"
    Then Make a POST Call
    Then Validate the response code is 200
    Then Validate the response contains "response"
    Then Validate if the response matches value "bcd2997" for the path "ID"
    And Tear Down
    
    
    @Gettmethod
  Scenario: get Book data
    Given Set base path "/Library/GetBook.php?ID=bcd2926"
    Then Set headers
      | Content-Type | application/json |
    #Then Generete Oauth Token
   # Then Set input payload from path "C:\Users\HP\eclipse-workspace\Develop\new\new\oct\API_Cucumber\src\test\resources\Payload\book.json"
    Then Make a GET Call
    Then Validate the response code is 200
    Then Validate the response contains "response"
   # Then Validate if the response matches value "Learn Appium Automation with Java" for the path "book_name"
    And Tear Down
