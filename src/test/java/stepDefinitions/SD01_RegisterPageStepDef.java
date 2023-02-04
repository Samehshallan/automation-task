package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.RegisterPage;


public class SD01_RegisterPageStepDef {
    public RegisterPage registerPage;

    @When("the user enter all valid data")
    public void ValidData(){
        registerPage=new RegisterPage(Hooks.driver);
        registerPage.RegisterStep();
    }

    @Then("the registration process should done successfully")
    public void SuccessProcess(){
        Assert.assertEquals("Your registration completed", Hooks.driver.findElement(registerPage.TheRegistrationMess()).getText());
    }
}
