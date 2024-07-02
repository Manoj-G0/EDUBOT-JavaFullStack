import java.io.File;

public class FileSearch {
    private static void searchFiles(String directory, String extension) {
        File dir = new File(directory);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory: " + directory);
            return;
        }
        searchFilesRecursive(dir, extension);
    }

    private static void searchFilesRecursive(File dir, String extension) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFilesRecursive(file, extension);
                } else {
                    if (file.getName().endsWith(extension)) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String directoryPath = "E:/EduBot/Java_DSA/Module1";
        String fileExtension = ".java"; 

        searchFiles(directoryPath, fileExtension);
    }
}
