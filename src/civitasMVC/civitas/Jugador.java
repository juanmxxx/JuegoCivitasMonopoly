/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;
import java.util.ArrayList;
import java.lang.Float;

/**
 *
 * @author Enrique Santolaya Fabiani
 * @author Juan Manuel Sujar Gonzalez
 */
public class Jugador implements Comparable{
    protected static int CasasMax = 4;
    protected static int HotelesMax = 4;
    protected static int CasasPorHotel = 4;
    private int CasillaActual;
    protected String nombre;
    protected static float PasoPorSalida = 1000;
    private boolean puedeComprar;
    private float saldo;
    private static float SaldoInicial = 7500;
    private ArrayList<CasillaCalle> propiedades = new ArrayList<>();
    
    Jugador(String nombre){
        this.nombre = nombre;
        saldo = SaldoInicial;
    }
    
    public Jugador(Jugador otro){
        nombre = otro.nombre;
        CasillaActual = otro.CasillaActual;
        puedeComprar = otro.puedeComprar;
        saldo = otro.saldo;
        propiedades.addAll(otro.propiedades);
    }
    
    private boolean existeLaPropiedad(int ip){
        return propiedades.size() > ip;
    }
    
    boolean puedeComprarCasilla(){
        puedeComprar = true;
        return puedeComprar;
    }
    
    boolean modificarSaldo(float cantidad){
        saldo += cantidad;
        Diario.getInstance().ocurreEvento("Cantidad de saldo de "+nombre+" cambia a "+saldo);
        return true;
    }
    
    boolean paga(float cantidad){
        float cantidadPagar = cantidad * -1;
        return modificarSaldo(cantidadPagar);
    }
    
    boolean pagaAlquiler(float cantidad){
        return paga(cantidad);
    }
    
    boolean recibe(float cantidad){
        return modificarSaldo(cantidad);
    }
    
    boolean moverACasiila(int numCasilla){
        CasillaActual = numCasilla;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("La casilla actual se ha cambiado a: "+CasillaActual);
        return true;
    }
    
    private boolean puedoGastar(float precio){
        return saldo >= precio;
    }
    
    boolean tieneAlgoQueGestionar(){
        return propiedades.size() > 0;
    }
    
    boolean pasaPorSalida(){
        recibe(PasoPorSalida);
        Diario.getInstance().ocurreEvento("Se recibe "+PasoPorSalida+" por pasar por la salida");
        return true;
    }
    
    public int compareTo(Jugador otro){
        int compare = Float.compare(saldo, otro.saldo);
        return compare;
    }
   
    int cantidadCasasHotel(){
        int cantidad = 0;
        for(int i=0; i < propiedades.size(); i++){
            cantidad += propiedades.get(i).cantidadCasasHoteles();
        }
        return cantidad;
    }
    
    boolean enBancarrota(){
        return saldo < 0;
    }
    
    protected int getCasasMax(){
        return CasasMax;
    }
    protected int getHotelesMax(){
        return HotelesMax;
    }
    int getCasasPorHotel(){
        return CasasPorHotel;
    }
    public int getCasillaActual(){
        return CasillaActual;
    }
    public String getNombre(){
        return nombre;
    }
    private float getPremioPorSalida(){
        return PasoPorSalida;
    }
    public ArrayList<CasillaCalle> getPropiedades(){  //protected
        return propiedades;
    }
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    public float getSaldo(){
        return saldo;
    }
    
    public boolean esEspeculador(){
        return false;
    }
    
    private boolean puedoEdificarCasa(CasillaCalle propiedad){
        if( propiedad.getNumCasas() < getCasasMax() ){
            return puedoGastar(propiedad.getPrecioEdificar());
        }
        return false;
    }
    private boolean puedoEdificarHotel(CasillaCalle propiedad){
        if( propiedad.getNumHoteles() < getHotelesMax() ){
            if( propiedad.getNumCasas() >= CasasPorHotel ){
                return puedoGastar(propiedad.getPrecioEdificar());
            }
        }
        return false;
    }
    
    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        if(puedeComprar){
            float precio = titulo.getPrecioCompra();
            
            if(puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador "+this.getNombre()+" compra la propiedad "+titulo.getNombre());
                puedeComprar = false;
            }
            else Diario.getInstance().ocurreEvento("El jugador "+this.getNombre()+" no tiene saldo para comprar la propiedad "+titulo.getNombre());
        }
        return result;
    }
    
    boolean contruirCasa(int ip){           
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        if(existe){
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificar = puedoEdificarCasa(propiedad);
            float precioEdificar = propiedad.getPrecioEdificar();
            if(puedoEdificar){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador "+this.getNombre()+" construye casa en la propiedad "+propiedad.getNombre());
            }
        }
        return result;
    }
    
    public CasillaCalleSocial hacerCalleSocial(int ip){
        
        CasillaCalleSocial calleSocial = null;
        
        if(existeLaPropiedad(ip)){
            CasillaCalle calle = this.propiedades.get(ip);
            calleSocial = calle.hacermeSocial(this);
            
                
            
            if(calleSocial!=null){
                Diario.getInstance().ocurreEvento("calle socializada");
                propiedades.set(ip, calleSocial);
            }
            
            
        }
        
        return calleSocial;
    }
    

    
    boolean construirHotel(int ip){          
        boolean result = false;
        if(this.existeLaPropiedad(ip)){
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
            float precio = propiedad.getPrecioEdificar();
            if(puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador "+this.getNombre()+" construye hotel en la propiedad "+propiedad.getNombre());
            }
        }
        return result;
    }
    
    protected JugadorEspeculador convertir(){
        JugadorEspeculador NuevoJugador = new JugadorEspeculador(this);
        return NuevoJugador;
    }
    
    protected void actualizaPropiedadesPorConversion(JugadorEspeculador nuevo){
        for(int i=0; i < propiedades.size(); i++){
            propiedades.get(i).actualizaPropietarioPorConversion(nuevo);
        }
    }
    
    @Override
    public String toString() {
        return "Nombre=" + nombre + ", saldo=" + saldo + ", especulador=" + esEspeculador();
    }
    
}
