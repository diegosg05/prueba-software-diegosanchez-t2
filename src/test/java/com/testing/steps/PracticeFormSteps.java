package com.testing.steps;

import com.testing.pages.PracticeFormPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class PracticeFormSteps {

    @Managed
    WebDriver driver;

    PracticeFormPage practiceFormPage;

    @Given("el usuario está en el formulario PracticeForm")
    public void elUsuarioEstaEnLaPaginaDePracticeForm(){
        practiceFormPage.openPage();
    }

    @When("ingresa el first name {string}")
    public void ingresaElFirstName(String firstName){
        practiceFormPage.enterFirstName(firstName);
    }

    @And("ingresa el last name {string}")
    public void ingresaElLastName(String lastName){
        practiceFormPage.enterLastName(lastName);
    }

    @And("ingresa el email {string}")
    public void ingresaElEmail(String email){
        practiceFormPage.enterEmail(email);
    }

    @And("selecciona el gender Male")
    public void selectElGender(){
        practiceFormPage.selectGender();
    }

    @And("ingresa el mobile number {string}")
    public void ingresaElMobile(String mobileNumber){
        practiceFormPage.enterMobile(mobileNumber);
    }

    @And("selecciona un hobbie Sports")
    public void selectElHobbie(){
        practiceFormPage.selectHobbiesCheckbox();
    }

    @And("ingresa el current address {string}")
    public void ingresaElCurrentAddress(String currentAddress){
        practiceFormPage.enterCurrentAddress(currentAddress);
    }

    @And("hace click al button Submit")
    public void haceClickAlBotonSubmit(){
        practiceFormPage.clickSubmit();
    }

    @Then("me abre el modal de confirmacion")
    public void debeAbrirElModalDeConfirmacion(){
        assertTrue(practiceFormPage.isConfirmationModalVisible());
    }

    @And("el título del modal debe ser {string}")
    public void elTituloDelModalDebeSer(String title) {
        String actualTitle = practiceFormPage.getModalTitleText();
        assertEquals(title, actualTitle);
    }

    @And("el contenido del modal debe mostrar el nombre completo {string}")
    public void elContenidoDelModalDebeMostrarElNombreCompletoCorrecto(String fullName) {

        String actualFullName = practiceFormPage.getFullName();

        assertEquals(fullName, actualFullName);
    }

    @Then("me marca en rojo el campo mobile number")
    public void debeMarcarEnRojoLosCamposObligatorios(){
        assertTrue(practiceFormPage.isMobileFieldInvalid());
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
