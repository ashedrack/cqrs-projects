package com.mentormate.patients.service.command.command;


/**
 * @author Shedrack Chiedozie Aji
 **/


public class UpdatePatientCommand extends BaseCommand<String> {

    private String name;
    private String age;
    private String address;
    private String phoneNumber;


    public UpdatePatientCommand(String id, String name, String age, String address, String phoneNumber ) {
        super(id);
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
}

