package com.psych.psychGame.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Auditable {
    // for email validations
    @Email
    // & email cannot be blank
    @NotBlank
    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    // password cannot be blank
    @NotBlank
    @Getter
    @Setter
    private String saltedHashedPassword;

    @ManyToMany
    @Getter
    @Setter
    Set<Role> roles = new HashSet<>();
}
