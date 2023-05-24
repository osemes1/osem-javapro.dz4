package javapro.dz13;

import java.util.*;

class FileData {
    private String name;
    private long size;
    private String path;

    public FileData(String name, long size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }
}

class FileNavigator {
    private Map<String, List<FileData>> filesMap;

    public FileNavigator() {
        filesMap = new HashMap<>();
    }

    public void add(FileData file) {
        String path = file.getPath();
        if (!filesMap.containsKey(path)) {
            filesMap.put(path, new ArrayList<>());
        }
        filesMap.get(path).add(file);
    }

    public List<FileData> find(String path) {
        return filesMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> filteredFiles = new ArrayList<>();
        for (List<FileData> fileList : filesMap.values()) {
            for (FileData file : fileList) {
                if (file.getSize() <= maxSize) {
                    filteredFiles.add(file);
                }
            }
        }
        return filteredFiles;
    }

    public void remove(String path) {
        filesMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> fileList : filesMap.values()) {
            allFiles.addAll(fileList);
        }
        Collections.sort(allFiles, Comparator.comparingLong(FileData::getSize));
        return allFiles;
    }

    public void addFileConsistencyCheck(FileData file) {
        String path = file.getPath();
        if (filesMap.containsKey(path)) {
            List<FileData> fileList = filesMap.get(path);
            for (FileData existingFile : fileList) {
                if (existingFile.getPath().equals(path)) {
                    System.out.println("Error: Inconsistent file path. FileData path: " + path + ", Existing file path: " + existingFile.getPath());
                    return;
                }
            }
        }
        add(file);
    }
}

public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();

        FileData file1 = new FileData("files.txt", 100, "/path/to/file");
        FileData file2 = new FileData("firstApp.java", 200, "/path/to/file");

        navigator.add(file1);
        navigator.add(file2);

        // Приклад виклику методів:

        List<FileData> foundFiles = navigator.find("/path/to/file");
        System.out.println("Found files: " + foundFiles);

        List<FileData> filteredFiles = navigator.filterBySize(150);
        System.out.println("Filtered files: " + filteredFiles);

        navigator.remove("/path/to/file");

        List<FileData> sortedFiles = navigator.sortBySize();
        System.out.println("Sorted files: " + sortedFiles);

        FileData inconsistentFile = new FileData("test.txt", 50, "/another/path/");
        navigator.addFileConsistencyCheck(inconsistentFile);
    }
}
