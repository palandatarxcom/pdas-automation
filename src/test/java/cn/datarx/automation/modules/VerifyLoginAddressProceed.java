package cn.datarx.automation.modules;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class VerifyLoginAddressProceed {

	public static void execute(WebDriver driver) throws Exception{
		assertTrue(driver.getCurrentUrl().equals("http://slave02/studio/#/login"));
	}
}
