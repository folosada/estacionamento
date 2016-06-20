/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.view;

import br.furb.Veiculo;
import br.furb.controller.Controller;
import br.furb.factory.ParkFactory;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author flavioomar
 */
public class VeiculoView extends javax.swing.JDialog implements View {

    /**
     * Creates new form VeiculoView
     */
    
    public VeiculoView(Object form) {
        super((JFrame) form, true);
        initComponents();
        atualizaTabela();
        veiculosJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;
                int selected = veiculosJTable.getSelectedRow();
                nomeJTextField.setText((String) veiculosJTable.getValueAt(selected, 1));
                placaJFormattedTextField.setText((String) veiculosJTable.getValueAt(selected, 0));
            }
        });
    }
    
    public VeiculoView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        veiculosJTable = new javax.swing.JTable();
        nomeJTextField = new javax.swing.JTextField();
        placaJLabel = new javax.swing.JLabel();
        lblVeiculoNome = new javax.swing.JLabel();
        placaJFormattedTextField = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        veiculosJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(veiculosJTable);

        placaJLabel.setText("Placa:");

        lblVeiculoNome.setText("Nome");

        try {
            placaJFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("???-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(placaJLabel)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblVeiculoNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeJTextField)
                            .addComponent(placaJFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVeiculoNome)
                    .addComponent(nomeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placaJLabel)
                    .addComponent(placaJFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            Veiculo veiculo = new Veiculo();
            veiculo.setPlaca(placaJFormattedTextField.getText());
            veiculo.setNome(nomeJTextField.getText());
            if (this.recuperar(veiculo.getPlaca()) != null){
                String message = "Já exite um veículo cadastrado com esta placa, deseja substituir?";
                String title = "Confirmação";
                int reply = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION){
                    this.salvar(veiculo);
                    this.atualizaTabela();
                }
            } else {
                this.salvar(veiculo);
                this.atualizaTabela();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(VeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeiculoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VeiculoView dialog = new VeiculoView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVeiculoNome;
    private javax.swing.JTextField nomeJTextField;
    private javax.swing.JFormattedTextField placaJFormattedTextField;
    private javax.swing.JLabel placaJLabel;
    private javax.swing.JTable veiculosJTable;
    // End of variables declaration//GEN-END:variables

    @Override
    public void salvar(Object info) {
        Controller veiculoController = ParkFactory.getFactory("Veiculo").createController();
        try {
            veiculoController.salvar(info);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar veículo!\n" + ex.getMessage());
        }
    }

    @Override
    public Object recuperar(String chave) {
        Controller veiculoController = ParkFactory.getFactory("Veiculo").createController();
        try {
            return veiculoController.recuperar(chave);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List recuperar() {
        Controller veiculoController = ParkFactory.getFactory("Veiculo").createController();
        try {
            return veiculoController.recuperar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao recuperar registros!\n" + ex.getMessage());
        }
        return null;
    }

    @Override
    public void abreJanela() {
        this.setVisible(true);
    }

    @Override
    public void atualizaTabela() {
        DefaultTableModel dtm = new DefaultTableModel(new String[]{"Placa", "Nome"}, 0);
        LinkedList<Veiculo> veiculos = (LinkedList) this.recuperar();
        veiculos.sort(null);
        for (Veiculo veiculo : veiculos) {
            dtm.addRow(new String[]{veiculo.getPlaca(), veiculo.getNome()});
        }
        veiculosJTable.setModel((TableModel) dtm);
    }
}
