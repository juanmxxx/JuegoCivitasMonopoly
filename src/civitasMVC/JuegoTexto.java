/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC;

import civitasMVC.civitas.CivitasJuego;
import civitasMVC.controladorCivitas.Controlador;
import civitasMVC.vistaTextualCivitas.VistaTextual;
import java.util.ArrayList;

/**
 *
 * @author Enrique Santolaya Fabiani
 */
public class JuegoTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> listaJugadores = new ArrayList<>();
        listaJugadores.add("JugadorA");
        listaJugadores.add("JugadorB");
        listaJugadores.add("JugadorC");
        CivitasJuego juego = new CivitasJuego(listaJugadores, false);
        
        VistaTextual vista = new VistaTextual(juego);
        //Controlador controlador = new Controlador(juego, vista);
        //controlador.juega();
    }
    
}
