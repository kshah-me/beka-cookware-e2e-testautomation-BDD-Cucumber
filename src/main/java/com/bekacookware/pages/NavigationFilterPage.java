package com.bekacookware.pages;


import com.bekacookware.base.BasePage;
import com.bekacookware.config.ConfigReader;
import com.bekacookware.utility.MouseKeyboardAction;
import com.bekacookware.utility.PageScrollUtility;
import com.bekacookware.utility.UrlCheck;
import com.bekacookware.utility.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;
import java.util.List;
import java.util.Objects;
import java.util.regex.*;



public class NavigationFilterPage  extends BasePage {

    private Integer totalcountbeforefilter;


    @FindBy(xpath = "(//ul[@class='top-nav__list']/li/a)[1]")
    private WebElement aboutBekaMenuButton;
    public void clickAboutBekaMenuButton() {
        WaitUtils.waitUntillElementVisibility(driver,aboutBekaMenuButton).click();
    }

    @FindBy(xpath = "(//ul[@class='top-nav__list']/li/a)[2]")
    private WebElement findAStoreMenuButton;
    public void clickFindAStoreMenuButton() {
        WaitUtils.waitUntillElementVisibility(driver,findAStoreMenuButton).click();
    }

    @FindBy(xpath = "(//ul[@class='top-nav__list']/li/a)[3]")
    private WebElement bestSellersMenuButton;
    public void clickBestSellersMenuButton() {
        WaitUtils.waitUntillElementVisibility(driver,bestSellersMenuButton).click();
    }

