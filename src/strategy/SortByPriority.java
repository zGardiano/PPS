package strategy;

import model.Task;

import java.util.Collections;
import java.util.List;

public class SortByPriority implements SortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        Collections.sort(tasks, (a, b) -> Integer.compare(b.getPriority(), a.getPriority()));
    }
}
