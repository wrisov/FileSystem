package org.example;

public class Main {
    public static void main(String[] args) {
        // Initialize the root directory with no parent (p = null)
        Directory directory = new Directory("root", null);

        // Create files and directories; they will automatically be added to the parent directory
        File file1 = new File("f1", directory, 2);
        File file2 = new File("f2", directory, 2);
        Directory subDirectory = new Directory("subDir", directory);
        File subFile = new File("subFile", subDirectory, 3);

        // Set file contents
        file1.setContents("I am a hero");
        file2.setContents("I am strange");
        subFile.setContents("I am in a subdirectory");

        // Print file details
        System.out.println("File 1 - Path: " + file1.getFullPath() + ", Last Accessed: " + file1.getLastAccessedTime() + ", Size: " + file1.size());
        System.out.println("File 1 Content: " + file1.getContents());

        System.out.println("File 2 - Path: " + file2.getFullPath() + ", Last Accessed: " + file2.getLastAccessedTime() + ", Size: " + file2.size());
        System.out.println("File 2 Content: " + file2.getContents());

        // Print the number of files in the directory
        System.out.println("Directory Number of Files: " + directory.numberOfFiles());

        // Search for files and directories by path
        Entry foundEntry = directory.searchByPath("f1");
        if (foundEntry != null) {
            System.out.println("Found Entry - Path: " + foundEntry.getFullPath() + ", Size: " + foundEntry.size());
        } else {
            System.out.println("Entry not found");
        }

        Entry foundSubFile = directory.searchByPath("subDir/subFile");
        if (foundSubFile != null) {
            System.out.println("Found SubFile - Path: " + foundSubFile.getFullPath() + ", Size: " + foundSubFile.size());
            System.out.println("SubFile Content: " + ((File) foundSubFile).getContents());
        } else {
            System.out.println("SubFile not found");
        }
    }
}
