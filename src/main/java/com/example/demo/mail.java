package com.example.demo;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public class mail {
    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    private boolean isRead=false;
    private ArrayList<String> sentToMails;
    private String date;
    private String title;
    private String sender;
    private String message;
    private ArrayList<attachment>attachments;
    private int id;
    private int delDateDay;
    private int delDateMonth;
    private int priorityLvl;

    public int getPriorityLvl() {
        return priorityLvl;
    }

    public void setPriorityLvl(int priorityLvl) {
        this.priorityLvl = priorityLvl;
    }

    public int getDelDateDay() {
        return delDateDay;
    }

    public void setDelDateDay(int delDateDay) {
        this.delDateDay = delDateDay;
    }

    public int getDelDateMonth() {
        return delDateMonth;
    }

    public void setDelDateMonth(int delDateMonth) {
        this.delDateMonth = delDateMonth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "mail{" +
                "isRead=" + isRead +
                ", sentToMails=" + sentToMails +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                ", attachments=" + attachments +
                ", id=" + id +
                '}';
    }

    public ArrayList<attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<attachment> attachments) {
        this.attachments = attachments;
    }

    public ArrayList<String> getSentToMails() {
        return sentToMails;
    }

    public void setSentToMails(ArrayList<String> sentToMails) {
        this.sentToMails = sentToMails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}