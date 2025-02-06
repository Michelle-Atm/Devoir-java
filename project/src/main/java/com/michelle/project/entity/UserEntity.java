package com.michelle.project.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.michelle.project.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "\\+237[0-9]+", message = "Le numéro doit commencé par +237 et ne contenir que des chiffres")
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<Article> article = new HashSet<>();

}
