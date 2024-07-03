import java.util.Scanner;
class Movie {
    String title;
    String director;
    int year;
    double rating;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
class TreeNode {
    Movie movie;
    TreeNode left;
    TreeNode right;

    public TreeNode(Movie movie) {
        this.movie = movie;
        this.left = null;
        this.right = null;
    }
}
class MovieBST {
    private TreeNode root;

    public MovieBST() {
        this.root = null;
    }

    public void insert(Movie movie) {
        root = insertRecursive(root, movie);
    }

    private TreeNode insertRecursive(TreeNode root, Movie movie) {
        if (root == null) {
            return new TreeNode(movie);
        }

        if (movie.title.compareTo(root.movie.title) < 0) {
            root.left = insertRecursive(root.left, movie);
        }
        else if (movie.title.compareTo(root.movie.title) > 0) {
            root.right = insertRecursive(root.right, movie);
        }

        return root;
    }

    public void delete(String title) {
        root = deleteRecursive(root, title);
    }

    private TreeNode deleteRecursive(TreeNode root, String title) {
        if (root == null) {
            return null;
        }

        if (title.compareTo(root.movie.title) < 0) {
            root.left = deleteRecursive(root.left, title);
        } else if (title.compareTo(root.movie.title) > 0) {
            root.right = deleteRecursive(root.right, title);
        } else { 
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.movie = minValueNode(root.right).movie;
            root.right = deleteRecursive(root.right, root.movie.title);
        }

        return root;
    }

    private TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Movie search(String title) {
        return searchRecursive(root, title);
    }

    private Movie searchRecursive(TreeNode root, String title) {
        if (root == null || root.movie.title.equals(title)) {
            return root == null ? null : root.movie;
        }
        if (title.compareTo(root.movie.title) < 0) {
            return searchRecursive(root.left, title);
        }
        return searchRecursive(root.right, title);
    }

    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.movie);
            inorderRecursive(root.right);
        }
    }
}
class MovieDatabase {
    private MovieBST bst;

    public MovieDatabase() {
        this.bst = new MovieBST();
    }

    public void addMovie(Movie movie) {
        bst.insert(movie);
    }

    public void deleteMovie(String title) {
        bst.delete(title);
    }

    public Movie searchMovie(String title) {
        return bst.search(title);
    }

    public void listAllMovies() {
        bst.inorder();
    }

    public static void main(String[] args) {
        MovieDatabase database = new MovieDatabase();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Welcome to Movie Database Management System");
            System.out.println("1. Add a movie");
            System.out.println("2. Delete a movie by title");
            System.out.println("3. Search for a movie by title");
            System.out.println("4. List all movies in alphabetical order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine(); 
                    Movie newMovie = new Movie(title, director, year, rating);
                    database.addMovie(newMovie);
                    System.out.println("Movie added successfully!");
                    break;
                case 2:
                    System.out.print("Enter movie title to delete: ");
                    String deleteTitle = scanner.nextLine();
                    database.deleteMovie(deleteTitle);
                    System.out.println("Movie deleted successfully!");
                    break;
                case 3:
                    System.out.print("Enter movie title to search: ");
                    String searchTitle = scanner.nextLine();
                    Movie foundMovie = database.searchMovie(searchTitle);
                    if (foundMovie != null) {
                        System.out.println("Movie found:");
                        System.out.println(foundMovie);
                    } else {
                        System.out.println("Movie not found!");
                    }
                    break;
                case 4:
                    System.out.println("Listing all movies:");
                    database.listAllMovies();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
