/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Enrique Santolaya Fabiani
 * @author Juan Manuel Sujar Gonzalez
 */
public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init(){
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas =0;
    }
    
    MazoSorpresas(boolean estadoDebug){
        init();
        debug = estadoDebug;
        if (debug) {
            Diario.getInstance().ocurreEvento("Estado Debug= true");
        }
    }
    MazoSorpresas(){
        init();
        debug = false;
    }
    
    void alMazo( Sorpresa s ){
        if( !barajada ) sorpresas.add(s);
    }
    Sorpresa siguiente(){
        if (!barajada || usadas == sorpresas.size()){
            if(!debug){
                Collections.shuffle(sorpresas);
                usadas = 0;
                barajada = true;
            }
        } 
        usadas++;
        Sorpresa unaSorpresa = sorpresas.get(0);
        for( int i=0; i < sorpresas.size()-2; i++){
            sorpresas.set(i, sorpresas.get(i+1));
        }
        sorpresas.set(sorpresas.size()-1, unaSorpresa);
        return unaSorpresa;
    }
}