#Author: vkumar.plr@gmail.com
Feature: Verify the configuration of different car details

  Scenario Outline: Check and Validate the Tax, Mot, Registration and Vehicle make
    Given the user navigates to Landing Page
    When the user provides the valid "<vehicleRegistration>" details
    Then the user verifies the car "<vehicleRegistration>", "<make>" and configuration
    And the user quits the browser windows

    Examples: 
      | vehicleRegistration | make       |
      | S161 XWC            | FORD       |
      | RO61 OSK            | VOLKSWAGEN |
