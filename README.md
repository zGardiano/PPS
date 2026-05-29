# PPS - Sistema de Gerenciamento de Tarefas

Aplicação Java desenvolvida para a disciplina de Padrões de Projeto de Software, utilizando conceitos de Programação Orientada a Objetos e padrões de projeto aplicados em um sistema de gerenciamento de tarefas (ToDo List).

---

# Funcionalidades

- Adicionar tarefas
- Definir prioridade
- Marcar tarefas como concluídas
- Listar tarefas
- Ordenar tarefas de diferentes formas
- Interface gráfica com Java Swing

---

# Padrões de Projeto Utilizados

## Singleton
Utilizado na classe `TaskManager`, garantindo uma única instância responsável pelo gerenciamento das tarefas.

## Factory Method
Utilizado na classe `TaskFactory`, centralizando a criação e validação dos objetos `Task`.

## Strategy
Utilizado para permitir diferentes formas de ordenação das tarefas:

- `SortByName`
- `SortByPriority`
- `SortByStatus`

---

# Estrutura do Projeto

```text
src/
│
├── app/
├── factory/
├── gui/
├── model/
├── singleton/
└── strategy/
```

---

# Tecnologias Utilizadas

- Java
- Java Swing
- Programação Orientada a Objetos
- GitHub

---

# Como Executar

Clone o repositório:

```bash
git clone https://github.com/zGardiano/PPS.git
```

Abra o projeto em uma IDE Java e execute:

```text
Main.java
```

---

# Objetivo do Trabalho

O objetivo do projeto é demonstrar a aplicação prática de padrões de projeto em uma aplicação Java funcional, utilizando boas práticas de organização e desenvolvimento orientado a objetos.

---

# Diagrama UML
<img width="660" height="567" alt="image" src="https://github.com/user-attachments/assets/3e0acad2-a678-4589-9ad4-e469fa28a5ef" />

--

# Integrantes

- Felipe Arosti - 839913
- João Gardiano - 839588
- Leone Carpine - 840588
