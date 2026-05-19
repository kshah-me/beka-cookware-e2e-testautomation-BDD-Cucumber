package stepdefinitions;


import com.bekacookware.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class CartDetails_StepsDef{


    CartPage cartpage = new CartPage();

    @Given("Click on Add to Cart button")
    public void click_on_add_to_cart_button() throws InterruptedException {
        cartpage.clickAddToCartButton();
    }

    @Then("Verify product has been added to cart page")
    public void verify_product_has_been_added_to_cart_page() {
        cartpage.verifyCountOnOpenCartPage(1);
    }

    @Then("Increase the product count to {int}")
    public void increase_the_product_count_to(Integer count) throws InterruptedException {
            cartpage.clickIncrementItemCountButtonCartPopUp(count);
            Thread.sleep(3000);

    }

    @Then("Click on close cart button")
    public void click_on_close_cart_button() {
        cartpage.clickCloseOpenCartPupupButton();

    }

    @Then("Verify product count on cart icon is same")
    public void verify_product_count_on_cart_icon_is_same() {
        cartpage.verifyCountOnCartButton(1);
    }

    @Then("Verify product name is same on cart page")
    public void verify_product_name_is_same_on_cart_page() throws InterruptedException {
        cartpage.verifyProductNameOnCareIsSameAsProductDetails();
    }

    @Then("Verify Product suggestion under cart page")
    public void verify_product_suggestion_on_cart_page() throws InterruptedException {
        cartpage.verifyProductSuggestionOnOpenCartPage();
    }


    @Then("Verify image of product suggested under cart page are not broken")
    public void verify_image_of_product_suggested_under_cart_page_are_not_broken() throws InterruptedException {
       cartpage.verifyImageOfSuggestedItemUnderCartAreNotBroken();
    }


    @Then("Verify product price is same on cart page")
    public void verify_product_price_is_same_on_cart_page() throws InterruptedException {
        cartpage.verifyProductPriceOnCareIsSameAsProductDetails();
    }


    @Then("Verify the total price")
    public void verify_the_total_price() {
        cartpage.verifyTotalPriceIsSumOfEachItemPrice();
    }

    @And("Click on delete button against the product")
    public void click_on_delete_button_against_the_product() throws InterruptedException {
        cartpage.clickDeleteButtonOnOpenCartPage();
        Thread.sleep(3000);
    }

    @Then("Verify the total price as zero")
    public void verify_the_total_price_as_zero() {
        cartpage.verifyMessageOnEmptyCart();
        cartpage.verifyCountOnOpenCartPage(0);
    }

    @Then("Verify the total price for {int} products")
    public void verify_the_total_price_for_products(Integer count) throws InterruptedException {
        cartpage.verify10ProductPriceOnCartIsSameAsProductDetails(count);
    }

    @Then("Verify shipping details and return policy on cart page")
    public void verify_shipping_details_on_cart_page() throws InterruptedException {
        cartpage.verifyShippingDetailOnCartPage();
    }

    @Then("Verify delivery eligibility based on price")
    public void verify_free_delivery_eligibility_based_on_price() throws InterruptedException {
        cartpage.verifyDeliveryMessageCheckOnCartPage();
    }

}
