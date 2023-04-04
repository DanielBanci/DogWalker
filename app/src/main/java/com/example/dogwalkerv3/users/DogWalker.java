package com.example.dogwalkerv3.users;

/**
 * This class represents a user who's looking for walking/tacking care of a dog;
 * it extends the 'User' class.
 * @author Daniel
 * @version 1.0
 */
public class DogWalker extends User{

    /**
     * Constructor of the class
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param email user's email
     * @param password user's password
     */
    public DogWalker(String firstName, String lastName, String email, String password){
        super(firstName,lastName,email,password);

    }
}
