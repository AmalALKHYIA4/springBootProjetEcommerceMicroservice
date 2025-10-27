package com.ecom.app.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "adresses")
public class Adresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String street ;
    private String city ;
    private String state ;
    private String country ;
    private String zipCode ;

}
