package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class LoginDemoScreen extends PageObject {

    // XPath para el producto Sauce Labs Backpack
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Sauce Labs Backpack']")
    private WebElement sauceLabsBackpackProduct;


    // Localizador por Accessibility ID
    @AndroidFindBy(accessibility = "Sauce Labs Backpack")
    private WebElement sauceLabsBackpackAccessibilityId;


    // Campo de cantidad
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']")
    private WebElement quantityField;

    // Botón para agregar el producto al carrito
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Tap to add product to cart']")
    private WebElement addToCartButton;

    // Icono del carrito
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Displays number of items in your cart']")
    private WebElement cartButton;

    // Validación del nombre del producto en el carrito
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV']")
    private WebElement cartProductName;

    // Hacer clic en el producto


    // Ingresar la cantidad de producto
    public void setQuantity(String quantity) {
        quantityField.click();
        quantityField.clear();  // Limpiar el campo antes de escribir el valor
        quantityField.sendKeys(quantity);  // Ingresar la cantidad
    }

    // Agregar el producto al carrito
    public void addToCart() {
        addToCartButton.click();
    }

    // Ir al carrito
    public void goToCart() {
        cartButton.click();
    }

    // Obtener el nombre del producto en el carrito
    public String getCartProductName() {
        return cartProductName.getText();
    }





}