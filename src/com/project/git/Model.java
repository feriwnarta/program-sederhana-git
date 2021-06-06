/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.git;

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
                break;
            case 2 :
                break;
            case 3 :
                break;
            default :
                System.out.println("salah menu");
                break;
        }
        
    }
    
    
    
}
