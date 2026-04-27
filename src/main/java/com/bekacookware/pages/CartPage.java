package com.bekacookware.pages;



import com.bekacookware.config.ConfigReader;
import com.bekacookware.utility.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import java.util.*;

public class CartPage{

    String productname = "";
    Double productprice ;
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//ul/li/a[@data-modal-id='cart-modal']/sup")
    private WebElement countOnCartButton;
    public void verifyCountOnCartButton(Integer count) {
        Assert.assertEquals(WaitUtils.waitUntillElementVisibility(driver,countOnCartButton).getText().trim(),String.valueOf(count));
    }

    @FindBy(xpath="(//button[@data-increment='1'])[2]")
    private WebElement incrementItemCountButtonCartPopUp;
    public void clickIncrementItemCountButtonCartPopUp() {
        WaitUtils.waitUntillElementVisibility(driver,incrementItemCountButtonCartPopUp).click();
    }


    @FindBy(xpath="//p[@class='cart-drawer__title h4']/span")
    private WebElement countOnOpenCartPage;
    public void verifyCountOnOpenCartPage(Integer count) {
        Assert.assertEquals(WaitUtils.waitUntillElementVisibility(driver,countOnOpenCartPage).getText().trim(),String.valueOf(count));

    }

    @FindBy(xpath="//button[@class='ajaxcart__product-remove | js-remove-item']")
    private WebElement deleteButtonOnOpenCartPage;
    public void clickDeleteButtonOnOpenCartPage() {
        WaitUtils.waitUntillElementVisibility(driver,deleteButtonOnOpenCartPage).click();
    }


    @FindBy(xpath="//button[@data-type='favorite_products']/preceding-sibling::div/button")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='product__price']/span")
    private WebElement priceOfItemOnProductDetailsPage;
    @FindBy(xpath = "//h1[@class='product__title']")
    private WebElement nameOfItemOnProductDetailsPage;
    public void clickAddToCartButton() throws InterruptedException {
        productname = nameOfItemOnProductDetailsPage.getText().trim();
        productprice=Double.valueOf(priceOfItemOnProductDetailsPage.getText().trim().replace("€", "").replace(",", "."));
        WaitUtils.waitUntillElementVisibility(driver,addToCartButton).click();
        Thread.sleep(3000);
    }

    @FindBy(xpath = "//div[@class='ajaxcart__product-info']/a")
    private WebElement nameOfItemOnCartOpenPage;
    public void verifyProductNameOnCareIsSameAsProductDetails() throws InterruptedException {
        Assert.assertEquals(nameOfItemOnCartOpenPage.getText().trim().toUpperCase(), productname);
    }

    @FindBy(xpath = "//div[@class='ajaxcart__product-info']/parent::div/following-sibling::div/span")
    private WebElement priceOfItemOnCartOpenPage;
    public void verifyProductPriceOnCareIsSameAsProductDetails() throws InterruptedException {
        Assert.assertEquals(Double.valueOf(priceOfItemOnCartOpenPage.getText().trim().replace("€", "").replace(",", ".")),productprice);
    }

    private WebElement priceOf10ItemOnCartOpenPage;
    public void verify10ProductPriceOnCartIsSameAsProductDetails(Integer count) throws InterruptedException {
        productprice = productprice*count;
        Assert.assertEquals(Double.valueOf(priceOfItemOnCartOpenPage.getText().trim().replace("€", "").replace(",", ".")),productprice);
    }

    @FindBy(xpath="//p[@class='ajaxcart__total-price']")
    private WebElement totalPriceOnCart;
    public void verifyTotalPriceIsSumOfEachItemPrice() {
        double updatedprice = productprice * 2;
        System.out.println("Calculated price:- "+updatedprice);
        Assert.assertEquals(Double.parseDouble(totalPriceOnCart.getText().trim().replace("€", "").replace(",", ".")), updatedprice, 0.01);
    }


    @FindBy(xpath="//p[@class='cart-drawer__title h4']/following-sibling::button")
    private WebElement closeOpenCartPupupButton;
    public void clickCloseOpenCartPupupButton() {
        WaitUtils.waitUntillElementVisibility(driver,closeOpenCartPupupButton).click();
    }

    @FindBy(xpath="//button[@name='checkout']")
    private WebElement checkoutButtonOnCartPage;
    public void clickCheckoutButtonOnCartPage() {
        WaitUtils.waitUntillElementVisibility(driver,checkoutButtonOnCartPage).click();
    }

    @FindBy(xpath="//div[@id='cart-container']/p")
    private WebElement messageOnEmptyCart;
    public void verifyMessageOnEmptyCart() {
        String lang = ConfigReader.propValueFromConfigFile("Language");
        switch (lang) {
            case "English" ->
                    Assert.assertEquals("Your cart is currently empty.", WaitUtils.waitUntillElementVisibility(driver, messageOnEmptyCart).getText());
            case "Deutsch" ->
                    Assert.assertEquals("Ihr Einkaufswagen ist im Moment leer.", WaitUtils.waitUntillElementVisibility(driver, messageOnEmptyCart).getText());
            case "Dutch" ->
                    Assert.assertEquals("Uw winkelwagentje is momenteel leeg.", WaitUtils.waitUntillElementVisibility(driver, messageOnEmptyCart).getText());
            case "French" ->
                    Assert.assertEquals("Votre panier est vide.", WaitUtils.waitUntillElementVisibility(driver, messageOnEmptyCart).getText());
        }
    }

}
