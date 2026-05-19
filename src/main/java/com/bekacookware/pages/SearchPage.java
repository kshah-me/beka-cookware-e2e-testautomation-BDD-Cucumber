package com.bekacookware.pages;


import com.bekacookware.base.BasePage;
import com.bekacookware.config.ConfigReader;
import com.bekacookware.utility.UrlCheck;
import com.bekacookware.utility.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;
import java.util.Objects;

public class SearchPage extends BasePage {


    @FindBy(xpath = "//button[@data-modal-id='search-modal']")
    private WebElement searchButtonOnHomePage;
    public void clickSearchButtonOnHomePage() {
        WaitUtils.waitUntillElementVisibility(driver,searchButtonOnHomePage).click();
    }


    @FindBy(xpath = "(//input[@name='q'])[2]")
    private WebElement searchInputBoxOnHomePage;
    public void enterSearchInputBoxOnHomePage(String item) throws InterruptedException {
        WaitUtils.waitUntillElementVisibility(driver,searchInputBoxOnHomePage).sendKeys(item);
        Thread.sleep(5000);
    }

    @FindBy(xpath = "(//input[@name='q'])[1]")
    private WebElement searchInputBoxOnSearchResultPage;
    public void enterInSearchInputBoxOnSearchResultPage(String item) throws InterruptedException {
        WaitUtils.waitUntillElementVisibility(driver,searchInputBoxOnSearchResultPage).sendKeys(item);
        Thread.sleep(5000);
    }

    @FindBy(xpath = "(//button[contains(@class,'search-bar__submit')])[1]")
    private WebElement searchSubmitButtonOnSearchresultPage;
    public void clickSearchSubmitButtonOnSearchresultPage() {
        WaitUtils.waitUntillElementVisibility(driver,searchSubmitButtonOnSearchresultPage).click();
        WaitUtils.waitUntillPageLoaded(driver);
    }

    @FindBy(xpath = "(//button[contains(@class,'search-bar__submit')])[2]")
    private WebElement searchSubmitButtonOnHomePage;
    public void clickSearchSubmitButtonOnHomePage() {
        WaitUtils.waitUntillElementVisibility(driver,searchSubmitButtonOnHomePage).click();
        WaitUtils.waitUntillPageLoaded(driver);
    }


    @FindBy(xpath = "//nav[@aria-label='breadcrumbs']/following-sibling::div//h1")
    private WebElement searchResultPage;
    public void verifySearchResultPageDisplayed() {
        String lang = ConfigReader.propValueFromConfigFile("Language");
        switch (lang) {
            case "English" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, searchResultPage).getText().trim().contains("SEARCH RESULTS"));
            case "Deutsch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, searchResultPage).getText().trim().contains("SUCHERGEBNISSE"));
            case "Dutch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, searchResultPage).getText().trim().contains("ZOEKEN"));
            case "French" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, searchResultPage).getText().trim().contains("RÉSULTATS DE RECHERCHE"));
        }
    }



    @FindBy(xpath = "//nav[@aria-label='breadcrumbs']//span/following-sibling::span")
    private WebElement resultCountOnSearchResultPage;
    public void verifyResultCountOnSearchResultPage() {
        Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver,resultCountOnSearchResultPage).getText().trim().matches(".*\\d.*"));
    }

    public void verifyNewSearchedItemsDetailsOnSearchResultPage(String newitem) {
        Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver,resultCountOnSearchResultPage).getText().trim().contains(newitem));
    }

    @FindBy(xpath = "//ul[@id='predictive-search-results']/div/h3[contains(text(),'Prod')]")
    private WebElement productHeaderInSearchResult;
    public void verifyProductAsHeaderInSearchResult() {
        Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver,productHeaderInSearchResult).getText().trim().toLowerCase().contains("prod"));
    }


    @FindBy(xpath = "//dl[contains(@class,'predictive-search-item__details price')]/ancestor::a")
    List<WebElement> searchResultItemHasNoBrokenLink;
    public void verifySearchResultItemHasNoBrokenLink() {
        for (WebElement link:searchResultItemHasNoBrokenLink){
            Assert.assertEquals(link.getTagName(),"a");
            Assert.assertEquals(UrlCheck.brokenUrlAndImageCheck(Objects.requireNonNull(link.getAttribute("href"))),200);
        }
    }

    @FindBy(xpath = "//dl[contains(@class,'predictive-search-item__details price')]/ancestor::a//img")
    List<WebElement> searchResultItemHasNoBrokenImg;
    public void verifySearchResultItemHasNoBrokenImg() {
        for (WebElement img:searchResultItemHasNoBrokenImg){
            Assert.assertEquals(UrlCheck.brokenUrlAndImageCheck(img.getAttribute("src")),200);
        }
    }

    @FindBy(xpath = "//dl[contains(@class,'predictive-search-item__details price')]//dd/span")
    List<WebElement> searchResultItemHasProductPrice;
    public void verifySearchResultItemHasProductPrice() {
        for (WebElement price:searchResultItemHasProductPrice){
            Assert.assertTrue(price.getText().contains("€"));
            Assert.assertTrue(price.getText().contains(","));
            Assert.assertTrue(price.getText().matches(".*€\\s*\\d+.*"));
        }
    }

    @FindBy(xpath = "//div[@class='search-result__image']//img")
    List<WebElement> searchResultPageHasNoBrokenImage;
    public void verifySearchResultPageHasNoBrokenImage() {
        for (WebElement img:searchResultPageHasNoBrokenImage){
            Assert.assertEquals(UrlCheck.brokenUrlAndImageCheck(img.getAttribute("src")),200);
        }
    }


    @FindBy(xpath = "//div[@class='grid__item large--three-quarters']//a")
    List<WebElement> searchResultPageHasProductNameAslinkAndNotEmpty;
    public void verifySearchResultPageHasProductNameAslinkAndNotEmpty() {
        for (WebElement link:searchResultPageHasProductNameAslinkAndNotEmpty){
            Assert.assertFalse(link.getText().isEmpty());
            Assert.assertEquals(UrlCheck.brokenUrlAndImageCheck(link.getAttribute("href")),200);
        }
    }

    @FindBy(xpath = "//div[@class='grid__item large--three-quarters']//a/parent::h2/following-sibling::p")
    List<WebElement> searchResultPageHasProductDescriptionNotEmpty;
    public void verifySearchResultPageHasProductDescriptionNotEmpty() {
        Assert.assertFalse(searchResultPageHasProductDescriptionNotEmpty.isEmpty());
       // System.out.println("Product Description count"+productSearchResultPageHasProductDescriptionNotEmpty.size());
        for (WebElement productdescription:searchResultPageHasProductDescriptionNotEmpty){
            Assert.assertFalse(productdescription.getText().isEmpty());
        }
    }

    @FindBy(xpath = "//a[text()='Home']/following-sibling::span[contains(text(),'0')]")
    private WebElement noSearchResultMessage;
    public void verifyNoRecordMessageOnSearchResultPage(String lang) {
        switch (lang) {
            case "English" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, noSearchResultMessage).getText().contains("Search: 0 results found for"));
            case "Deutsch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, noSearchResultMessage).getText().contains("Suche: 0 Ergebnisse gefunden für"));
            case "Dutch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, noSearchResultMessage).getText().contains("Zoeken: 0 resultaten gevonden voor"));
            case "French" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, noSearchResultMessage).getText().contains("Recherche : 0 résultat trouvé pour"));
        }
    }

}
