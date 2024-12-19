Feature: Validar funcionalidad del carrito de compras en SauceLabs

  Scenario: Agregar Sauce Labs Backpack al carrito
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galería
    When agrego el producto "Sauce Labs Backpack" al carrito
    Then valido que el carrito de compra actualice correctamente

  Scenario: Agregar Sauce Labs Bolt T-Shirt al carrito
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galería
    When agrego el producto "Sauce Labs Bolt T-Shirt" al carrito
    Then valido que el carrito de compra actualice correctamente

  Scenario: Seleccionar un producto y manejar errores si la app falla
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galería
    When selecciono el producto "Sauce Labs Bike Light"
    Then valido que el carrito de compra actualice correctamente