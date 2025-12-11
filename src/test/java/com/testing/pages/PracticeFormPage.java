package com.testing.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PracticeFormPage extends PageObject {

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderRadio = By.xpath("//label[@for='gender-radio-1']");
    private By mobileField = By.id("userNumber");
    private By hobbiesCheckbox = By.xpath("//label[@for='hobbies-checkbox-1']");
    private By currentAddressField = By.id("currentAddress");
    private By submitButton = By.id("submit");
    private By confirmationModal = By.className("modal-content");
    private By modalTitle = By.id("example-modal-sizes-title-lg");
    private By modalContentTable = By.className("table-responsive");


    public void openPage() {
        getDriver().get("https://demoqa.com/automation-practice-form");
    }

    public void enterFirstName(String firstName) {
        $(firstNameField).type(firstName);
    }

    public void enterLastName(String lastName) {
        $(lastNameField).type(lastName);
    }

    public void enterEmail(String email) {
        $(emailField).type(email);
    }

    public void selectGender() {
        $(genderRadio).click();
    }

    public void enterMobile(String mobile) {
        $(mobileField).type(mobile);
    }

    public void selectHobbiesCheckbox() {
        $(hobbiesCheckbox).click();
    }

    public void enterCurrentAddress(String currentAddress) {
        $(currentAddressField).type(currentAddress);
    }

    public void clickSubmit() {
        var submitElement = $(submitButton);
        String jsScript = "arguments[0].closest('form').setAttribute('novalidate', 'true'); arguments[0].click();";
        evaluateJavascript(jsScript, submitElement);
    }

    public boolean isConfirmationModalVisible() {
        waitForCondition().until(ExpectedConditions.visibilityOfElementLocated(confirmationModal));
        return $(confirmationModal).isVisible();
    }

    public String getModalTitleText() {
        return $(modalTitle).getText();
    }

    public String getFullName() {
        var nameRow = $(modalContentTable).find(By.xpath(".//tbody/tr[1]/td[2]"));
        return nameRow.getText();
    }

    public boolean isMobileFieldInvalid() {
        return (Boolean) evaluateJavascript("return arguments[0].validity.valid == false;", $(mobileField));
    }

}
