#Author: gabrieldeoliveiraneves@gmail.com

@Login @Regression
Feature: Login no sistema Mantis

@LoginComSucesso 
  Scenario: Login com sucesso
    Given que estou na página de login
    When eu insiro o usuário "GABRIEL_NEVES" e a senha "gabrielneves"
    And eu clico no botão de login
    Then eu devo ver o dashboard com o botão de "Criar Tarefa"

@LoginSemSucesso
  Scenario: Login com credenciais inválidas
    Given que estou na página de login
    When eu insiro o usuário "usuario_invalido" e a senha "senha_invalida"
    And eu clico no botão de login
    Then eu devo ver uma mensagem de erro "Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos."

@LoginComSucesso
  Scenario: Logout com sucesso
    Given que estou logado no sistema
    When eu clico no botão de logout
    Then eu devo ver a página de login