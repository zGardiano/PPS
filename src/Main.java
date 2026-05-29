import factory.TaskFactory;
import model.Task;
import singleton.TaskManager;
import strategy.SortByName;
import strategy.SortByPriority;
import strategy.SortByStatus;
import strategy.SortStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TaskAppGUI().setVisible(true);
        });
    }

    private static void addTask(Scanner scanner, TaskManager manager) {
        System.out.print("Descricao da tarefa: ");
        String description = scanner.nextLine();
        if (description.trim().isEmpty()) {
            description = scanner.nextLine();
        }

        System.out.print("Prioridade (1=Baixa, 2=Media, 3=Alta): ");
        int priority = readInt(scanner);

        try {
            Task task = TaskFactory.createTask(description, priority);
            manager.addTask(task);
            System.out.println("Tarefa adicionada com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void completeTask(Scanner scanner, TaskManager manager) {
        listTasks(manager.getTasks());
        if (manager.getTasks().isEmpty()) {
            return;
        }

        System.out.print("Numero da tarefa para concluir: ");
        int index = readInt(scanner) - 1;
        manager.completeTask(index);
        System.out.println("Operacao concluida.");
    }

    private static void listTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print("Digite um numero valido: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
