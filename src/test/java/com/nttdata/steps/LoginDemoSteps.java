package com.nttdata.steps;

import com.nttdata.screens.LoginDemoScreen;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class LoginDemoSteps extends UIInteractionSteps {

    LoginDemoScreen loginDemoScreen;



    // Ingresar cantidad y agregar al carrito
    public void addProductToCart(String quantity) {
        loginDemoScreen.setQuantity(quantity);
        waitFor5Seconds();
        loginDemoScreen.addToCart();
    }

    // Verificar que el producto esté en el carrito
    public void verifyProductInCart() {
        loginDemoScreen.goToCart();
        String cartProductName = loginDemoScreen.getCartProductName();
        String productName = loginDemoScreen.getCartProductName();
        Assert.assertEquals("El producto en el carrito es el mismo", productName, cartProductName);
    }

    // Método para hacer una pausa de 5 segundos
    public void waitFor5Seconds() {
        try {
            Thread.sleep(5000);  // Espera de 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método actualizado para dar clic en el producto según condicional

    public void clickOnProductAndAddToCart(String productName) {
        try {
            // Construir dinámicamente el XPath usando el nombre del producto
            String productXPath = "//android.widget.ImageView[@content-desc='" + productName + "']";

            // Encontrar y dar clic en el producto
            System.out.println("Buscando el producto con XPath: " + productXPath);
            WebElement productElement = getDriver().findElement(By.xpath(productXPath));
            productElement.click();
            System.out.println("Producto clicado: " + productName);

            // Esperar 2 segundos
            Thread.sleep(2000);

            // XPath del botón "Añadir al carrito"
            String addToCartXPath = "//android.widget.Button[@content-desc='Tap to add product to cart']";

            // Encontrar y dar clic en el botón de añadir al carrito
            System.out.println("Buscando el botón para añadir al carrito: " + addToCartXPath);
            WebElement addToCartButton = getDriver().findElement(By.xpath(addToCartXPath));
            addToCartButton.click();
            System.out.println("Producto añadido al carrito");

            // Esperar 2 segundos
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error al interactuar con los elementos: " + e.getMessage());
        }
    }

    public void carrito() {
        try {
            // Paso 1: Clic en el botón para visualizar el carrito
            System.out.println("Intentando ingresar al carrito...");
            String cartButtonXPath = "//android.widget.ImageView[@content-desc='Displays number of items in your cart']";
            WebElement cartButton = getDriver().findElement(By.xpath(cartButtonXPath));
            cartButton.click();
            Thread.sleep(1000); // Esperar 1 segundo

            // Paso 2: Clic en el botón del menú dentro del carrito
            System.out.println("Ingresando al menú dentro del carrito...");
            String menuButtonXPath = "//android.widget.ImageView[@content-desc='View menu']";
            WebElement menuButton = getDriver().findElement(By.xpath(menuButtonXPath));
            menuButton.click();
            Thread.sleep(2000); // Esperar 2 segundos

            // Paso 3: Seleccionar la opción de 'Catalog'
            System.out.println("Seleccionando la opción 'Catalog'...");
            String catalogOptionXPath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='Catalog']";
            WebElement catalogOption = getDriver().findElement(By.xpath(catalogOptionXPath));
            catalogOption.click();

            System.out.println("Flujo completado y regresando al catálogo.");
        } catch (Exception e) {
            System.out.println("Error durante el flujo del carrito: " + e.getMessage());
        }
    }


    // Método para manejar clics en productos y capturar errores
    public void clickOnProductWithErrorHandling(String productXPath) {
        try {
            System.out.println("Intentando hacer clic en el producto: " + productXPath);
            WebElement productElement = getDriver().findElement(By.xpath(productXPath));
            productElement.click();
            System.out.println("Producto seleccionado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al seleccionar el producto: " + e.getMessage());
            throw new RuntimeException("Fallo crítico: la aplicación se cerró inesperadamente al seleccionar el producto.", e);
        }
    }










}
