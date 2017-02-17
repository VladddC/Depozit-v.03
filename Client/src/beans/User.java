/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Vlad.C
 */
public class User implements Serializable {
    private String user;
    private char[] pass;

    public User(String user, char[] pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public char[] getPass() {
        return pass;
    }

    public void setPass(char[] pass) {
        this.pass = pass;
    }
    
    
    
}
