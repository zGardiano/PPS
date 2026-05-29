# ToDo List em Java - Padrões de Projeto

Projeto simples e didático em Java puro para demonstrar três padrões de projeto em um sistema de gerenciamento de tarefas.

## Objetivo

O sistema foi feito para ser fácil de entender e apresentar em sala. Ele usa apenas console, sem banco de dados e sem frameworks.

## Padrões aplicados

### Singleton
A classe `TaskManager` controla todas as tarefas da aplicação e possui apenas uma instância.

### Factory Method
A classe `TaskFactory` cria objetos `Task` sem que a classe principal precise usar `new Task()` diretamente.

### Strategy
A interface `SortStrategy` permite trocar a forma de ordenação das tarefas em tempo de execução.

Estratégias implementadas:
- `SortByPriority` - ordena por prioridade
- `SortByName` - ordena por nome
- `SortByStatus` - ordena por status

## Estrutura

```text
src/
├── Main.java
├── model/
│   └── Task.java
├── factory/
│   └── TaskFactory.java
├── singleton/
│   └── TaskManager.java
└── strategy/
    ├── SortStrategy.java
    ├── SortByPriority.java
    ├── SortByName.java
    └── SortByStatus.java
```

## Funcionalidades

- Adicionar tarefas
- Listar tarefas
- Marcar tarefas como concluídas
- Excluir tarefas
- Definir prioridade da tarefa
- Ordenar tarefas por prioridade, nome ou status

## Como compilar

Na pasta do projeto, execute:

```bash
javac -d bin src/Main.java src/model/Task.java src/factory/TaskFactory.java src/singleton/TaskManager.java src/strategy/SortStrategy.java src/strategy/SortByPriority.java src/strategy/SortByName.java src/strategy/SortByStatus.java
```

## Como executar

Depois de compilar:

```bash
java -cp bin Main
```

## Observacoes para apresentacao

- Mostre primeiro o `Singleton` no `TaskManager`.
- Depois explique como a `TaskFactory` centraliza a criacao das tarefas.
- Por fim, demonstre que a interface `SortStrategy` permite trocar o algoritmo de ordenacao sem alterar a classe principal.

## Observacao

O projeto foi mantido propositalmente simples para facilitar a explicacao durante a apresentacao.
