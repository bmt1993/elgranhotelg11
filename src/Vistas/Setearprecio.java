/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.reserva;
import accesoadatos.reservadata;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bmt
 */
public class Setearprecio extends javax.swing.JInternalFrame {

    private DefaultTableModel modelotabla = new DefaultTableModel();
    private int dni;
    
    public Setearprecio(int dni) {
        initComponents();
        armarcabecera();
        this.dni=dni;
        llenarcampos(this.dni);
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
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton1.setText("Setear montos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione una reserva:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       reservadata resdd = new reservadata();
        boolean exception;
        boolean exception2=false;
        String montobases;
        String montofinals;
        
        double montobase;
        double montofinal;
        
        montobases=JOptionPane.showInputDialog("Ingresar el monto base");
        do{
            if(montobases!=null){
                exception=false;
         
                try{
                    montobase=Double.parseDouble(montobases);
                    exception2=true;
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Debe ingresar un valor numérico. Utilice el punto '.' como separador decimal.");
                    exception=true;
                    montobases=JOptionPane.showInputDialog("Ingresar el monto base");                }
            }else{
                exception=false;
               exception2=false;

            }
            
        }while(exception==true);
        
        
        
        if(exception2==true){
        montofinals=JOptionPane.showInputDialog("Ingresar el monto adicional");
        do{
            
            if(montofinals!=null){
                exception=false;
                try{
                    montofinal=Double.parseDouble(montofinals);
                    montobase=Double.parseDouble(montobases);
                    
                      
                      
                      
                      
        resdd.setearmontos(montobase, montofinal,(Integer) jTable1.getValueAt(jTable1.getSelectedRow(),3));
        
        
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Debe ingresar un valor numérico. Utilice el punto '.' como separador decimal.");
                    exception=true;
                    montofinals=JOptionPane.showInputDialog("Ingresar el monto adicional");                }
            }else{
                exception=false;
            }
            
            
        }while(exception==true);
        
              
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


    private void armarcabecera(){
        
        modelotabla.addColumn("ID habitacion");
      
        modelotabla.addColumn("Fecha checkin");
        modelotabla.addColumn("Fecha checkout");
        modelotabla.addColumn("ID reserva");
        jTable1.setModel(modelotabla);
    }



    
    private void llenarcampos(int dni){
        
        ArrayList<reserva> reservas=new ArrayList();
        reservadata reserv = new reservadata();
        
        
        reservas= reserv.buscarreservadni(dni);
        
        Object[] vector = new Object[4];
        
        for(int i=0;i<=reservas.size()-1;i++){
            
            vector[0]=reservas.get(i).getHabitacion().getIdhabitacion();
            vector[1]=reservas.get(i).getCheckin();
            vector[2]=reservas.get(i).getCheckout();
            vector[3]=reservas.get(i).getIdreserva();
            
            modelotabla.addRow(vector);
            
            
        }
        
        
        
        
        
        
        
        
    }


}
