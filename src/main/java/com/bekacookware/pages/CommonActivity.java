package com.bekacookware.pages;

import com.bekacookware.base.BasePage;
import com.bekacookware.utility.WaitUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CommonActivity extends BasePage {

    public void launchUrl(String url) {
        driver.get(url);
        clickCookiesPopupAcceptance();
        clickCrossButtonOnGermanyCountrySelectionPopup();
        clickCloseButtonOnAddPopUp();
    }


    @FindBy(xpath = "//button[@aria-label='Close dialog']/*[local-name()='svg']")
    private WebElement closeButtonOnAddPopUp;
    public void clickCloseButtonOnAddPopUp() {
        WaitUtils.waitAndClickIfPresent(driver, closeButtonOnAddPopUp);
    }

    @FindBy(xpath = "//button[text()='Cookies accepteren']")
    private WebElement cookiesPopupAcceptance;
    public void clickCookiesPopupAcceptance() {
        WaitUtils.waitUntillElementVisibility(driver,cookiesPopupAcceptance).click();
    }

    @FindBy(xpath = "//button[@class='modal__close | js-modal-close']")
    private WebElement crossButtonOnGermanyCountrySelectionPopup;
    public void clickCrossButtonOnGermanyCountrySelectionPopup() {
        WaitUtils.waitUntillElementVisibility(driver,crossButtonOnGermanyCountrySelectionPopup).click();
    }


    @FindBy(css = "iframe[src*='challenges.cloudflare']")
    private WebElement cloudflareIframe;
    private List<WebElement> cloudflareIframeExisting;
    public void clickRobotPagePopup() {
        if (!cloudflareIframeExisting.isEmpty()){
            WaitUtils.waitUntillPresenceOfElement(driver,cloudflareIframe);
            driver.switchTo().frame(cloudflareIframe);

        }
    }

}
