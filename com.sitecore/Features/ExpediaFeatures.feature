@ExpediaTestFeature
Feature: Test Search Results in Expedia

@ExpediaTest
  Scenario Outline: Validate Search Of Expedia Website
    Given Navigate To Expedia Website
    And Expedia Website Loaded Successfully
    When Search For an Accomodation in NewYork
    And Click on Add Flight Option
    And Add a Flight From Brussels To NewYork
    And Select Travel Dates  <FromDate>  <FromMonth>  <ToDate>  <ToMonth>
    And Select No of <Adults> and <Children> and <ChildAge>
    Then Verify results page contains Travel Option


   Examples:     
    | FromDate|     FromMonth     |  ToDate |     ToMonth    | Adults| Children | ChildAge |
    |   "14"  |   "March 2021"    |   "4"   |   "April 2021" |   2   |     1    |    3     |
