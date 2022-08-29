package com.example.serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws IOException {
        Employee employee = new Employee(1, "Maleeha", "Plot 689", 1245  );
        //serialize(employee);
        deserialize(employee);

    }

    public static void serialize(Employee e) {

        try{
            FileOutputStream file = new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream outputStream = new ObjectOutputStream(file);
            outputStream.writeObject(e);

            outputStream.close();
            file.close();

            System.out.println("Serialized data is saved in /tmp/employee.ser");
        } catch (Exception exception){
            System.out.println(exception);
        }

    }

    public static void deserialize(Employee e) {

        try{
            FileInputStream file = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream inputStream = new ObjectInputStream(file);
            Employee employee = (Employee)inputStream.readObject();

            inputStream.close();
            file.close();

            System.out.println(employee.name);
        } catch (Exception exception){
            System.out.println(exception);
        }

    }
}




class Employee implements Serializable {
    public int id;
    public String name;
    public String address;
    public transient int SSN;

    Employee(int id, String name, String address, int SSN){
        this.id = id;
        this.name = name;
        this.address = address;
        this.SSN = SSN;
    }
}