    public void verifyAboutBekaPageDisplayed() {
        if (ConfigReader.propValueFromConfigFile("Language").equals("Dutch")) {
            Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("over-beka"));
        }
        else{
            Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("about-beka-"));
        }
    }

    public void verifyFindAStorePageDisplayed() {
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("store-locator"));
    }

    public void verifyBestSellersPageDisplayed() {
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("best-sellers"));
    }

    @FindBy(xpath = "(//ul[@class='main-nav__list']/li/a)[3]")
    private WebElement outletNavigationButtonOnHomePage;
    public void clickOutletNavigationButtonOnHomePage() {
        WaitUtils.waitUntillElementVisibility(driver,outletNavigationButtonOnHomePage).click();
    }


    @FindBy(xpath = "//main[@class='main']//h1")
    private WebElement outletNavigationPage;
    public void verifyOutletPageDisplayed() {
        String lang = ConfigReader.propValueFromConfigFile("Language");
        switch (lang) {
            case "English", "Dutch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, outletNavigationPage).getText().trim().contains("SALES"));
            case "Deutsch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, outletNavigationPage).getText().trim().contains("PROMOTIONS"));
            case "French" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, outletNavigationPage).getText().trim().contains("ANGEBOTE"));
        }
    }


    @FindBy(xpath = "(//ul[@class='main-nav__list']/li/a)[4]")
    private WebElement inspirationNavigationButtonOnHomePage;
    public void clickInspirationNavigationButtonOnHomePage() {
        WaitUtils.waitUntillElementVisibility(driver,inspirationNavigationButtonOnHomePage).click();
    }


    @FindBy(xpath = "//nav[@aria-label='breadcrumbs']/following-sibling::div/h1")
    private WebElement inspirationNavigationPage;
    public void verifyInspirationPageDisplayed() {
        String lang = ConfigReader.propValueFromConfigFile("Language");
        switch (lang) {
            case "English", "French", "Deutsch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, inspirationNavigationPage).getText().contains("INSPIRATION"));
            case "Dutch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, inspirationNavigationPage).getText().contains("INSPIRATIE"));
        }
    }

    @FindBy(xpath = "(//ul[@class='aside-nav__list']/li/a)[1]")
    public WebElement profileIconButtonOnHomePage;
    public void clickProfileIconButtonOnHomePage() {
        WaitUtils.waitUntillElementVisibility(driver,profileIconButtonOnHomePage).click();
    }

    public void verifyLoginPageDisplayed(){
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("https://shopify.com/authentication"));
    }

    @FindBy(xpath = "(//ul[@class='aside-nav__list']/li/a)[2]")
    public WebElement wishlistIconButtonOnHomePage;
    public void clickWishlistIconButtonOnHomePage() {
        WaitUtils.waitUntillElementVisibility(driver,wishlistIconButtonOnHomePage).click();
    }

    @FindBy(xpath = "//main[@class='main']//h1")
    private WebElement wishlistNavigationPage;
    public void verifyWishlistPageDisplayed() {
        String lang = ConfigReader.propValueFromConfigFile("Language");
        switch (lang) {
            case "English", "Dutch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, wishlistNavigationPage).getText().contains("WISHLIST"));
            case "Deutsch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, wishlistNavigationPage).getText().contains("WUNSCHLISTE"));
            case "French" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, wishlistNavigationPage).getText().contains("LISTE DE SOUHAITS"));
        }
    }

    @FindBy(xpath = "(//ul[@class='aside-nav__list']/li/a)[3]")
    public WebElement cartIconButtonOnHomePage;
    public void clickCartIconButtonOnHomePage() {
        WaitUtils.waitUntillElementVisibility(driver,cartIconButtonOnHomePage).click();
    }

    @FindBy(xpath = "//div[@id='cart-container']/p")
    public WebElement cartPopupOnHomePage;
    public void verifyCartPopupOnHomePage() {
        String lang =ConfigReader.propValueFromConfigFile("Language");
        switch (lang) {
            case "English" ->
                    Assert.assertEquals("Your cart is currently empty.", WaitUtils.waitUntillElementVisibility(driver, cartPopupOnHomePage).getText());
            case "Deutsch" ->
                    Assert.assertEquals("Ihr Einkaufswagen ist im Moment leer.", WaitUtils.waitUntillElementVisibility(driver, cartPopupOnHomePage).getText());
            case "Dutch" ->
                    Assert.assertEquals("Uw winkelwagentje is momenteel leeg.", WaitUtils.waitUntillElementVisibility(driver, cartPopupOnHomePage).getText());
            case "French" ->
                    Assert.assertEquals("Votre panier est vide.", WaitUtils.waitUntillElementVisibility(driver, cartPopupOnHomePage).getText());
        }
    }

    @FindBy(xpath = "//ul[@class='main-nav__list']/li/a[contains(@href,'collections/all')]")
    private WebElement productMenuDropDown;
    public void HoverOnProductMenuDropDown() {
        MouseKeyboardAction.mouseHoverOnMainMenu(driver,WaitUtils.waitUntillElementVisibility(driver,productMenuDropDown));
    }

    @FindBy(xpath = "//img[contains(@src,'cdn/shop/collections/pannen')]/ancestor::a")
    private WebElement fryingPannUnderProductGridDropDown;
    public void clickFryingPannUnderProductGridDropDown() {
        MouseKeyboardAction.clickSubMenuViaMouseHover(driver,WaitUtils.waitUntillElementVisibility(driver,productMenuDropDown), fryingPannUnderProductGridDropDown);
    }

    @FindBy(xpath = "//img[contains(@src,'cdn/shop/files/sauteerpannen.png?')]/ancestor::a")
    private WebElement skilletsUnderProductGridDropDown;
    public void clickSkilletsUnderProductGridDropDown() {
        MouseKeyboardAction.clickSubMenuViaMouseHover(driver,WaitUtils.waitUntillElementVisibility(driver,productMenuDropDown), skilletsUnderProductGridDropDown);
    }

    @FindBy(xpath = "(//img[contains(@src,'cdn/shop/collections/sets.png')]/ancestor::a)[1]")
    private WebElement setsUnderProductGridDropDown;
    public void clickSetsUnderProductGridDropDown() {
        MouseKeyboardAction.clickSubMenuViaMouseHover(driver,WaitUtils.waitUntillElementVisibility(driver,productMenuDropDown), setsUnderProductGridDropDown);
    }


    @FindBy(xpath = "//a[contains(@href,'collections/all')]/following-sibling::ul//ul/li//img")
    private List<WebElement> imageUnderProductMenuList;
    public void verifyImagesOfItemsUnderProductListNotBroken(){
        for(WebElement productItem:imageUnderProductMenuList){
            Assert.assertEquals(200, UrlCheck.brokenUrlAndImageCheck("https:"+productItem.getDomAttribute("src")));
        }
    }

    @FindBy(xpath = "//a[contains(@href,'collections/all')]/following-sibling::ul//ul/li//span/following-sibling::span")
    private List<WebElement> nameUnderProductMenuList;
    public void verifyNameOfItemsUnderProductListIsNotEmpty(){
        for(WebElement productItemName:nameUnderProductMenuList){
            Assert.assertFalse(productItemName.getText().trim().isEmpty());
        }
    }


    @FindBy(xpath = "//ul[contains(@class,'main-nav__dropdown')]/preceding-sibling::a[contains(@href,'page')]")
    private WebElement collectionMenuDropDown;
    public void HoverOnCollectionMenuDropDown() {
        MouseKeyboardAction.mouseHoverOnMainMenu(driver,WaitUtils.waitUntillElementVisibility(driver,collectionMenuDropDown));
    }

    @FindBy(xpath = "//ul[contains(@class,'main-nav__dropdown')]/preceding-sibling::a[contains(@href,'page')]/following-sibling::ul//ul/li//img")
    private List<WebElement> imageunderCollectionMenuList;
    public void verifyImagesOfItemsUnderCollectionMenuListIsNotBroken(){
        for(WebElement collectionItem:imageunderCollectionMenuList){
            Assert.assertEquals(200, UrlCheck.brokenUrlAndImageCheck("https:"+collectionItem.getDomAttribute("src")));
        }
    }


    @FindBy(xpath = "//ul[@class='main-nav__dropdown-item-list']/li//span[contains(@class,'--grid-title')]")
    public List<WebElement> nameUnderCollectionMenuList;
    public void verifyNameOfItemsUnderCollectionListIsNotEmpty(){
        for(WebElement productItemName:nameUnderCollectionMenuList){
            //System.out.println(productItemName.getText().trim().isEmpty());
            Assert.assertFalse(productItemName.getText().trim().isEmpty());
        }
    }


    @FindBy(xpath = "//img[contains(@src,'cdn/shop/files/Collection_images4_Chef')]/ancestor::a")
    private WebElement chefProductUnderCollectionGridDropDown;
    public void clickChefProductUnderCollectionGridDropDown() {
        MouseKeyboardAction.clickSubMenuViaMouseHover(driver,WaitUtils.waitUntillElementVisibility(driver,collectionMenuDropDown), chefProductUnderCollectionGridDropDown);
    }

    @FindBy(xpath = "(//div[@id='product-grid']//div[@class='product-item__wrapper'])[3]")
    private WebElement fryingPannUnderProductResultPage;
    public void clickFryingPannUnderProductResultPage() {
        WaitUtils.waitUntillElementVisibility(driver,fryingPannUnderProductResultPage).click();
    }


    @FindBy(xpath = "//p[@id='verticalTitle']")
    private WebElement filterSectionOnSearchResultpage;
    public void verifyFilterSectionOnSearchResultpage() {
        filterSectionOnSearchResultpage.isDisplayed();
    }

    @FindBy(xpath = "//div[@id='FacetsWrapperDesktop']//p[@id='verticalTitle']")
    private WebElement filterSection;
    public void scrollToFilterSection() {
        PageScrollUtility.scrollToElement(driver,filterMaterialExpandButtonOnFilterSection);
    }

    @FindBy(xpath = "//span[@id='ProductCountDesktop']")
    private WebElement totalResultCountOnBeforeFilter;
    public void getTotalResultCountOnBeforeFilter() {
        totalcountbeforefilter= Integer.parseInt(WaitUtils.waitUntillElementVisibility(driver,totalResultCountOnBeforeFilter).getText().replaceAll("\\D+", ""));
    }

    public Integer extractFilterCount() {
        Matcher matcher = Pattern.compile("\\d+").matcher(WaitUtils.waitUntillElementVisibility(driver,totalResultCountOnBeforeFilter).getText());
        return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
    }

    public void verifyResultCountIsLessThanTotalCount() {
       Assert.assertTrue(totalcountbeforefilter >= extractFilterCount());
    }

    @FindBy(xpath = "(//div[@id='FacetsWrapperDesktop']/details[@data-index='1']/div//ul//div)[1]")
    private WebElement filterByPannTypeUnderFilterSection;
    public void clickFilterByFishPannUnderFilterSection() {
        WaitUtils.waitUntillElementVisibility(driver,filterByPannTypeUnderFilterSection).click();
        Assert.assertTrue(totalcountbeforefilter >= extractFilterCount());
    }

    @FindBy(xpath = "(//span[normalize-space()='Aluminium' or normalize-space()='Aluminum']/ancestor::li)[1]")
    private WebElement filterMaterialAluminiumButtonOnFilterSection;
    @FindBy(xpath = "(//summary[contains(@aria-label,'Matériaux') or contains(@aria-label,'Materia')])[1]")
    private WebElement filterMaterialExpandButtonOnFilterSection;
    public void clickAluminiumFilterUnderMaterialSectionOnFilterSection() throws InterruptedException {
        WaitUtils.waitUntillElementVisibility(driver,filterMaterialExpandButtonOnFilterSection).click();
        Thread.sleep(3000);
        WaitUtils.waitUntillElementClickable(driver,filterMaterialAluminiumButtonOnFilterSection).click();
        Thread.sleep(3000);
    }

    @FindBy(xpath = "(//summary[contains(@aria-label,'dishwasher') or contains(@aria-label,'vaatwasser') or contains(@aria-label,'Wärmequelle') or contains(@aria-label,'lave-vaisselle')])[1]")
    private WebElement filterHeatSourceDishwasherExpandButtonOnFilterSection;
    @FindBy(xpath = "//summary/following-sibling::div//ul/li//span[contains(text(),'Electric') or contains(text(),'Électrique') or contains(text(),'Elektrisch')]/ancestor::li")
    private WebElement filterHeatSourceTypeElectricButtonOnFilterSection;
    public void clickElectricFilterUnderHeatSourceOnFilterSection() throws InterruptedException {
        WaitUtils.waitUntillElementVisibility(driver,filterHeatSourceDishwasherExpandButtonOnFilterSection).click();
        Thread.sleep(3000);
        WaitUtils.waitUntillElementVisibility(driver,filterHeatSourceTypeElectricButtonOnFilterSection).click();
        Thread.sleep(3000);
    }

    @FindBy(xpath = "(//input[@class='input js-max-value' and @type='number'])[1]")
    private WebElement priceEndRangeInputBox;
    public void enterEndPriceRangeInputBox(Integer num) throws InterruptedException {
        WaitUtils.waitUntillElementVisibility(driver,priceEndRangeInputBox).sendKeys(Integer.toString(num));
        Thread.sleep(3000);
    }

    public void navigateBackToOriginalPage(){
        driver.navigate().back();
    }

    @FindBy(xpath = "//div[@id='product-grid']//p")
    private WebElement noRecordFoundMessage;
    public void verifyNoRecordFoundMessageForAllLanguages(){
        String lang =ConfigReader.propValueFromConfigFile("Language");
        switch (lang) {
            case "English" ->
                    Assert.assertEquals("Sorry, there are no products in this collection", WaitUtils.waitUntillElementVisibility(driver, noRecordFoundMessage).getText());
            case "Deutsch" ->
                    Assert.assertEquals("Es tut uns leid, aber Ihre Suche nach Produkten hat keine Treffer ergeben.", WaitUtils.waitUntillElementVisibility(driver, noRecordFoundMessage).getText());
            case "Dutch" ->
                    Assert.assertEquals("Sorry, er zitten geen producten in deze collectie", WaitUtils.waitUntillElementVisibility(driver, noRecordFoundMessage).getText());
            case "French" ->
                    Assert.assertEquals("Aucun produit ne correspond à votre recherche.", WaitUtils.waitUntillElementVisibility(driver, noRecordFoundMessage).getText());
        }

    }

}