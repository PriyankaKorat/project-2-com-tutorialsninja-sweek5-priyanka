package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class LaptopAndNotebookPage extends Utility{
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12']//div[1]//div[2]//div[1]//p//span[@class='price-tax']")
    By productPrice;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    public WebElement clickOnCheckout;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    public WebElement verifyTheTextCheckout;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    public WebElement verifyTheTxtNewCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    public WebElement clickOnGuestCheckout;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    public WebElement ClickOnContinue;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    public WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    public WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    public WebElement eMail;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    public WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    public WebElement Address1;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    public WebElement city;

    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    public WebElement postcode;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    public WebElement state;

    @CacheLookup
    @FindBy(id = "button-guest")
    public WebElement clickOnCon;

    @CacheLookup
    @FindBy(id = "button-shipping-method")
    public WebElement continueButtonAfterComment;

    @CacheLookup
    @FindBy(name = "comment")
    public WebElement enterComment;

    public String getLaptopsAndNotebooksText() {
        // Reports and Log
        CustomListeners.test.log(Status.PASS,"Get text " + laptopsAndNotebooksText);
        Reporter.log("Get text " + laptopsAndNotebooksText.toString());
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        List<WebElement> products = getListOfElements(productsPrices);
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            //System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            //System.out.println(arr[0]);
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        // Reports and Log
        CustomListeners.test.log(Status.PASS,"Get product prices " + productsPrices);
        Reporter.log("Get product prices " + productsPrices.toString());
        return originalProductsPrice;
    }

    public void selectSortByOption(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
        // Reports and Log
        CustomListeners.test.log(Status.PASS,"Select option " + option);
        Reporter.log("Select option from " + sortBy.toString());
    }

    public void selectProductByName(String product) {
        List<WebElement> products = getListOfElements(productsList);
        for (WebElement e : products) {
            if (e.getText().equals(product)) {
                e.click();
                break;
            }
        }
        // Reports and Log
        CustomListeners.test.log(Status.PASS,"Select option " + product);
        Reporter.log("Select "+product+" from " + productsList.toString());
    }

    //Convert list to descending order
    public List<Double> getProductPricesInDefaultFilterAndSortByDescendingOrder() {
        return convertPriceListToReverse(productPrice);
    }

    //Get list after applying filter
    public List<Double> getProductPriceAfterFilterHighToLow() {
        return afterFilterPrice(productPrice);
    }

    public void enterTheMandatoryField(WebElement element, String value){
        sendTextToElement(element, value);
    }


}