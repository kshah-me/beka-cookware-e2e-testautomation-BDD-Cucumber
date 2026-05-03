package stepdefinitions;


import com.bekacookware.config.ConfigReader;
import com.bekacookware.pages.CommonActivity;
import com.bekacookware.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePage_StepsDef {


    HomePage homepage = new HomePage();
    CommonActivity commonactivity = new CommonActivity();

    @Then("Verify logo is present on home page")
    public void verify_logo_is_present_on_home_page() {
        homepage.verifyLogoIsPresentAndNotBroken();
    }

    @Given("Launch the application url")
    public void launch_the_application_url() {
        commonactivity.launchUrl(ConfigReader.propValueFromConfigFile("url"));
    }

    @When("User select the {string} Language")
    public void user_select_the_language(String lang) {
        homepage.clickOnLanguageDropDown();
        homepage.selectLanguage(lang);

    }


    @Then("Verify page title as {string}")
    public void verify_page_title_as(String title) {
        homepage.verifyPageTitle(title);
    }


    @Then("Verify application is in {string} Language")
    public void verify_application_is_in_language(String lang) {
            homepage.verifyApplicationLanguage(lang);
    }

    @When("Select application language based on configuration")
    public void select_application_language_based_on_configuration() {
        homepage.clickOnLanguageDropDown();
        homepage.selectLanguage(ConfigReader.propValueFromConfigFile("Language"));
        commonactivity.clickCloseButtonOnAddPopUp();
    }



    @Then("Verify all Main menu and sub menus are working")
    public void verify_all_main_menu_and_sub_menus_are_working() throws InterruptedException {
        homepage.verifyNavigationOnHomePage();
    }

    @Then("Verify all footer items are working")
    public void verify_all_footer_items_are_working() {
        homepage.verifyFooterOnHomePageDisplayed();
    }

}
