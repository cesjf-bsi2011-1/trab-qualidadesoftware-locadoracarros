/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.auadottonizaidem.locadoraveicolos.viewcontroller;

import com.auadottonizaidem.locadoraveicolos.model.Veiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author auadtassio
 */
public class VeiculoForm extends javax.swing.JFrame {

    private EntityManager entityManager;
    
    /**
     * Creates new form InsertVeiculoForm
     */
    public VeiculoForm() {
        initComponents();
        EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("LocadoraVeiculosPU");
        
        entityManager = entityManagerFactory.createEntityManager();
        
        buttonAtualizar.setEnabled(false);
        buttonDeletar.setEnabled(false);
        
        Query query = entityManager.createNamedQuery("Veiculo.findAll");
        List<Veiculo> veiculos = query.getResultList();
        
        tableVeiculos.clearSelection();
        tableVeiculos.removeAll();

        DefaultTableModel tm = (DefaultTableModel) tableVeiculos.getModel();
        tm.getDataVector().removeAllElements();
        
        for (Veiculo veiculo : veiculos) {
            Date data = new Date(veiculo.getDataFabricacao());
            
            tm.addRow(new Object[]{
                veiculo.getId(),
                veiculo.getNome(),
                veiculo.getMarca(),
                veiculo.getCilindrada(),
                veiculo.getCor(),
                veiculo.getPlaca(),
                new SimpleDateFormat("dd/MM/yyyy").format(data)
            });
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonNovo = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldPlaca = new javax.swing.JTextField();
        formatedTextFielData = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        textFieldMarca = new javax.swing.JTextField();
        textFieldCilindrada = new javax.swing.JTextField();
        textFieldCor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonDeletar = new javax.swing.JButton();
        buttonAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });
        jPanel1.add(buttonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, -1, -1));

        jLabel4.setText("Cor");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel5.setText("Placa");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));
        jPanel1.add(textFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 111, 156, -1));

        try {
            formatedTextFielData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(formatedTextFielData, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 133, -1));

        jLabel6.setText("Data");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));
        jPanel1.add(textFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 52, 223, -1));
        jPanel1.add(textFieldMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 174, -1));
        jPanel1.add(textFieldCilindrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 92, -1));
        jPanel1.add(textFieldCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 111, 125, -1));

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 29, -1, -1));

        jLabel2.setText("Marca");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel3.setText("Cilindradas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        buttonDeletar.setText("Deletar");
        buttonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        buttonAtualizar.setText("Atualizar");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(buttonAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 180));

        tableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Marca", "Cilindrada", "Cor", "Placa", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableVeiculosMouseReleased(evt);
            }
        });
        tableVeiculos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableVeiculosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableVeiculos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 550, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        buttonCancelar.setEnabled(true);
        buttonNovo.setEnabled(true);
        buttonAtualizar.setEnabled(false);
        buttonDeletar.setEnabled(false);
            
        textFieldCilindrada.setText("");
        textFieldCor.setText("");
        textFieldMarca.setText("");
        textFieldPlaca.setText("");
        textFieldNome.setText("");
        formatedTextFielData.setText("");
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        Veiculo veiculo = new Veiculo();
        veiculo.setNome(textFieldNome.getText());
        veiculo.setMarca(textFieldMarca.getText());
        veiculo.setCilindrada(textFieldCilindrada.getText());
        veiculo.setCor(textFieldCor.getText());
        veiculo.setPlaca(textFieldPlaca.getText());
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = format.parse(formatedTextFielData.getText());
        } catch (ParseException ex) {
            Logger.getLogger(VeiculoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        veiculo.setDataFabricacao(data.getTime());
        
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(veiculo);
            entityManager.getTransaction().commit();
            
            textFieldCilindrada.setText("");
            textFieldCor.setText("");
            textFieldMarca.setText("");
            textFieldPlaca.setText("");
            textFieldNome.setText("");
            formatedTextFielData.setText("");
        
            Query query = entityManager.createNamedQuery("Veiculo.findAll");
            List<Veiculo> veiculos = query.getResultList();

            tableVeiculos.clearSelection();
            tableVeiculos.removeAll();

            DefaultTableModel tm = (DefaultTableModel) tableVeiculos.getModel();
            tm.getDataVector().removeAllElements();

            for (Veiculo v : veiculos) {
                Date d = new Date(v.getDataFabricacao());

                tm.addRow(new Object[]{
                    v.getId(),
                    v.getNome(),
                    v.getMarca(),
                    v.getCilindrada(),
                    v.getCor(),
                    v.getPlaca(),
                    new SimpleDateFormat("dd/MM/yyyy").format(d)
                });
            }
            
            buttonCancelar.setEnabled(true);
            buttonNovo.setEnabled(true);
            buttonAtualizar.setEnabled(false);
            buttonDeletar.setEnabled(false);
        
        }catch(Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }//GEN-LAST:event_buttonNovoActionPerformed

    private void tableVeiculosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVeiculosMouseReleased
        buttonCancelar.setEnabled(true);
        buttonNovo.setEnabled(false);
        buttonAtualizar.setEnabled(true);
        buttonDeletar.setEnabled(true);
        
        int linha = tableVeiculos.getSelectedRow();
        if (linha < 0) {
            return;
        }
        DefaultTableModel tm;
        tm = (DefaultTableModel) tableVeiculos.getModel();
        textFieldNome.setText(String.valueOf(tm.getValueAt(linha, 1)));
        textFieldMarca.setText((String) tm.getValueAt(linha, 2));
        textFieldCilindrada.setText((String) tm.getValueAt(linha, 3));
        textFieldCor.setText((String) tm.getValueAt(linha, 4));
        textFieldPlaca.setText((String) tm.getValueAt(linha, 5));
        formatedTextFielData.setText((String) tm.getValueAt(linha, 6));
       
    }//GEN-LAST:event_tableVeiculosMouseReleased

    private void tableVeiculosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableVeiculosKeyReleased
        buttonCancelar.setEnabled(true);
        buttonNovo.setEnabled(false);
        buttonAtualizar.setEnabled(true);
        buttonDeletar.setEnabled(true);
            
        int linha = tableVeiculos.getSelectedRow();
        if (linha < 0) {
            return;
        }
        
        DefaultTableModel tm;
        tm = (DefaultTableModel) tableVeiculos.getModel();
        textFieldNome.setText((String) tm.getValueAt(linha, 1));
        textFieldMarca.setText((String) tm.getValueAt(linha, 2));
        textFieldCilindrada.setText((String) tm.getValueAt(linha, 3));
        textFieldCor.setText((String) tm.getValueAt(linha, 4));
        textFieldPlaca.setText((String) tm.getValueAt(linha, 5));
        formatedTextFielData.setText((String) tm.getValueAt(linha, 6));
    }//GEN-LAST:event_tableVeiculosKeyReleased

    private void buttonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarActionPerformed
        int linha = tableVeiculos.getSelectedRow();
        DefaultTableModel tm = (DefaultTableModel) tableVeiculos.getModel();
        int idVeiculo = (int) tm.getValueAt(linha, 0);
        
        try {
            entityManager.getTransaction().begin();
            Veiculo veiculo = entityManager.find(Veiculo.class, idVeiculo);
            veiculo.setNome(textFieldNome.getText());
            veiculo.setMarca(textFieldMarca.getText());
            veiculo.setCilindrada(textFieldCilindrada.getText());
            veiculo.setCor(textFieldCor.getText());
            veiculo.setPlaca(textFieldPlaca.getText());

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date data = null;
            try {
                data = format.parse(formatedTextFielData.getText());
            } catch (ParseException ex) {
                Logger.getLogger(VeiculoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            veiculo.setDataFabricacao(data.getTime());
            entityManager.getTransaction().commit();
            
            tableVeiculos.clearSelection();
            tableVeiculos.removeAll();

            tm.getDataVector().removeAllElements();
            
            Query query = entityManager.createNamedQuery("Veiculo.findAll");
            List<Veiculo> veiculos = query.getResultList();
            for (Veiculo v : veiculos) {
                Date d = new Date(v.getDataFabricacao());

                tm.addRow(new Object[]{
                    v.getId(),
                    v.getNome(),
                    v.getMarca(),
                    v.getCilindrada(),
                    v.getCor(),
                    v.getPlaca(),
                    new SimpleDateFormat("dd/MM/yyyy").format(d)
                });
            }
            
            buttonCancelar.setEnabled(true);
            buttonNovo.setEnabled(true);
            buttonAtualizar.setEnabled(false);
            buttonDeletar.setEnabled(false);
            
            textFieldCilindrada.setText("");
            textFieldCor.setText("");
            textFieldMarca.setText("");
            textFieldPlaca.setText("");
            textFieldNome.setText("");
            formatedTextFielData.setText("");
        } catch(Exception e) {
            entityManager.getTransaction().rollback();
        }
    }//GEN-LAST:event_buttonAtualizarActionPerformed

    private void buttonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletarActionPerformed
        int linha = tableVeiculos.getSelectedRow();
        DefaultTableModel tm = (DefaultTableModel) tableVeiculos.getModel();
        int idVeiculo = (int) tm.getValueAt(linha, 0);
        Veiculo veiculo = entityManager.find(Veiculo.class, idVeiculo);
        
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(veiculo);
            entityManager.getTransaction().commit();
            
            tableVeiculos.clearSelection();
            tableVeiculos.removeAll();

            tm.getDataVector().removeAllElements();

            Query query = entityManager.createNamedQuery("Veiculo.findAll");
            List<Veiculo> veiculos = query.getResultList();
            for (Veiculo v : veiculos) {
                Date d = new Date(v.getDataFabricacao());

                tm.addRow(new Object[]{
                    v.getId(),
                    v.getNome(),
                    v.getMarca(),
                    v.getCilindrada(),
                    v.getCor(),
                    v.getPlaca(),
                    new SimpleDateFormat("dd/MM/yyyy").format(d)
                });
            }
            
            buttonCancelar.setEnabled(true);
            buttonNovo.setEnabled(true);
            buttonAtualizar.setEnabled(false);
            buttonDeletar.setEnabled(false);
            
            textFieldCilindrada.setText("");
            textFieldCor.setText("");
            textFieldMarca.setText("");
            textFieldPlaca.setText("");
            textFieldNome.setText("");
            formatedTextFielData.setText("");
        } catch(Exception e) {
            entityManager.getTransaction().rollback();
        }
    }//GEN-LAST:event_buttonDeletarActionPerformed

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
            java.util.logging.Logger.getLogger(VeiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VeiculoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAtualizar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonDeletar;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JFormattedTextField formatedTextFielData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableVeiculos;
    private javax.swing.JTextField textFieldCilindrada;
    private javax.swing.JTextField textFieldCor;
    private javax.swing.JTextField textFieldMarca;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldPlaca;
    // End of variables declaration//GEN-END:variables
}
