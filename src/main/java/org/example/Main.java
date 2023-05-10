package org.example;

import java.io.*;
/**
 * @Author Zhixiang Shang
 * @Date 10.05.2023 10:47
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // Create a new security manager to limit access and operations
        SecurityManager securityManager = new MySecurityManager();
        System.setSecurityManager(securityManager);

        // Try to read from a file other than demo.xml
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\sandBox\\sandBox\\src\\main\\java\\org\\example\\demo.xml"));
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // Try to write to a file other than demo.xml
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\sandBox\\sandBox\\src\\main\\java\\org\\example\\otherfile.txt"));
            writer.write("Hello, world!");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        // Try to execute a system command
        try {
            Runtime.getRuntime().exec("ls -l");
        } catch (IOException e) {
            System.out.println("Error executing command: " + e.getMessage());
        }
        // Try to load an external library
        try {
            System.loadLibrary("externalLib");
        } catch (UnsatisfiedLinkError e) {
            System.out.println("Error loading library: " + e.getMessage());
        }
        // Try to delete a file other than demo.xml
        File otherFile = new File("E:\\sandBox\\sandBox\\src\\main\\java\\org\\example\\otherfile.txt");
        if (otherFile.exists()) {
            otherFile.delete();
        }
        // Try to delete demo.xml
        File file = new File("E:\\sandBox\\sandBox\\src\\main\\java\\org\\example\\demo.xml");
        if (file.exists()) {
            file.delete();
        }
    }
}