/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author u04127224290
 */
public abstract class DAO_Abstract {
    public abstract void insert();
    public abstract void update();
    public abstract void delete();
    
    public void mostrar(String texto) {
        System.out.println("");
            }
    
}
