package com.mentormate.patients.service.command.command;

/**
 * @author Shedrack Chiedozie Aji
 **/
public class CreatePatientCommand extends BaseCommand<String> {

    private String name;
    private String age;
    private String address;
    private String phoneNumber;

    public CreatePatientCommand(String id, String name, String age, String address, String phoneNumber ) {
        super(id);
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
