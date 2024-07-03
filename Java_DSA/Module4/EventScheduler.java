import java.util.*;

class Event {
    String name;
    int startTime;
    int endTime;

    Event(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class EventScheduler {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        events.add(new Event("Event 1", 9, 10));
        events.add(new Event("Event 2", 11, 12));
        events.add(new Event("Event 3", 10, 11));
        events.add(new Event("Event 4", 10, 12));

        events.sort(Comparator.comparingInt(e -> e.startTime));
        List<Event> schedule = new ArrayList<>();
        schedule.add(events.get(0));
        for (int i = 1; i < events.size(); i++) {
            Event current = events.get(i);
            Event lastScheduled = schedule.get(schedule.size() - 1);
            if (current.startTime >= lastScheduled.endTime) {
                schedule.add(current);
            }
        }
        for (Event event : schedule) {
            System.out.println(event.name + " (" + event.startTime + " - " + event.endTime + ")");
        }
    }
}
