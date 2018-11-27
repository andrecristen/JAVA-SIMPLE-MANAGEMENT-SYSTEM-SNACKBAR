package View;

import Controller.FornecedorController;
import Model.Fornecedor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SelecionarEditarFornecedor extends javax.swing.JDialog {

    public String retornaValor;

    public String getRetornaValor() {
        return retornaValor;
    }

    public void setRetornaValor(String retornaValor) {
        this.retornaValor = retornaValor;
    }

    /**
     * Creates new form SelecionarEditarFornecedor
     */
    public SelecionarEditarFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencheComFornecedoresCadastrados();
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
        fornecedoresTable = new javax.swing.JTable();
        selecionarEditarFornecedorButton = new javax.swing.JButton();
        selecionarExcluirFornecedorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fornecedoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "CNPJ", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(fornecedoresTable);

        selecionarEditarFornecedorButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selecionarEditarFornecedorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editIcon.png"))); // NOI18N
        selecionarEditarFornecedorButton.setText("Editar");
        selecionarEditarFornecedorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarEditarFornecedorButtonActionPerformed(evt);
            }
        });

        selecionarExcluirFornecedorButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selecionarExcluirFornecedorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/removeIcon.png"))); // NOI18N
        selecionarExcluirFornecedorButton.setText("Excluir");
        selecionarExcluirFornecedorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionarExcluirFornecedorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selecionarEditarFornecedorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selecionarExcluirFornecedorButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selecionarEditarFornecedorButton)
                    .addComponent(selecionarExcluirFornecedorButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selecionarExcluirFornecedorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarExcluirFornecedorButtonActionPerformed
        int row = fornecedoresTable.getSelectedRow();
        if (row >= 0) {
            int reply = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja realmente excluir este registro?", "Atenção!", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                DefaultTableModel fornecedoresTable = (DefaultTableModel) this.fornecedoresTable.getModel();
                String codigo = fornecedoresTable.getValueAt(row, 0).toString();
                FornecedorController controller = new FornecedorController();
                controller.removerFornecedorByCodigo(codigo);
                while (fornecedoresTable.getRowCount() > 0) {
                    fornecedoresTable.removeRow(0);
                }
                preencheComFornecedoresCadastrados();
            }
        } else if (row < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para prosseguir com a exclusão de Fornecedor.");
        }
    }//GEN-LAST:event_selecionarExcluirFornecedorButtonActionPerformed

    private void selecionarEditarFornecedorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionarEditarFornecedorButtonActionPerformed
        FornecedorController controller = new FornecedorController();
        int row = fornecedoresTable.getSelectedRow();
        String codigo = fornecedoresTable.getValueAt(row, 0).toString();
        Fornecedor fornecedor = controller.findFornecedorByCodigo(codigo);
        EditarFornecedor edit = new EditarFornecedor(null, rootPaneCheckingEnabled, fornecedor);
        edit.setVisible(true);
        DefaultTableModel fornecedorTable = (DefaultTableModel) this.fornecedoresTable.getModel();
        while (fornecedorTable.getRowCount() > 0) {
            fornecedorTable.removeRow(0);
        }
        preencheComFornecedoresCadastrados();
    }//GEN-LAST:event_selecionarEditarFornecedorButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SelecionarEditarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionarEditarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionarEditarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionarEditarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelecionarEditarFornecedor dialog = new SelecionarEditarFornecedor(new javax.swing.JFrame(), true);
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

    private void preencheComFornecedoresCadastrados() {
        FornecedorController controller = new FornecedorController();
        ArrayList<Fornecedor> data = controller.selecionarTodosFornecedores();
        DefaultTableModel tabela = (DefaultTableModel) fornecedoresTable.getModel();
        for (Fornecedor fornecedor : data) {
            tabela.addRow(new Object[]{fornecedor.getCodigo().toString(), fornecedor.getCnpj().toString(), fornecedor.getNome().toString()});
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable fornecedoresTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selecionarEditarFornecedorButton;
    private javax.swing.JButton selecionarExcluirFornecedorButton;
    // End of variables declaration//GEN-END:variables
}