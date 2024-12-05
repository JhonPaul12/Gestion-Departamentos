/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logica;

import igu.Pantalla_Principal;

/**
 *
 * @author justi
 */
public class Gestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pantalla_Principal pantalla = new Pantalla_Principal();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        Conexion_BaseDatos db = new Conexion_BaseDatos();
        db.conexion();
        
    }
    
}
