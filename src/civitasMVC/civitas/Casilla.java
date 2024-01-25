/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;
import java.util.ArrayList;
public class Casilla {
    protected static float FACTORIALQUILERCALLE = 1.0f;
    protected static float FACTORIALQUILERCASA = 1.0f;
    protected static float FACTORIALQUILERHOTEL = 4.0f;
    
    private String nombre;
    protected Jugador propietario;
    
    Casilla(String nombre){
        init();       
        this.nombre = nombre;
    }
    private void init(){
        nombre = "NombreInit";
        propietario = new Jugador("");
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador "+todos.get(actual).getNombre()+" cae en la casilla "+nombre);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public boolean tienePropietario(){
        return !propietario.getNombre().isEmpty();
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        return propietario.getNombre().equals(jugador.getNombre());
    }

    void recibeJugador(int actual, ArrayList<Jugador> todos){
        this.informe(actual, todos);
    }
    
    
    @Override
    public String toString() {
        if( tienePropietario() ){
            return "Nombre=" + nombre + ", propietario="+ propietario.getNombre();
        }
        return "Nombre=" + nombre;
    }
}
