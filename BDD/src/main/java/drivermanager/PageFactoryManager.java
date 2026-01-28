package drivermanager;

import org.openqa.selenium.WebDriver;
import uiappfeaturePages.HomePage;
import uiappfeaturePages.SearchPage;

public class PageFactoryManager {
    HomePage homepage;
    SearchPage searchPage;
    public HomePage getHomePageObject(WebDriver driver){
        if(homepage==null){
            homepage=new HomePage(driver);
            return homepage;
        }
        else return homepage;
    }

    public SearchPage getSearchPageObject(WebDriver driver) {
    if(searchPage==null){
        searchPage=new SearchPage(driver);
        return searchPage;
    }
    else return searchPage;
    }
}
