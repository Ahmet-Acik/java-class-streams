// FileHandler.java
package org.ahmet.classes.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    public String readFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    public void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Path.of(filePath), content);
    }

    public boolean deleteFile(String filePath) throws IOException {
        return Files.deleteIfExists(Path.of(filePath));
    }
}