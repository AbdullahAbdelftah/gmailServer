package com.example.demo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Service
public class Control {
    private final ObjectMapper objectMapper = new ObjectMapper();
//7ngls'path:"D:\\vue\\Gmail\\backGmail\\usersData.json"
    //bahaa's path: "E:\\programming\\Project\\Gmail\\backGmail\\usersData.json"
    private static final String JSON_FILE_PATH = "D:\\vue\\Gmail\\backGmail\\usersData.json";
    public ArrayList<UserData> usersData;
    public void cleanTrash(ArrayList<mail>x){
        Calendar calendar = Calendar.getInstance();
        int currDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currMonth = calendar.get(Calendar.MONTH) + 1;
        for(int i=0;i<x.size();i++){
            if(x.get(i).getDelDateDay()-currDay>=30 && x.get(i).getDelDateMonth()==currMonth){
                x.remove(i);
            }
            else if(x.get(i).getDelDateMonth()!=currMonth && x.get(i).getDelDateDay()-currDay==0){
                x.remove(i);
            }
        }
    }
    public int getMsgIndByID(ArrayList<mail>x,int id){
        for(int i=0;i<x.size();i++){
            if(id==x.get(i).getId()){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<UserData> getUsersData() {
        try {
            return objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<ArrayList<UserData>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeUsersData(ArrayList<UserData> usersData) {
        try {
            objectMapper.writeValue(new File(JSON_FILE_PATH), usersData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserData getUserByEmail(String email) {
        ArrayList<UserData> usersData = getUsersData();
        for(UserData x:usersData){
            if(x.getEmail().equals(email)){
                return x;
            }
        }
        return null;
    }
}
