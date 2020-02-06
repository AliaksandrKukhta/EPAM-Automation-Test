package com.epam.automation.parsing;

import com.epam.automation.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<User> readBooksFromCSV(String fileName) {
        List<User> users = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                User user = createBook(attributes);
                users.add(user);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return users;
    }

    private static User createBook(String[] metadata) {
        int id = Integer.parseInt(metadata[0]);
        String name = metadata[1];
        String login = metadata[2];
        String password = metadata[3];
        String e_mail = metadata[4];
        return new User(id, name, login,  password, e_mail);
    }
}

