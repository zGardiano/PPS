package factory;

import model.Task;

public class TaskFactory {

    public static Task createTask(String description, int priority) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao nao pode ser vazia.");
        }
        if (priority < 1 || priority > 3) {
            throw new IllegalArgumentException("Prioridade deve ser 1, 2 ou 3.");
        }
        return new Task(description.trim(), priority);
    }
}
