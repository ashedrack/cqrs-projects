package com.mentormate.patients.service.command.dto;


import lombok.Data;


/**
 * @author Shedrack Chiedozie Aji
 **/
@Data
public class CreatePatientRequest {

    private String name;
    private String age;
    private String address;
    private String phoneNumber;
}
