/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;

/**
 *
 * @author esfabiani
 */
public class JugadorEspeculador extends Jugador{
    protected static int FactorEspeculador = 2;
    
    protected JugadorEspeculador(Jugador otro) {
        super(otro);
        super.actualizaPropiedadesPorConversion(this);
    }
    
    @Override
    boolean paga(float cantidad){
        float cantidadEspeculador = cantidad/2;
        return super.paga(cantidadEspeculador);
    }
    
    
    @Override
    protected int getCasasMax(){
        return CasasMax * FactorEspeculador;
    }
    
    @Override
    protected int getHotelesMax(){
        return HotelesMax * FactorEspeculador;
    }
    
    @Override
    public boolean esEspeculador(){
        return true;
    }
    
    //Funcion extra para comprobar el funcionamiento de JugadorEspeculador
    protected void cambiarNombre(){
        nombre = nombre+" Especulador";
    }
}
