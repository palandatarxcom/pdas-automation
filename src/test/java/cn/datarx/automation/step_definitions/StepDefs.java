package cn.datarx.automation.step_definitions;

import org.openqa.selenium.WebDriver;

/**
 * Created by Yuan on 2017/6/18.
 */
public abstract class StepDefs {
    protected WebDriver driver;

    public StepDefs() {

        driver = new SharedDriver();
    }
}
