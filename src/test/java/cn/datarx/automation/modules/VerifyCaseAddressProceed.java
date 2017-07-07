package cn.datarx.automation.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class VerifyCaseAddressProceed {

	public static void execute(WebDriver driver) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until((ExpectedCondition<Boolean>) webDriver -> webDriver.getCurrentUrl().equals("http://slave02/studio/#/cases/all"));
	}
}
