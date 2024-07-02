import java.util.ArrayDeque;
import java.util.Queue;

 class TaskScheduler {

    private Queue<String> highPriorityQueue;
    private Queue<String> mediumPriorityQueue;
    private Queue<String> lowPriorityQueue;

    public TaskScheduler() {
        highPriorityQueue = new ArrayDeque<>();
        mediumPriorityQueue = new ArrayDeque<>();
        lowPriorityQueue = new ArrayDeque<>();
    }
    public void addTask(String task, Priority priority) {
        switch (priority) {
            case HIGH:
                highPriorityQueue.offer(task);
                break;
            case MEDIUM:
                mediumPriorityQueue.offer(task);
                break;
            case LOW:
                lowPriorityQueue.offer(task);
                break;
            default:
                throw new IllegalArgumentException("Invalid priority");
        }
    }
    public String getNextTask() {
        if (!highPriorityQueue.isEmpty()) {
            return highPriorityQueue.poll();
        } else if (!mediumPriorityQueue.isEmpty()) {
            return mediumPriorityQueue.poll();
        } else if (!lowPriorityQueue.isEmpty()) {
            return lowPriorityQueue.poll();
        } else {
            return null; 
        }
    }
    public void scheduleTasks() {
        System.out.println("Task scheduling started...");
        while (true) {
            String nextTask = getNextTask();
            if (nextTask == null) {
                break; 
            }
            System.out.println("Executing task: " + nextTask);
        }
        System.out.println("Task scheduling completed.");
    }
    public enum Priority {
        HIGH, MEDIUM, LOW
    }
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTask("Task1", TaskScheduler.Priority.LOW);
        scheduler.addTask("Task2", TaskScheduler.Priority.HIGH);
        scheduler.addTask("Task3", TaskScheduler.Priority.MEDIUM);
        scheduler.addTask("Task4", TaskScheduler.Priority.HIGH);

        scheduler.scheduleTasks();
    }
}
