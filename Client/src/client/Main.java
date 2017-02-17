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


public class Main {

      
    public static void main(String[] args) {
      try{
          Socket socket = new Socket("localhost",4321);
          
          PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          
          //citire din consola
          BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
          
          while(true){
              System.out.print("Client : ");
              String line = consola.readLine();
              
              out.print(line);
              
              line = in.readLine();
              System.out.print("Server : " + line);
              
              if (line.equalsIgnoreCase("end")){
                  break;
              }
              
          }
          // stop citire consola 
      }catch(Exception e)
      {e.printStackTrace();} 
        
        
    }
    
}
