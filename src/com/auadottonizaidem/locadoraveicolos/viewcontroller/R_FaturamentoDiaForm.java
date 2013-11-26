/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auadottonizaidem.locadoraveicolos.viewcontroller;

import com.auadottonizaidem.locadoraveicolos.model.Locacao;
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
 * @author Aparecida
 */
public class R_FaturamentoDiaForm extends javax.swing.JFrame {

    private EntityManager entityManager;
    float faturamento = 0;
    Query query;
    List<Locacao> listLocacoes;

    /**
     * Creates new form R_FaturamentoForm
     */
    public R_FaturamentoDiaForm() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("LocadoraVeiculosPU");

        entityManager = entityManagerFactory.createEntityManager();

        initComponents();

    }

    private float faturamentoDiario() {
        try {
            float valorLocacao = 0;

            Locacao locacao;
            entityManager.getTransaction().begin();

            for (int i = 0; i < listLocacoes.size(); i++) {
                int diaLocacao = Integer.parseInt(new SimpleDateFormat("dd")
                        .format(listLocacoes.get(i).getDataLocacao()));
                int diaDevolucao = Integer.parseInt(new SimpleDateFormat("dd")
                        .format(listLocacoes.get(i).getDataDevolucao()));
                int mesLocacao = Integer.parseInt(new SimpleDateFormat("MM")
                        .format(listLocacoes.get(i).getDataLocacao()));
                int mesDevolucao = Integer.parseInt(new SimpleDateFormat("MM")
                        .format(listLocacoes.get(i).getDataDevolucao()));

                int diasDeLocacao = diaDevolucao - diaLocacao;
                if (diasDeLocacao == 0) {
                    diasDeLocacao = 1;
                }
                if (mesDevolucao != mesLocacao) {
                    diasDeLocacao *= ((mesDevolucao - mesLocacao) * 30);
                }

                valorLocacao = listLocacoes.get(i).getVeiculoLocado().getPreco().floatValue()
                        * diasDeLocacao;

                faturamento += valorLocacao;

            }

            entityManager.getTransaction().commit();
            return faturamento;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return 0;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorioDia = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        tfData = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableRelatorioDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dia", "Faturamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableRelatorioDia);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Relatório Diário");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(91, 91, 91)
                        .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(42, 42, 42))
        );

        setBounds(0, 0, 448, 332);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Set your date format
        String dataForm = tfData.getText();
        try {
            Date dataBusca = sdf.parse(dataForm);
            long datamilis = dataBusca.getTime();
            query = entityManager.createNamedQuery("Locacao.findByDataParameter");
            query.setParameter("dataBusca", datamilis);
            listLocacoes = query.getResultList();

            float fatura = faturamentoDiario();

            jTableRelatorioDia.clearSelection();
            jTableRelatorioDia.removeAll();

            DefaultTableModel dfTable = (DefaultTableModel) jTableRelatorioDia.getModel();
            dfTable.getDataVector().removeAllElements();

            dfTable.addRow(new Object[]{dataForm, fatura});

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data ínvalida, impossivel buscar!");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDataActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorioDia;
    private javax.swing.JFormattedTextField tfData;
    // End of variables declaration//GEN-END:variables
}
