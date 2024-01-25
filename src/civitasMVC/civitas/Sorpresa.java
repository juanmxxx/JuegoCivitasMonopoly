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
public abstract class Sorpresa {
    private String texto;
    private int valor;
    private MazoSorpresas mazo;
    
    Sorpresa(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    
    protected void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento(todos.get(actual).getNombre()+" Recibe la sorpresa: "+toString());
    }
    
    protected int getValor(){
        return valor;
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
    }

    
    @Override
    public String toString() {
        return texto;
    }
}
