package cn.datarx.automation.modules;

import cn.datarx.automation.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yuan on 2017/7/7.
 */
public class LogoutAction {

    public static void execute(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Actions action = new Actions(driver);

        action.moveToElement(HomePage.profile).perform();

        wait.until(ExpectedConditions.visibilityOf(HomePage.logout));

        HomePage.logout.click();

    }
}
