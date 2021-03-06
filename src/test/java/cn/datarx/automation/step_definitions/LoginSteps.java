package cn.datarx.automation.step_definitions;

import cn.datarx.automation.dto.UserDTO;
import cn.datarx.automation.helpers.Env;
import cn.datarx.automation.modules.LoginAction;
import cn.datarx.automation.modules.LogoutAction;
import cn.datarx.automation.modules.VerifyCaseAddressProceed;
import cn.datarx.automation.modules.VerifyLoginAddressProceed;
import cn.datarx.automation.pageobjects.HomePage;
import cn.datarx.automation.pageobjects.LoginPage;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Yuan on 2017/7/7.
 */
public class LoginSteps extends StepDefs {

    @假如("^打开首页$")
    public void 打开首页() throws Throwable {
        driver.get(Env.getProperty("pdas.index"));
    }

    @那么("^进入登录页面$")
    public void 进入登录页面() throws Throwable {
        VerifyLoginAddressProceed.execute(driver);
    }

    @当("^我登录$")
    public void 我登录() throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin("yuanzhencai");
        userDTO.setPassword("yzc.1234");
        LoginAction.execute(driver, userDTO);
    }

    @那么("^进入首页$")
    public void 进入首页() throws Throwable {
        VerifyCaseAddressProceed.execute(driver);
    }

    @当("^我登出$")
    public void 我登出() throws Throwable {
        PageFactory.initElements(driver, HomePage.class);
        LogoutAction.execute(driver);
        VerifyLoginAddressProceed.execute(driver);
    }
}
