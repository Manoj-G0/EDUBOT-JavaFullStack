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
class AVLTreeNode {
    Movie movie;
    AVLTreeNode left;
    AVLTreeNode right;
    int height;

    public AVLTreeNode(Movie movie) {
        this.movie = movie;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
class AVLTree {
    private AVLTreeNode root;

    public AVLTree() {
        this.root = null;
    }
    private int height(AVLTreeNode node) {
        if (node == null)
            return 0;
        return node.height;
    }
    private int getBalance(AVLTreeNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }
    private AVLTreeNode rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLTreeNode leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a movie into the AVL Tree
    public void insert(Movie movie) {
        root = insertRecursive(root, movie);
    }

    private AVLTreeNode insertRecursive(AVLTreeNode node, Movie movie) {
        if (node == null)
            return new AVLTreeNode(movie);

        if (movie.title.compareTo(node.movie.title) < 0)
            node.left = insertRecursive(node.left, movie);
        else if (movie.title.compareTo(node.movie.title) > 0)
            node.right = insertRecursive(node.right, movie);
        else 
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));


        int balance = getBalance(node);
        if (balance > 1 && movie.title.compareTo(node.left.movie.title) < 0)
            return rightRotate(node);

        if (balance < -1 && movie.title.compareTo(node.right.movie.title) > 0)
            return leftRotate(node);
        if (balance > 1 && movie.title.compareTo(node.left.movie.title) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && movie.title.compareTo(node.right.movie.title) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public void delete(String title) {
        root = deleteRecursive(root, title);
    }

    private AVLTreeNode deleteRecursive(AVLTreeNode node, String title) {
        if (node == null)
            return node;

        if (title.compareTo(node.movie.title) < 0)
            node.left = deleteRecursive(node.left, title);
        else if (title.compareTo(node.movie.title) > 0)
            node.right = deleteRecursive(node.right, title);
        else {
            if (node.left == null || node.right == null) {
                AVLTreeNode temp = node.left != null ? node.left : node.right;

                // No child case
                if (temp == null) {
                    temp = node;
                    node = null;
                } else // One child case
                    node = temp; // Copy the contents of the non-empty child

            } else {
                // Case 2: Node with two children
                AVLTreeNode temp = minValueNode(node.right); // Get the inorder successor
                node.movie = temp.movie; // Copy the inorder successor's data to this node
                node.right = deleteRecursive(node.right, temp.movie.title); // Delete the inorder successor
            }
        }

        // If the tree had only one node then return
        if (node == null)
            return node;

        // Update the height of the current node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this node to check whether it became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Find the node with minimum value
    private AVLTreeNode minValueNode(AVLTreeNode node) {
        AVLTreeNode current = node;

        // Find the leftmost leaf
        while (current.left != null)
            current = current.left;

        return current;
    }

    // Search for a movie by title
    public Movie search(String title) {
        return searchRecursive(root, title);
    }

    private Movie searchRecursive(AVLTreeNode node, String title) {
        // Base Cases: root is null or title is present at the root
        if (node == null || node.movie.title.equals(title))
            return node == null ? null : node.movie;

        // Title is greater than root's title
        if (title.compareTo(node.movie.title) > 0)
            return searchRecursive(node.right, title);

        // Title is smaller than root's title
        return searchRecursive(node.left, title);
    }

    // Inorder traversal to list movies alphabetically
    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(AVLTreeNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.println(node.movie);
            inorderRecursive(node.right);
        }
    }
}

// MovieDatabase class to manage collection of movies using AVL Tree
class MovieDatabase {
    private AVLTree avlTree;

    public MovieDatabase() {
        this.avlTree = new AVLTree();
    }

    public void addMovie(Movie movie) {
        avlTree.insert(movie);
    }

    public void deleteMovie(String title) {
        avlTree.delete(title);
    }

    public Movie searchMovie(String title) {
        return avlTree.search(title);
    }

    public void listAllMovies() {
        avlTree.inorder();
    }

    public static void main(String[] args) {
        MovieDatabase database = new MovieDatabase();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Welcome to Movie Database Management System with AVL Trees");
            System.out.println("1. Add a movie");
            System.out.println("2. Delete a movie by title");
            System.out.println("3. Search for a movie by title");
            System.out.println("4. List all movies in alphabetical order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

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
                    scanner.nextLine(); // Consume newline character
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
