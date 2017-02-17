/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Client{

    private static Socket socket; 
    public static String ip;
    public static String nume;
    public static BufferedReader in;
    public static PrintWriter out;
    
    
    public static void main(String[] args) {
      
        ip = JOptionPane.showInputDialog("Server Address : ");
        nume = JOptionPane.showInputDialog("Login : ");
        
        try{
          
          Socket socket = new Socket(ip,4321);
          
          PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          
          //citire din consola
          BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
          
          String line; 
          
          while(true){
              System.out.print("Client : ");
              
              line = consola.readLine();
              
              out.println(line);
              
              line = in.readLine();
              System.out.print("Server : " + line + "\n");
              
              if (line.equalsIgnoreCase("end")){
                  break;
              }
              
          }
          // stop citire consola 
      }catch(Exception e)
      {e.printStackTrace();} 
        
        
    }
    
}
