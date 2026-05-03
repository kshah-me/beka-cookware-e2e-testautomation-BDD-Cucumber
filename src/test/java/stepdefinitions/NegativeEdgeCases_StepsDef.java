package stepdefinitions;


import com.bekacookware.pages.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class NegativeEdgeCases_StepsDef{

    HomePage homepage = new HomePage();
    CartPage cartpage = new CartPage();
    CheckoutPage checkoutpage = new CheckoutPage();

    @When("User enter invalid username {string}")
    public void user_enter_invalid_usrname(String username) {
        homepage.EnterUserEmailId(username);
        homepage.clickOnLoginButton();
    }

    @Then("Verify an error message for invalid username")
    public void verify_an_error_message_for_invalid_username() {
        homepage.verifyErrorMessageForInvalidUserName();
    }

    @When("Click on Proceed to Checkout button")
    public void click_on_proceed_to_checkout_button() {
        cartpage.clickCheckoutButtonOnCartPage();

    }

    @When("User enter invalid Voucher code {string}")
    public void user_enter_invalid_voucher_code(String code) {
        checkoutpage.enterVoucherCodeOnCheckoutPage("ABC");
    }

    @When("User click on Voucher code apply button")
    public void user_click_on_voucher_code_apply_button() {
        checkoutpage.clickVoucherCodeRedeemButtonOnCheckoutPage();
    }

    @Then("Verify an error message for invalid Voucher code")
    public void verify_an_error_message_for_invalid_voucher_code() {
        checkoutpage.verifyErrorMessageForInvalidVoucherCodeOnCheckoutPage();
    }

}