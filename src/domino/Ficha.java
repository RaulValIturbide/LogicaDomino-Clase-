/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domino;

/**
 *
 * @author baske
 */
public class Ficha {
    private static int contadorId = 0;
    private int id;
    private int numIzq;
    private int numDch;
    
    
    public Ficha(int numIzq, int numDch){
        id = contadorId;
        contadorId++;
        this.numIzq = numIzq;
        this.numDch = numDch;
}
    
    
    public void setNumIzq(int numIzq){
        this.numIzq = numIzq;
    }
    public void setNumDch(int numDch){
        this.numDch = numDch;
    }
    public int getNumIzq(){
        return numIzq;
    }
    public int getNumDch(){
        return numDch;
    }
    
    @Override
    public String toString(){
        return "\nNum izq: " + numIzq + "\nNum dch: " + numDch ;
    }
    
    
    
    
    
    
}
