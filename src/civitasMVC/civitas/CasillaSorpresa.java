/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;
import java.util.ArrayList;

/**
 *
 * @author w4lkerPC
 */
public class CasillaSorpresa extends Casilla{
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;

    public CasillaSorpresa(String nombre, MazoSorpresas mazo) {
        super(nombre);
        this.mazo = mazo;
    }
    
    private void recibeJugador_sorpresa(int actual, ArrayList<Jugador> todos){
        sorpresa = this.mazo.siguiente();
        informe(actual, todos);
        sorpresa.aplicarAJugador(actual, todos);
    }
    
    @Override
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        recibeJugador_sorpresa(actual, todos);
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo=Sorpresa" + ", sorpresa=" + sorpresa;
    }
}
