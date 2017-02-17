/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {


    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(4321);
            Socket socket = ss.accept();
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            while(true){
                String line = in.readLine();
                
                //citeste intrarea si reverseaza
                
                StringBuffer sb = new StringBuffer(line);
                
                sb.reverse();
                
                line = sb.toString();
                out.println(line);
            
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
