package com.bekacookware.pages;



import com.bekacookware.config.ConfigReader;
import com.bekacookware.utility.UrlCheck;
import com.bekacookware.utility.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import java.util.List;


public class HomePage{

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//img[@class='logo-desktop']")
	private WebElement logo;
	public void verifyLogoIsPresentAndNotBroken() {
		Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver,logo).isDisplayed());
        Assert.assertEquals(200, UrlCheck.brokenUrlAndImageCheck(logo.getAttribute("src")));
    }

    public void verifyPageTitle(String title) {
        Assert.assertEquals(driver.getTitle(),title);
    }

    @FindBy(xpath = "//html[@lang='nl']")
    private WebElement applicationLanguageAsNL;
    public void verifyApplicationInDutch() {
        Assert.assertTrue(applicationLanguageAsNL.isDisplayed());
    }

    @FindBy(xpath = "//html[@lang='en']")
    private WebElement applicationLanguageAsEN;
    public void verifyApplicationInEnglish() {
        Assert.assertTrue(applicationLanguageAsEN.isDisplayed());
    }

    @FindBy(xpath = "//html[@lang='fr']")
    private WebElement applicationLanguageAsFR;
    public void verifyApplicationInFrench() {
        Assert.assertTrue(applicationLanguageAsFR.isDisplayed());
    }

    @FindBy(xpath = "//html[@lang='de']")
    private WebElement applicationLanguageAsDE;
    public void verifyApplicationInDeutsch() {
        Assert.assertTrue(applicationLanguageAsDE.isDisplayed());
    }

    @FindBy(xpath = "//ul//form[@id='localization_form']")
    private WebElement languageDropDownButton;
    public void clickOnLanguageDropDown() {
        WaitUtils.waitUntillElementVisibility(driver,languageDropDownButton).click();
    }

    @FindBy(xpath = "(//ul[@id='lang-list']/li/a[@data-value='nl'])[1]")
    private WebElement nlLanguage;
    public void selectDutchLanguage() {
        WaitUtils.waitUntillElementVisibility(driver,nlLanguage).click();
    }

    @FindBy(xpath = "(//ul[@id='lang-list']/li/a[@data-value='en'])[1]")
    private WebElement enLanguage;
    public void selectEnglishLanguage() {
        WaitUtils.waitUntillElementVisibility(driver,enLanguage).click();
    }

    @FindBy(xpath = "(//ul[@id='lang-list']/li/a[@data-value='fr'])[1]")
    private WebElement frLanguage;
    public void selectFrenchLanguage() {
        WaitUtils.waitUntillElementVisibility(driver,frLanguage).click();
    }

    @FindBy(xpath = "(//ul[@id='lang-list']/li/a[@data-value='de'])[1]")
    private WebElement deLanguage;
    public void selectDeutschLanguage() {
        WaitUtils.waitUntillElementVisibility(driver,deLanguage).click();
    }

    @FindBy(tagName = "footer")
    private WebElement footerOnHomePage;
    public void verifyFooterOnHomePageDisplayed() {
        Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver,footerOnHomePage).isDisplayed());
    }

    @FindBy(xpath="//nav//a")
    private List<WebElement> navigationOnHomePage;
    public void verifyNavigationOnHomePage() throws InterruptedException {
        for (WebElement aTag:navigationOnHomePage){
            String href = aTag.getAttribute("href");
            if (href != null && !href.startsWith("https://www.beka-cookware.com/customer_authentication")) {
                Thread.sleep(3000);
                Assert.assertEquals(200, UrlCheck.brokenUrlAndImageCheck(href));
            }
        }
    }

    @FindBy(xpath = "//div[@class='icon icon-account']/parent::a")
    private WebElement accountIconButton;
    public void clickOnAccountIconButton() {
        WaitUtils.waitUntillElementVisibility(driver,accountIconButton).click();
    }

    @FindBy(xpath ="//input[@id='customer-authentication-web-email']")
    private WebElement userEmailId;
    public void EnterUserEmailId(String emailid) {
        WaitUtils.waitUntillElementVisibility(driver,userEmailId).sendKeys(emailid);
    }

    @FindBy(xpath ="//input[@id='customer-authentication-web-email']/parent::div/parent::div/following-sibling::button")
    private WebElement loginButton;
    public void clickOnLoginButton() {
        WaitUtils.waitUntillElementVisibility(driver,loginButton).click();
    }

    @FindBy(xpath = "//div[@id='error-for-customer-authentication-web-email']")
    private WebElement errorMessageForInvalidUserName;
    public void verifyErrorMessageForInvalidUserName() {
        String lang = ConfigReader.propValueFromConfigFile("Language");
        switch (lang) {
            case "English" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, errorMessageForInvalidUserName).getText().contains("Enter a valid email address"));
            case "Deutsch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, errorMessageForInvalidUserName).getText().contains("Gib eine gültige E-Mail-Adresse ein"));
            case "Dutch" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, errorMessageForInvalidUserName).getText().contains("Voer een geldig e-mailadres in"));
            case "French" ->
                    Assert.assertTrue(WaitUtils.waitUntillElementVisibility(driver, errorMessageForInvalidUserName).getText().contains("Saisissez une adresse e-mail valide"));
        }

    }

    public void selectLanguage(String lang){
        if (lang.contains("English")) {
            selectEnglishLanguage();
        } else if (lang.contains("Dutch")) {
            selectDutchLanguage();
        } else if (lang.contains("French")) {
            selectFrenchLanguage();
        } else if (lang.contains("Deutsch")) {
            selectDeutschLanguage();
        }
    }
}
