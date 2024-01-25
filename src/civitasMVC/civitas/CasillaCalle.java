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
public class CasillaCalle extends Casilla{
    private String nombre;
    private float precioCompra;
    private float precioEdificar;
    private float precioBaseAlquiler;
    private int numCasas, numHoteles;

    public CasillaCalle(String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler) {
        super(titulo);
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        numCasas = 0;
        numHoteles = 0;
    }

    public float getPrecioCompra(){
        return precioCompra;
    }
    public float getPrecioEdificar(){
        return precioEdificar;
    }
    public float getPrecioBaseAlquiler(){
        return precioBaseAlquiler;
    }
    public int getNumCasas(){
        return numCasas;
    }
    public int getNumHoteles(){
        return numHoteles;
    }
    float getPrecioAlquilerCompleto(){
        float PrecioAlquiler = precioBaseAlquiler * (FACTORIALQUILERCASA + numCasas + (numHoteles*FACTORIALQUILERHOTEL));
        return PrecioAlquiler;
    }
    
    public void tramitarAlquiler(Jugador jugador){
        if( tienePropietario() && !esEsteElPropietario(jugador) ){
            jugador.pagaAlquiler(getPrecioAlquilerCompleto());
            propietario.recibe(getPrecioAlquilerCompleto());
        }
    }
    
    public int cantidadCasasHoteles(){
        return ( numCasas+numHoteles );
    }
    
    boolean construirCasa(){
        numCasas++;
        return true;
    }
    boolean construirHotel(){
        numHoteles++;
        return true;
    }
    
    boolean derruirCasas(int n, Jugador jugador){
        if( esEsteElPropietario(jugador) && numCasas >= n ){
            numCasas -= n;
            return true;
        }
        return false;
    }

    boolean comprar(Jugador jugador){
        propietario = jugador;
        jugador.paga(precioCompra);
        return true;
    }
    
    boolean construirCasa(Jugador jugador){
        propietario.paga(precioEdificar);
        numCasas++;
        return true;
    }
    
    boolean construirHotel(Jugador jugador){
        propietario.paga(precioEdificar);
        numHoteles++;
        return true;
    }
    
    
    
    
    public CasillaCalleSocial hacermeSocial(Jugador jugador){
        propietario = jugador;
        
        return propietario.hacerCalleSocial(numCasas);
        
    }
    
    public boolean soySocial(){
        boolean soySocial = false;
        
        if(propietario.getCasasMax() == 1 && propietario.getHotelesMax() == 1)
             soySocial = true;
        
        return soySocial;
    }
    
    public void setNumCasas(int numCasas){
        this.numCasas = numCasas;
    }
    
    public void setNumHoteles(int numHoteles){
        this.numHoteles = numHoteles;
    }
    
    
    
    
    private void recibeJugador_calle(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        Jugador jugador = todos.get(actual);
        if(!tienePropietario()){
            jugador.puedeComprarCasilla();
        }
        else{
            tramitarAlquiler(jugador);
        }
    }
    
    @Override
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        recibeJugador_calle(actual, todos);
    }
    
    void actualizaPropietarioPorConversion(JugadorEspeculador nuevo){
        propietario = nuevo;
    }

    @Override
    public String toString() {
        return super.toString()+", Tipo=Calle" + ", precioCompra=" + precioCompra + ", precioEdificar=" + precioEdificar + ", precioBaseAlquiler=" + precioBaseAlquiler + ", numCasas=" + numCasas + ", numHoteles=" + numHoteles;
    }
  }
    

    
    
    
    
    
    
    
    
  
    
    
    

