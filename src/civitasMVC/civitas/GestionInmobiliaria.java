/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.civitas;

/**
 *
 * @author Enrique Santolaya Fabiani
 * @author Juan Manuel Sujar Gonzalez
 */
public class GestionInmobiliaria {
    int propiedad;
    OperacionInmobiliaria operacion;
    
    public GestionInmobiliaria(OperacionInmobiliaria gets, int ip){
        propiedad = ip;
        operacion = gets;
    }
    
    public OperacionInmobiliaria getOperacion(){
        return operacion;
    }
    
    public int getPropiedad(){
        return propiedad;
    }
}
