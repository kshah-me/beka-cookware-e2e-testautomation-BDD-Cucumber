package stepdefinitions;

import com.bekacookware.base.DriverFactory;
import com.bekacookware.pages.NavigationFilterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class NavigationFilters_StepsDef {


    NavigationFilterPage navigationfilterpage = new NavigationFilterPage(DriverFactory.getINSTANCE().getDriver());

    @When("User click on About Beka Menu button")
    public void user_click_on_about_beka_menu_button() {
        navigationfilterpage.clickAboutBekaMenuButton();
    }
    @Then("Verify About Beka page should be displayed")
    public void verify_about_beka_page_should_be_displayed() {
        navigationfilterpage.verifyAboutBekaPageDisplayed();
    }
    @When("User click on Find a store Menu button")
    public void user_click_on_find_a_store_menu_button() {
        navigationfilterpage.clickFindAStoreMenuButton();
    }
    @Then("Verify Find a store page should be displayed")
    public void verify_find_a_store_page_should_be_displayed() {
        navigationfilterpage.verifyFindAStorePageDisplayed();
    }
    @When("User click on Best Sellers Menu button")
    public void user_click_on_best_sellers_menu_button() {
        navigationfilterpage.clickBestSellersMenuButton();
    }
    @Then("Verify Best Sellers page should be displayed")
    public void verify_best_sellers_page_should_be_displayed() {
        navigationfilterpage.verifyBestSellersPageDisplayed();
    }
    @When("User click on Outlet button")
    public void user_click_on_outlet_button() {
        navigationfilterpage.clickOutletNavigationButtonOnHomePage();
    }
    @Then("Verify Outlet page should be displayed")
    public void verify_outlet_page_should_be_displayed() {
        navigationfilterpage.verifyOutletPageDisplayed();
    }
    @When("User click on Inspiration button")
    public void user_click_on_inspiration_button() {
        navigationfilterpage.clickInspirationNavigationButtonOnHomePage();
    }
    @Then("Verify Inspiration page should be displayed")
    public void verify_inspiration_page_should_be_displayed() {
        navigationfilterpage.verifyInspirationPageDisplayed();
    }
    @When("User click on Profile button")
    public void user_click_on_profile_button() {
        navigationfilterpage.clickProfileIconButtonOnHomePage();
    }
    @Then("Verify Login page should be displayed")
    public void verify_login_page_should_be_displayed() {
        navigationfilterpage.verifyLoginPageDisplayed();
    }
    @When("User click on wishlist button")
    public void user_click_on_wishlist_button() {
        navigationfilterpage.clickWishlistIconButtonOnHomePage();
    }
    @Then("Verify wishlist page should be displayed")
    public void verify_wishlist_page_should_be_displayed() {
        navigationfilterpage.verifyWishlistPageDisplayed();
    }
    @When("User click on Add Cart button")
    public void user_click_on_cart_button() {
        navigationfilterpage.clickCartIconButtonOnHomePage();
    }
    @Then("Verify Cart page should be displayed")
    public void verify_cart_page_should_be_displayed() {
        navigationfilterpage.verifyCartPopupOnHomePage();
    }

    @When("User hover on Product tab")
    public void user_hover_on_product_tab() {
        navigationfilterpage.HoverOnProductMenuDropDown();
    }

    @Then("Verify all images under product grid are not broken")
    public void verify_all_images_under_product_grid_are_not_broken() {
        navigationfilterpage.verifyImagesOfItemsUnderProductListNotBroken();
    }

    @Then("Verify product names under product grid are not missing")
    public void verify_product_names_under_product_grid_are_not_missing() {
        navigationfilterpage.verifyNameOfItemsUnderProductListIsNotEmpty();
    }

    @When("User hover on Collections tab")
    public void user_hover_on_collections_tab() {
        navigationfilterpage.HoverOnCollectionMenuDropDown();

    }

    @Then("Verify all images under collection grid are not broken")
    public void verify_all_images_under_collection_grid_are_not_broken() {
        navigationfilterpage.verifyImagesOfItemsUnderCollectionMenuListIsNotBroken();
    }

    @Then("Verify product names under collection grid are not missing")
    public void verify_product_names_under_collection_grid_are_not_missing() {
        navigationfilterpage.verifyNameOfItemsUnderCollectionListIsNotEmpty();
    }

    @When("Click on Frying pan product")
    public void click_on_frying_pan_product() {
        navigationfilterpage.clickFryingPannUnderProductGridDropDown();
    }

    @When("Click on Sets product")
    public void click_on_sets_product() {
        navigationfilterpage.clickSetsUnderProductGridDropDown();
    }


    @Then("Verify Product filter page displayed")
    public void verify_product_filter_page_displayed() {
        navigationfilterpage.scrollToFilterSection();
        navigationfilterpage.verifyFilterSectionOnSearchResultpage();
    }

    @When("Click on Skillets product")
    public void click_on_skillets_product() {
        navigationfilterpage.clickSkilletsUnderProductGridDropDown();
    }

    @When("Select Aluminium as Material filter")
    public void select_as_material_filter() throws InterruptedException {
        navigationfilterpage.scrollToFilterSection();
        navigationfilterpage.clickAluminiumFilterUnderMaterialSectionOnFilterSection();
    }

    @And("Get the Initial Count Before Filter")
    public void get_the_initial_count_on_filter_Page() {
        navigationfilterpage.getTotalResultCountOnBeforeFilter();
    }

    @Then("Verify result has been updated")
    public void verify_result_has_been_updated() {
        navigationfilterpage.verifyResultCountIsLessThanTotalCount();
        navigationfilterpage.getTotalResultCountOnBeforeFilter();
    }
    @Then("Select Heat Source & Dishwasher filter as Electric")
    public void select_heat_source_dishwasher_filter_as_electric() throws InterruptedException {
        navigationfilterpage.clickElectricFilterUnderHeatSourceOnFilterSection();
    }

    @Then("Enter max price as {int}")
    public void enter_max_price_as(Integer maxprice) throws InterruptedException {
        navigationfilterpage.enterEndPriceRangeInputBox(maxprice);
    }

    @Then("Verify a message should be displayed")
    public void verify_a_message_should_be_displayed() {
        navigationfilterpage.verifyNoRecordFoundMessageForAllLanguages();
    }

    @Then("Navigate back to original page")
    public void navigate_back_to_original_page() {
        navigationfilterpage.navigateBackToOriginalPage();
    }
}
