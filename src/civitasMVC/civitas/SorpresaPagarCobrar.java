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
public class SorpresaPagarCobrar extends Sorpresa{

    SorpresaPagarCobrar(String texto, int valor) {
        super(texto, valor);
    }
    
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        super.informe(actual, todos);
        todos.get(actual).modificarSaldo(super.getValor());
    }

    @Override
    public String toString() {
        if(super.getValor() < 0) return super.toString() + " " + -super.getValor();
        else return super.toString() + " " + super.getValor();
    }
    
    
}
