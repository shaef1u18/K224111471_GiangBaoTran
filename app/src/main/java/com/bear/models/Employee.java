package com.bear.models;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String username;
    private String password;
    private boolean saveinfor;
    private String phone;  // Add the phone attribute

    // Getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and setter for saveinfor
    public boolean isSaveinfor() {
        return saveinfor;
    }

    public void setSaveinfor(boolean saveinfor) {
        this.saveinfor = saveinfor;
    }

    // Getter and setter for phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Constructor with all attributes
    public Employee(int id, String name, String email, String username, String password, boolean saveinfor, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.saveinfor = saveinfor;
        this.phone = phone;  // Initialize phone
    }

    // Default constructor
    public Employee(){
    }
}
