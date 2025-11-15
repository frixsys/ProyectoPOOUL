/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;

/**
 *
 * @author santiago
 */
public class gestorUsuarios {
    private Usuario [] listaUsuarios;
    private int nroUsuarios;
    
    public gestorUsuarios() {
        this.listaUsuarios = new Usuario[20];
        this.nroUsuarios = 0;
    }
    
    public void AgregarUsuario(String pUsername, String pPassword, String pRole){
        this.listaUsuarios[this.nroUsuarios] = new Usuario(pUsername, pPassword, pRole);
        this.nroUsuarios++;
    }
    
    public Usuario validarUsuario(String pUsername, String pPassword){
        for (int i = 0; i < this.nroUsuarios; i++) {
            if(this.listaUsuarios[i].getUsername().equals(pUsername)&&this.listaUsuarios[i].getPassword().equals(pPassword)) {
                return this.listaUsuarios[i];
            }
        }
        return null;
    }
}
