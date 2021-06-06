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
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Feri Winarta
 */
public class Model {
    public class GitHead {
        private GitHead initialize, head, next;
        private String unix, userName, userEmail, message;
        
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
    
    private Controller control;
    private GitHead pointer;
    private int countCommit = 0;
    
    public Model(Controller control){
        this.control = control;
    }
    
    public void ambilDataUserInput(){
        int resultInputUser = control.getUserInput();
        
        // pilihan dari menu
        switch(resultInputUser){
            case 1 :
                initialize();
                break;
            case 2 :
                editFile(edit());
                break;
            case 3 :
                commit();
                break;
            case 4 :
                break;
            case 5 :
                gitLog();
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
        
            File newFile = new File("file-untuk-git.txt");
        try {
            newFile.createNewFile();
        } catch (IOException ex) {
            System.out.println("file-untuk-git.txt gagal dibuat \n" + ex.getMessage());
        }
    }
    
    private void editFile(String isiPesan){
        // baca file-untuk-git.txt

        try {
            BufferedWriter writeFile = new BufferedWriter(new FileWriter("file-untuk-git.txt"));
            writeFile.write(isiPesan);
            writeFile.newLine();
            writeFile.flush();
            writeFile.close();
        } catch (IOException ex) {
            System.out.println("file-untuk-git gagal diload untuk diedit \n" + ex.getMessage());
        }
    }
    
    private String edit(){
        String message;
        Scanner input = new Scanner(System.in);
        System.out.println("masukan isi file-untuk-git.txt");
        return message = input.nextLine();
    }
    
     private void commit(){
         // jika pointer head masih null
         // berarti baru pertama commit, dan pointer ini akan
         
         // commit initialized
         System.out.println("Masukan pesan commit : ");
         Scanner input = new Scanner(System.in);
         String message = input.nextLine();
         
         if(pointer == null){
             commitInitialize(message);
         } else {
             commitNext(message);
         }
     }
     
     private void commitInitialize(String message){
          // menjadi commit awal initialize
         Scanner input = new Scanner(System.in);
         if(pointer == null) {
             pointer = new GitHead();
             if(pointer.getUserName() == null) {
                 System.out.println("tolong bilang saya anda siapa ? ");
                 System.out.println("tolong isi username dan email");
                 System.out.println("masukan username : ");
                 String userName = input.nextLine();
                 System.out.println("masukan email : ");
                 String email = input.nextLine();
                 pointer.setUserName(userName);
                 pointer.setUserEmail(email);
                 pointer.setInitialize(pointer);
                 pointer.setHead(pointer);
                 pointer.message = message;
             }
         }
         overWriteFile();
     }
     
     private void commitNext(String message){
         GitHead commitNext = new GitHead();
         commitNext.setUserName(pointer.userName);
         commitNext.setUserEmail(pointer.userEmail);
         commitNext.message = message;
         pointer.head = null;
         pointer.next = commitNext;
         pointer = commitNext;
         pointer.head = pointer;
         overWriteFile();
     }
     
     private void overWriteFile(){
         BufferedReader read = null;
         BufferedWriter write = null;

         // baca dan overwrite commit
         try {
            read = new BufferedReader(new FileReader("file-untuk-git.txt"));
            write = new BufferedWriter(new FileWriter("commit " + countCommit));
            String baca = read.readLine();
            while(baca != null){
                write.write(baca);
                write.newLine();
                baca = read.readLine();
            }
            // nanti di ganti unix code
            countCommit++;
        } catch (FileNotFoundException ex) {
            System.out.println("file tidak ditemukan " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("file io expcetion " + ex.getMessage());
        } 
         
     }
     
     private void gitLog(){
         if(pointer == null){
             System.out.println("tidak ada commit !!!");
         }
         
         while(pointer != null){
             System.out.println(pointer.userName + " " +  pointer.userEmail);
             System.out.println(pointer.message);
             pointer = pointer.next;
         }
     }
    
}
