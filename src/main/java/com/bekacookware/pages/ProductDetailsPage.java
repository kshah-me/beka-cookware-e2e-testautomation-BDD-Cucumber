package com.bekacookware.pages;


import com.bekacookware.base.BasePage;
import com.bekacookware.config.ConfigReader;
import com.bekacookware.utility.UrlCheck;
import com.bekacookware.utility.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;

public class ProductDetailsPage extends BasePage {


    @FindBy(xpath = "(//h2[@class='h3']/a)[1]")
    private WebElement firstItemUnderProductResultPage;
    public void clickFirstItemUnderProductResultPage() {
        WaitUtils.waitUntillElementVisibility(driver,firstItemUnderProductResultPage).click();
    }

    @FindBy(xpath = "//h1[@class='product__title']")
    private WebElement productNameOnProductDetailsPage;
    public void verifyProductNameIsNotEmptyOnProductDetailsPage() {
      Assert.assertFalse(WaitUtils.waitUntillElementVisibility(driver,productNameOnProductDetailsPage).getText().isEmpty());
    }

    @FindBy(xpath = "//a[@data-tab-id='reviews']")
    private WebElement productReviesOnProductDetailsPage;
    public void verifyProductReviesOnProductDetailsPage() {
        Assert.assertFalse(WaitUtils.waitUntillElementVisibility(driver,productReviesOnProductDetailsPage).getText().isEmpty());
    }


    @FindBy(xpath = "//h3[text()='Care and use']")
    private WebElement productCareAndUseOnProductDetailsPage;
    public void clickProductCareAndUseOnProductDetailsPage() {
       WaitUtils.waitUntillElementVisibility(driver,productCareAndUseOnProductDetailsPage).click();
    }

    @FindBy(xpath = "//h3[text()='Care and use']/following-sibling::div/a")
    private WebElement productCareAndUseAsLinkOnProductDetailsPage;
    public void verifyProductCareAndUseIsNotEmptyOnProductDetailsPage() {
        Assert.assertFalse(WaitUtils.waitUntillElementVisibility(driver,productCareAndUseAsLinkOnProductDetailsPage).getText().isEmpty());
    }

    @FindBy(xpath = "//div[@class='product__button-block']/button")
    private WebElement addToCartButtonOnProductDetailsPage;
    public void verifyAddToCartButtonOnProductDetailsPage() {
        Assert.assertFalse(WaitUtils.waitUntillElementVisibility(driver,addToCartButtonOnProductDetailsPage).getText().isEmpty());
    }

    @FindBy(xpath = "//button[@data-type='favorite_products']")
    private WebElement addToFavoritesButtonOnProductDetailsPage;
    public void clickAddToFavoritesButtonOnProductDetailsPage() {
        WaitUtils.waitUntillElementVisibility(driver,addToFavoritesButtonOnProductDetailsPage).click();
    }

