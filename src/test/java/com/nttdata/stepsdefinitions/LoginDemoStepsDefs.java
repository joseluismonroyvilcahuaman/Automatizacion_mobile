package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginDemoSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;

public class LoginDemoStepsDefs {

    @Steps
    LoginDemoSteps loginDemoSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        // Lógica para abrir la app, si es necesario
    }

    @Given("valido que carguen correctamente los productos en la galería")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        // Lógica de validación de carga de productos
        loginDemoSteps.waitFor5Seconds();  // Espera de 5 segundos después de la validación
    }

    @When("agrego {string} unidades del siguiente producto {string}")
    public void agregoUnidadesDelProducto(String quantity, String product) {
        System.out.println("Buscando y seleccionando el producto: " + product);
        loginDemoSteps.addProductToCart(product);
        System.out.println("Producto seleccionado: " + product);
        System.out.println("Cantidad seleccionada: " + quantity);
    }

    @Then("valido que el carrito de compra actualice correctamente")
    public void validoQueElCarritoDeCompraActualiceCorrectamente() {
        System.out.println("Validando y saliendo del carrito...");
        loginDemoSteps.carrito();
        System.out.println("Flujo completado, listo para el siguiente escenario.");
    }


    @When("agrego el producto {string} al carrito")
    public void agregoElProductoAlCarrito(String producto) {
        loginDemoSteps.clickOnProductAndAddToCart(producto);
    }







}
