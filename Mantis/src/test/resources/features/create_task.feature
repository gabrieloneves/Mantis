#Author: gabrieldeoliveiraneves@gmail.com

@CreateTask @Regression
Feature: Criação de Tarefas no sistema Mantis
	
	@TarefaComSucesso
  Scenario: Criar uma nova tarefa com sucesso
    Given que estou logado no sistema
    When eu navego para a página de criar tarefa
    And eu preencho os detalhes da tarefa
    And eu clico no botão de enviar
    Then eu devo ver a mensagem "Operação realizada com sucesso."
	
	@TarefaSemResumo
  Scenario: Criar uma tarefa sem campos resumo
    Given que estou logado no sistema
    When eu navego para a página de criar tarefa
    And eu preencho os detalhes da tarefa sem o campo "Resumo"
    And eu clico no botão de enviar
    Then eu devo ver a mensagem de erro "Preencha este campo."
	
	@TarefaSemDescrição
  Scenario: Criar uma tarefa sem campos descrição
    Given que estou logado no sistema
    When eu navego para a página de criar tarefa
    And eu preencho os detalhes da tarefa sem o campo "Descrição"
    And eu clico no botão de enviar
    Then eu devo ver a mensagem de erro "Preencha este campo."
  
  @TarefaSemCategoria  
  Scenario: Criar uma tarefa sem selecionar categoria
    Given que estou logado no sistema
    When eu navego para a página de criar tarefa
    And eu preencho os detalhes da tarefa sem selecionar categoria
    And eu clico no botão de enviar
    Then eu devo ver a mensagem de erro "Um campo necessário 'category' estava vazio."
    
  