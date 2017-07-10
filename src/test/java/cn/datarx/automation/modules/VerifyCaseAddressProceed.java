package cn.datarx.automation.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyCaseAddressProceed {

	public static void execute(WebDriver driver) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until((ExpectedCondition<Boolean>) webDriver -> {
			assert webDriver != null;
			return webDriver.getCurrentUrl().contains("cases/all");
		});
	}
}
