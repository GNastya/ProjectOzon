@TestOzon
Feature: add product to the basket and checking if this item is in the basket and going to registration


  @1
  Scenario: checking that the basket is empty
    #action
    Given open website 'https://www.ozon.ru/'
    When press 'Корзина' button in the header
    Then verify that basket is empty and close browser

  @2
  Scenario: adding a product to the basket and going to registration
    #action
    Given open 'https://www.ozon.ru/'
    When press 'Искать на Ozon' button and type information about product and press button with 'Magnifier' icon
    And check book details and press 'В корзину' button
    And press 'Корзина' button in header
    And check full Basket with the "(2020)Хроники Нарнии (ил. П. Бейнс) / The Magician's Nephew (для всех серий)" and "528"
    Then the product will be in basket and you can go to registration and close browser