package com.example.dogwalkerv3.users;

/**
 * Abstract class for the users.
 * @author Daniel
 * @version 1.0
 */
public abstract class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    protected Boolean connectedStatus;

    /**
     * Constructor of the class
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param email user's email
     * @param password user's password
     */
    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

        this.connectedStatus = false;
    }
}
