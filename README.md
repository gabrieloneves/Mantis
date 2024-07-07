# Projeto Mantis - Automação de Testes

Este projeto realiza automação de testes para a aplicação Mantis, utilizando Java, Selenium WebDriver, Cucumber e JUnit.

## Descrição

O projeto consiste em uma suíte de testes automatizados para verificar diversas funcionalidades do sistema Mantis, incluindo login, criação de tarefas, validação de campos obrigatórios, entre outros cenários.

## Funcionalidades Testadas

- **Login no Sistema:**
  - Verificação de login com sucesso.
  - Verificação de login com credenciais inválidas.
  - Verificação de logout com sucesso.

- **Criação de Tarefas:**
  - Criação de tarefa com todos os campos preenchidos corretamente.
  - Validação de criação de tarefa sem preenchimento do campo "Resumo".
  - Validação de criação de tarefa sem preenchimento do campo "Descrição".
  - Validação de criação de tarefa sem seleção de categoria.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- **`src/test/java`:** Contém os arquivos de teste escritos com Cucumber e JUnit.
- **`src/test/resources`:** Contém os arquivos de feature do Cucumber que descrevem os cenários de teste.

## Pré-requisitos

Certifique-se de ter instalado em sua máquina:

- Java 8 ou superior
- Maven
- ChromeDriver (configurado automaticamente pelo WebDriverManager)

## Como Executar

1. Clone este repositório:
https://github.com/gabrieloneves/Mantis.git

2. Navegue até o diretório do projeto:

3. Execute os testes utilizando Maven:


## Relatórios

Após a execução dos testes, relatórios em formato HTML são gerados na pasta `target/cucumber-reports.html`.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir novas issues ou pull requests para melhorar este projeto.

## Autor

Gabriel de Oliveira Neves - gabrieldeoliveiraneves@gmail.com
