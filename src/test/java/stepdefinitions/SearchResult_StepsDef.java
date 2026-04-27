package stepdefinitions;

import com.bekacookware.base.DriverFactory;
import com.bekacookware.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;

public class SearchResult_StepsDef extends DriverFactory {

    SearchPage searchpage = new SearchPage(DriverFactory.getDriver());

    @And("User clicks on search icon")
    public void user_clicks_on_search_icon() {
        searchpage.clickSearchButtonOnHomePage();
    }

    @When("User enters {string} product name in Searchbox")
    public void user_enters_valid_product_name_as(String productName) throws InterruptedException {
        searchpage.enterSearchInputBoxOnHomePage(productName);
    }

    @When("User click on Search Button")
    public void user_click_on_search_button() {
        searchpage.clickSearchSubmitButtonOnHomePage();
    }

    @When("User click on Search Button on Search Result Page")
    public void user_click_on_serach_button_on_search_result_page() {
        searchpage.clickSearchSubmitButtonOnSearchresultPage();
    }


    @Then("Verify user should navigates to search page")
    public void user_should_navigates_to_search_page() {
        searchpage.verifySearchResultPageDisplayed();
    }


    @Then("Verify result count on search result page should be displayed")
    public void verify_result_count_on_search_result_page_should_be_displayed() {
        searchpage.verifyResultCountOnSearchResultPage();
    }

    @Then("Verify No Record Found error message in {string} language on search result page should be displayed")
    public void verify_an_error_message_on_search_result_page_should_be_displayed(String lang) {
        searchpage.verifyNoRecordMessageOnSearchResultPage(lang);
    }

    @Then("Verify image of all products on search result page are not broken")
    public void verify_image_of_all_products_on_search_result_page_are_not_broken() {
        searchpage.verifySearchResultPageHasNoBrokenImage();
    }

    @Then("Verify description of all products on search result page are not empty")
    public void verify_description_of_all_products_on_search_result_page_are_not_empty() {
        searchpage.verifySearchResultPageHasProductDescriptionNotEmpty();
    }

    @Then("Verify each product name is hyperlink on search result page")
    public void verify_each_product_name_is_hyperlink_on_search_result_page() {
        searchpage.verifySearchResultPageHasProductNameAslinkAndNotEmpty();
    }

    @Then("User enters again valid product name as {string}")
    public void user_enters_again_valid_product_name_as(String productname) throws InterruptedException {
        searchpage.enterInSearchInputBoxOnSearchResultPage(productname);
    }

    @Then("Verify search result page with {string} details should be displayed")
    public void verify_search_result_page_with_updated_details_should_be_displayed(String newitem) {
        searchpage.verifyNewSearchedItemsDetailsOnSearchResultPage(newitem);
    }

//    @Test
//    public void verifyProductAsHeaderDisplayedInSearchedProductList() throws InterruptedException {
//        searchpage = new SearchPage(DriverFactory.getDriver());
//        searchpage.clickSearchButtonOnHomePage();
//        searchpage.enterSearchInputBoxOnHomePage("Pan");
//        searchpage.verifyProductAsHeaderInSearchResult();
//    }
//
//    @Test
//    public void verifySearchedProductListHasPrice() throws InterruptedException {
//        searchpage = new SearchPage(DriverFactory.getDriver());
//        searchpage.clickSearchButtonOnHomePage();
//        searchpage.enterSearchInputBoxOnHomePage("water");
//        searchpage.verifySearchResultItemHasProductPrice();
//    }
//
//    @Test
//    public void verifySearchedProductListHasNoBrokenLink() throws InterruptedException {
//        searchpage = new SearchPage(DriverFactory.getDriver());
//        searchpage.clickSearchButtonOnHomePage();
//        searchpage.enterSearchInputBoxOnHomePage("fork");
//        searchpage.verifySearchResultItemHasNoBrokenLink();
//    }
//
//    @Test
//    public void verifySearchedProductListHasNoBrokenImage() throws InterruptedException {
//        searchpage = new SearchPage(DriverFactory.getDriver());
//        searchpage.clickSearchButtonOnHomePage();
//        searchpage.enterSearchInputBoxOnHomePage("Glass");
//        searchpage.verifySearchResultItemHasNoBrokenImg();
//    }
//
//    @Test
//    public void verifyMessageForNoResultFoundOnSearchedProductPage() throws InterruptedException {
//        searchpage = new SearchPage(DriverFactory.getDriver());
//        searchpage.clickSearchButtonOnHomePage();
//        searchpage.enterSearchInputBoxOnHomePage("ABC");
//        searchpage.clickSearchSubmitButtonOnHomePage();
//        searchpage.verifyNoSearchResultMessageOnHomePage();
//    }
//
//    @Test
//    public void verifySearchedProductResultPageHasNoBrokenImage() throws InterruptedException {
//        searchpage = new SearchPage(DriverFactory.getDriver());
//        searchpage.clickSearchButtonOnHomePage();
//        searchpage.enterSearchInputBoxOnHomePage("Plate");
//        searchpage.clickSearchSubmitButtonOnHomePage();
//        searchpage.verifyProductSearchResultPageHasNoBrokenImage();
//    }
//
//    @Test
//    public void verifySearchedProductResultPageHasProductNameAsLinkAndNotEmpty() throws InterruptedException {
//        searchpage = new SearchPage(DriverFactory.getDriver());
//        searchpage.clickSearchButtonOnHomePage();
//        searchpage.enterSearchInputBoxOnHomePage("Plate");
//        searchpage.clickSearchSubmitButtonOnHomePage();
//        searchpage.verifyProductSearchResultPageHasProductNameAslinkAndNotEmpty();
//    }
//
//    @Test
//    public void verifySearchedProductResultPageHasProductDescriptionNotEmpty() throws InterruptedException {
//        searchpage = new SearchPage(DriverFactory.getDriver());
//        searchpage.clickSearchButtonOnHomePage();
//        searchpage.enterSearchInputBoxOnHomePage("Plate");
//        searchpage.clickSearchSubmitButtonOnHomePage();
//        searchpage.verifyProductSearchResultPageHasProductDescriptionNotEmpty();
//    }

}
