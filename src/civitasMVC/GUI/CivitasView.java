/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.GUI;

import civitasMVC.civitas.CivitasJuego;
import civitasMVC.civitas.OperacionInmobiliaria;
import civitasMVC.civitas.OperacionJuego;
import civitasMVC.controladorCivitas.Respuesta;
import civitasMVC.GUI.JugadorPanel;
import civitasMVC.GUI.DiarioDialog;
import civitasMVC.civitas.Dado;
import civitasMVC.civitas.Diario;
import javax.swing.JOptionPane;

/**
 *
 * @author esfabiani
 */
public class CivitasView extends javax.swing.JFrame implements Vista{
    
    CivitasJuego juego;
    
    public void setCivitasJuego(CivitasJuego juego){
        this.juego = juego;
        setVisible(true);
    }

    /**
     * Creates new form CivitasView
     */
    public CivitasView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jugadorPanel = new civitasMVC.GUI.JugadorPanel();
        CasillaActual = new javax.swing.JLabel();
        TextCasilla = new javax.swing.JTextField();
        SiguienteOperacion = new javax.swing.JLabel();
        TextSiguienteOperacion = new javax.swing.JTextField();
        Ranking = new javax.swing.JLabel();
        TextRanking = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo.setText("Civitas");

        CasillaActual.setText("Casilla Actual:");

        TextCasilla.setEditable(false);
        TextCasilla.setText("TextCasilla");

        SiguienteOperacion.setText("Siguiente operacion:");

        TextSiguienteOperacion.setEditable(false);
        TextSiguienteOperacion.setText("TextSiguienteOperacion");

        Ranking.setText("Ranking:");

        TextRanking.setEditable(false);
        TextRanking.setText("TextRanking");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(Titulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CasillaActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextCasilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SiguienteOperacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextSiguienteOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Ranking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Titulo)
                .addGap(29, 29, 29)
                .addComponent(jugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CasillaActual)
                    .addComponent(TextCasilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SiguienteOperacion)
                    .addComponent(TextSiguienteOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ranking)
                    .addComponent(TextRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CasillaActual;
    private javax.swing.JLabel Ranking;
    private javax.swing.JLabel SiguienteOperacion;
    private javax.swing.JTextField TextCasilla;
    private javax.swing.JTextField TextRanking;
    private javax.swing.JTextField TextSiguienteOperacion;
    private javax.swing.JLabel Titulo;
    private civitasMVC.GUI.JugadorPanel jugadorPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualiza() {
        Ranking.setVisible(false);
        TextRanking.setVisible(false);
        jugadorPanel.setJugador(juego.getJugadorActual());
        TextCasilla.setText(juego.getTablero().getCasilla(juego.getJugadorActual().getCasillaActual()).toString());
        
        if(juego.finalDelJuego()){
            Ranking.setVisible(true);
            TextRanking.setVisible(true);
            TextRanking.setText(juego.ranking().toString());
            repaint();
            revalidate();
        }
    }

    @Override
    public void pausa() {
        int val= JOptionPane.showConfirmDialog(null, "¿Continuar?", "Siguiente paso", JOptionPane.YES_NO_OPTION);
        
        if (val==1) System.exit(0);
    }

    @Override
    public Respuesta comprar() {
        int opcion= 1-JOptionPane.showConfirmDialog(null, "¿Quieres comprar la calle actual?", "Compra", JOptionPane.YES_NO_OPTION);
        if(opcion == 1) return Respuesta.SI;
        else return Respuesta.NO;
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        GestionarDialog gestionar = new GestionarDialog(this);
        if(gestionar.gestionElegida == 0) return OperacionInmobiliaria.CONSTRUIR_CASA;
        if(gestionar.gestionElegida == 1) return OperacionInmobiliaria.CONSTRUIR_HOTEL;
        else return OperacionInmobiliaria.TERMINAR;
    }

    @Override
    public int elegirPropiedad() {
        PropiedadDialog propiedad = new PropiedadDialog(this, juego.getJugadorActual());
        return propiedad.getPropiedad();
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operación) {
        TextSiguienteOperacion.setText(operación.toString());
        if(operación == OperacionJuego.AVANZAR){
            VistaDado.createInstance(this);
        }
        repaint();
    }

    @Override
    public void mostrarEventos() {
        if(!Diario.getInstance().getEventos().isEmpty()){
            new DiarioDialog(this);
        }
    }

    @Override
    public void mostrarEstado() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
