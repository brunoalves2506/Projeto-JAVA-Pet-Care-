# Sistema de Clínica Veterinária (Java)

## Descrição

Este projeto é um sistema de gerenciamento para uma clínica veterinária desenvolvido em Java. Ele permite o cadastro e controle de tutores, animais, veterinários, medicamentos e consultas, funcionando via terminal (console).

O objetivo do projeto é simular um sistema real, aplicando conceitos de programação orientada a objetos, estrutura de dados e validação de entrada de dados.

---

## Funcionalidades

* Cadastro de tutores
* Cadastro de animais vinculados a um tutor
* Cadastro e listagem de veterinários (pré-cadastrados)
* Controle de estoque de medicamentos
* Registro de consultas veterinárias
* Listagem de consultas realizadas
* Validação de dados (CPF, telefone, campos obrigatórios)
* Controle de status do tutor (ativo/inativo)

---

## Estrutura do Projeto

O sistema é composto pelas seguintes classes internas:

* `Tutor`: armazena informações do cliente responsável pelo animal
* `Animal`: representa o pet e sua relação com um tutor
* `Veterinario`: contém dados dos profissionais da clínica
* `Medicamento`: representa os itens disponíveis no estoque
* `Consulta`: centraliza as informações de atendimento veterinário

Os dados são armazenados em listas (`ArrayList`) em memória durante a execução do programa.

---

## Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos (POO)
* ArrayList (estrutura de dados)
* Scanner (entrada de dados via console)

---

## Como Executar

1. Certifique-se de ter o Java instalado na sua máquina
2. Compile o arquivo:

```bash
javac Main.java
```

3. Execute o programa:

```bash
java Main
```

---

## Fluxo do Sistema

Ao iniciar, o sistema carrega dados de teste (tutores, veterinários e medicamentos).

O usuário interage através de um menu com as seguintes opções:

* Cadastrar tutor
* Cadastrar animal
* Realizar consulta veterinária
* Listar consultas
* Ver estoque de medicamentos
* Listar tutores
* Listar animais
* Listar veterinários

---

## Validações Implementadas

* CPF com 11 dígitos numéricos
* Telefone com DDD
* Campos obrigatórios não podem estar vazios
* Idade e peso com valores positivos
* Impede cadastro de animal para tutor inativo

---

## Limitações

* Os dados não são persistidos (armazenamento apenas em memória)
* Não possui funcionalidades de edição ou exclusão (CRUD incompleto)
* Interface apenas em console
* Estrutura concentrada em uma única classe

---

## Possíveis Melhorias

* Implementação de banco de dados (PostgreSQL ou MySQL)
* Separação das classes em arquivos individuais
* Implementação completa de CRUD (Update e Delete)
* Uso de `LocalDate` e `LocalTime` para datas
* Criação de interface gráfica (JavaFX ou Swing)
* Aplicação de arquitetura em camadas (MVC)

---

## Objetivo do Projeto

Este projeto foi desenvolvido com fins educacionais para prática de:

* Lógica de programação
* Estruturação de sistemas
* Modelagem de dados
* Boas práticas iniciais em Java

---

## Autor

Bruno Alves Ribeiro de Souza
