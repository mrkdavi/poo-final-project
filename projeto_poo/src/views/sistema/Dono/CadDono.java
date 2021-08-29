/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.sistema.dono;

import dao.lugar.DAOEndereco;
import dao.usuarios.DAODono;
import javax.swing.JFrame;

import dao.usuarios.DAOPessoa;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.lugar.Endereco;
import modelos.usuarios.Dono;
import modelos.usuarios.Pessoa;
import sistema.Conexao;
import views.sistema.menulogin.MenuLogin;
/**
 *
 * @author Yara
 */
public class CadDono extends javax.swing.JFrame {
    private Pessoa pessoa;
    /**
     * Creates new form Dono
     */
    public CadDono(String cpf) {
        if(cpf != null){
            this.pessoa = new DAOPessoa().readOnePessoa(cpf);
            initComponents();
            populaComboEndereco();
        }else{
            initComponents();
            populaComboEndereco();
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

        jLabel1 = new javax.swing.JLabel();
        finalizarButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
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
        jButton4 = new javax.swing.JButton();
        errorLabelNome = new javax.swing.JLabel();
        errorLabelCpf = new javax.swing.JLabel();
        errorLabelDataNasc = new javax.swing.JLabel();
        errorLabelLogin = new javax.swing.JLabel();
        errorLabelEndereco = new javax.swing.JLabel();
        errorLabelSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Poppins", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Cadastro de Novo Dono");

        finalizarButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        finalizarButton.setText("Finalizar");
        finalizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton2.setText("Limpar");

        backButton.setText("Voltar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
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
        comboboxEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não há nenhum Endereço cadastrado" }));

        jButton4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton4.setText("Cadastrar Novo Endereço");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        errorLabelNome.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelCpf.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelCpf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelDataNasc.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelDataNasc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelLogin.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelEndereco.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelEndereco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelSenha.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(finalizarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataNascField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxEndereco, 0, 249, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(senhaField, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(loginField)))
                    .addComponent(errorLabelNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cpfField)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(errorLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataNascField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboboxEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(errorLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(errorLabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(errorLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(finalizarButton)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        pessoa.mostrarMenu();
        this.dispose();
        
    }//GEN-LAST:event_backButtonActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        pessoa.criarNovoEndereco("CadDono",-1);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
        
        if(comboboxEndereco.getSelectedItem().equals("Selecione um endereço") || comboboxEndereco.getSelectedItem().equals("Não há nenhum endereço cadastrado")){
            errorLabelEndereco.setText("Você precisa selecionar ou cadastrar um novo endereço");
            erroEndereco = true;
        }else{
            errorLabelEndereco.setText("");
        }
        
        erroDataNasc = checaErroDataNasc();
        
        
        if(erroNome|| erroCpf|| erroDataNasc|| erroEndereco|| erroLogin|| erroSenha){
            System.out.println("Deu erro e não rodou");
            return;
        }
        String nome = nomeField.getText(), login = loginField.getText(),data_nascStr = dataNascField.getText(), senha = senhaField.getText() , cpf = cpfField.getText();
        
        String[] endereco = comboboxEndereco.getSelectedItem().toString().split(",");
        
        int id_endereco = Integer.parseInt(endereco[2]);
        if(data_nascStr.contains("/")){
            
            String[] data_nascVet = data_nascStr.split("/");
            
            LocalDate data_nasc = LocalDate.of(Integer.parseInt(data_nascVet[2]), Integer.parseInt(data_nascVet[1]), Integer.parseInt(data_nascVet[0]));
            
            Pessoa pessoaAux = new Pessoa(nome, login, senha, "DON", cpf, data_nasc , id_endereco );
            if(new DAOPessoa().insertPessoa(pessoaAux)){
                
                if(new DAODono().insertDono(new Dono(nome, login, senha, cpf, cpf,data_nasc , id_endereco))){
                    pessoa.mostrarMenu();

                    this.dispose();
                }
                
            }
        }else{
            
            String[] data_nascVet = data_nascStr.split("-");
            
            LocalDate data_nasc= LocalDate.of(Integer.parseInt(data_nascVet[2]), Integer.parseInt(data_nascVet[1]), Integer.parseInt(data_nascVet[0]));
            
            Pessoa pessoaAux = new Pessoa(nome, login, senha, "DON", cpf, data_nasc, id_endereco );     
            if(new DAOPessoa().insertPessoa(pessoaAux)){
                if(new DAODono().insertDono(new Dono(nome, login, senha, cpf, cpf,data_nasc , id_endereco))){
                    pessoa.mostrarMenu();
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_finalizarButtonActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(CadDono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadDono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadDono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadDono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadDono(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField loginField;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextField senhaField;
    // End of variables declaration//GEN-END:variables
}
