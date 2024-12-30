package Modelo;

import java.io.*;

public class Usuario implements Serializable{
    
    //Atributos
    private String user;
    private String password;
    
    //Constructor vacio
    public Usuario() {};
    
    //Getters y Setters
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
}
