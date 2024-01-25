/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC;

import civitasMVC.GUI.CapturaNombres;
import civitasMVC.GUI.CivitasView;
import civitasMVC.civitas.CivitasJuego;
import civitasMVC.controladorCivitas.Controlador;
import java.util.ArrayList;

/**
 *
 * @author esfabiani
 */
public class TestP5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CivitasView Vista = new CivitasView();
        CapturaNombres instancia;
        ArrayList<String> nombres = new ArrayList<>();
        
        // Se permite jugar con menos de cuatro jugadores
        while(nombres.isEmpty()){
            instancia = new CapturaNombres(Vista,true);
            nombres = instancia.getNombres();
            for(int i=0; i < nombres.size(); i++){
                if(nombres.get(i).isBlank()){ nombres.remove(i); i--;}
            }
        }
        CivitasJuego juego = new CivitasJuego(nombres, false);
        Controlador control = new Controlador(juego, Vista);
        Vista.setCivitasJuego(juego);
        control.juega();
    }
    
}
