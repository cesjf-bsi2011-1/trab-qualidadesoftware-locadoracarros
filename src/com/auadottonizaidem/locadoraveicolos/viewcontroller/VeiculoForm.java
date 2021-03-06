/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.auadottonizaidem.locadoraveicolos.viewcontroller;
 
import com.auadottonizaidem.locadoraveicolos.model.Veiculo;
import com.auadottonizaidem.locadoraveiculo.utils.DBConnection;
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
        
        entityManager = DBConnection.getEntityManager();
        
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Cor");

        jLabel5.setText("Placa");

        try {
            formatedTextFielData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Data");

        jLabel1.setText("Nome");

        jLabel2.setText("Marca");

        jLabel3.setText("Cilindradas");

        buttonDeletar.setText("Deletar");
        buttonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletarActionPerformed(evt);
            }
        });

        buttonAtualizar.setText("Atualizar");
        buttonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(190, 190, 190)
                .addComponent(jLabel2)
                .addGap(137, 137, 137)
                .addComponent(jLabel3))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(textFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(textFieldCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addGap(115, 115, 115)
                .addComponent(jLabel5)
                .addGap(133, 133, 133)
                .addComponent(jLabel6))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(textFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(formatedTextFielData, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(buttonNovo)
                .addGap(12, 12, 12)
                .addComponent(buttonAtualizar)
                .addGap(8, 8, 8)
                .addComponent(buttonDeletar)
                .addGap(5, 5, 5)
                .addComponent(buttonCancelar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formatedTextFielData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonNovo)
                    .addComponent(buttonAtualizar)
                    .addComponent(buttonDeletar)
                    .addComponent(buttonCancelar)))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
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
