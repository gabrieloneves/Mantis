package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import utils.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	public By usernameField = By.id("username");
	public By passwordField = By.id("password");
	public By loginButton = By.xpath("//input[@value='Entrar']");
	public By errorMessage = By.xpath("//div[@class='alert alert-danger']//p");


	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username + Keys.RETURN);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public String getErrorMessage() {
        return driver.findElement(errorMessage).getText().trim();
    }
	
	public boolean isLoginPageDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
	
}
