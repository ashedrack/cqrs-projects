package com.mentormate.patients.service.common.event;

/**
 * @author Shedrack Chiedozie Aji
 **/

public class PatientCreatesEvent extends BaseEvent<String> {

    private String name;
    private String age;
    private String address;
    private String phoneNumber;



    public PatientCreatesEvent(String id, String name, String age, String address, String phoneNumber ) {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
