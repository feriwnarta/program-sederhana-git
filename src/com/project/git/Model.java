/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.git;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feri Winarta
 */
public class Model {
    private Controller control;
    
    public class GitHead {
        private GitHead initialize;
        private GitHead head;
        private String unix;
        private String userName;
        private String userEmail;

        public GitHead getInitialize() {
            return initialize;
        }

        public void setInitialize(GitHead initialize) {
            this.initialize = initialize;
        }

        public GitHead getHead() {
            return head;
        }

        public void setHead(GitHead head) {
            this.head = head;
        }

        public String getUnix() {
            return unix;
        }

        public void setUnix(String unix) {
            this.unix = unix;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }
        
        
    }
    
    public Model(){
        control = new Controller();
    }
    
    public void ambilDataUserInput(){
        int resultInputUser = control.getUserInput();
        
        // pilihan dari menu
        switch(resultInputUser){
            case 1 :
                initialize();
                break;
            case 2 :
                break;
            case 3 :
                break;
            case 4 :
                break;
            default :
                System.out.println("salah menu");
                break;
        }
        
    }
    
    private void initialize(){
        System.out.println("initialized new repository in program");
        System.out.println("membuat file-untuk-git.txt");
        // buat file-untuk-git.txt
        try {
            FileWriter writeFile = new FileWriter(new File("file-untuk-git.txt"));
        } catch(IOException e) {
            System.out.println("error saat buat file");
        }   
    }
    
    private void editFIle(String isiPesan){
        
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("file-untu-git.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("file-untuk-git tidak ada / belum dibuat");
        }
        
    }
    
}
