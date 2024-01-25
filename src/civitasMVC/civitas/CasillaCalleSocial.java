/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;

/**
 *
 * @author juanmavwgolf5
 */
public class CasillaCalleSocial extends CasillaCalle {
    private static int maxCasasSociales = 1;
    private static int maxHotelesSociales = 1;
    
    
    public CasillaCalleSocial(String nombre, float precioCompra, 
            float precioEdificar, float precioAlquilerBase){
        super(nombre, precioCompra, precioEdificar, precioAlquilerBase);       
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean soySocial() {
        return super.soySocial(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CasillaCalleSocial hacermeSocial(Jugador jugador) {
        return super.hacermeSocial(jugador); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    float getPrecioAlquilerCompleto() {
        return super.getPrecioAlquilerCompleto(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
}
