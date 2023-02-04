@regression
Feature: Test the process of adding an item to shopping cart

    Scenario: the logged user could be able to add items to his shopping cart
      When the logged user select an item to add it to shopping cart
      Then the item added successfully to shopping cart