# ToDo List em Java - Padrões de Projeto

Projeto simples e didático em Java puro para demonstrar três padrões de projeto em um sistema de gerenciamento de tarefas.

# Integrantes

Felipe Arosti - 839913
João Gardiano - 839588
Leone Carpine - 840588

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

## Funcionalidades

- Adicionar tarefas
- Listar tarefas
- Marcar tarefas como concluídas
- Excluir tarefas
- Definir prioridade da tarefa
- Ordenar tarefas por prioridade, nome ou status
