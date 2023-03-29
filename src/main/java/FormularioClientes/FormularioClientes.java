/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormularioClientes;

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
public class FormularioClientes extends javax.swing.JFrame {

    private final ArrayList<ObjCliente> lista = new ArrayList();
    private int contador=0;
    
    public FormularioClientes() {
        initComponents();
        LeerArchivo();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombres", "Apellidos", "Direccion", "Distrito", "Correo", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaClientes);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap())
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
            ObjCliente Cli = new ObjCliente();
            Cli.setDni(vr.getDni());
            Cli.setNombres(vr.getNombres());
            Cli.setApellidos(vr.getApellidos());
            Cli.setDireccion(vr.getDireccion());
            Cli.setDistrito(vr.getDistrito());
            Cli.setCorreo(vr.getCorreo());
            Cli.setCelular(vr.getCelular());
            lista.add(Cli);
            ActualizarTabla();
        }
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        GuardarDatosTabla();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = TablaClientes.getSelectedRow();
        int columna = TablaClientes.getSelectedColumn();
        if(fila>=0){
            String nuevo = JOptionPane.showInputDialog(this, "Ingrese el nuevo valor");
            if(!nuevo.isEmpty()){
                switch(columna){
                    case 0 : lista.get(fila).setDni(nuevo);break;
                    case 1 : lista.get(fila).setNombres(nuevo);break;
                    case 2 : lista.get(fila).setApellidos(nuevo);break;
                    case 3 : lista.get(fila).setDireccion(nuevo);break;
                    case 4 : lista.get(fila).setDistrito(nuevo);break;
                    case 5 : lista.get(fila).setCorreo(nuevo);break;
                    case 6 : lista.get(fila).setCelular(nuevo);break;
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor ingresa datos para modificar.","Alerta",JOptionPane.ERROR_MESSAGE);
            } ActualizarTabla();
        }else{
            JOptionPane.showMessageDialog(this, "Por favor ingresa datos para modificar.","Alerta",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         int fila = TablaClientes.getSelectedRow();
         if(fila>=0){
             int opcion = JOptionPane.showConfirmDialog(this, "¿Estas realmente seguro de eliminar el cliente?","Eliminar Cliente",JOptionPane.YES_NO_OPTION);
             if(opcion==0){
                 lista.remove(fila);
                 ActualizarTabla();
             }
         }else{
             JOptionPane.showMessageDialog(this, "Por favor selecciona una fila.", "Alerta", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String busqueda = JOptionPane.showInputDialog(this, "Ingrese el numero de DNI para realizar la busqueda.");
        if(!busqueda.isEmpty()){
            TablaClientes.clearSelection();
            for (int i = 0; i <=TablaClientes.getRowCount(); i++) {
                if (TablaClientes.getValueAt(i,0).equals(busqueda)) {
                    TablaClientes.requestFocus();
                    TablaClientes.changeSelection(i, 0, false, false);
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
            java.util.logging.Logger.getLogger(FormularioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaClientes;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void LeerArchivo(){
        File file = new File("clientes.txt");
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*,\\s*");
                ObjCliente Cli = new ObjCliente();
                Cli.setDni(delimitar.next());
                Cli.setNombres(delimitar.next());
                Cli.setApellidos(delimitar.next());
                Cli.setDireccion(delimitar.next());
                Cli.setDistrito(delimitar.next());
                Cli.setCorreo(delimitar.next());
                Cli.setCelular(delimitar.next());
                lista.add(Cli);
            }
            scanner.close();
            ActualizarTabla();
        }catch(FileNotFoundException e){
            System.out.println("Error " +e.getMessage());
        }
    }
    
    private void ActualizarTabla(){
        DefaultTableModel dtm = (DefaultTableModel) TablaClientes.getModel();
        Object NuevaFila[] = {null,null,null,null,null,null,null};
        //Limpiar tabla para luego llenarla de nuevo
        for (int b = (contador-1); b >=0; b--) {
            dtm.removeRow(b);
        }
        contador = 0;
        //LLenado de la tabla
        ObjCliente Cli;
        for(Object obj:lista){
            Cli=(ObjCliente)obj;
            dtm.addRow(NuevaFila);
            TablaClientes.setValueAt(Cli.getDni(),contador,0);
            TablaClientes.setValueAt(Cli.getNombres(),contador,1);
            TablaClientes.setValueAt(Cli.getApellidos(),contador,2);
            TablaClientes.setValueAt(Cli.getDireccion(),contador,3);
            TablaClientes.setValueAt(Cli.getDistrito(),contador,4);
            TablaClientes.setValueAt(Cli.getCorreo(),contador,5);
            TablaClientes.setValueAt(Cli.getCelular(),contador,6);
            contador++;
        }
    }
    
    private void GuardarDatosTabla(){
        try{
            FileWriter fw=new FileWriter("clientes.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            ObjCliente cli;
            for(Object obj:lista){
                cli = (ObjCliente) obj;
                bw.write(cli.getDni()+","+cli.getNombres()+
                        ","+cli.getApellidos()+","+cli.getDireccion()+
                        ","+cli.getDistrito()+","+cli.getCorreo()+
                        ","+cli.getCelular()+"\n");
            }
            bw.close();
            fw.close();
        }catch(Exception e){
            System.out.println("Error "+e.getMessage());
            
        }
    }
    
}
