package org.example;

import java.util.ArrayList;

import java.util.ArrayList;

import java.util.ArrayList;

public class Directory extends Entry {
    private ArrayList<Entry> contents;

    public Directory(String n, Directory p) {
        super(n, p);
        contents = new ArrayList<>();
        if (p != null) {
            p.addEntry(this);
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (Entry e : contents) {
            size += e.size();
        }
        return size;
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry e : contents) {
            if (e instanceof Directory) {
                count++; // Directory counts as a file
                Directory d = (Directory) e;
                count += d.numberOfFiles();
            } else if (e instanceof File) {
                count++;
            }
        }
        return count;
    }

    public boolean deleteEntry(Entry entry) {
        return contents.remove(entry);
    }

    public void addEntry(Entry entry) {
        contents.add(entry);
    }

    protected ArrayList<Entry> getContents() {
        return contents;
    }

    // Method to search by path
    public Entry searchByPath(String path) {
        String[] parts = path.split("/", 2);
        String name = parts[0];
        for (Entry entry : contents) {
            if (entry.getName().equals(name)) {
                if (parts.length == 1) {
                    return entry; // Found the entry
                } else if (entry instanceof Directory) {
                    Directory dir = (Directory) entry;
                    return dir.searchByPath(parts[1]); // Recurse into subdirectory
                }
                break;
            }
        }
        return null; // Not found
    }
}
