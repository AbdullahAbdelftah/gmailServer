package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;

@Service
public class Control {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String JSON_FILE_NAME = "usersData.json";
    private static final String JSON_FILE_PATH = "/usersData.json";

    public ArrayList<UserData> usersData;

    public void cleanTrash(ArrayList<mail> x) {
        Calendar calendar = Calendar.getInstance();
        int currDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currMonth = calendar.get(Calendar.MONTH) + 1;

        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getDelDateDay() - currDay >= 30 && x.get(i).getDelDateMonth() == currMonth) {
                x.remove(i);
            } else if (x.get(i).getDelDateMonth() != currMonth && x.get(i).getDelDateDay() - currDay == 0) {
                x.remove(i);
            }
        }
    }

    public int getMsgIndByID(ArrayList<mail> x, int id) {
        for (int i = 0; i < x.size(); i++) {
            if (id == x.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<UserData> getUsersData() {
        try {
            System.out.println("read");
            // Use the class loader to get the resource URL
            URL resource = getClass().getClassLoader().getResource(JSON_FILE_NAME);
            if (resource != null) {
                File file = Paths.get(resource.toURI()).toFile();
                return objectMapper.readValue(file, new TypeReference<ArrayList<UserData>>() {});
            } else {
                System.err.println("File not found in the classpath");
                return null;
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeUsersData(ArrayList<UserData> usersData) {
        System.out.println("write started");
        try {
            System.out.println(usersData);
            // Use the class loader to get the resource URL
            URL resource = getClass().getClassLoader().getResource(JSON_FILE_NAME);
            if (resource != null) {
                File file = Paths.get(resource.toURI()).toFile();
                // Note: This will write the file back to the classpath
                objectMapper.writeValue(file, usersData);
            } else {
                System.err.println("File not found in the classpath");
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public UserData getUserByEmail(String email) {
        ArrayList<UserData> usersData = getUsersData();
        if (usersData != null) {
            for (UserData x : usersData) {
                if (x.getEmail().equals(email)) {
                    return x;
                }
            }
        }
        return null;
    }
}
