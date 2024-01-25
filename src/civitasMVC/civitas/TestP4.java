/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;

/**
 *
 * @author Enrique Santolaya Fabiani
 */
public class TestP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Jugador");
        CasillaCalle casilla = new CasillaCalle("casillaCalle",10,10,10);
        jugador.recibe(1000);
        jugador.puedeComprarCasilla();
        jugador.comprar(casilla);
        JugadorEspeculador jugadorEspec = jugador.convertir();
        jugadorEspec.cambiarNombre();
        System.out.println(jugadorEspec.toString());
        System.out.println(jugadorEspec.getPropiedades().get(0).toString());
    }
    
}
