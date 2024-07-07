package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverUtility;

public class DashboardPage extends WebDriverUtility {
	public By createTaskButton = By.xpath("//*[text()=' Criar Tarefa ']");
	public By logoutButton = By.xpath("//a[contains(@href, '/logout_page.php')]");
	public By userMenuToggle = By.cssSelector("a.dropdown-toggle");

    public boolean isDashboardDisplayed() {
        return true;
    }

    public void clickCreateTask() {
        try {
            WebElement aguarda = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.elementToBeClickable(createTaskButton));
            aguarda.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", createTaskButton);
        }
    }
    
    public void user() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement toggle = wait.until(ExpectedConditions.elementToBeClickable(userMenuToggle));
        toggle.click();
    }
    
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
    
    public void tirarEvidencia(String pasta, String nomeEvidencia) {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./evidencias/" + pasta + "/" + nomeEvidencia + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			System.out.println("Não foi possivel tirar evidencia");
			e.printStackTrace();
		}
	}
}
