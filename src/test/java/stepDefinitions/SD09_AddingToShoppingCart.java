package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCartPage;

public class SD09_AddingToShoppingCart {
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    LoginPage loginPage;

    @When("the logged user select an item to add it to shopping cart")
    public void AddingItemToShoppingCart(){
        loginPage=new LoginPage(Hooks.driver);
        loginPage.LoginStep();
        homePage=new HomePage(Hooks.driver);
        homePage.AddingToShoppingCart();

    }

    @Then("the item added successfully to shopping cart")
    public void CheckingTheShoppingCart(){
        homePage=new HomePage(Hooks.driver);
        homePage.ClickOnShoppingCartTab();
        shoppingCartPage=new ShoppingCartPage(Hooks.driver);
        Assert.assertEquals("AP_MBP_13",shoppingCartPage.GetItemName());

    }

}
