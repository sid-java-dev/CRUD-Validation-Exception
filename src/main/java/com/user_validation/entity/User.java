package com.user_validation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

@Data
@Entity
@Table(name="user_db")
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String mobile;
    private int age;
    private String nationality;
}
