package com.example.Assignment;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Assignment1 {

    public static void main(String[] args) {
        EmployeeList list = new EmployeeList();
        
        list.readFromFile("/Users/maleehakhalid/Documents/Practice/Java/TestJava/src/employees.csv");

        list.sortByCity();

        Set<String> listOfCities = list.findUniqueCities();

        for (String city : listOfCities) {
            PrintingThread printingThread = new PrintingThread(list);

            printingThread.cityName = city;
            printingThread.employees = list.getByCity(city);

            printingThread.start();

        }


    }
}

class Employee{
    int id;
    String name;
    String gender;
    int age;
    String city;

    Employee(String line){
        String[] split = line.split(",");
        this.id = Integer.parseInt(split[0]);
        this.name = split[1];
        this.gender = split[2];
        this.age = Integer.parseInt(split[3]);
        this.city = split[4];
    }

}

class EmployeeList{
    List<Employee> employees = new ArrayList<>();
    public List<Employee> readFromFile(String fileName){
        try{
            String line;
            BufferedReader reader =  new BufferedReader(new FileReader(fileName));

            while( (line = reader.readLine()) != null){
                Employee e = new Employee(line);
                this.employees.add(e);
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return this.employees;

    }

    public void sortByCity(){
        this.employees.sort(Comparator.comparing(o -> o.city));
    }

    public void print(){
        System.out.println("........Printing data......");
        employees.forEach(e -> System.out.println(e.id + " "+ e.name +" "+ e.city +" "+ e.age +" "+ e.gender));
        System.out.println("........Finished printing data......");
    }

    public Set<String> findUniqueCities(){
        return this.employees.stream().map(employee -> employee.city).collect(Collectors.toSet());
    }

    public List<Employee> getByCity(String city){
        return this.employees.stream().filter(employee -> employee.city.equals(city)).collect(Collectors.toList());
    }

    public List<Employee> writeIntoFile(List<Employee> employees, String cityName){
        try{
            String line;
            BufferedWriter csvWriter =  new BufferedWriter(new FileWriter(cityName+"_data.csv"));

            csvWriter.append("Id");
            csvWriter.append(",");
            csvWriter.append("Name");
            csvWriter.append(",");
            csvWriter.append("Age");
            csvWriter.append(",");
            csvWriter.append("City");
            csvWriter.append(",");
            csvWriter.append("Gender");
            csvWriter.append("\n");


            employees.forEach(e -> {
                try {
                    csvWriter.append(e.id + " " + e.name + " " + e.city + " " + e.age + " " + e.gender);
                    csvWriter.append("\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            csvWriter.flush();
            csvWriter.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
        return this.employees;

    }


}

class PrintingThread extends Thread{
    EmployeeList resource;
    List<Employee> employees;
    String cityName;

    PrintingThread(EmployeeList resource) {
        this.resource = resource;
    }

    public void run() {
        resource.writeIntoFile(employees, cityName);
    }
}




