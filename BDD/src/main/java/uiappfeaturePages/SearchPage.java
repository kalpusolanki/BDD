package uiappfeaturePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePageUtility {
    WebDriver driver;



    public SearchPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='twotabsearchtextbox']")
    WebElement searchTextField;

    @FindBy(xpath = "//*[@id='nav-search-submit-button']")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(),'iPhone Air 1')]")
    WebElement iphoneAirPhone;
    public void searchPhone(String phoneToBeSearched) {
        clearAndSendKeys(searchTextField, phoneToBeSearched);

        click(searchButton);
    }

    public boolean validateResult() {
        WebElement phone = waitForVisibilityOfElement(iphoneAirPhone);

        boolean isDisplay = phone.isDisplayed();

        return isDisplay;
    }
}
