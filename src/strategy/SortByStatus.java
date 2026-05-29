package strategy;

import model.Task;

import java.util.Collections;
import java.util.List;

public class SortByStatus implements SortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        Collections.sort(tasks, (a, b) -> Boolean.compare(a.isCompleted(), b.isCompleted()));
    }
}
