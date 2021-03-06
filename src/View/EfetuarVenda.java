package View;

import Controller.VendaController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EfetuarVenda extends javax.swing.JDialog {

    private String precoProdutoSelecionado;

    /**
     * Creates new form EfetuarVenda
     */
    public EfetuarVenda(java.awt.Frame parent, boolean modal) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigoVendaInut = new javax.swing.JTextField();
        clienteVendaInput = new javax.swing.JTextField();
        atendenteVendaInput = new javax.swing.JTextField();
        findCliente = new javax.swing.JButton();
        findAtendente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vendaProdutosTable = new javax.swing.JTable();
        valorTotalLabel = new javax.swing.JLabel();
        valorTotalVenda = new javax.swing.JTextField();
        cancelarVendaButton = new javax.swing.JButton();
        confirmarVendaButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        produtoProdutoInput = new javax.swing.JTextField();
        findProduto = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        adicionarProdutoNaVendaButton = new javax.swing.JButton();
        removerLinhaSelecionadaButton = new javax.swing.JButton();
        quantidadeProdutoInput = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cliente:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Atendente*:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Código*:");

        clienteVendaInput.setEditable(false);
        clienteVendaInput.setBackground(new java.awt.Color(206, 211, 208));
        clienteVendaInput.setFocusable(false);
        clienteVendaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteVendaInputActionPerformed(evt);
            }
        });

        atendenteVendaInput.setEditable(false);
        atendenteVendaInput.setBackground(new java.awt.Color(206, 211, 208));
        atendenteVendaInput.setFocusable(false);

        findCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/findIcon.png"))); // NOI18N
        findCliente.setToolTipText("Selecionar um Cliente");
        findCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findClienteActionPerformed(evt);
            }
        });

        findAtendente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/findIcon.png"))); // NOI18N
        findAtendente.setToolTipText("Selecionar um Atendente");
        findAtendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findAtendenteActionPerformed(evt);
            }
        });

        vendaProdutosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Valor Unitário", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vendaProdutosTable);

        valorTotalLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        valorTotalLabel.setText("Valor Total:");

        valorTotalVenda.setEditable(false);
        valorTotalVenda.setBackground(new java.awt.Color(206, 211, 208));
        valorTotalVenda.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        valorTotalVenda.setText("0.0");
        valorTotalVenda.setFocusable(false);

        cancelarVendaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/tempoehdinheiroIcon.png"))); // NOI18N
        cancelarVendaButton.setText("Cancelar Venda");
        cancelarVendaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarVendaButtonActionPerformed(evt);
            }
        });

        confirmarVendaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/moneyIcon.png"))); // NOI18N
        confirmarVendaButton.setText("Confirmar Venda");
        confirmarVendaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarVendaButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Produto:");

        produtoProdutoInput.setEditable(false);
        produtoProdutoInput.setBackground(new java.awt.Color(206, 211, 208));
        produtoProdutoInput.setToolTipText("Selecionar um Produto");
        produtoProdutoInput.setFocusable(false);
        produtoProdutoInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoProdutoInputActionPerformed(evt);
            }
        });

        findProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/findIcon.png"))); // NOI18N
        findProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findProdutoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quantidade:");

        adicionarProdutoNaVendaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/addIcon.png"))); // NOI18N
        adicionarProdutoNaVendaButton.setText("Adicionar");
        adicionarProdutoNaVendaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarProdutoNaVendaButtonActionPerformed(evt);
            }
        });

        removerLinhaSelecionadaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/deleterowIcon.png"))); // NOI18N
        removerLinhaSelecionadaButton.setText("Apagar Linha Selecionada");
        removerLinhaSelecionadaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerLinhaSelecionadaButtonActionPerformed(evt);
            }
        });

        quantidadeProdutoInput.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorTotalVenda)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valorTotalLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cancelarVendaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmarVendaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removerLinhaSelecionadaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(codigoVendaInut, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(produtoProdutoInput)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(findProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(quantidadeProdutoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adicionarProdutoNaVendaButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(atendenteVendaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(findAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(clienteVendaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(findCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(5, 5, 5)))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(codigoVendaInut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(findCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clienteVendaInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2)
                    .addComponent(findAtendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atendenteVendaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(findProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(produtoProdutoInput, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adicionarProdutoNaVendaButton)
                        .addComponent(quantidadeProdutoInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valorTotalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removerLinhaSelecionadaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmarVendaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarVendaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findClienteActionPerformed
        PesquisarCliente pesquisaCliente = new PesquisarCliente(null, true);
        pesquisaCliente.setVisible(true);
        this.clienteVendaInput.setText(pesquisaCliente.getRetornaValor());
    }//GEN-LAST:event_findClienteActionPerformed

    private void findAtendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findAtendenteActionPerformed
        PesquisarAtendente pesquisarAtendente = new PesquisarAtendente(null, true);
        pesquisarAtendente.setVisible(true);
        this.atendenteVendaInput.setText(pesquisarAtendente.getRetornaValor());
    }//GEN-LAST:event_findAtendenteActionPerformed

    private void cancelarVendaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarVendaButtonActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar está venda? Todo o progresso será perido", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_cancelarVendaButtonActionPerformed

    private void confirmarVendaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarVendaButtonActionPerformed
        boolean valido = true;
        String codigoVenda = codigoVendaInut.getText();
        if (codigoVenda.trim().equals("")) {
            valido = false;
        }
        //Pega  o id do cliente
        String codigoCliente = clienteVendaInput.getText();
        String[] valoresCliente = codigoCliente.split("-");
        codigoCliente = valoresCliente[0];
      
        //Pega  o id do atendente
        String codigoAtendente = atendenteVendaInput.getText();
        String[] valoresAtendente = codigoAtendente.split("-");
        codigoAtendente = valoresAtendente[0];
        if (codigoAtendente.trim().equals("")) {
            valido = false;
        }
        //Verifica se tem algum produto na venda
        int rows = vendaProdutosTable.getRowCount();
        if (rows <= 0) {
            valido = false;
        }
        if (valido) {
            String[][] produtos = new String[rows][2];
            for (int row = 0; row < rows; row++) {
                //Código do produto
                produtos[row][0] = vendaProdutosTable.getValueAt(row, 0).toString();
                //Quantidade do produto
                produtos[row][1] = vendaProdutosTable.getValueAt(row, 2).toString();

            }
            VendaController controller = new VendaController();
            String mensagem = controller.cadastrarNovaVenda(codigoVenda, codigoCliente, codigoAtendente, produtos);
            JOptionPane.showMessageDialog(null, mensagem);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos, verifique a venda!");
        }

    }//GEN-LAST:event_confirmarVendaButtonActionPerformed

    private void findProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findProdutoActionPerformed
        PesquisarProduto pesquisarProduto = new PesquisarProduto(null, true);
        pesquisarProduto.setVisible(true);
        this.produtoProdutoInput.setText(pesquisarProduto.getRetornaValor());
        this.precoProdutoSelecionado = pesquisarProduto.getValorDeVenda();
    }//GEN-LAST:event_findProdutoActionPerformed

    private void produtoProdutoInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoProdutoInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produtoProdutoInputActionPerformed

    private void removerLinhaSelecionadaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerLinhaSelecionadaButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) vendaProdutosTable.getModel();
        try {
            int SelectedRowIndex = vendaProdutosTable.getSelectedRow();
            int SelectedsRows = vendaProdutosTable.getSelectedRowCount();
            if (SelectedsRows == 1) {
                String valor = model.getValueAt(SelectedRowIndex, 4).toString();
                String valorTotalAtual = this.valorTotalVenda.getText();
                Float newValoTotal = Float.parseFloat(valorTotalAtual) - Float.parseFloat(valor);
                this.valorTotalVenda.setText(newValoTotal.toString());
                model.removeRow(SelectedRowIndex);
            } else if (SelectedsRows > 1) {
                JOptionPane.showMessageDialog(null, "Para garantir uma exclusão mais segura, selecione apenas um linha por vez");
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma linha para exclusão");
            }
            if (vendaProdutosTable.getRowCount() == 0) {
                this.valorTotalVenda.setText("0.00");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_removerLinhaSelecionadaButtonActionPerformed

    private void adicionarProdutoNaVendaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarProdutoNaVendaButtonActionPerformed
        String produto = this.produtoProdutoInput.getText();
        String quantidade = this.quantidadeProdutoInput.getText();
        DefaultTableModel tabela = (DefaultTableModel) vendaProdutosTable.getModel();
        if (produto.equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para poder adicionar a venda");
        } else {
            if (quantidade.equals("")) {
                JOptionPane.showMessageDialog(null, "Informe a quantidade que deseja deste produto");
            } else {
                if (quantidade.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Informe uma quantidade maior que zero");
                } else {
                    String valor = this.precoProdutoSelecionado;
                    Float valorTotal = Integer.parseInt(quantidade) * Float.parseFloat(valor);
                    String[] partes = produto.split("-");
                    tabela.addRow(new Object[]{partes[0], partes[1], quantidade, valor, valorTotal.toString()});
                    this.produtoProdutoInput.setText("");
                    this.quantidadeProdutoInput.setText("");
                    String valorVenda = this.valorTotalVenda.getText();
                    if (valorVenda.equals("")) {
                        valorVenda = "0";
                    }
                    Float newValorTotal = Float.parseFloat(valorVenda) + valorTotal;
                    this.valorTotalVenda.setText(newValorTotal.toString());
                }
            }
        }
    }//GEN-LAST:event_adicionarProdutoNaVendaButtonActionPerformed

    private void clienteVendaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteVendaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteVendaInputActionPerformed

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
            java.util.logging.Logger.getLogger(EfetuarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EfetuarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EfetuarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EfetuarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EfetuarVenda dialog = new EfetuarVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton adicionarProdutoNaVendaButton;
    private javax.swing.JTextField atendenteVendaInput;
    private javax.swing.JButton cancelarVendaButton;
    private javax.swing.JTextField clienteVendaInput;
    private javax.swing.JTextField codigoVendaInut;
    private javax.swing.JButton confirmarVendaButton;
    private javax.swing.JButton findAtendente;
    private javax.swing.JButton findCliente;
    private javax.swing.JButton findProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField produtoProdutoInput;
    private javax.swing.JFormattedTextField quantidadeProdutoInput;
    private javax.swing.JButton removerLinhaSelecionadaButton;
    private javax.swing.JLabel valorTotalLabel;
    private javax.swing.JTextField valorTotalVenda;
    private javax.swing.JTable vendaProdutosTable;
    // End of variables declaration//GEN-END:variables
}
