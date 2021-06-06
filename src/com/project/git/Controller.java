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
public class Controller {
    private View view;
    private Model model;
    private int userInput;
    
    // default konstruktor
    public Controller(){
        view = new View();
        model = new Model(this);
    }
    
    // tampil menu git
    public void showMenu(){
        userInput = view.menu();
    }

    public View getView() {
        return view;
    }

    // mendapatkan pilihan dari menu
    public int getUserInput() {
        return userInput;
    }
    
    public void resultAmbilDataUserInput(){
        model.ambilDataUserInput();
    }
    
    
    
}
