/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unipiloto.proyecto;

/**
 *
 * @author DANIEL
 */
public class Recuperar {
    public String correo;
    public String pass;

    public Recuperar(String correo, String pass) {
        this.correo = correo;
        this.pass = pass;
    }

    public Recuperar() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
}
