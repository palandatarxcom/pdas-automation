package cn.datarx.automation.modules;

import cn.datarx.automation.domain.User;
import cn.datarx.automation.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yuan on 2017/7/7.
 */
public class LoginAction {

    public static void execute(WebDriver driver, User user) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(LoginPage.username));

        LoginPage.username.sendKeys(user.getUsername());
        LoginPage.password.sendKeys(user.getPassword());
        LoginPage.login.click();
    }
}
