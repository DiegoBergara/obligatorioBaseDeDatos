/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Data.Classes.RutaRaw;
import Data.Classes.Ubicacion;
import Data.Classes.Usuario;
import Data.Classes.Viaje;
import DataBase.Queries.*;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JFrame;

/**
 *
 * @author Faivel
 */
public class PublicarViaje extends javax.swing.JFrame {
    JFrame parentFrame;
    Usuario user;
    /**
     * Creates new form PublicarViaje
     */
    public PublicarViaje(JFrame parent, Usuario user) {
        this.parentFrame = parent;
        this.user = user;
        initComponents();
        this.setVisible(true);
        
        cbgrupo.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        porigen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ocalle = new javax.swing.JTextField();
        nporigen = new javax.swing.JTextField();
        pdestino = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dcalle = new javax.swing.JTextField();
        npdestino = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        txthora = new javax.swing.JTextField();
        txtvacantes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        chkvisibility = new javax.swing.JCheckBox();
        cbgrupo = new javax.swing.JComboBox<>();
        lblGrupo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        porigen.setBorder(javax.swing.BorderFactory.createTitledBorder("Origen"));

        jLabel2.setText("Calle");

        jLabel3.setText("Numero de Puerta");

        javax.swing.GroupLayout porigenLayout = new javax.swing.GroupLayout(porigen);
        porigen.setLayout(porigenLayout);
        porigenLayout.setHorizontalGroup(
            porigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(porigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(porigenLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, porigenLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(porigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nporigen, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(ocalle))
                .addGap(4, 4, 4))
        );
        porigenLayout.setVerticalGroup(
            porigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porigenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(porigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(porigenLayout.createSequentialGroup()
                        .addComponent(ocalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(porigenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nporigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(porigenLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ocalle.getAccessibleContext().setAccessibleParent(this);
        nporigen.getAccessibleContext().setAccessibleParent(this);

        pdestino.setBorder(javax.swing.BorderFactory.createTitledBorder("Destino"));

        jLabel5.setText("Calle");

        jLabel6.setText("Numero de Puerta");

        npdestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npdestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pdestinoLayout = new javax.swing.GroupLayout(pdestino);
        pdestino.setLayout(pdestinoLayout);
        pdestinoLayout.setHorizontalGroup(
            pdestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdestinoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pdestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pdestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(npdestino)
                    .addComponent(dcalle, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );
        pdestinoLayout.setVerticalGroup(
            pdestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pdestinoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pdestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dcalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pdestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(npdestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dcalle.getAccessibleContext().setAccessibleParent(this);
        npdestino.getAccessibleContext().setAccessibleParent(this);

        jLabel1.setText("Fecha");

        jLabel4.setText("Hola");

        txtfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaActionPerformed(evt);
            }
        });

        jLabel7.setText("Cantidad de Pasajeros");

        jButton2.setText("PUBLICAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        chkvisibility.setText("Mostrar unicamente a un grupo?");
        chkvisibility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkvisibilityActionPerformed(evt);
            }
        });

        cbgrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblGrupo.setText("Grupo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(porigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pdestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(96, 96, 96)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel1)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtvacantes, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(jLabel4)
                                        .addGap(24, 24, 24)
                                        .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblGrupo)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(chkvisibility))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pdestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(porigen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtvacantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkvisibility))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbgrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.parentFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void npdestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npdestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npdestinoActionPerformed

    private void txtfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ConsultasUbicaciones con_ubic = new ConsultasUbicaciones();
        if (txtfecha.getText().length() != 0 &&
                txthora.getText().length() != 0 &&
                txtvacantes.getText().length() != 0 &&
                ocalle.getText().length() != 0 &&
                dcalle.getText().length() != 0 &&
                nporigen.getText().length() != 0 &&
                npdestino.getText().length() != 0){
                
            Ubicacion origen = con_ubic.buscarUbicacion(ocalle.getText(), Integer.parseInt(nporigen.getText()));
            Ubicacion destino = con_ubic.buscarUbicacion(dcalle.getText(), Integer.parseInt(npdestino.getText()));
            if(origen == null){
                origen = con_ubic.insertar( new Ubicacion(ocalle.getText(), Integer.parseInt(nporigen.getText())));
            }
            if(destino == null){
                destino = con_ubic.insertar( new Ubicacion(dcalle.getText(), Integer.parseInt(npdestino.getText())));
            }
            
            ConsultasRutas con_ruta = new ConsultasRutas();
            RutaRaw ruta = con_ruta.buscarRuta(origen.idUbicacion, destino.idUbicacion);
            
            if(ruta == null){
                ruta = con_ruta.insertar(new RutaRaw(origen.idUbicacion, destino.idUbicacion));
            }
            
            ConsultasViajes con_viaje = new ConsultasViajes();
            int group = chkvisibility.isSelected()?Integer.parseInt((String)cbgrupo.getSelectedItem()):0;
            int viaje = con_viaje.insertar(new Viaje(ruta.idRuta,user.mail,1,Time.valueOf(txthora.getText()),Date.valueOf(txtfecha.getText()), Integer.parseInt(txtvacantes.getText())), chkvisibility.isSelected()?1:0, group);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void chkvisibilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkvisibilityActionPerformed
       ConsultasUsuarios con_user = new ConsultasUsuarios();
        if(chkvisibility.isSelected()){
            lblGrupo.setVisible(true);
            cbgrupo.setVisible(true);
            cbgrupo.removeAllItems();
            
            java.util.List<Integer> grupos = con_user.getUserGroups(user.mail);
            if (grupos != null){
            for (Integer group : grupos) {
		cbgrupo.addItem(String.valueOf(group));
            }
        }
            
        }else{
            lblGrupo.setVisible(false);
            cbgrupo.setVisible(false);
        }
    }//GEN-LAST:event_chkvisibilityActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PublicarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PublicarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PublicarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PublicarViaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PublicarViaje().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbgrupo;
    private javax.swing.JCheckBox chkvisibility;
    private javax.swing.JTextField dcalle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JTextField npdestino;
    private javax.swing.JTextField nporigen;
    private javax.swing.JTextField ocalle;
    private javax.swing.JPanel pdestino;
    private javax.swing.JPanel porigen;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txthora;
    private javax.swing.JTextField txtvacantes;
    // End of variables declaration//GEN-END:variables
}
