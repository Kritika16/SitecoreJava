@DuckDuckGoTestFeature
Feature: Test Search Results in DuckDuckGo

@DuckDuckGoTest
  Scenario Outline: Validate Search Of DuckDuckGo Website
    Given Open DuckDuckGo website
    And Page Loaded Successfully
    When Search For a <Place>
    Then Verify User is navigated to search results
    And Take A <ScreenShot>

   Examples:     
    | Place |ScreenShot |
    | Bahamas | Bahamas_Result |
    | Amsterdam | Amsterdam_Result |