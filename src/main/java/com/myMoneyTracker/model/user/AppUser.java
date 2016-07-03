package com.myMoneyTracker.model.user;

import java.util.Currency;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Floryn on 17.12.2015.
 * Entity class for the app_user table
 */
@Entity
@Table(name = "app_user",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }),
                @UniqueConstraint(columnNames = { "email" }) },
        indexes = {@Index(name = "username_index",  columnList="username", unique = true),
                @Index(name="email_index", columnList = "email", unique = true)})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String surname;

    private Date birthdate;

    @NotNull
    @NotEmpty
    @Length(min = 5, message = "Username should have at least 5 characters!")
    private String username;

    @NotNull
    @Length(min = 8, message = "Password should have at least 8 characters!")
    private String password;

    @NotNull
    @NotEmpty
    @Email(message = "Please provide a valid email address!")
    private String email;

    private boolean activated;

    private Currency defaultCurrency;

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public Date getBirthdate() {

        return birthdate;
    }

    public void setBirthdate(Date birthdate) {

        this.birthdate = birthdate;
    }

    public boolean isActivated() {

        return activated;
    }

    public void setActivated(boolean activated) {

        this.activated = activated;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}