/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitasMVC.GUI;

import civitasMVC.civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;

/**
 *
 * @author esfabiani
 */
public class PropiedadDialog extends javax.swing.JDialog {

    int propiedadElegida;
    
    int getPropiedad(){
        return propiedadElegida;
    }
    
    /**
     * Creates new form PropiedadDialog
     */
    public PropiedadDialog(java.awt.Frame parent, Jugador jugadorActual) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        propiedadElegida = -1;
        
        DefaultListModel propiedades = new DefaultListModel<>();
        ArrayList<String> opciones = new ArrayList<> (Arrays.asList());
        for(int i=0; i < jugadorActual.getPropiedades().size(); i++){
            opciones.add(jugadorActual.getPropiedades().get(i).getNombre());
        }
        for(String S: opciones){
            propiedades.addElement(S);}
        ListaPropiedades.setModel(propiedades);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Propiedades = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaPropiedades = new javax.swing.JList<>();
        Seleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Propiedades.setText("Propiedades:");

        ListaPropiedades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListaPropiedades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaPropiedadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListaPropiedades);

        Seleccionar.setText("Seleccionar");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Seleccionar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Propiedades))
                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Propiedades)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Seleccionar)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaPropiedadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaPropiedadesMouseClicked
        propiedadElegida = ListaPropiedades.getSelectedIndex();
    }//GEN-LAST:event_ListaPropiedadesMouseClicked

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed
        dispose();
    }//GEN-LAST:event_SeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaPropiedades;
    private javax.swing.JLabel Propiedades;
    private javax.swing.JButton Seleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}