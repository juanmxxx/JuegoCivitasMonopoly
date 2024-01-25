/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;

import java.util.Random;
/**
 *
 * @author Enrique Santolaya Fabiani
 * @author Juan Manuel Sujar Gonzalez
 */
public class Dado {
    static final private Dado instance = new Dado();
    
    private Random random;
    private int ultimoResultado;
    private boolean debug;
            
    private Dado(){
        ultimoResultado = 0;
        debug = false;
        random = new Random();
    }
    
    static public Dado getInstance() {
        return instance;
    }
    int tirar(){
        int resultado = random.nextInt(6)+1;
        if(debug) resultado = 1;
        ultimoResultado = resultado;
        return resultado;
    }
    
    int quienEmpieza(int n){ 
        int jugador;
        jugador = random.nextInt(n);
        return jugador;
    }
    
    public void setDebug(boolean d){
        debug = d;
        if(debug) Diario.getInstance().ocurreEvento("Estado debug=true");
    }
    
    public int getUltimoResultado(){
        return ultimoResultado;
    }
    
    public boolean getDebug(){
        return debug;
    }
}