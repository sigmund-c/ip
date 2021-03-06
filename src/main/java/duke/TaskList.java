package duke;

import duke.tasks.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a list of {@link Task}.
 */
public class TaskList implements Iterable<Task> {
    private List<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList from a List of Tasks.
     */
    private TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Mark the Task at specified index as done.
     * @param index the index of the Task to be marked as done.
     * @return the Task marked as done.
     */
    public Task done(int index) {
        Task task = tasks.get(index);
        task.markDone();
        return task;
    }

    /**
     * Mark the Tasks at specified indexes as done.
     * @param indexes the indexes of the Tasks to be marked as done.
     * @return a new TaskList consisting the Tasks marked as done.
     */
    public TaskList done(List<Integer> indexes) {
        List<Task> markedDone = new ArrayList<>();
        for (int i: indexes) {
            Task task = tasks.get(i);
            task.markDone();
            markedDone.add(task);
        }
        return new TaskList(markedDone);
    }

    /**
     * Deletes the Task at the specified index from this TaskList.
     * @param index the index of the Task to be deleted.
     * @return the deleted Task.
     */
    public Task delete(int index) {
        return tasks.remove(index);
    }

    /**
     * Deletes the Tasks at the specified indexes from this TaskList.
     * @param indexes the indexes of the Tasks to be deleted.
     * @return a new TaskList consisting the deleted Tasks.
     */
    public TaskList delete(List<Integer> indexes) {
        List<Task> toDelete = new ArrayList<>();
        for (int i: indexes) {
            toDelete.add(tasks.get(i));
        }

        // Remove the tasks after adding them all to the list, so that the index positioning
        // doesn't get messed up for multiple deletions
        for (Task t: toDelete) {
            tasks.remove(t);
        }
        return new TaskList(toDelete);
    }

    /**
     * Adds a Task to this TaskList.
     * @param task the Task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }


    @Override
    public Iterator iterator() {
        return tasks.iterator();
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < tasks.size(); i++) {
            string += (i + 1) + ". " + tasks.get(i);

            if (i != tasks.size() - 1) {
                string += "\n";
            }
        }

        return string;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof TaskList)) {
            return false;
        }

        TaskList tl = (TaskList) other;

        return tl.toString().equals(toString()); // might be a bit slow but is a simple implementation
    }

    /**
     * Returns a new TaskList consisting of Tasks that has matching keywords in their taskNames.
     * @param keyword the word to be searched for in the tasks.
     * @return a new TaskList with Tasks with matching keywords.
     */
    public TaskList find(String keyword) {
        TaskList foundTasks = new TaskList();

        for (Task task: tasks) {
            if (task.getTaskName().contains(keyword)) {
                foundTasks.addTask(task);
            }
        }

        return foundTasks;
    }
}
