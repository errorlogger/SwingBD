/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.seb.swingDB.entity;

/**
 *
 * @author formation
 */
public class User {
    
    private int id;
    private String name;
    private String firstName;
    private String email;
    private String role;
    private String password;
    
    //constructeur par defaut
    public User(){
        
    }

    public User(int id, String name, String firstName, String role, String password) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.role = role;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public User setId(int id) {
        this.id = id;
        return this;// pour pouvoir faire syntaxe du genre User.setNom().setPrenom.setAge()
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    
    
    
}
