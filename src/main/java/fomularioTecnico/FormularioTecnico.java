/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomularioTecnico;

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
public class FormularioTecnico extends javax.swing.JFrame {

    private final ArrayList<ObjTecnico> lista = new ArrayList();
    private int contador=0;
    
    public FormularioTecnico() {
        initComponents();
        LeerArchivo();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTecnicos = new javax.swing.JTable();
        btnBuscarEsp = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnBuscarNom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TablaTecnicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombres", "Apellidos", "Direccion", "Telefono", "Correo", "Especialidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaTecnicos);

        btnBuscarEsp.setText("Buscar por Especialidad");
        btnBuscarEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEspActionPerformed(evt);
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

        btnBuscarNom.setText("Buscar por Nombre");
        btnBuscarNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarEsp)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnBuscarNom))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addComponent(btnRegistrar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnSalir)
                                .addComponent(btnEliminar)))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnBuscarEsp)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarNom)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(49, 49, 49)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        VentanaRegistro vr = new VentanaRegistro(this,true);
        vr.setLocationRelativeTo(null);
        vr.setVisible(true);
        
        if(vr.getEstado()){
            ObjTecnico tec = new ObjTecnico();
            tec.setCodigo(vr.getCodigo());
            tec.setNombres(vr.getNombres());
            tec.setApellidos(vr.getApellidos());
            tec.setDireccion(vr.getDireccion());
            tec.setTelefono(vr.getTelefono());
            tec.setCorreo(vr.getCorreo());
            tec.setEspecialidad(vr.getEspecialidad());
            lista.add(tec);
            ActualizarTabla();
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        GuardarDatosTabla();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = TablaTecnicos.getSelectedRow();
        int columna = TablaTecnicos.getSelectedColumn();
        if(fila>=0){
            String nuevo = JOptionPane.showInputDialog(this, "Ingrese el nuevo valor");
            if(!nuevo.isEmpty()){
                switch(columna){
                    case 0 : lista.get(fila).setCodigo(nuevo);break;
                    case 1 : lista.get(fila).setNombres(nuevo);break;
                    case 2 : lista.get(fila).setApellidos(nuevo);break;
                    case 3 : lista.get(fila).setDireccion(nuevo);break;
                    case 4 : lista.get(fila).setTelefono(nuevo);break;
                    case 5 : lista.get(fila).setCorreo(nuevo);break;
                    case 6 : lista.get(fila).setEspecialidad(nuevo);break;
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor ingresa datos para modificar.","Alerta",JOptionPane.ERROR_MESSAGE);
            } ActualizarTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Por favor ingresa datos para modificar.","Alerta",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         int fila = TablaTecnicos.getSelectedRow();
         if(fila>=0){
             int opcion = JOptionPane.showConfirmDialog(this, "¿Estas realmente seguro de eliminar el tecnico?","Eliminar tecnico",JOptionPane.YES_NO_OPTION);
             if(opcion==0){
                 lista.remove(fila);
                 ActualizarTabla();
             }
         }else{
             JOptionPane.showMessageDialog(this, "Por favor selecciona una fila.", "Alerta", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEspActionPerformed
        String busqueda = JOptionPane.showInputDialog(this, "Ingrese la especialidad para realizar la busqueda.");
        if(!busqueda.isEmpty()){
            TablaTecnicos.clearSelection();
            for (int i = 0; i <=TablaTecnicos.getRowCount(); i++) {
                if (TablaTecnicos.getValueAt(i,6).equals(busqueda)) {
                    TablaTecnicos.requestFocus();
                    TablaTecnicos.changeSelection(i, 6, false, false);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Por favor ingresa un dato");
        }
    }//GEN-LAST:event_btnBuscarEspActionPerformed

    private void btnBuscarNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNomActionPerformed
        String busqueda = JOptionPane.showInputDialog(this, "Ingrese el nombre para realizar la busqueda.");
        if(!busqueda.isEmpty()){
            TablaTecnicos.clearSelection();
            for (int i = 0; i <=TablaTecnicos.getRowCount(); i++) {
                if (TablaTecnicos.getValueAt(i,1).equals(busqueda)) {
                    TablaTecnicos.requestFocus();
                    TablaTecnicos.changeSelection(i, 1, false, false);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Por favor ingresa un dato");
        }
    }//GEN-LAST:event_btnBuscarNomActionPerformed

   
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
            java.util.logging.Logger.getLogger(FormularioTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioTecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaTecnicos;
    private javax.swing.JButton btnBuscarEsp;
    private javax.swing.JButton btnBuscarNom;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void LeerArchivo(){
        File file = new File("Tecnico.txt");
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*,\\s*");
                ObjTecnico tec = new ObjTecnico();
                tec.setCodigo(delimitar.next());
                tec.setNombres(delimitar.next());
                tec.setApellidos(delimitar.next());
                tec.setDireccion(delimitar.next());
                tec.setTelefono(delimitar.next());
                tec.setCorreo(delimitar.next());
                tec.setEspecialidad(delimitar.next());
                lista.add(tec);
            }
            scanner.close();
            ActualizarTabla();
        }catch(FileNotFoundException e){
            System.out.println("Error " +e.getMessage());
        }
    }
    
    private void ActualizarTabla(){
        DefaultTableModel dtm = (DefaultTableModel) TablaTecnicos.getModel();
        Object NuevaFila[] = {null,null,null,null,null,null,null};
        //Limpiar tabla para luego llenarla de nuevo
        for (int b = (contador-1); b >=0; b--) {
            dtm.removeRow(b);
        }
        contador = 0;
        //LLenado de la tabla
        ObjTecnico Osrv;
        for(Object obj:lista){
            Osrv=(ObjTecnico)obj;
            dtm.addRow(NuevaFila);
            TablaTecnicos.setValueAt(Osrv.getCodigo(),contador,0);
            TablaTecnicos.setValueAt(Osrv.getNombres(),contador,1);
            TablaTecnicos.setValueAt(Osrv.getApellidos(),contador,2);
            TablaTecnicos.setValueAt(Osrv.getDireccion(),contador,3);
            TablaTecnicos.setValueAt(Osrv.getTelefono(),contador,4);
            TablaTecnicos.setValueAt(Osrv.getCorreo(),contador,5);
            TablaTecnicos.setValueAt(Osrv.getEspecialidad(),contador,6);
            
            contador++;
        }
    }
    
    private void GuardarDatosTabla(){
        try{
            FileWriter fw=new FileWriter("Tecnico.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            ObjTecnico tec;
            for(Object obj:lista){
                tec = (ObjTecnico) obj;
                bw.write(tec.getCodigo()+","+tec.getNombres()+","+tec.getApellidos()+","+tec.getDireccion()+","+tec.getTelefono()+","+tec.getCorreo()+","+tec.getEspecialidad()+"\n");
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            System.out.println("Error "+e.getMessage());
            
        }
    }
    
}
