package stepdefinitions;

import com.bekacookware.base.DriverFactory;
import com.bekacookware.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class CartDetails_StepsDef extends DriverFactory {


    CartPage cartpage = new CartPage(DriverFactory.getDriver());

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
        for (int i=1;i<count;i++){
            cartpage.clickIncrementItemCountButtonCartPopUp();
            Thread.sleep(5000);
        }
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

    @Then("Verify product price is same on cart page")
    public void verify_product_price_is_same_on_cart_page() throws InterruptedException {
        cartpage.verifyProductPriceOnCareIsSameAsProductDetails();
    }


    @Then("Increase the product count")
    public void increase_the_product_count() throws InterruptedException {
        cartpage.clickIncrementItemCountButtonCartPopUp();
        Thread.sleep(3000);
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


}
