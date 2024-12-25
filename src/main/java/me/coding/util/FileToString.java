package me.coding.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileToString {
    public static String readFileAsString(){
        byte[] encodedBytes = new byte[0];
        try {
            encodedBytes = Files.readAllBytes(Paths.get("C:\\code\\data\\leetcode\\src\\main\\java\\me\\coding\\util\\data.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }
}
