/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Enrique Santolaya Fabiani
 * @author Juan Manuel Sujar Gonzalez
 */
public class CivitasJuego {
    private int indiceJugadorActual;
    private EstadoJuego estado;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Tablero tablero;
    private MazoSorpresas mazo;
    private GestorEstados gestor;
    
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        for(int i=0; i<nombres.size(); i++){
            Jugador nuevo = new Jugador(nombres.get(i));
            jugadores.add(nuevo);
        }
        gestor = new GestorEstados();
        estado = gestor.estadoInicial();
        Dado.getInstance().setDebug(debug);
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        mazo = new MazoSorpresas(debug);
        inicializaMazoSorpresa();
        inicializaTablero(mazo);
    }
    
    private void inicializaTablero(MazoSorpresas mazo){
        tablero = new Tablero();
        Casilla casilla1 = new Casilla("Salida");
        CasillaCalle casilla2 = new CasillaCalle("Calle1",200,100,100);
        CasillaCalle casilla3 = new CasillaCalle("Calle2",300,150,150);
        CasillaSorpresa casilla4 = new CasillaSorpresa("Sorpresa1",mazo);
        CasillaCalle casilla5 = new CasillaCalle("Calle3",220,110,110);
        CasillaCalle casilla6 = new CasillaCalle("Calle4",320,170,170);
        CasillaSorpresa casilla7 = new CasillaSorpresa("Sorpresa2",mazo);
        CasillaCalle casilla8 = new CasillaCalle("Calle5",250,150,150);
        CasillaCalle casilla9 = new CasillaCalle("Calle6",350,200,200);
        CasillaCalle casilla10 = new CasillaCalle("Calle7",450,250,250);
        Casilla casilla11 = new Casilla("Parking");
        CasillaCalle casilla12 = new CasillaCalle("Calle8",350,200,200);
        CasillaCalle casilla13 = new CasillaCalle("Calle9",450,250,250);
        CasillaCalle casilla14 = new CasillaCalle("Calle10",475,260,260);
        CasillaSorpresa casilla15 = new CasillaSorpresa("Sorpresa3",mazo);
        CasillaCalle casilla16 = new CasillaCalle("Calle11",475,260,260);
        CasillaCalle casilla17 = new CasillaCalle("Calle12",525,300,300);
        CasillaSorpresa casilla18 = new CasillaSorpresa("Sorpresa4",mazo);
        CasillaCalle casilla19 = new CasillaCalle("Calle13",600,400,400);
        CasillaCalle casilla20 = new CasillaCalle("Calle14",800,500,500);
        tablero.anadeCasilla(casilla1);
        tablero.anadeCasilla(casilla2);
        tablero.anadeCasilla(casilla3);
        tablero.anadeCasilla(casilla4);
        tablero.anadeCasilla(casilla5);
        tablero.anadeCasilla(casilla6);
        tablero.anadeCasilla(casilla7);
        tablero.anadeCasilla(casilla8);
        tablero.anadeCasilla(casilla9);
        tablero.anadeCasilla(casilla10);
        tablero.anadeCasilla(casilla11);
        tablero.anadeCasilla(casilla12);
        tablero.anadeCasilla(casilla13);
        tablero.anadeCasilla(casilla14);
        tablero.anadeCasilla(casilla15);
        tablero.anadeCasilla(casilla16);
        tablero.anadeCasilla(casilla17);
        tablero.anadeCasilla(casilla18);
        tablero.anadeCasilla(casilla19);
        tablero.anadeCasilla(casilla20);
    }
    private void inicializaMazoSorpresa(){
        SorpresaPagarCobrar sorpresaC1 = new SorpresaPagarCobrar("Cobrar",100);
        SorpresaPagarCobrar sorpresaC2 = new SorpresaPagarCobrar("Cobrar",150);
        SorpresaPagarCobrar sorpresaC3 = new SorpresaPagarCobrar("Cobrar",200);
        SorpresaPagarCobrar sorpresaC4 = new SorpresaPagarCobrar("Pagar",-100);
        SorpresaPagarCobrar sorpresaC5 = new SorpresaPagarCobrar("Pagar",-150);
        SorpresaPagarCobrar sorpresaC6 = new SorpresaPagarCobrar("Pagar",-200);
        SorpresaPorCasaHotel sorpresaH1 = new SorpresaPorCasaHotel("Cobrar",50);
        SorpresaPorCasaHotel sorpresaH2 = new SorpresaPorCasaHotel("Cobrar",75);
        SorpresaPorCasaHotel sorpresaH3 = new SorpresaPorCasaHotel("Pagar",-50);
        SorpresaPorCasaHotel sorpresaH4 = new SorpresaPorCasaHotel("Pagar",-75);
        mazo.alMazo(sorpresaC1);
        mazo.alMazo(sorpresaC2);
        mazo.alMazo(sorpresaC3);
        mazo.alMazo(sorpresaC4);
        mazo.alMazo(sorpresaC5);
        mazo.alMazo(sorpresaC6);
        mazo.alMazo(sorpresaH1);
        mazo.alMazo(sorpresaH2);
        mazo.alMazo(sorpresaH3);
        mazo.alMazo(sorpresaH4);
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        if( tablero.computarPasoPorSalida() ){
            jugadorActual.pasaPorSalida();
        }
    }
    
    private void pasarTurno(){
        indiceJugadorActual++;
        if( indiceJugadorActual >= jugadores.size() ){
            indiceJugadorActual = 0;
        }
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        estado = gestor.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }
    
    public boolean contruirCasa(int ip){
        return jugadores.get(indiceJugadorActual).contruirCasa(ip);
    }
    public boolean contruirHotel(int ip){
        return jugadores.get(indiceJugadorActual).construirHotel(ip);
    }
    
    public boolean finalDelJuego(){
        for(int i=0; i<jugadores.size(); i++){
            if(jugadores.get(i).enBancarrota()) return true;
        }
        return false;
    }
    
    class SortSaldo implements Comparator<Jugador>{
        @Override
        public int compare(Jugador Jugador1,Jugador Jugador2){
            return Jugador1.compareTo(Jugador2);
        }
    }
    
    public ArrayList<Jugador> ranking(){
        Collections.sort(jugadores, new SortSaldo());
        return jugadores;
    }
    
    private void avanzaJugador(){
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        contabilizarPasosPorSalida();
        jugadorActual.moverACasiila(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
    }
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        GestorEstados gestado = new GestorEstados();
        OperacionJuego operacion = gestado.siguienteOperacion(jugadorActual, estado);
        if(operacion == OperacionJuego.PASAR_TURNO){
            pasarTurno();
            siguientePasoCompletado(operacion);
        }
        if(operacion == OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        return operacion;
    }
    
    public boolean comprar(){
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        CasillaCalle casilla = (CasillaCalle)tablero.getCasilla(numCasillaActual);
        return jugadorActual.comprar(casilla);
    }
    
    private void contabilizarPasosPorSalida(){
        if( tablero.computarPasoPorSalida() ){
            jugadores.get(indiceJugadorActual).pasaPorSalida();
        }
    }
    
    
    public boolean hacerCalleSocial(int ip){
        boolean result = false;
        int casillaActual;
        ArrayList<Casilla> casillas = new ArrayList<>();
        Casilla casilla;
        CasillaCalleSocial calleSocial;
        Jugador jugador;
        Tablero tablero = null;
        
        
        
        jugador = jugadores.get(indiceJugadorActual);
     
        calleSocial = jugador.hacerCalleSocial(ip);
        
        if(calleSocial!=null){
            casillaActual = jugador.getCasillaActual();
            result = true;
        }
        
        if(calleSocial!=null){
            casillaActual = jugador.getCasillaActual();
            casillas = tablero.getCasillas();
            casillas.set(casillaActual, calleSocial);
            
            result = true;
        }
        
        
        return result;
    }
    
   
    
}
