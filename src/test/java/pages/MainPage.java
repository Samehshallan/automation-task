package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.Hooks;

import java.time.Duration;
import java.util.ArrayList;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public Select SelectedItem(){
        WebElement currency=driver.findElement(By.name("customerCurrency"));
        Select selectedItem=new Select(currency);
        return selectedItem;
    }

    @FindBy(css = "a[href=\"http://www.facebook.com/nopCommerce\"]")
    WebElement facebookLink;

    @FindBy(css = "a[href=\"https://twitter.com/nopCommerce\"]")
    WebElement twitterLink;

    @FindBy(css = "a[href=\"/news/rss/1\"]")
    WebElement newsLink;

    @FindBy(css = "a[href=\"http://www.youtube.com/user/nopCommerce\"]")
    WebElement youtubeLink;

    @FindBy(name = "customerCurrency")
    WebElement currencyList;

    public WebElement Slider(String num){
        return Hooks.driver.findElement(By.cssSelector("a[class=\"nivo-imageLink\"]:nth-child("+num+")"));
    }

























    //////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/div[1]/span")
    WebElement theComputerPrice;

    @FindBy(xpath = "/html/body/pre")
    WebElement theContext;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2")
    WebElement message;

    public boolean IsTwitterLinkWork(){
        boolean exist = false;
        for (String windowID:driver.getWindowHandles()) {
            String windowURL=driver.switchTo().window(windowID).getCurrentUrl();
            if (windowURL.equals("https://twitter.com/nopCommerce")){
                exist=true;
                driver.close();
                break;
            }
        }
        return exist;
    }



//    public boolean NewsLink(){
//        newsLink.click();
//        return theContext.getText().contains("<title>nopCommerce demo store: News</title>");
//
//    }

    public String GetNewsURL(){
        newsLink.click();
        ArrayList<String> tabs=new ArrayList<>(Hooks.driver.getWindowHandles());
      return Hooks.driver.switchTo(). window(tabs.get(0)).getCurrentUrl();
    }

    public boolean IsYoutubeLinkWork(){
        boolean exist = false;
        for (String windowID:driver.getWindowHandles()) {
            String windowURL=driver.switchTo().window(windowID).getCurrentUrl();
            if (windowURL.equals("https://www.youtube.com/user/nopCommerce")){
                exist=true;
                driver.close();
                break;
            }
        }
        return exist;
    }

    public boolean IsFBLinkWork(){
        boolean exist = false;
        for (String windowID:driver.getWindowHandles()) {
            String windowURL=driver.switchTo().window(windowID).getCurrentUrl();
            if (windowURL.equals("https://www.facebook.com/nopCommerce")){
                exist=true;
                driver.close();
                break;
            }
        }
        return exist;
    }

    /////////////////////////////////////////////////////////////////////////

    public void ConfirmingFacebookLink(){
        facebookLink.click();
      //  driver.close();
    }
    public void ConfirmingTwitterLink(){
        twitterLink.click();
       // driver.close();
    }
    public void ConfirmingNewsLink(){
        newsLink.click();
        driver.navigate().back();
    }
    public void ConfirmingYoutubeLink(){
        youtubeLink.click();
       // driver.close();
    }


    public void ChooseEuroCurrencySteps(){
        Select selectEuro=new Select(currencyList);
        selectEuro.selectByVisibleText("Euro");
    }

    public void ChooseDollarCurrencySteps(){
        Select selectDollar=new Select(currencyList);
        selectDollar.selectByVisibleText("US Dollar");
    }

    public void Verifying1stSliderWrapper(){

        Slider("1").click();
    }
    public void Verifying2ndSliderWrapper(){

        Slider("2").click();
    }


    public String GetThePriceContext(){
        return theComputerPrice.getText();
    }
}
