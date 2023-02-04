@regression
Feature: Test the whole process of complete an order

    Scenario: the logged user could be complete his order with his valid data
      When he completes his payment method
      Then the payment method of order has done

