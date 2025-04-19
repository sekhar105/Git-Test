package com.test.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "REGISTERD_USERS")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String firstName;
    private  String lastName;


}
