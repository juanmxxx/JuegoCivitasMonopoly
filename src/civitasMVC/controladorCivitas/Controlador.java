/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.controladorCivitas;

import civitasMVC.civitas.CivitasJuego;
import civitasMVC.civitas.GestionInmobiliaria;
import civitasMVC.civitas.OperacionInmobiliaria;
import civitasMVC.civitas.OperacionJuego;
import civitasMVC.GUI.Vista;

/**
 *
 * @author Enrique Santolaya Fabiani
 */
public class Controlador {
    private CivitasJuego juego;
    private Vista vista;
    
    public Controlador(CivitasJuego juego, Vista vista){
        this.juego = juego;
        this.vista = vista;
    }
    
    public void juega(){
        while( !juego.finalDelJuego() ){
            vista.actualiza();
            vista.pausa();
            OperacionJuego operacion = juego.siguientePaso();
            vista.mostrarSiguienteOperacion(operacion);
            if( operacion != OperacionJuego.PASAR_TURNO ){
                vista.mostrarEventos();
            }
            boolean finalJuego = juego.finalDelJuego();
            if( !finalJuego ){
                if(operacion == OperacionJuego.COMPRAR){
                    if(vista.comprar() == Respuesta.SI){
                        juego.comprar();
                    }
                    juego.siguientePasoCompletado(operacion);
                }
                if(operacion == OperacionJuego.GESTIONAR){
                    OperacionInmobiliaria gestOperacion;
                    gestOperacion = vista.elegirOperacion();
                    if(gestOperacion != OperacionInmobiliaria.TERMINAR){
                        int ip = vista.elegirPropiedad();
                        GestionInmobiliaria gestion = new GestionInmobiliaria(gestOperacion, ip);
                        if( gestOperacion == OperacionInmobiliaria.CONSTRUIR_CASA ){
                            juego.contruirCasa(ip);
                        }
                        if( gestOperacion == OperacionInmobiliaria.CONSTRUIR_HOTEL ){
                            juego.contruirHotel(ip);
                        }
                    }
                    else{
                        juego.siguientePasoCompletado(operacion);
                    }
                }
            }
        }
        vista.actualiza();
        vista.mostrarEstado();
    }
}
