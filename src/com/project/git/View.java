/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.git;

import java.util.Scanner;

/**
 *
 * @author Feri Winarta
 */
public class View {
    
    public int menu() {
        // anggap jika program hanya logikanya saja yg sama,bukan membuat git asli
        // seluruh proses git hanya akan dilakukan didalam program
        // dan hanya menggunakan file-untuk-git.txt yg akan melakukan
        // proses initalize, commit, checkout, branch (belum)
        
        // HARAP UNTUK SELALU MENGINITIALIZE PROGRAM TERLEBIH DAHULU 
        // DAN AKAN DIBUATKAN FILE-UNTUK-GIT.txt YG NANTI AKAN DIISI
        Scanner input = new Scanner(System.in);
        System.out.println("menu git");
        System.out.println("1. initialize(akan membuat file-untuk-git.txt)");
        System.out.println("2. git commit");
        System.out.println("3. git checkout");
        // System.out.println("4. git branch"); 
        System.out.println("masukan pilihan : ");
        int pilihan = input.nextInt();
        return pilihan;
    }
}
