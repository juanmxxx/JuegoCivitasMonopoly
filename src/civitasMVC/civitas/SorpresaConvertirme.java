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
public class SorpresaConvertirme extends Sorpresa{

    public SorpresaConvertirme(String texto, int valor) {
        super(texto, valor);
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        super.informe(actual, todos);
        JugadorEspeculador NuevoJugador = todos.get(actual).convertir();
        todos.set(actual, NuevoJugador);
    }
}
