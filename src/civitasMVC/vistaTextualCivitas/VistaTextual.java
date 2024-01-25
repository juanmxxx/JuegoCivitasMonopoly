package civitasMVC.vistaTextualCivitas;

import civitasMVC.civitas.Casilla;
import civitasMVC.civitas.CivitasJuego;
import civitasMVC.civitas.Diario;
import civitasMVC.civitas.OperacionJuego;
import civitasMVC.controladorCivitas.Respuesta;
import civitasMVC.civitas.OperacionInmobiliaria;
import civitasMVC.civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  public void actualiza(){
      
  }
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }
  
  public Respuesta comprar(){
      String titulo = "Desea comprar la casilla?";
      ArrayList<String> lista = new ArrayList<>();
      for(int i=0; i<Respuesta.values().length; i++){
          lista.add(Respuesta.values()[i].toString());
      }
      int menuComprar = menu(titulo, lista);
      Respuesta respuesta = Respuesta.values()[menuComprar];
      return respuesta;
  }
  
  public OperacionInmobiliaria elegirOperacion(){
      String titulo = "Que gestion inmobiliaria desea?";
      ArrayList<String> lista = new ArrayList<>();
      for(int i=0; i<Respuesta.values().length; i++){
          lista.add(Respuesta.values()[i].toString());
      }
      int menuComprar = menu(titulo, lista);
      OperacionInmobiliaria operacion = OperacionInmobiliaria.values()[menuComprar];
      return operacion;
  }
  
  public int elegirPropiedad(){
      String titulo = "Que propiedad desea?";
      ArrayList<String> lista = new ArrayList<>();
      for(int i=0; i<juegoModel.getJugadorActual().getPropiedades().size(); i++){
          lista.add(juegoModel.getJugadorActual().getPropiedades().get(i).toString());
      }
      int menuPropiedad = menu(titulo, lista);
      return menuPropiedad;
  }
  
  public void mostrarSiguienteOperacion(OperacionJuego operacion){
      System.out.println("\n"+operacion.toString());
  }
  
  public void mostrarEventos(){
      while(Diario.getInstance().eventosPendientes()){
          System.out.println("\n"+Diario.getInstance().leerEvento());
      }
  }
  
  public void mostrarEstado(){
      if(!juegoModel.finalDelJuego()){
          System.out.println(juegoModel.getJugadorActual().toString());
      }
      else{
          System.out.println(juegoModel.getJugadores().toString());
      }
  }

    

}
