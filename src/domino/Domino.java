/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package domino;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author baske
 */
public class Domino {

    /**
     * @param args the command line arguments
     */
    static HashSet<Ficha> lista = new HashSet<>();//Vamos a crear un HashSet para dar la sensacion de aleatoriedad que tiene una bolsa, ya que estarán desordenados
    static ArrayList<Ficha> tablero = new ArrayList<>();
    static int ladoDch; // Este atributo será el numero que haya en la parte derecha de la ficha derecha del tablero 
    static int ladoIzq; // Este atributo será el numero que haya en la parte izquierda de la ficha izquierda del tablero 
    static int contador = 0;
    static int conexiones = 0;
   

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        //Se crean las fichas y se meten en una LinkedList tras desordenarlas en un HashSet
        crearFichas();
        LinkedList<Ficha> bolsa = new LinkedList<>(lista);
        Collections.shuffle(bolsa);
        sacarPrimeraFicha(bolsa);//Sacamos la primera ficha
        do {

            sacarFicha(bolsa);

            teclado.nextLine();

        } while (!bolsa.isEmpty() && conexiones < 8);
        
        
        if(conexiones >= 8){
            System.out.println("Has ganado, has conectado 8 fichas de domino");
        }     
    }
    
    public static void sacarPrimeraFicha(LinkedList<Ficha> bolsa){
        tablero.add(bolsa.getFirst());//Añade la ficha al tablero
        ladoDch = bolsa.getFirst().getNumDch();
        ladoIzq = bolsa.getFirst().getNumIzq();
        System.out.println(bolsa.getFirst());
       bolsa.remove(bolsa.getFirst()); //Borra la ficha de la bolsa

    }

    public static void sacarFicha(LinkedList<Ficha> bolsa) {
        contador++;
        System.out.println(bolsa.getFirst());
        if (conectarIzq(bolsa.getFirst())) {
            System.out.println("Se puede conectar por la izquierda");
            conexiones++;
            tablero.addFirst(bolsa.getFirst());
            bolsa.remove(bolsa.getFirst());
        } else if (conectarDch(bolsa.getFirst())) {
            System.out.println("Se puede conectar por la derecha");
            conexiones++;
            tablero.add(bolsa.getFirst());
            bolsa.remove(bolsa.getFirst());
        } else {
            bolsa.remove(bolsa.getFirst());
            System.out.println("No se puede conectar");
        }

        System.out.println(tablero + "\n");

    }
    public static void rotarFicha(Ficha ficha){
        int aux = ficha.getNumDch();
        ficha.setNumDch(ficha.getNumIzq());
        ficha.setNumIzq(aux);
    }
    
    public static boolean conectarIzq(Ficha ficha) {
        if (ficha.getNumIzq() == ladoIzq) {
            ladoIzq = ficha.getNumDch();
            rotarFicha(ficha);
            return true;
        } else if (ficha.getNumDch() == ladoIzq) {
            ladoIzq = ficha.getNumIzq();
            return true;
        } else {
            return false;
        }
    }
        public static boolean conectarDch(Ficha ficha) {
        if (ficha.getNumDch() == ladoDch) {
            ladoDch = ficha.getNumIzq();
            rotarFicha(ficha);
            return true;
        } else if (ficha.getNumIzq() == ladoDch) {
            ladoDch = ficha.getNumDch();
            return true;
        } else {
            return false;
        }
    }
    
    
    

    public static void crearFichas() {
        for (int i = 0; i <= 6; i++) { // Para las caras de 0 a 6
            for (int j = i; j <= 6; j++) { // Evita duplicar fichas como (2,3) y (3,2)
                lista.add(new Ficha(i, j)); // Suponiendo que tienes un constructor Ficha(int, int)
            }
        }
    }
    public static void recorrerLista(LinkedList<Ficha> bolsa){
        for(Ficha ficha : bolsa){
            System.out.println(ficha.toString());
        
        }
    }
    
    
    
    
}
