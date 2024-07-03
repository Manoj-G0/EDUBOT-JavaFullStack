import java.util.*;

class Person {
    int id;
    String name;
    List<Person> friends;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        this.friends = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
    }
}

class City {
    int id;
    String name;
    Map<City, Integer> roads;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
        this.roads = new HashMap<>();
    }

    @Override
    public String toString() {
        return name;
    }
}

class GraphApp {
    Map<Integer, Person> people;
    Map<Integer, City> cities;

    public GraphApp() {
        this.people = new HashMap<>();
        this.cities = new HashMap<>();
    }

    public void addPerson(int id, String name) {
        people.put(id, new Person(id, name));
    }

    public void addFriendship(int person1Id, int person2Id) {
        Person person1 = people.get(person1Id);
        Person person2 = people.get(person2Id);
        if (person1 != null && person2 != null) {
            person1.friends.add(person2);
            person2.friends.add(person1);
        }
    }

    public boolean areConnected(int person1Id, int person2Id) {
        return false; // Placeholder
    }

    public List<Person> shortestPath(int person1Id, int person2Id) {
        return new ArrayList<>(); // Placeholder
    }

    public List<Person> getAllFriends(int personId) {
        Person person = people.get(personId);
        if (person != null) {
            return person.friends;
        }
        return new ArrayList<>();
    }

    public void addCity(int id, String name) {
        cities.put(id, new City(id, name));
    }

    public void addRoad(int city1Id, int city2Id, int distance) {
        City city1 = cities.get(city1Id);
        City city2 = cities.get(city2Id);
        if (city1 != null && city2 != null) {
            city1.roads.put(city2, distance);
            city2.roads.put(city1, distance);
        }
    }

    public List<City> shortestPathBetweenCities(int city1Id, int city2Id) {
        return new ArrayList<>(); // Placeholder
    }

    public boolean hasCycle() {
        return false; // Placeholder
    }

    public static void main(String[] args) {
        GraphApp app = new GraphApp();

        // Example usage for Social Network
        app.addPerson(1, "Alice");
        app.addPerson(2, "Bob");
        app.addFriendship(1, 2);

        List<Person> friendsOfAlice = app.getAllFriends(1);
        System.out.println("Friends of Alice: " + friendsOfAlice);

        // Example usage for City Navigation
        app.addCity(1, "New York");
        app.addCity(2, "Los Angeles");
        app.addRoad(1, 2, 2800);

        List<City> shortestPath = app.shortestPathBetweenCities(1, 2);
        System.out.println("Shortest path from New York to Los Angeles: " + shortestPath);
    }
}
