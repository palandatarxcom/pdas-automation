package cn.datarx.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by Yuan on 2017/7/7.
 */
public class CasePage extends BaseClass {

    public CasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@ui-sref=\"cases.created\"]")
    public static WebElement created;


    public static class CaseCreatedPage extends BaseClass {

        public CaseCreatedPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(how = How.CLASS_NAME, using = "projects-header")
        public static WebElement projects_header;

        @FindBy(how = How.CLASS_NAME, using = "case-project-item")
        public static List<WebElement> cases;

    }

    public static class CaseDetailsPage extends BaseClass {

        public CaseDetailsPage(WebDriver driver) {
            super(driver);
        }

        @FindBy(how = How.XPATH, using = "//*[@ui-sref=\"requirement\"]")
        public static WebElement document;

        @FindBy(how = How.XPATH, using = "//*[@ui-sref=\"case-flow\"]")
        public static WebElement flow;

        @FindBy(how = How.XPATH, using = "//*[@ui-sref=\"case-dataset.list\"]")
        public static WebElement dataset;

        @FindBy(how = How.XPATH, using = "//*[@ui-sref=\"case-analysis.list\"]")
        public static WebElement analysis;

        @FindBy(how = How.XPATH, using = "//*[@ui-sref=\"dashboard\"]")
        public static WebElement notebook;


    }

}
