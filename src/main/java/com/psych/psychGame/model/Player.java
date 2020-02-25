package com.psych.psychGame.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

// Declaring Players class as entity
@Entity
// Table name to be associated with it
@Table(name = "players")
// Whenever class is entity, it needs to implement serializable
public class Player extends User {
    // alias cannot be blank
    @NotBlank
    @Getter
    @Setter
    private String alias;

    @Getter
    @Setter
    private String psychFaceURL;

    @Getter
    @Setter
    private String picURL;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Stat stat = new Stat();

    @ManyToMany(mappedBy = "players")
    @Getter
    @Setter
    private Set<Game> games = new HashSet<>();

    public Player() {}

    private Player(Builder builder) {
        setEmail(builder.email);
        setSaltedHashedPassword(builder.saltedHashedPassword);
        setAlias(builder.alias);
        setPsychFaceURL(builder.psychFaceURL);
        setPicURL(builder.picURL);
    }

    public static final class Builder {
        private @Email @NotBlank String email;
        private @NotBlank String saltedHashedPassword;
        private @NotBlank String alias;
        private String psychFaceURL;
        private String picURL;

        public Builder() {
        }

        public Builder email(@Email @NotBlank String val) {
            email = val;
            return this;
        }

        public Builder saltedHashedPassword(@NotBlank String val) {
            saltedHashedPassword = val;
            return this;
        }

        public Builder alias(@NotBlank String val) {
            alias = val;
            return this;
        }

        public Builder psychFaceURL(String val) {
            psychFaceURL = val;
            return this;
        }

        public Builder picURL(String val) {
            picURL = val;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
