    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.auadottonizaidem.locadoraveicolos.viewcontroller;

import com.auadottonizaidem.locadoraveicolos.model.Cliente;
import com.auadottonizaidem.locadoraveicolos.model.Locacao;
import com.auadottonizaidem.locadoraveicolos.model.Veiculo;
import com.auadottonizaidem.locadoraveiculo.utils.DBConnection;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class LocacaoForm extends javax.swing.JFrame {

    private EntityManager entityManager;
    
    /**
     * Creates new form LocacaoForm
     */
    public LocacaoForm() {
        initComponents();
        buttonDevolucao.setEnabled(false);
        
        entityManager = DBConnection.getEntityManager();
        
        Query query = entityManager.createNamedQuery("Veiculo.findAll");
        List<Veiculo> veiculos = query.getResultList();
        
        for(Veiculo veiculo: veiculos) {
            cbVeiculo.addItem(veiculo);
        }
        
        query = entityManager.createNamedQuery("Cliente.findAll");
        List<Cliente> clientes = query.getResultList();
        
        for(Cliente cliente : clientes) {
            comboBoxCliente.addItem(cliente);
        }
        
        buttonDevolucao.setEnabled(false);
        
        query = entityManager.createNamedQuery("Locacao.findAllNaoDevolvido");
        List<Locacao> locacoes = query.getResultList();

        jTable1.clearSelection();
        jTable1.removeAll();

        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();            
        tm.getDataVector().removeAllElements();

        for (Locacao novaLocacao : locacoes) {
            Date dataLocacao = new Date(novaLocacao.getDataLocacao());
            Date dataDevolucao = new Date(novaLocacao.getDataDevolucao());

            tm.addRow(new Object[]{
                novaLocacao.getId(),
                novaLocacao.getVeiculoLocado().getNome(),
                novaLocacao.getClienteLocador().getNomeCompleto(),
                new SimpleDateFormat("dd/MM/yyyy").format(dataLocacao),
                new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao)
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
        labelCliente = new javax.swing.JLabel();
        labelVeiculo = new javax.swing.JLabel();
        comboBoxCliente = new javax.swing.JComboBox();
        cbVeiculo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        buttonDevolucao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Realizar Locação"));

        labelCliente.setText("Cliente");

        labelVeiculo.setText("Veiculo");

        jButton1.setText("Locar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelCliente)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(labelVeiculo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCliente)
                    .addComponent(comboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVeiculo)
                    .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        buttonDevolucao.setText("Devolver");
        buttonDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDevolucaoActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Veículos em Locação"));

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Veículo", "Cliente", "Data de Locação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonDevolucao)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonDevolucao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Veiculo veiSel = (Veiculo) cbVeiculo.getSelectedItem();
        Cliente c = (Cliente) comboBoxCliente.getSelectedItem();
        
        Locacao locacao = new Locacao();
        locacao.setClienteLocador(c);
        locacao.setVeiculoLocado(veiSel);
        locacao.setDataLocacao(new Date().getTime());
        locacao.setFuncionarioResponsavel(LoginForm.funcionarioLogado);
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(locacao);
            entityManager.getTransaction().commit();
            
            buttonDevolucao.setEnabled(false);
        
            Query query = entityManager.createNamedQuery("Locacao.findAllNaoDevolvido");
            List<Locacao> locacoes = query.getResultList();

            jTable1.clearSelection();
            jTable1.removeAll();

            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();            
            tm.getDataVector().removeAllElements();

            for (Locacao novaLocacao : locacoes) {
                Date dataLocacao = new Date(novaLocacao.getDataLocacao());
                Date dataDevolucao = new Date(novaLocacao.getDataDevolucao());

                tm.addRow(new Object[]{
                    novaLocacao.getId(),
                    novaLocacao.getVeiculoLocado().getNome(),
                    novaLocacao.getClienteLocador().getNomeCompleto(),
                    new SimpleDateFormat("dd/MM/yyyy").format(dataLocacao),
                    new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao)
                });
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDevolucaoActionPerformed
        try {
            int linha = jTable1.getSelectedRow();
            DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            int id = (int) tm.getValueAt(linha, 0);
            entityManager.getTransaction().begin();
            Locacao locacao = entityManager.find(Locacao.class, 1);
            locacao.setDataDevolucao(new Date().getTime());
            entityManager.getTransaction().commit();
            
            /**
             * Calculo da locação
             */
            int diaLocacao = Integer.parseInt(new SimpleDateFormat("dd")
                    .format(locacao.getDataLocacao()));
            int diaDevolucao = Integer.parseInt(new SimpleDateFormat("dd")
                    .format(locacao.getDataLocacao()));
            int mesLocacao = Integer.parseInt(new SimpleDateFormat("MM")
                    .format(locacao.getDataLocacao()));
            int mesDevolucao = Integer.parseInt(new SimpleDateFormat("MM")
                    .format(locacao.getDataLocacao()));
            
            int diasDeLocacao = diaDevolucao - diaLocacao;
            if(diasDeLocacao == 0) diasDeLocacao = 1;
            if(mesDevolucao != mesLocacao) {
                diasDeLocacao *= ((mesDevolucao - mesLocacao) * 30);
            }
            
            float valorLocacao = locacao.getVeiculoLocado().getPreco().floatValue() 
                    * diasDeLocacao;
            
            
            
            buttonDevolucao.setEnabled(false);
        
            Query query = entityManager.createNamedQuery("Locacao.findAllNaoDevolvido");
            List<Locacao> locacoes = query.getResultList();

            jTable1.clearSelection();
            jTable1.removeAll();

            tm.getDataVector().removeAllElements();

            for (Locacao novaLocacao : locacoes) {
                Date dataLocacao = new Date(novaLocacao.getDataLocacao());
                Date dataDevolucao = new Date(novaLocacao.getDataDevolucao());

                tm.addRow(new Object[]{
                    novaLocacao.getId(),
                    novaLocacao.getVeiculoLocado().getNome(),
                    novaLocacao.getClienteLocador().getNomeCompleto(),
                    new SimpleDateFormat("dd/MM/yyyy").format(dataLocacao),
                    new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao)
                });
            }
            
            JOptionPane.showMessageDialog(null, "Valor da Locação: " + valorLocacao);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }//GEN-LAST:event_buttonDevolucaoActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        buttonDevolucao.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDevolucao;
    private javax.swing.JComboBox cbVeiculo;
    private javax.swing.JComboBox comboBoxCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelVeiculo;
    // End of variables declaration//GEN-END:variables
}
