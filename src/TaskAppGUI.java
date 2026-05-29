import factory.TaskFactory;
import model.Task;
import singleton.TaskManager;
import strategy.SortByName;
import strategy.SortByPriority;
import strategy.SortByStatus;

import javax.swing.*;
import java.awt.*;

public class TaskAppGUI extends JFrame {
    private final TaskManager manager;
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;
    private JComboBox<String> sortCombo;

    public TaskAppGUI() {
        super("ToDo - Padrões de Projeto");
        manager = TaskManager.getInstance();
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));

        // Top: add task
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEADING, 8, 8));
        JTextField descField = new JTextField(24);
        String[] priorities = {"1 - Baixa", "2 - Media", "3 - Alta"};
        JComboBox<String> priorityCombo = new JComboBox<>(priorities);
        JButton addBtn = new JButton("Adicionar");

        top.add(new JLabel("Descrição:"));
        top.add(descField);
        top.add(new JLabel("Prioridade:"));
        top.add(priorityCombo);
        top.add(addBtn);

        // Center: task list
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(taskList);

        // Bottom: controls
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.TRAILING, 8, 8));
        JButton completeBtn = new JButton("Marcar Concluída");
        JButton deleteBtn = new JButton("Excluir Tarefa");
        sortCombo = new JComboBox<>(new String[]{"Original", "Prioridade", "Nome", "Status"});
        JButton sortBtn = new JButton("Aplicar Ordenação");
        JButton refreshBtn = new JButton("Atualizar");

        bottom.add(completeBtn);
        bottom.add(deleteBtn);
        bottom.add(new JLabel("Ordenar por:"));
        bottom.add(sortCombo);
        bottom.add(sortBtn);
        bottom.add(refreshBtn);

        panel.add(top, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);
        setContentPane(panel);

        // Actions
        addBtn.addActionListener(e -> {
            String desc = descField.getText().trim();
            if (desc.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite uma descrição válida.");
                return;
            }
            int priority = priorityCombo.getSelectedIndex() + 1;
            try {
                manager.addTask(TaskFactory.createTask(desc, priority));
                descField.setText("");
                refreshList();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        completeBtn.addActionListener(e -> {
            Task selected = taskList.getSelectedValue();
            if (selected == null) {
                JOptionPane.showMessageDialog(this, "Selecione uma tarefa.");
                return;
            }
            java.util.List<Task> original = manager.getTasks();
            int idx = original.indexOf(selected);
            if (idx >= 0) {
                manager.completeTask(idx);
                refreshList();
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível localizar a tarefa.");
            }
        });

        deleteBtn.addActionListener(e -> {
            Task selected = taskList.getSelectedValue();
            if (selected == null) {
                JOptionPane.showMessageDialog(this, "Selecione uma tarefa.");
                return;
            }
            java.util.List<Task> original = manager.getTasks();
            int idx = original.indexOf(selected);
            if (idx >= 0) {
                int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja excluir a tarefa selecionada?",
                        "Confirmar exclusão",
                        JOptionPane.YES_NO_OPTION
                );
                if (choice == JOptionPane.YES_OPTION) {
                    manager.deleteTask(idx);
                    refreshList();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível localizar a tarefa.");
            }
        });

        sortBtn.addActionListener(e -> refreshList());
        refreshBtn.addActionListener(e -> refreshList());

        // Double-click to toggle complete (optional): mark as complete
        taskList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Task selected = taskList.getSelectedValue();
                    if (selected != null) {
                        java.util.List<Task> original = manager.getTasks();
                        int idx = original.indexOf(selected);
                        if (idx >= 0) {
                            manager.completeTask(idx);
                            refreshList();
                        }
                    }
                }
            }
        });

        refreshList();
    }

    private void refreshList() {
        listModel.clear();
        String sel = (String) sortCombo.getSelectedItem();
        java.util.List<Task> tasks;
        if ("Prioridade".equals(sel)) {
            tasks = manager.getSortedTasks(new SortByPriority());
        } else if ("Nome".equals(sel)) {
            tasks = manager.getSortedTasks(new SortByName());
        } else if ("Status".equals(sel)) {
            tasks = manager.getSortedTasks(new SortByStatus());
        } else {
            tasks = manager.getTasks();
        }
        for (Task t : tasks) {
            listModel.addElement(t);
        }
    }
}
