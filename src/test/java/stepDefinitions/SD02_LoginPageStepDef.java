package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;

public class SD02_LoginPageStepDef {
    LoginPage loginPage;

    @When("the user enter his valid email and password")
    public void ValidData(){
        loginPage=new LoginPage(Hooks.driver);
        loginPage.LoginStep();

    }

    @Then("the user could be able to login his page")
    public void SuccessLogin(){
        Assert.assertEquals("https://demo.nopcommerce.com/",Hooks.driver.getCurrentUrl());
    }

}
