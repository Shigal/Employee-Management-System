package com.shigal.ems.entity;/*
 *
 * @author Lawshiga
 *
 */

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
