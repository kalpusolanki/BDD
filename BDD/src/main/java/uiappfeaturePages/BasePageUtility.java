package uiappfeaturePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageUtility {

    WebDriverWait wait;
    public BasePageUtility(WebDriver driver){
        wait=new WebDriverWait(driver,Duration.ofSeconds(60));
    }

    public WebElement waitForVisibilityOfElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForElementToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void click(WebElement element) {
        waitForElementToBeClickable(element).click();

    }
    public void clearAndSendKeys(WebElement element, String textToBeTyped) {
        element = waitForVisibilityOfElement(element);

        element.clear();

        element.sendKeys(textToBeTyped);
    }

}
