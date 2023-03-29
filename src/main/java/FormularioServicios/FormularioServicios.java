/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormularioServicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lol_B
 */
public class FormularioServicios extends javax.swing.JFrame {

    private final ArrayList<ObjServicio> lista = new ArrayList();
    private int contador=0;
    
    public FormularioServicios() {
        initComponents();
        LeerArchivo();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaServicios = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaServicios);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnBuscar)
                        .addGap(32, 32, 32)
                        .addComponent(btnRegistrar)
                        .addGap(29, 29, 29)
                        .addComponent(btnModificar)
                        .addGap(34, 34, 34)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        VentanaRegistro vr = new VentanaRegistro(this,true);
        vr.setLocationRelativeTo(null);
        vr.setVisible(true);
        
        if(vr.getEstado()){
            ObjServicio serv = new ObjServicio();
            serv.setCodigo(vr.getCodigo());
            serv.setNombre(vr.getNombre());
            serv.setDescripcion(vr.getDescripcion());
            serv.setPrecio(vr.getPrecio());
            lista.add(serv);
            ActualizarTabla();
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        GuardarDatosTabla();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = TablaServicios.getSelectedRow();
        int columna = TablaServicios.getSelectedColumn();
        if(fila>=0){
            String nuevo = JOptionPane.showInputDialog(this, "Ingrese el nuevo valor");
            if(!nuevo.isEmpty()){
                switch(columna){
                    case 0 : lista.get(fila).setCodigo(nuevo);break;
                    case 1 : lista.get(fila).setNombre(nuevo);break;
                    case 2 : lista.get(fila).setDescripcion(nuevo);break;
                    case 3 : lista.get(fila).setPrecio(nuevo);break;
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor ingresa datos para modificar.","Alerta",JOptionPane.ERROR_MESSAGE);
            } ActualizarTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Por favor ingresa datos para modificar.","Alerta",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         int fila = TablaServicios.getSelectedRow();
         if(fila>=0){
             int opcion = JOptionPane.showConfirmDialog(this, "¿Estas realmente seguro de eliminar el servicio?","Eliminar Servicio",JOptionPane.YES_NO_OPTION);
             if(opcion==0){
                 lista.remove(fila);
                 ActualizarTabla();
             }
         }else{
             JOptionPane.showMessageDialog(this, "Por favor selecciona una fila.", "Alerta", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String busqueda = JOptionPane.showInputDialog(this, "Ingrese el CODIGO para realizar la busqueda.");
        if(!busqueda.isEmpty()){
            TablaServicios.clearSelection();
            for (int i = 0; i <=TablaServicios.getRowCount(); i++) {
                if (TablaServicios.getValueAt(i,0).equals(busqueda)) {
                    TablaServicios.requestFocus();
                    TablaServicios.changeSelection(i, 0, false, false);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Por favor ingresa un dato");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

   
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
            java.util.logging.Logger.getLogger(FormularioServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioServicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaServicios;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void LeerArchivo(){
        File file = new File("servicios.txt");
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*,\\s*");
                ObjServicio srv = new ObjServicio();
                srv.setCodigo(delimitar.next());
                srv.setNombre(delimitar.next());
                srv.setDescripcion(delimitar.next());
                srv.setPrecio(delimitar.next());
                lista.add(srv);
            }
            scanner.close();
            ActualizarTabla();
        }catch(FileNotFoundException e){
            System.out.println("Error " +e.getMessage());
        }
    }
    
    private void ActualizarTabla(){
        DefaultTableModel dtm = (DefaultTableModel) TablaServicios.getModel();
        Object NuevaFila[] = {null,null,null,null};
        //Limpiar tabla para luego llenarla de nuevo
        for (int b = (contador-1); b >=0; b--) {
            dtm.removeRow(b);
        }
        contador = 0;
        //LLenado de la tabla
        ObjServicio Osrv;
        for(Object obj:lista){
            Osrv=(ObjServicio)obj;
            dtm.addRow(NuevaFila);
            TablaServicios.setValueAt(Osrv.getCodigo(),contador,0);
            TablaServicios.setValueAt(Osrv.getNombre(),contador,1);
            TablaServicios.setValueAt(Osrv.getDescripcion(),contador,2);
            TablaServicios.setValueAt(Osrv.getPrecio(),contador,3);
            contador++;
        }
    }
    
    private void GuardarDatosTabla(){
        try{
            FileWriter fw=new FileWriter("servicios.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            ObjServicio servc;
            for(Object obj:lista){
                servc = (ObjServicio) obj;
                bw.write(servc.getCodigo()+","+servc.getNombre()+","+servc.getDescripcion()+","+servc.getPrecio()+"\n");
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            System.out.println("Error "+e.getMessage());
            
        }
    }
    
}
