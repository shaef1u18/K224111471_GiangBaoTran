package com.bear.models;

import java.util.ArrayList;

public class ListEmployee {
    private ArrayList<Employee> employees;

    public ListEmployee() {
        employees=new ArrayList<>(){};
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public void gen_dataset()
    {
        Employee e1=new Employee();
        e1.setId(1);
        e1.setName("bear");
        e1.setEmail("boi@gmail.com");
        e1.setPhone("0987744082");
        e1.setUsername("shaef1u");
        e1.setPassword("123");
        employees.add(e1);

        Employee e2=new Employee();
        e1.setId(2);
        e1.setName("gd");
        e1.setEmail("gd@gmail.com");
        e1.setPhone("0938283119");
        e1.setUsername("xxxgdrgn");
        e1.setPassword("188");
        employees.add(e2);

        Employee e3=new Employee();
        e1.setId(3);
        e1.setName("kendricklamar");
        e1.setEmail("kendrick@gmail.com");
        e1.setPhone("0224235646");
        e1.setUsername("kendrick");
        e1.setPassword("1019");
        employees.add(e3);
    }
}
