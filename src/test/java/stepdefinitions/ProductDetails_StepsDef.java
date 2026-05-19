package stepdefinitions;


import com.bekacookware.pages.ProductDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetails_StepsDef{

    ProductDetailsPage productdetailspage = new ProductDetailsPage();

    @When("Click on first item on search result page")
    public void click_on_first_item_on_search_result_page() {
        productdetailspage.clickFirstItemUnderProductResultPage();
    }
    @Then("Verify product name is not empty on Product details page")
    public void verify_product_name_is_not_empty_on_product_details_page() {

        productdetailspage.verifyProductNameIsNotEmptyOnProductDetailsPage();
    }

    @Then("Verify product review is not empty on Product details page")
    public void verify_product_review_is_not_empty_on_product_details_page() {
        productdetailspage.verifyProductReviesOnProductDetailsPage();
    }

    @Then("Verify Add To Cart button is displayed on product details page")
    public void verify_add_to_cart_button_is_displayed_on_product_details_page() {
        productdetailspage.verifyAddToCartButtonOnProductDetailsPage();
    }

    @Then("Verify product image is not broken on Product details page")
    public void verify_product_image_is_not_broken_on_product_details_page() {
        productdetailspage.verifyProductImageIsNotBrokenOnProductDetailsPage();
    }

    @Then("Verify product image gallery is not broken on Product details page")
    public void verify_product_image_gallery_is_not_broken_on_product_details_page() {
        productdetailspage.verifyProductImagesGalleryOnProductDetailsPage();
    }

    @Then("Verify product description is not empty on Product details page")
    public void verify_product_description_is_not_empty_on_product_details_page() {
        productdetailspage.clickProductDescriptionButton();
        productdetailspage.verifyProductDescriptionIsNotEmpty();
    }
    @Then("Verify product characteristics is not empty on Product details page")
    public void verify_product_characteristics_is_not_empty_on_product_details_page() {
        productdetailspage.clickProductCharacteristicsButtonOnProductDetailsPage();
        productdetailspage.verifyProductCharacteristicsDescriptionIsNotEmpty();
    }
    @Then("Verify product specification is not empty on Product details page")
    public void verify_product_specification_is_not_empty_on_product_details_page() {
        productdetailspage.clickViewProductSpecificationsOnProductDetailsPage();
        productdetailspage.verifyProductSpecificationsDetailsIsNotEmpty();
    }


    @Then("Verify product Care and use is not empty on Product details page")
    public void verify_product_care_and_use_is_not_empty_on_product_details_page() {
        productdetailspage.clickProductCareAndUseOnProductDetailsPage();
        productdetailspage.verifyProductCareAndUseIsNotEmptyOnProductDetailsPage();
    }


    @When("Click on Add to Favorites button on Product details page")
    public void click_on_add_to_favorites_button_on_product_details_page() {
        productdetailspage.clickAddToFavoritesButtonOnProductDetailsPage();
    }
    @Then("Verify Tooltip message on Product details page")
    public void verify_tooltip_message_on_product_details_page() {
        productdetailspage.verifyTooltipMessageOnAddToFavoritesOnProductDetailsPage();
    }

    @Then("Verify product price is not empty on Product details page")
    public void verify_product_price_is_not_empty_on_product_details_page() {
        productdetailspage.verifyProductPrinceIsNotEmpty();
    }

    @Then("Verify product price is in Euro on Product details page")
    public void verify_product_price_is_in_euro_on_product_details_page() {
        productdetailspage.verifyProductPrinceIsInEuro();
    }
}
