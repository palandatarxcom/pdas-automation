package cn.datarx.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Yuan on 2017/7/7.
 */
public class HomePage extends BaseClass {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "header-profile-div")
    public static WebElement profile;

    @FindBy(how=How.XPATH, using="//*[@ng-click=\"vm.logout()\"]")
    public static WebElement logout;

}
