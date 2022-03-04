package com.example.university.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_manager")
public class Manager extends Person {

}
