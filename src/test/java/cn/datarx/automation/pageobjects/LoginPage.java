package cn.datarx.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Yuan on 2017/7/7.
 */
public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(how=How.XPATH, using="//*[@ng-model=\"vm.username\"]")
    public static WebElement username;

    @FindBy(how=How.XPATH, using="//*[@ng-model=\"vm.password\"]")
    public static WebElement password;

    @FindBy(how=How.XPATH, using="//*[@translate=\"login.form.button\"]")
    public static WebElement login;
}
