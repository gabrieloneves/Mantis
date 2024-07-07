package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import pages.DashboardPage;
import pages.LoginPage;
import utils.WebDriverUtility;

public class LoginSteps {
	private LoginPage loginPage = new LoginPage();
	private DashboardPage dashboardPage = new DashboardPage();
	public Metodos metodos = new Metodos();

	@Given("que estou na página de login")
    public void queEstouNaPaginaDeLogin() throws Exception {
        WebDriverUtility.getDriver("http://mantis-prova.base2.com.br");
        metodos.tirarEvidencia("login", "queEstouNaPaginaDeLogin");
    }

    @When("eu insiro o usuário {string} e a senha {string}")
    public void euInsiroOUsuarioEASenha(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        metodos.tirarEvidencia("login", "euInsiroOUsuarioEASenha");
    }

    @When("eu clico no botão de login")
    public void euClicoNoBotaoDeLogin() {
        loginPage.clickLogin();
        metodos.tirarEvidencia("login", "euClicoNoBotaoDeLogin");
    }

    @Then("eu devo ver uma mensagem de erro {string}")
    public void euDevoVerUmaMensagemDeErro(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals(expectedErrorMessage, actualErrorMessage);
        metodos.tirarEvidencia("login", "euDevoVerUmaMensagemDeErro");
        WebDriverUtility.closeBrowser();
    }

    @When("eu clico no botão de logout")
    public void euClicoNoBotaoDeLogout() {
        dashboardPage.user();
        dashboardPage.clickLogout();
        metodos.tirarEvidencia("login", "euClicoNoBotaoDeLogout");
    }

    @Then("eu devo ver a página de login")
    public void euDevoVerAPaginaDeLogin() {
        assertTrue(loginPage.isLoginPageDisplayed());
        metodos.tirarEvidencia("login", "euDevoVerAPaginaDeLogin");
        WebDriverUtility.closeBrowser();
    }

    @Then("eu devo ver o dashboard com o botão de {string}")
    public void euDevoVerODashboardComOBotaoDe(String string) {
        assertTrue(dashboardPage.isDashboardDisplayed());
        metodos.tirarEvidencia("login", "euDevoVerODashboardComOBotaoDe");
        WebDriverUtility.closeBrowser();
    }
}