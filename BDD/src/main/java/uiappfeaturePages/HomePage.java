package uiappfeaturePages;

import drivermanager.Driverfactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePageUtility {
private WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
     this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='nav-cart']")
    private WebElement cartIcon;

    @FindBy(xpath = "//*[contains(@alt,'Great Indian Festival')]/parent::a")
    private WebElement greatIndianFestival;
    @FindBy(xpath = "//*[@class='a-spacing-mini']//span")
    private WebElement textOnPage;

    public String getTitleOfPage(){
        return driver.getTitle();
    }
    public boolean isCartIconIsDisplayed(){
         return   cartIcon.isDisplayed();
    }

    public void checkOutDealSeaction(){
        waitForVisibilityOfElement(greatIndianFestival);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",greatIndianFestival);
    }


    public String getPageInfo() {
        waitForVisibilityOfElement(textOnPage);
        String text = textOnPage.getText();

        return text;
    }
}
