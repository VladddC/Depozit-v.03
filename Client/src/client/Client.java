/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import gui.Login;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Client{

    private static Socket socket; 
    public static String ip;
    public static String nume;
    public static BufferedReader in;
    public static PrintWriter out;
    public static ObjectInputStream oin;
    public static ObjectOutputStream oout;
    
    
    public static void main(String[] args) {
      
        ip = JOptionPane.showInputDialog("Server Address : ");
        nume = JOptionPane.showInputDialog("Login : ");
        
        try{
          
          Socket socket = new Socket(ip,4321);
          
          PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          oout = new ObjectOutputStream(socket.getOutputStream());
          oin = new ObjectInputStream(socket.getInputStream());
           
          //citire din consola
          //BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
          
          String line; 
          
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                }
            }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
             }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
          
       
    
          
         /* while(true){
              System.out.print("Client : ");
              
              line = consola.readLine();
              
              out.println(line);
              
              line = in.readLine();
              System.out.print("Server : " + line + "\n");
              
              if (line.equalsIgnoreCase("end")){
                  break;
              } 
              
          }*/
          // stop citire consola 
      }catch(Exception e)
      {e.printStackTrace();} 
        
        
    }
    
}
