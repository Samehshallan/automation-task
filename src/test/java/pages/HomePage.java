package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.Hooks;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[1]/a/img")
    WebElement appleMacBookProAddToCartTab;

    @FindBy(css = "span[class=\"cart-label\"]")
    WebElement shoppingCartTab;

    public void AddingToShoppingCart(){
        appleMacBookProAddToCartTab.click();
        ProductPage productPage=new ProductPage(driver);
        productPage.AddingToShoppingCart();
    }

    public void ClickOnShoppingCartTab(){
        shoppingCartTab.click();
    }
    }
