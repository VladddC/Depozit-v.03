/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import static server.Server.clients;

/**
 *
 * @author Vlad.C
 */
public class ServerThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
   public ServerThread(Socket socket){
       this.socket = socket;
       
       try{
           in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           out = new PrintWriter(socket.getOutputStream(),true);
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
    }   
    public void run(){
        try{ 
            while(true){
                   String line = in.readLine();
                   for(ServerThread client: Server.clients){
                       client.sendMessage(line);
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
       
}

