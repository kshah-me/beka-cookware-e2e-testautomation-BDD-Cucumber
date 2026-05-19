package com.bekacookware.pages;


import com.bekacookware.base.BasePage;
import com.bekacookware.config.ConfigReader;
import com.bekacookware.utility.UrlCheck;
import com.bekacookware.utility.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import java.util.*;


public class CartPage extends BasePage {

    private String productname = "";
    private Double productprice ;


    @FindBy(xpath="//ul/li/a[@data-modal-id='cart-modal']/sup")
    private WebElement countOnCartButton;
    public void verifyCountOnCartButton(Integer count) {
        Assert.assertEquals(WaitUtils.waitUntillElementVisibility(driver,countOnCartButton).getText().trim(),String.valueOf(count));
    }

    @FindBy(xpath="//button[@data-increment='1']")
    private WebElement incrementItemCountButtonCartPopUp;
    public void clickIncrementItemCountButtonCartPopUp(Integer count) throws InterruptedException {
        try {
            if (count == 1) {
                    WaitUtils.waitUntillElementClickable(driver, incrementItemCountButtonCartPopUp).click();
                    Thread.sleep(5000);
                }
            else {
                for (int i = 1; i < count; i++) {
                    WaitUtils.waitUntillElementClickable(driver, incrementItemCountButtonCartPopUp).click();
                    Thread.sleep(5000);
                }
            }

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement ele = driver.findElement(By.xpath("(//button[@data-increment='1'])[2]"));
            if (count == 1) {
                WaitUtils.waitUntillElementClickable(driver, ele).click();
                Thread.sleep(5000);
            }
            else {
                for (int i = 1; i < count; i++) {
                    WaitUtils.waitUntillElementClickable(driver, ele).click();
                    Thread.sleep(5000);
                }
            }

        }
    }


    @FindBy(xpath="//div[@id='cart-container']//p[contains(@class,'collection__title')]")
    private WebElement productSuggestionOnCartPage;
    public void verifyProductSuggestionOnOpenCartPage() {
        String lang = ConfigReader.propValueFromConfigFile("Language");
        switch (lang) {
            case "English" ->
                    Assert.assertEquals("You might also like", WaitUtils.waitUntillElementVisibility(driver, productSuggestionOnCartPage).getText());
            case "Deutsch" ->
                    Assert.assertEquals("Das könnte Ihnen auch gefallen", WaitUtils.waitUntillElementVisibility(driver, productSuggestionOnCartPage).getText());
            case "Dutch" ->
                    Assert.assertEquals("Ontdek meer", WaitUtils.waitUntillElementVisibility(driver, productSuggestionOnCartPage).getText());
            case "French" ->
                    Assert.assertEquals("vous pourriez aussi aimer", WaitUtils.waitUntillElementVisibility(driver, productSuggestionOnCartPage).getText());
        }
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

    @FindBy(xpath = "//div[@class='ajaxcart__price-line']/span[contains(@class,'price--sale') or @class='ajaxcart__price']")
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
        Assert.assertEquals(Double.parseDouble(totalPriceOnCart.getText().trim().replace("€", "").replace(",", ".")), updatedprice, 0.01);
    }

    @FindBy(xpath="//div[@data-config='cart-upsell-slider']//div[@role='group']//div[@class='product__image']//img")
    List<WebElement> totalSuggestedItemUnderCart;
    public void verifyImageOfSuggestedItemUnderCartAreNotBroken() {
        if (!totalSuggestedItemUnderCart.isEmpty()){
            for (WebElement ele:totalSuggestedItemUnderCart){
                 UrlCheck.brokenUrlAndImageCheck(ele.getAttribute("src"));
            }
        }
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

    @FindBy(xpath = "//ul[@class='ajaxcart__usps']/li")
    List<WebElement> shippingDetailOnCartPage;
    public void verifyShippingDetailOnCartPage() {
        String lang = ConfigReader.propValueFromConfigFile("Language");
        Map<String, List<String>> expectedTexts = new HashMap<>();
        expectedTexts.put("English", List.of(
                "Order before 12:00 = shipped the same day",
                "Free shipping from €70",
                "Returns within 30 days after purchase"
        ));

        expectedTexts.put("Deutsch", List.of(
                "Bestellen Sie vor 12:00 Uhr = Versand am selben Tag",
                "Kostenloser Versand ab 70€",
                "Rücksendungen innerhalb von 30 Tagen nach dem Kauf"
        ));

        expectedTexts.put("Dutch", List.of(
                "Voor 12:00 besteld = zelfde dag verzonden",
                "Gratis verzending vanaf 70 euro",
                "Retour binnen 30 dagen na aankoop"
        ));

        expectedTexts.put("French", List.of(
                "Commande passée avant midi = expédiée le jour même",
                "Livraison gratuite à partir de 70 euros",
                "Retour dans les 30 jours suivant l'achat"
        ));

        List<String> expectedList = expectedTexts.get(lang);
        Assert.assertEquals(expectedList.size(), shippingDetailOnCartPage.size());

        for (int i = 0; i < expectedList.size(); i++) {
            String actualText = shippingDetailOnCartPage.get(i).getText().trim();
            Assert.assertEquals(actualText, expectedList.get(i));
        }
    }


    @FindBy(xpath="//div[@id='free-shipping-bar']/p")
    private WebElement deliveryMessageCheck;
    public void verifyDeliveryMessageCheckOnCartPage() {
        String lang = ConfigReader.propValueFromConfigFile("Language");
        double price =Double.parseDouble(totalPriceOnCart.getText().trim().replace("€", "").replace(",", "."));
        System.out.println("total price before:- "+totalPriceOnCart.getText().trim());
        System.out.println("Delivery message text:- "+price);
        if (price>69.99){
            switch (lang) {
                case "English" ->
                        Assert.assertEquals("You are eligible for free shipping!", WaitUtils.waitUntillElementVisibility(driver, deliveryMessageCheck).getText());
                case "Deutsch" ->
                        Assert.assertEquals("Sie haben Anspruch auf kostenlosen Versand!", WaitUtils.waitUntillElementVisibility(driver, deliveryMessageCheck).getText());
                case "Dutch" ->
                        Assert.assertEquals("Je hebt recht op gratis verzending!", WaitUtils.waitUntillElementVisibility(driver, deliveryMessageCheck).getText());
                case "French" ->
                        Assert.assertEquals("Vous avez droit à la livraison gratuite !", WaitUtils.waitUntillElementVisibility(driver, deliveryMessageCheck).getText());
            }
        }
        else {
            String formattedPrice = "€"+String.format("%.2f", 70.00-price).replace(".",",");
            System.out.println("Delivery message formattedPrice:- "+formattedPrice);
            switch (lang) {
                case "English" ->
                        Assert.assertEquals("Add "+formattedPrice+" more for free shipping!", WaitUtils.waitUntillElementVisibility(driver, deliveryMessageCheck).getText());
                case "Deutsch" ->
                        Assert.assertEquals("Fügen Sie "+formattedPrice+" mehr für kostenlosen Versand hinzu!", WaitUtils.waitUntillElementVisibility(driver, deliveryMessageCheck).getText());
                case "Dutch" ->
                        Assert.assertEquals("Voeg nog "+formattedPrice+" toe voor gratis verzending!", WaitUtils.waitUntillElementVisibility(driver, deliveryMessageCheck).getText());
                case "French" ->
                        Assert.assertEquals("Ajoutez "+formattedPrice+" pour avoir une livraison gratuite !", WaitUtils.waitUntillElementVisibility(driver, deliveryMessageCheck).getText());
            }
        }
    }
}
