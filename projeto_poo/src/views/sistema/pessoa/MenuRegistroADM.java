/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.sistema.pessoa;

import dao.lugar.DAOEndereco;
import javax.swing.JFrame;

import java.util.ArrayList;
import modelos.lugar.Endereco;
import modelos.usuarios.Pessoa;
import sistema.Conexao;
import views.sistema.endereco.MenuEndereco_Cadastro;
import dao.usuarios.DAOPessoa;
import java.time.LocalDate;
import views.sistema.menulogin.MenuLogin;
/**
 *
 * @author Yara
 */
public class MenuRegistroADM extends javax.swing.JFrame {
    private Pessoa pessoa;
    private String cnpj;
    public MenuRegistroADM() {
        initComponents();
        populaComboEndereco();
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
        finalizarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cpfField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dataNascField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        loginField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        senhaField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboboxEndereco = new javax.swing.JComboBox<>();
        cadastrarEnderecoButton = new javax.swing.JButton();
        errorLabelNome = new javax.swing.JLabel();
        errorLabelCpf = new javax.swing.JLabel();
        errorLabelEndereco = new javax.swing.JLabel();
        errorLabelDataNasc = new javax.swing.JLabel();
        errorLabelLogin = new javax.swing.JLabel();
        errorLabelSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Poppins", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Cadastro de Administrador");

        finalizarButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        finalizarButton.setText("Finalizar");
        finalizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarButtonActionPerformed(evt);
            }
        });

        limparButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Sair");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("CPF:");

        cpfField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cpfField.setToolTipText("");
        cpfField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Data de Nascimento:");

        dataNascField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dataNascField.setToolTipText("");
        dataNascField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataNascFieldActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel16.setText("Login:");

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel15.setText("Senha:");

        nomeField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        nomeField.setToolTipText("");
        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });

        loginField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        loginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Nome:");

        senhaField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Endereço:");

        comboboxEndereco.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        comboboxEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Endereço" }));

        cadastrarEnderecoButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cadastrarEnderecoButton.setText("Cadastrar Novo Endereço");
        cadastrarEnderecoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEnderecoButtonActionPerformed(evt);
            }
        });

        errorLabelNome.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelCpf.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelCpf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelEndereco.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelDataNasc.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelDataNasc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelLogin.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelSenha.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(closeButton)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(finalizarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(limparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpfField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataNascField, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboboxEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loginField)
                                    .addComponent(senhaField)))
                            .addComponent(errorLabelDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorLabelCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorLabelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorLabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorLabelSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 128, Short.MAX_VALUE)
                .addComponent(cadastrarEnderecoButton)
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(closeButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cpfField)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataNascField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboboxEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadastrarEnderecoButton)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizarButton)
                    .addComponent(limparButton))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void cpfFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfFieldActionPerformed

    private void dataNascFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataNascFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataNascFieldActionPerformed

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void loginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginFieldActionPerformed

    private void cadastrarEnderecoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEnderecoButtonActionPerformed
        MenuEndereco_Cadastro enderecoCadastro = new MenuEndereco_Cadastro(null,"",-1);
        
        enderecoCadastro.setVisible(true);
        enderecoCadastro.pack();
        enderecoCadastro.setLocationRelativeTo(null);
        enderecoCadastro.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_cadastrarEnderecoButtonActionPerformed

    private void finalizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarButtonActionPerformed
        boolean erroNome = false, erroCpf= false, erroDataNasc= false, erroEndereco= false, erroLogin= false, erroSenha= false;

        if(nomeField.getText().length() == 0){
            errorLabelNome.setText("O campo nome não pode estar vazio");
            erroNome = true;
        }else{
            errorLabelNome.setText("");
        }

        if(senhaField.getText().length() == 0){
            errorLabelSenha.setText("O campo senha não pode estar vazio");
            erroCpf = true;
        }else{
            errorLabelSenha.setText("");
        }

        if(loginField.getText().length() == 0){
            errorLabelLogin.setText("O campo login não pode estar vazio");
            erroLogin = true;
        }else{
            errorLabelLogin.setText("");
        }

        if(cpfField.getText().length() == 0){
            errorLabelCpf.setText("O campo cpf não pode estar vazio");
            erroCpf = true;
        }else{
            if( !(cpfField.getText().contains(".") && (cpfField.getText().contains("-"))) ){
                errorLabelCpf.setText("O campo cpf está no formato errado");
                erroCpf = true;
            }else{
                errorLabelCpf.setText("");
            }
        }
        
        if(comboboxEndereco.getSelectedItem().equals("Selecione um endereço") || comboboxEndereco.getSelectedItem().equals("Não há nenhum endereço criado")){
            errorLabelEndereco.setText("Você precisa selecionar ou cadastrar um novo endereço");
            erroEndereco = true;
        }
        
        erroDataNasc = checaErroDataNasc();
        
        
        if(erroNome|| erroCpf|| erroDataNasc|| erroEndereco|| erroLogin|| erroSenha){
            System.out.println("Deu erro e não rodou");
            return;
        }
        String nome = nomeField.getText(), login = loginField.getText(),data_nasc = dataNascField.getText(), senha = senhaField.getText() , cpf = cpfField.getText();
        
        String[] endereco = comboboxEndereco.getSelectedItem().toString().split(",");
        
        int id_endereco = Integer.parseInt(endereco[2]);
        if(data_nasc.contains("/")){
            String[] data_nascVet = data_nasc.split("/");
            Pessoa pessoaAux = new Pessoa(nome, login, senha, "ADM", cpf, LocalDate.of(Integer.parseInt(data_nascVet[2]), Integer.parseInt(data_nascVet[1]), Integer.parseInt(data_nascVet[0])) , id_endereco );
            if(new DAOPessoa().insertPessoa(pessoaAux)){
                MenuLogin telaLogin = new MenuLogin();

                telaLogin.setVisible(true);
                telaLogin.pack();
                telaLogin.setLocationRelativeTo(null);
                telaLogin.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);

                this.dispose();
            }
        }else{
            String[] data_nascVet = data_nasc.split("-");
            Pessoa pessoaAux = new Pessoa(nome, login, senha, "ADM", cpf, LocalDate.of(Integer.parseInt(data_nascVet[2]), Integer.parseInt(data_nascVet[1]), Integer.parseInt(data_nascVet[0])) , id_endereco );     
            if(new DAOPessoa().insertPessoa(pessoaAux)){
                MenuLogin telaLogin = new MenuLogin();

                telaLogin.setVisible(true);
                telaLogin.pack();
                telaLogin.setLocationRelativeTo(null);
                telaLogin.setDefaultCloseOperation(JFrame .EXIT_ON_CLOSE);

                this.dispose();
            }
        }
        
    }//GEN-LAST:event_finalizarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        nomeField.setText("");
        cpfField.setText("");
        loginField.setText("");
        senhaField.setText("");
        dataNascField.setText("");
        comboboxEndereco.setSelectedIndex(0);
    }//GEN-LAST:event_limparButtonActionPerformed
    
    
    private boolean checaErroDataNasc(){
        boolean erroDataNasc = false;
        if(dataNascField.getText().length() == 0){
            errorLabelDataNasc.setText("O campo data de nascimento não pode estar vazio");
            erroDataNasc = true;
        }else{
            try{
                if(!(dataNascField.getText().contains("/") || dataNascField.getText().contains("-"))){
                    errorLabelDataNasc.setText("Data escrita no formato incorreto");
                    erroDataNasc = true;
                } else if(dataNascField.getText().contains("/")){
                    String [] dataAux = dataNascField.getText().split("/");
                    if(Integer.parseInt(dataAux[0])<=0 || Integer.parseInt(dataAux[1])<=0||Integer.parseInt(dataAux[2])<=0){
                        errorLabelDataNasc.setText("Datas não podem ter valores iguais ou menores que zero");
                        erroDataNasc = true;
                    }else{
                        errorLabelDataNasc.setText("");
                    }
                } else if(dataNascField.getText().contains("-")){
                    String [] dataAux = dataNascField.getText().split("-");
                    if(Integer.parseInt(dataAux[0])<=0 || Integer.parseInt(dataAux[1])<=0||Integer.parseInt(dataAux[2])<=0){
                        errorLabelDataNasc.setText("Datas não podem ter valores iguais ou menores que zero");
                        erroDataNasc = true;
                    }else{
                        errorLabelDataNasc.setText("");
                    }
                }
            }catch(Exception e){
                System.err.print("Houve um erro na inserção da data: "+e);
                errorLabelDataNasc.setText("Não é permitida a inserção de palavras em datas");
            }
        }
        return erroDataNasc;
    }
    
    private void populaComboEndereco(){
        Conexao conexao = new Conexao();
        conexao.conect();
        ArrayList<Endereco> enderecos = new DAOEndereco().readAll();
        
        if(enderecos != null){
            if(comboboxEndereco.getComponentCount() > 0){
                comboboxEndereco.removeAllItems();
            }
            comboboxEndereco.addItem("Selecione um endereço");
            for (Endereco endereco : enderecos) {
                comboboxEndereco.addItem(endereco.getNumero()+","+endereco.getRua()+","+endereco.getId());                
            }
        }else{
            if(comboboxEndereco.getComponentCount() > 0){
                comboboxEndereco.removeAllItems();
                comboboxEndereco.addItem("Não há nenhum endereço cadastrado");  
            }
        }
    }
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
            java.util.logging.Logger.getLogger(MenuRegistroADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuRegistroADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuRegistroADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuRegistroADM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuRegistroADM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarEnderecoButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JComboBox<String> comboboxEndereco;
    private javax.swing.JTextField cpfField;
    private javax.swing.JTextField dataNascField;
    private javax.swing.JLabel errorLabelCpf;
    private javax.swing.JLabel errorLabelDataNasc;
    private javax.swing.JLabel errorLabelEndereco;
    private javax.swing.JLabel errorLabelLogin;
    private javax.swing.JLabel errorLabelNome;
    private javax.swing.JLabel errorLabelSenha;
    private javax.swing.JButton finalizarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton limparButton;
    private javax.swing.JTextField loginField;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextField senhaField;
    // End of variables declaration//GEN-END:variables
}
