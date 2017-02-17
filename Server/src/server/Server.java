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
import java.util.ArrayList;


public class Server{
    
    static ServerSocket ss;
    static ArrayList<ServerThread> clients = new ArrayList<ServerThread>();

    public static void main(String[] args) {
        try{
            
            ss = new ServerSocket(4321);
            
            while(true){
                
               ServerThread st = new ServerThread(ss.accept());
               clients.add(st);
               st.start();
            
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
