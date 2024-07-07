package metodos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.WebDriverUtility;

public class Metodos extends WebDriverUtility {
	
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
