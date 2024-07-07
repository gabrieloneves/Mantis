package steps;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import pages.DashboardPage;
import pages.LoginPage;
import pages.TaskPage;
import utils.WebDriverUtility;

public class TaskSteps extends WebDriverUtility {
    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private TaskPage taskPage = new TaskPage();
    public Metodos metodos = new Metodos();

    @Given("que estou logado no sistema")
    public void queEstouLogadoNoSistema() throws Exception {
        WebDriverUtility.getDriver("http://mantis-prova.base2.com.br");
        loginPage.enterUsername("GABRIEL_NEVES");
        loginPage.enterPassword("gabrielneves");
        loginPage.clickLogin();
        assertTrue(dashboardPage.isDashboardDisplayed());
        metodos.tirarEvidencia("taskSteps", "queEstouLogadoNoSistema");
    }

    @When("eu navego para a página de criar tarefa")
    public void euNavegoParaAPaginaDeCriarTarefa() {
        dashboardPage.clickCreateTask();
        metodos.tirarEvidencia("taskSteps", "euNavegoParaAPaginaDeCriarTarefa");
    }

    @When("eu preencho os detalhes da tarefa")
    public void euPreenchoOsDetalhesDaTarefa() throws AWTException, InterruptedException {
        taskPage.selectCategory("[Todos os Projetos] categoria teste");
        taskPage.selectFrequency("sempre");
        taskPage.selectSeverity("pequeno");
        taskPage.selectPriority("normal");
        taskPage.selectProfile();
        taskPage.fillPlatform("Windows");
        taskPage.fillOS("Windows 10");
        taskPage.fillOSBuild("21H1");
        taskPage.enterSummary("Resumo...");
        taskPage.enterDescription("Descrição...");
        taskPage.enterStepsToReproduce("Passos para Reproduzir...");
        taskPage.enterAdditionalInfo("Informações Adicionais...");
        taskPage.enterTag("Bug");
        taskPage.selectTag("Atividade");
        taskPage.clickUploadElement();
        taskPage.uploadFile();
        taskPage.selectVisibility(); 
        taskPage.checkOption();
        metodos.tirarEvidencia("taskSteps", "euPreenchoOsDetalhesDaTarefa");
    }

    @When("eu clico no botão de enviar")
    public void euClicoNoBotaoDeEnviar() {
        taskPage.clickSubmit();
        metodos.tirarEvidencia("taskSteps", "euClicoNoBotaoDeEnviar");
    }

    @Then("eu devo ver a mensagem {string}")
    public void euDevoVerAMensagem(String mensagem) {
        assertTrue(taskPage.isMessageDisplayed(mensagem));
        metodos.tirarEvidencia("taskSteps", "euDevoVerAMensagem");
        WebDriverUtility.closeBrowser();
    }
    
    @When("eu preencho os detalhes da tarefa sem o campo \"Resumo\"")
    public void euPreenchoOsDetalhesDaTarefaSemOResumo() {
        taskPage.selectCategory("[Todos os Projetos] categoria teste");
        taskPage.selectFrequency("sempre");
        taskPage.selectSeverity("pequeno");
        taskPage.selectPriority("normal");
        taskPage.enterDescription("Descrição...");
        metodos.tirarEvidencia("taskSteps", "euPreenchoOsDetalhesDaTarefaSemOResumo");
    }

    @When("eu preencho os detalhes da tarefa sem o campo \"Descrição\"")
    public void euPreenchoOsDetalhesDaTarefaSemADescricao() {
        taskPage.selectCategory("[Todos os Projetos] categoria teste");
        taskPage.selectFrequency("sempre");
        taskPage.selectSeverity("pequeno");
        taskPage.selectPriority("normal");
        taskPage.enterSummary("Resumo...");
        metodos.tirarEvidencia("taskSteps", "euPreenchoOsDetalhesDaTarefaSemADescricao");
    }

    @When("eu preencho os detalhes da tarefa sem selecionar categoria")
    public void euPreenchoOsDetalhesDaTarefaSemSelecionarCategoria() {
        taskPage.selectFrequency("sempre");
        taskPage.selectSeverity("pequeno");
        taskPage.selectPriority("normal");
        taskPage.enterSummary("Resumo...");
        taskPage.enterDescription("Descrição...");
        metodos.tirarEvidencia("taskSteps", "euPreenchoOsDetalhesDaTarefaSemSelecionarCategoria");
    }

    @Then("eu devo ver a mensagem de erro {string}")
    public void euDevoVerAMensagemDeErro(String mensagemErro) {
        taskPage.isErrorMessageDisplayedInTooltip(mensagemErro);
        metodos.tirarEvidencia("taskSteps", "euDevoVerAMensagemDeErro");
        WebDriverUtility.closeBrowser();
    }
}
