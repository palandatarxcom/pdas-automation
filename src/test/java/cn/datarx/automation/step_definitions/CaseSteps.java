package cn.datarx.automation.step_definitions;

import cn.datarx.automation.pageobjects.CasePage;
import cn.datarx.automation.pageobjects.CasePage.CaseCreatedPage;
import cn.datarx.automation.pageobjects.CasePage.CaseDetailsPage;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.同时;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Yuan on 2017/7/7.
 */
public class CaseSteps extends StepDefs {

    @假如("^进入案例页面$")
    public void 进入案例页面() throws Throwable {
        driver.get("http://slave02/studio/#/cases/all");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) webDriver -> webDriver.getCurrentUrl().contains("cases/all"));
    }

    @当("^选择我负责的$")
    public void 选择我负责的() throws Throwable {
        PageFactory.initElements(driver, CasePage.class);
        CasePage.created.click();
    }

    @那么("^进入我负责的案例列表页面$")
    public void 进入我负责的案例列表页面() throws Throwable {
        PageFactory.initElements(driver, CaseCreatedPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(CaseCreatedPage.projects_header));
    }

    @假如("^有案例$")
    public void 有案例() throws Throwable {
        Assert.assertFalse(CaseCreatedPage.cases.isEmpty());
    }

    @当("^点击第一个案例$")
    public void 点击第一个案例() throws Throwable {
        WebElement first = CaseCreatedPage.cases.get(0);
        WebElement projectTitle = first.findElement(By.xpath("//*[@ng-click=\"openCaseView(caseItem.id)\"]"));
        projectTitle.click();
    }

    @那么("^进入案例详情页面$")
    public void 进入案例详情页面() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) webDriver -> webDriver.getCurrentUrl().contains("cases-detail"));
    }

    @同时("^还可以查看详情$")
    public void 还可以查看详情() throws Throwable {
        PageFactory.initElements(driver, CaseDetailsPage.class);
        CaseDetailsPage.document.click();
        CaseDetailsPage.flow.click();
        CaseDetailsPage.dataset.click();
        CaseDetailsPage.analysis.click();
        CaseDetailsPage.notebook.click();
    }
}
