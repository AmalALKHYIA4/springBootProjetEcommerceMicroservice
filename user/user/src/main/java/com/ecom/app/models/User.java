package com.ecom.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor //générer un constructeur sans argument
@AllArgsConstructor //générer un constructeur avec tous les champs
@Entity //indique une table ds la base
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String firstName ;
    private String lastName;
    private String email ;
    private String phone ;
    private UserRole role = UserRole.CUSTOMER ;

    @OneToOne(cascade= CascadeType.ALL , orphanRemoval = true)
    @JoinColumn(name = "adresse_id" , referencedColumnName = "id")
    private Adresses adress ;

    @CreationTimestamp
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    private LocalDateTime updateAt ;
}

