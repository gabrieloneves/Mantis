package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WebDriverUtility;

public class TaskPage extends WebDriverUtility {

	private By categoryDropdown = By.id("category_id");
	private By frequencyDropdown = By.id("reproducibility");
	private By severityDropdown = By.id("severity");
	private By priorityDropdown = By.id("priority");
	private By summaryField = By.id("summary");
	private By descriptionField = By.id("description");
	private By submitButton = By.cssSelector("input[value='Criar Nova Tarefa']");
	private By successMessage = By.xpath("//*[contains(text(), 'Operação realizada com sucesso.')]");
	private By errorMessage = By.xpath("//*[contains(text(), 'Campos obrigatórios não preenchidos.')]");
	private By attachFileInput = By.xpath("//div[contains(@class, 'dropzone center dz-clickable')]");
	private By continueReportingCheckbox = By.name("report_stay");
	private By platformField = By.id("platform");
	private By osField = By.id("os");
	private By osBuildField = By.id("os_build");
	private By resumoFieldLocator = By.name("summary");

	public void selectCategory(String categoria) {
		WebElement categoryDropdown = driver.findElement(this.categoryDropdown);
		Select categorySelect = new Select(categoryDropdown);
		categorySelect.selectByVisibleText(categoria);
	}

	public void selectFrequency(String frequency) {
		WebElement reproducibilityDropdown = driver.findElement(this.frequencyDropdown);
		Select reproducibilitySelect = new Select(reproducibilityDropdown);
		reproducibilitySelect.selectByVisibleText(frequency);
	}

	public void selectSeverity(String severity) {
		WebElement severityDropdown = driver.findElement(this.severityDropdown);
		Select severitySelect = new Select(severityDropdown);
		severitySelect.selectByVisibleText(severity);
	}

	public void selectPriority(String priority) {
		WebElement priorityDropdown = driver.findElement(this.priorityDropdown);
		Select prioritySelect = new Select(priorityDropdown);
		prioritySelect.selectByVisibleText(priority);
	}

	public void selectProfile() {
		WebElement profileElement = driver.findElement(By.className("fa-plus-square-o"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", profileElement);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", profileElement);
	}

	public void fillPlatform(String platform) {
		WebElement platformInput = driver.findElement(platformField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + platform + "';", platformInput);
	}

	public void fillOS(String os) {
		WebElement osInput = driver.findElement(osField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + os + "';", osInput);
	}

	public void fillOSBuild(String osBuild) {
		WebElement osBuildInput = driver.findElement(osBuildField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + osBuild + "';", osBuildInput);
	}

	public void selectVisibility() {
		WebElement visibilityRadio = driver.findElement(By.xpath("//input[@tabindex=\"14\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", visibilityRadio);
	}

	public void enterSummary(String summary) {
		WebElement summaryInput = driver.findElement(summaryField);
		summaryInput.sendKeys(summary);
	}

	public void enterDescription(String description) {
		WebElement descriptionTextarea = driver.findElement(descriptionField);
		descriptionTextarea.sendKeys(description);
	}

	public void enterStepsToReproduce(String steps) {
		WebElement stepsField = driver.findElement(By.id("steps_to_reproduce"));
		stepsField.sendKeys(steps);
	}

	public void enterAdditionalInfo(String additionalInfo) {
		WebElement additionalInfoField = driver.findElement(By.id("additional_info"));
		additionalInfoField.sendKeys(additionalInfo);
	}

	public void enterTag(String tag) {
		WebElement tagField = driver.findElement(By.id("tag_string"));
		tagField.sendKeys(tag);
	}

	public void selectTag(String tag) {
		WebElement tagDropdown = driver.findElement(By.id("tag_select"));
		Select selectTag = new Select(tagDropdown);
		selectTag.selectByVisibleText(tag);
	}

	public void clickUploadElement() {
		driver.findElement(attachFileInput).click();
	}

	public void uploadFile() throws AWTException {
		Robot robot = new Robot();
		robot.delay(1000);
		StringSelection ss = new StringSelection("C:\\Users\\Gabriel\\Pictures\\bug.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);

	}

	public void clickSubmit() {
		try {
            WebElement aguarda = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.elementToBeClickable(submitButton));
            aguarda.click();
        } catch (Exception e) {
        	JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(submitButton));
        }
	}

	public boolean isMessageDisplayed(String message) {
		if (message.equals("Operação realizada com sucesso.")) {
			return driver.findElement(successMessage).isDisplayed();
		} else if (message.equals("Campos obrigatórios não preenchidos.")) {
			return driver.findElement(errorMessage).isDisplayed();
		}
		return false;
	}

	public void checkOption() {
		WebElement checkbox = driver.findElement(continueReportingCheckbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
	}

	public boolean isErrorMessageDisplayedInTooltip(String mensagemErro) {
        try {
            WebElement resumoField = driver.findElement(resumoFieldLocator);
            resumoField.submit();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.attributeToBe(resumoField, "validationMessage", mensagemErro));
            String validationMessage = resumoField.getAttribute("validationMessage");
            return validationMessage.contains(mensagemErro);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
