/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import beans.User;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;


/**
 *
 * @author Vlad.C
 */
public class ServerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ObjectOutputStream oout;
    private ObjectInputStream oin;
    
    
   public ServerThread(Socket socket){
       this.socket = socket;
       
       try{
           in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           out = new PrintWriter(socket.getOutputStream(),true);
           oout = new ObjectOutputStream(socket.getOutputStream());
           oin = new ObjectInputStream(socket.getInputStream());
           
       }catch(Exception e){
           e.printStackTrace();
       }
    }   
    public void run(){
        try{ 
            while(true){
                   User u =(User) oin.readObject();
                   for(ServerThread client: Server.clients){
                      // client.sendMessage(line);
                      client.verifyLogin(u);
                   }
               }
           }catch(Exception e){
               e.printStackTrace();
           }
           
    }   
    
    public void sendMessage(String message){
           StringBuffer sb = new StringBuffer(message);
           sb.reverse();
           out.println(sb.toString());
           
    }
    
    public void verifyLogin(User u){
        String username = u.getUser();
        char[] password = u.getPass();
        System.out.println(String.valueOf(password));
        if(username.equalsIgnoreCase("Vlad") && String.valueOf(password).contentEquals("password")){
            System.out.println("Conexiune reusita");
            
        }
        else{
            System.out.println("Ce faci wa?!");
            JOptionPane.showMessageDialog(null,"Utilizator inexistent!","Error.",JOptionPane.ERROR_MESSAGE);
        }
            
        
    }
}

