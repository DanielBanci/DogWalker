package com.example.dogwalkerv3.users;

/**
 * This class represents a user who's looking for someone to walk/tack care of their dog;
 * it extends the 'User' class.
 * @author Daniel
 * @version 1.0
 */
public class DogOwner extends User{

    /**
     * Constructor of the class
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param email user's email
     * @param password user's password
     */
    public DogOwner(String firstName, String lastName, String email, String password){
        super(firstName,lastName,email,password);
    }
}
