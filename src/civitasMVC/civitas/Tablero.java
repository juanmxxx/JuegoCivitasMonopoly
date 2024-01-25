/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;
import java.util.ArrayList;

/**
 *
 * @author Enrique Santolaya Fabiani
 * @author Juan Manuel Sujar Gonzalez
 */
public class Tablero {
    private ArrayList<Casilla> Casillas;
    private boolean porSalida;
    
    public Tablero(){
        Casillas = new ArrayList<>();
        porSalida = false;
    }
    
    private boolean correcto(int numCasilla){
        return Casillas.size() > numCasilla;
    }
    
    boolean computarPasoPorSalida(){
        if( porSalida ){
            porSalida = false;
            return true;
        }
        else porSalida = false;
        return false;
    }
    
    void anadeCasilla(Casilla casilla){
        Casillas.add(casilla);
    }
    
    public Casilla getCasilla(int numCasilla){
        if( correcto(numCasilla) )
            return Casillas.get(numCasilla);
        else return null;
    }
    public ArrayList<Casilla> getCasillas(){
        return Casillas;
    }
    
    int nuevaPosicion(int actual, int tirada){
        int total = actual+tirada;
        if( !correcto(total) ){
            total = tirada - (Casillas.size()-actual);
            porSalida = true;
        }
        return total;
    }
}
