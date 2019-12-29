package com.deba.jpahibernatemysql.springjpahibernatemysql.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @Column(name = "ID", unique = true)
    private long id;

    @Column(name = "USER_NM")
    private String name;

    @Column(name = "USER_SAL")
    private double salary;

}
