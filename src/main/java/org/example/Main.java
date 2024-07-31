package org.example;

public class Main {
    public static void main(String[] args) {
        // Initialize the root directory with no parent (p = null)
        Directory p = null;
        Directory directory = new Directory("root", p);

        // Create files and add them to the directory
        File file1 = new File("f1", directory, 2);
        File file2 = new File("f2", directory, 2);

        // Set file contents
        file1.setContents("I am a hero");
        file2.setContents("I am strange");

        // Print file details
        System.out.println("File 1 - Last Accessed: " + file1.getLastAccessedTime() + ", Size: " + file1.size());
        System.out.println("File 1 Content: " + file1.getContents());

        System.out.println("File 2 - Last Accessed: " + file2.getLastAccessedTime() + ", Size: " + file2.size());
        System.out.println("File 2 Content: " + file2.getContents());

        // Add files to the directory
//        directory.addEntry(file1);
//        directory.addEntry(file2);

        // Print the number of files in the directory
        System.out.println("Directory Number of Files: " + directory.numberOfFiles());
    }
}