    @FindBy(xpath = "//div[@role='tooltip']//a/parent::div")
    private WebElement tooltipOnAddToFavoritesOnProductDetailsPage;
    public void verifyTooltipMessageOnAddToFavoritesOnProductDetailsPage() {
            String lang = ConfigReader.propValueFromConfigFile("Language");
            switch (lang) {
                case "English" ->
                        Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, tooltipOnAddToFavoritesOnProductDetailsPage).getText().trim().contains("To save a favorite, you first need to"));
                case "Deutsch" ->
                        Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, tooltipOnAddToFavoritesOnProductDetailsPage).getText().trim().contains("Um ein Favorit zu speichern, müssen Sie sich zuerst"));
                case "Dutch" ->
                        Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, tooltipOnAddToFavoritesOnProductDetailsPage).getText().trim().contains("Om een favoriet op te slaan dien je eerst te"));
                case "French" ->
                        Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, tooltipOnAddToFavoritesOnProductDetailsPage).getText().trim().contains("Pour enregistrer un favori, veuillez d'abord vous"));
            }
    }

    @FindBy(xpath = "//div[@class='product__price']/span")
    private WebElement productPriceOnProductDetailsPage;
    public void verifyProductPrinceIsNotEmpty() {
        Assert.assertFalse(WaitUtils.waitUntillElementVisibility(driver,productPriceOnProductDetailsPage).getText().isEmpty());
    }

    public void verifyProductPrinceIsInEuro() {
        Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver,productPriceOnProductDetailsPage).getText().matches("€.*\\d.*"));
    }


    @FindBy(xpath = "//a[@data-tab-id='reviews']/following-sibling::a[@data-tab-id='specifications']")
    private WebElement viewProductSpecificationsOnProductDetailsPage;
    public void clickViewProductSpecificationsOnProductDetailsPage() {
        WaitUtils.waitUntillElementClickable(driver,viewProductSpecificationsOnProductDetailsPage).click();
    }

    @FindBy(xpath = "//h3[@data-tab-id='description']")
    private WebElement productDescriptionButtonOnProductDetailsPage;
    public void clickProductDescriptionButton() {
        WaitUtils.waitUntillElementClickable(driver,productDescriptionButtonOnProductDetailsPage).click();
    }

    @FindBy(xpath = "//div[contains(@class,'content--visible')]")
    private WebElement productDescriptionOnProductDetailsPage;
    public void verifyProductDescriptionIsNotEmpty() {
        Assert.assertFalse(WaitUtils.waitUntillElementVisibility(driver,productDescriptionOnProductDetailsPage).getText().isEmpty());
    }

    @FindBy(xpath = "//img[@loading='eager']")
    private WebElement productImageOnProductDetailsPage;
    public void verifyProductImageIsNotBrokenOnProductDetailsPage() {
        Assert.assertEquals(UrlCheck.brokenUrlAndImageCheck("https:"+WaitUtils.waitUntillElementVisibility(driver,productImageOnProductDetailsPage).getDomAttribute("src")),200);
    }

    @FindBy(xpath = "//div[@data-config='product-thumbs-slider']/div//img")
    private List<WebElement> productImageGalleryOnProductDetailsPage;
    public void verifyProductImagesGalleryOnProductDetailsPage() {
        for (WebElement image:productImageGalleryOnProductDetailsPage){
         Assert.assertEquals(UrlCheck.brokenUrlAndImageCheck("https:"+image.getDomAttribute("src")),200);
        }
    }


    @FindBy(xpath = "//h3[text()='Characteristics']")
    private WebElement productCharacteristicsButtonOnProductDetailsPage;
    public void clickProductCharacteristicsButtonOnProductDetailsPage() {
        WaitUtils.waitUntillElementVisibility(driver,productCharacteristicsButtonOnProductDetailsPage).click();
    }

    @FindBy(xpath = "//div[contains(@class,'content--visible')]/ul/li")
    private List<WebElement> productCharacteristicsDescriptionOnProductDetailsPage;
    public void verifyProductCharacteristicsDescriptionIsNotEmpty() {
        for(WebElement chars:productCharacteristicsDescriptionOnProductDetailsPage){
            Assert.assertFalse(WaitUtils.waitUntillElementVisibility(driver,chars).getText().isEmpty());
        }
    }

    @FindBy(xpath = "//button[@data-tab-id='specifications']")
    private WebElement productSpecificationsButtonOnProductDetailsPage;
    public void clickProductSpecificationsButtonOnProductDetailsPage() {
        WaitUtils.waitUntillElementVisibility(driver,productSpecificationsButtonOnProductDetailsPage).click();
    }

    @FindBy(xpath = "//div[@data-tab-id='specifications']//span")
    private List<WebElement> productSpecificationsDetailsnOnProductDetailsPage;
    public void verifyProductSpecificationsDetailsIsNotEmpty() {
        for(WebElement spec:productSpecificationsDetailsnOnProductDetailsPage){
            Assert.assertFalse(WaitUtils.waitUntillElementVisibility(driver,spec).getText().isEmpty());
        }
    }
}