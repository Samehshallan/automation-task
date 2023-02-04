package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.*;

public class SD10_CreatingSuccessfulOrder {
    LoginPage loginPage;
    HomePage homePage;
    CheckOutPage checkOutPage;
    ThankYouPage thankYouPage;
    ShoppingCartPage shoppingCartPage;

    @When("he completes his payment method")
    public void CompletionPaymentMethod(){
        loginPage=new LoginPage(Hooks.driver);
        loginPage.LoginStep();
        homePage=new HomePage(Hooks.driver);
        homePage.AddingToShoppingCart();
        homePage=new HomePage(Hooks.driver);
        homePage.ClickOnShoppingCartTab();
       shoppingCartPage=new ShoppingCartPage(Hooks.driver);
       shoppingCartPage.FinishingCheckProcess();
        checkOutPage=new CheckOutPage(Hooks.driver);
        checkOutPage.FillingBillingFields();

    }

    @Then("the payment method of order has done")
    public void DidProcessFinishSuccessfully(){
        thankYouPage=new ThankYouPage(Hooks.driver);
        Assert.assertEquals("Your order has been successfully processed!",thankYouPage.GetSecondMessage());

    }

}
