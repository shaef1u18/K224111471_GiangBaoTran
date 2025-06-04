package com.bear.models;

public class Orders {
    private int ID;
    private String Code;
    private String Name;
    private int EmployeeID;
    private int CustomerID;
    private String OrderDate;
    private String Description;
    private int Status;
    private String StatusDescription;

    public Orders(int ID, String code, String name, int employeeID, int customerID, String orderDate, String description, int status, String statusDescription) {
        this.ID = ID;
        Code = code;
        Name = name;
        EmployeeID = employeeID;
        CustomerID = customerID;
        OrderDate = orderDate;
        Description = description;
        Status = status;
        StatusDescription = statusDescription;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getStatusDescription() {
        return StatusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        StatusDescription = statusDescription;
    }

    public Orders() {
    }
}
