/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.sistema.dono;

import dao.empresa.DAOEmpresa;
import dao.empresa.DAOSetor;
import dao.usuarios.DAODono;
import javax.swing.table.DefaultTableModel;
import modelos.usuarios.Dono;
import modelos.empresa.Empresa;
import modelos.empresa.Setor;
import java.util.ArrayList;

/**
 *
 * @author sarah
 */
public class MenuDono_AdmSetor extends javax.swing.JFrame {
    private Empresa empresa;
    private Dono dono;
    /**
     * Creates new form AlterarDadosSetorDono
     */
    public MenuDono_AdmSetor(String cnpj, String cpf) {
        if(cnpj != null && cpf != null){
            this.empresa = new DAOEmpresa().readOnEmpresa(cnpj, "cnpj");
            this.dono = new DAODono().readOneDono(cpf);
            initComponents();
            iniciaTabela();
        }else{
            initComponents();
        }
    }  
    
    public void iniciaTabela(){

        ArrayList<Setor> setores = new DAOSetor().readAll();

        DefaultTableModel testetabela = (DefaultTableModel) tabelaDados.getModel();
        Object[] colunas = {"id","nome","orcamento"};
        testetabela.setColumnIdentifiers(colunas);
        while(testetabela.getRowCount() > 0){
            testetabela.removeRow(testetabela.getRowCount()-1);
        }
        for(int i = 0; i < setores.size(); i++){
            if(setores.get(i).getCnpj_empresa().equals(empresa.getCnpj())){
                final Object[] entrada = new Object[3];
                entrada[0] = setores.get(i).getId();
                entrada[1] = setores.get(i).getNome(); 
                entrada[2] = setores.get(i).getOrcamento();
                
                testetabela.addRow(entrada);
            }
        }
        tabelaDados.setModel(testetabela);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeSetorTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        orcamentoTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomeAlterButton = new javax.swing.JButton();
        orcamentoAlterButton = new javax.swing.JButton();
        backDonoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        admFuncionariosButton = new javax.swing.JButton();
        admEstagiariosButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        deleteCheckBox = new javax.swing.JCheckBox();
        errorMessage = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomeSetorTextField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Orçamento:");

        clearButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        clearButton.setText("Limpar");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        orcamentoTextField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Poppins", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Administrar Dados - Setor");

        nomeAlterButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        nomeAlterButton.setText("Alterar Nome do Setor");
        nomeAlterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeAlterButtonActionPerformed(evt);
            }
        });

        orcamentoAlterButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        orcamentoAlterButton.setText("Alterar Orçamento do Setor");
        orcamentoAlterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orcamentoAlterButtonActionPerformed(evt);
            }
        });

        backDonoButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        backDonoButton.setText("Voltar");
        backDonoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backDonoButtonActionPerformed(evt);
            }
        });

        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Orçamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
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
        jScrollPane1.setViewportView(tabelaDados);
        if (tabelaDados.getColumnModel().getColumnCount() > 0) {
            tabelaDados.getColumnModel().getColumn(0).setResizable(false);
            tabelaDados.getColumnModel().getColumn(1).setResizable(false);
            tabelaDados.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Nome do Setor:");

        admFuncionariosButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        admFuncionariosButton.setText("Administrar Funcionários");
        admFuncionariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admFuncionariosButtonActionPerformed(evt);
            }
        });

        admEstagiariosButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        admEstagiariosButton.setText("Administrar Estagiários");
        admEstagiariosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admEstagiariosButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        deleteButton.setText("Excluir Setor");
        deleteButton.setPreferredSize(new java.awt.Dimension(102, 24));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        deleteCheckBox.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        deleteCheckBox.setText("Confirmar exclusão ");
        deleteCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCheckBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Adicionar Setor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backDonoButton)
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(orcamentoTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                                    .addComponent(nomeSetorTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(admFuncionariosButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(admEstagiariosButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nomeAlterButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orcamentoAlterButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteCheckBox, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backDonoButton)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeSetorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeAlterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orcamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(orcamentoAlterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteCheckBox)
                    .addComponent(admFuncionariosButton)
                    .addComponent(admEstagiariosButton)
                    .addComponent(jButton1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeAlterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAlterButtonActionPerformed
        boolean error = false;
        String nome = nomeSetorTextField.getText();
        
        if(nome.length() == 0){
            errorMessage.setText("O campo nome do setor não pode estar vazio");
            error = true;
        }
        
        if(!error){
            errorMessage.setText("");
        }
        
        if(error){
            return;
        }
        DAOEmpresa daoEmpresa = new DAOEmpresa();
        String cnpj = daoEmpresa.readOnEmpresa(dono.getCpf(), "cpf").getCnpj();
        DAOSetor daoSetor = new DAOSetor();
        int id = daoSetor.readOnSetor("cnpj", cnpj).getId();
        daoSetor.updateSetor("nome", id, nome);
        
        iniciaTabela();
    }//GEN-LAST:event_nomeAlterButtonActionPerformed

    private void admFuncionariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admFuncionariosButtonActionPerformed
        dono.administrarFuncionarios();
        this.dispose();
    }//GEN-LAST:event_admFuncionariosButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        boolean errorCheckbox = false, errorFild = false;

        if(deleteCheckBox.isSelected() != true){
            errorMessage.setText("Para deletar o setor, você deve marcar o campo confirmar exclusão.");
            errorCheckbox = true;
        }
        if(!errorCheckbox){
            errorMessage.setText("");
        }
        
        if(errorCheckbox){
            return;
        }
        
        DefaultTableModel testetabela = (DefaultTableModel) tabelaDados.getModel();
        if(tabelaDados.getSelectedRowCount() == 1){
            int column = 0;
            int row = tabelaDados.getSelectedRow();
            String id = tabelaDados.getModel().getValueAt(column, row).toString();
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            String cnpj = daoEmpresa.readOnEmpresa(dono.getCpf(), "cpf").getCnpj();
            DAOSetor daoSetor = new DAOSetor();
            //int id = daoSetor.readOnSetor("cnpj", cnpj).getId();
            testetabela.removeRow(tabelaDados.getSelectedRow());
            new DAOSetor().deleteSetor(id);
            
        } else {
            if(tabelaDados.getRowCount() == 0){
                errorMessage.setText("Tabela vazia.");
            } else {
                errorMessage.setText("É preciso selecionar a linha que deseja deletar.");
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void admEstagiariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admEstagiariosButtonActionPerformed
        dono.administrarEstagiarios();
        this.dispose();
    }//GEN-LAST:event_admEstagiariosButtonActionPerformed

    private void deleteCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteCheckBoxActionPerformed

    private void orcamentoAlterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orcamentoAlterButtonActionPerformed
        boolean error = false;
        String orcamento = orcamentoTextField.getText();
        
        if(orcamento.length() == 0){
            errorMessage.setText("O campo orçamento não pode estar vazio");
            error = true;
        }
        
        if(!error){
            errorMessage.setText("");
        }
        
        if(error){
            return;
        }
        
        DAOEmpresa daoEmpresa = new DAOEmpresa();
        String cnpj = daoEmpresa.readOnEmpresa(dono.getCpf(), "cpf").getCnpj();
        DAOSetor daoSetor = new DAOSetor();
        int id = daoSetor.readOnSetor("cnpj", cnpj).getId();
        daoSetor.updateSetor("orcamento", id, orcamento);
        //this.empresa = daoEmpresa.readOnEmpresa(this.empresa.getCnpj());
        
        iniciaTabela();
    }//GEN-LAST:event_orcamentoAlterButtonActionPerformed

    private void backDonoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backDonoButtonActionPerformed
        dono.administrarEmpresa();
        this.dispose();
        this.dispose();
    }//GEN-LAST:event_backDonoButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        nomeSetorTextField.setText("");
        orcamentoTextField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MenuDono_AdmSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDono_AdmSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDono_AdmSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDono_AdmSetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDono_AdmSetor(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admEstagiariosButton;
    private javax.swing.JButton admFuncionariosButton;
    private javax.swing.JButton backDonoButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JCheckBox deleteCheckBox;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nomeAlterButton;
    private javax.swing.JTextField nomeSetorTextField;
    private javax.swing.JButton orcamentoAlterButton;
    private javax.swing.JTextField orcamentoTextField;
    private javax.swing.JTable tabelaDados;
    // End of variables declaration//GEN-END:variables
}
