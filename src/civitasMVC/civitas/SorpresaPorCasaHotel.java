/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;
import java.util.ArrayList;

/**
 *
 * @author esfabiani
 */
public class SorpresaPorCasaHotel extends Sorpresa{
    int cantidadSaldo;
    
    SorpresaPorCasaHotel(String texto, int valor) {
        super(texto, valor);
    }
    
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        super.informe(actual, todos);
        int cantidad = todos.get(actual).cantidadCasasHotel();
        todos.get(actual).modificarSaldo(super.getValor()*cantidad);
        cantidadSaldo = cantidad;
    }

    @Override
    public String toString() {
        if(cantidadSaldo < 0) return super.toString() + " " + -cantidadSaldo;
        else return super.toString() + " " + cantidadSaldo;
    }
    
}
