package model;

public class Task {
    private String description;
    private int priority;
    private boolean completed;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }

    public String getPriorityLabel() {
        switch (priority) {
            case 1:
                return "Baixa";
            case 2:
                return "Media";
            case 3:
                return "Alta";
            default:
                return "Desconhecida";
        }
    }

    public String getStatusLabel() {
        return completed ? "Concluida" : "Pendente";
    }

    @Override
    public String toString() {
        return "[" + getStatusLabel() + "] " + description + " | Prioridade: " + getPriorityLabel();
    }
}
