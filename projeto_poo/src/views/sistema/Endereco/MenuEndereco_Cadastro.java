/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.sistema.endereco;
import dao.lugar.DAOBairro;
import dao.lugar.DAOCidade;
import dao.lugar.DAOEndereco;
import dao.lugar.DAOEstado;
import dao.usuarios.DAODono;
import dao.usuarios.DAOFuncionario;
import dao.usuarios.DAOPessoa;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import modelos.lugar.Bairro;
import modelos.lugar.Cidade;
import modelos.lugar.Endereco;
import modelos.lugar.Estado;
import modelos.usuarios.Diretor;
import modelos.usuarios.Dono;
import modelos.usuarios.Estagiario;
import modelos.usuarios.Funcionario;
import modelos.usuarios.Gerente;
import modelos.usuarios.Pessoa;
import sistema.Conexao;
import views.sistema.pessoa.MenuRegistroADM;
/**
 *
 * @author Ana Beatriz
 */
public class MenuEndereco_Cadastro extends javax.swing.JFrame {
    private Pessoa pessoa;
    private String opt;
    private int id_setor;
    /**
     * Creates new form MenuEndereco_Cadastro
     */
    public MenuEndereco_Cadastro(String cpf, String opt, int id_setor) {
        if(cpf != null){
            this.opt = opt;
            this.pessoa = new DAOPessoa().readOnePessoa(cpf);
            this.id_setor = id_setor;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cidadeField = new javax.swing.JTextField();
        ruaField = new javax.swing.JTextField();
        numeroCasaField = new javax.swing.JTextField();
        complementoField = new javax.swing.JTextField();
        cadastrarButton = new javax.swing.JButton();
        limparLabels = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        errorLabelCidade = new javax.swing.JLabel();
        errorLabelEstado = new javax.swing.JLabel();
        errorLabelNumero = new javax.swing.JLabel();
        errorLabelRua = new javax.swing.JLabel();
        errorLabelComplemento = new javax.swing.JLabel();
        errorLabelBairro = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bairroField = new javax.swing.JTextField();
        comboboxEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cepField = new javax.swing.JTextField();
        errorLabelCep = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Poppins", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("Cadastro Novo Endereço");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel2.setText("Estado:");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Cidade:");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("Rua:");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setText("Número da Casa:");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("Complemento (opcional):");

        cidadeField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        ruaField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        numeroCasaField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        complementoField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        cadastrarButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        limparLabels.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        limparLabels.setText("Limpar");
        limparLabels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparLabelsActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        backButton.setText("Voltar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        errorLabelCidade.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelCidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelEstado.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelNumero.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelRua.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelRua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelComplemento.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelComplemento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        errorLabelBairro.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelBairro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setText("Bairro:");

        bairroField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        comboboxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um estado" }));
        comboboxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxEstadoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setText("Cep:");

        cepField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        errorLabelCep.setForeground(new java.awt.Color(255, 51, 51));
        errorLabelCep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addGap(78, 78, 78)
                .addComponent(jLabel1)
                .addGap(0, 145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(cadastrarButton)
                .addGap(50, 50, 50)
                .addComponent(limparLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorLabelNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cidadeField))
                    .addComponent(errorLabelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboboxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(errorLabelRua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ruaField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairroField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroCasaField))
                    .addComponent(errorLabelCidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(complementoField))
                    .addComponent(errorLabelComplemento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorLabelCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cepField)))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backButton))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cepField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelCep, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboboxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(bairroField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cidadeField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ruaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelRua, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroCasaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(complementoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabelComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarButton)
                    .addComponent(limparLabels))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        boolean erroEstado = false, erroCidade= false, erroRua= false, erroNumero= false, erroComplemento= false, erroBairro = false, erroCep = false;
        
        
        if(comboboxEstado.getSelectedIndex() == 0 ){
            errorLabelEstado.setText("É preciso selecionar um estado");
            erroEstado = true;
        }else{
            errorLabelEstado.setText("");
        }
        
        if(cidadeField.getText().length() == 0){
            errorLabelCidade.setText("O campo cidade não pode estar vazio");
            erroCidade = true;
        }else{
            errorLabelCidade.setText("");
        }
        
        if(cepField.getText().length() == 0){
            errorLabelCep.setText("O campo cep não pode estar vazio");
            erroCep = true;
        }else{
            errorLabelCep.setText("");
        }
        
        if(bairroField.getText().length() == 0){
            errorLabelBairro.setText("O campo bairro não pode estar vazio");
            erroBairro = true;
        }else{
            errorLabelBairro.setText("");
        }

        if(ruaField.getText().length() == 0){
            errorLabelRua.setText("O campo rua não pode estar vazio");
            erroRua = true;
        }else{
            errorLabelRua.setText("");
        }

        if(numeroCasaField.getText().length() == 0){
            errorLabelNumero.setText("O campo numero não pode estar vazio");
            erroNumero = true;
        }else{
            try{
                int numero = Integer.parseInt(numeroCasaField.getText());
            }catch(NumberFormatException e){
                System.err.println("Numero está escrito num formato incorreto" + e);
                errorLabelNumero.setText("Numero está escrito num formato incorreto");
                erroNumero = true;
            }
                if(erroNumero == false){
                    errorLabelNumero.setText("");
                }
        }
        
        if(complementoField.getText().length() == 0){
            errorLabelComplemento.setText("O campo complemento não pode estar vazio");
            erroComplemento = true;
        }else{
                errorLabelComplemento.setText("");
        }
        
        if(erroEstado|| erroBairro || erroCidade|| erroCep|| erroRua|| erroNumero|| erroComplemento){
            System.out.println("Deu erro e não rodou");
            return;
        }
        
        
        String[] estadoSplit = comboboxEstado.getSelectedItem().toString().split(","); 
        
        //cadastro cidade
        Estado estado = new DAOEstado().readOnEstado(estadoSplit[1]);
        
        Cidade cidade = new Cidade( cidadeField.getText(), estadoSplit[1]);
        DAOCidade daoCidade = new DAOCidade();
        daoCidade.insertCidade(cidade);
        
        ArrayList<Cidade> cidades = daoCidade.readAll();
        
        int id_cidade = 0;
        
        for (Cidade cidade1 : cidades) {
            if(cidade1.getNome().equals(cidade.getNome()) && cidade1.getUf().equals(cidade.getUf())){
                id_cidade = cidade1.getId();
            }
        }
        
        System.out.println(id_cidade);
        
        Bairro bairro = new Bairro( cidadeField.getText(), id_cidade);
        DAOBairro daoBairro = new DAOBairro();
        daoBairro.insertBairro(bairro);
        ArrayList<Bairro> bairros = daoBairro.readAll();
        
        int id_bairro = 0;
        
        for (Bairro bairro1 : bairros) {
            System.out.println("teste");
            if(bairro1.getNome().equals(bairro.getNome()) && bairro1.getId_cidade() == bairro.getId_cidade() ){
                System.out.println(bairro1.getId());
                id_bairro = bairro1.getId();
            }
        }
        
        
        String rua = ruaField.getText(),
               complemento = complementoField.getText(),
               cep = cepField.getText();
        int numero = Integer.parseInt(numeroCasaField.getText());
        
        
        Endereco endereco = new Endereco(numero, cep, rua, complemento, id_bairro);    
        DAOEndereco dao = new DAOEndereco();
        if(dao.insertEndereco(endereco)){
            if(pessoa == null){
                MenuRegistroADM menu = new MenuRegistroADM();

                menu.setVisible(true);
                menu.pack();
                menu.setLocationRelativeTo(null);
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
                return;
            }

            switch (pessoa.getTipo()) {
                case "DIR":
                    Diretor diretor =(Diretor) pessoa;
                    diretor.consultarDadosPessoais();
                    this.dispose();
                    break;

                case "DON":
                    Dono dono = (Dono) pessoa;
                    dono.consultarDadosPessoais();
                    this.dispose();
                    break;

                case "GER":
                    Gerente gerente = (Gerente) pessoa;
                    gerente.consultarDadosPessoais();
                    this.dispose();
                    break;
                case "EST":
                    Estagiario estagiario = (Estagiario) pessoa;
                    estagiario.consultarDadosPessoais();
                    this.dispose();
                    break;
                case "FUN":
                    Funcionario funcionario =(Funcionario) pessoa;
                    funcionario.consultarDadosPessoais();
                    this.dispose();
                    break;
                case "ADM":
                    if(opt.equals("CadDono")){
                        pessoa.criarDono();
                        this.dispose();
                        break;
                    }else{
                        pessoa.consultarDadosPessoais();
                        this.dispose();
                        break;
                    }
            }
        }
        
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if(pessoa == null){
                MenuRegistroADM menu = new MenuRegistroADM();

                menu.setVisible(true);
                menu.pack();
                menu.setLocationRelativeTo(null);
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
                return;
        }

        switch (pessoa.getTipo()) {
            case "DIR":
                Diretor diretor =(Diretor) pessoa;
                diretor.consultarDadosPessoais();
                this.dispose();
                break;

            case "DON":
                if(opt!= null){
                    if(opt.equals("CadFuncionario") && id_setor != -1){
                        Dono dono = new DAODono().readOneDono(pessoa.getCpf());
                        dono.admitirFuncionario(id_setor);
                        this.dispose();
                        break;
                    }
                }
                Dono dono = new DAODono().readOneDono(pessoa.getCpf());
                dono.consultarDadosPessoais();
                this.dispose();
                break;

            case "GER":
                Gerente gerente = (Gerente) pessoa;
                gerente.consultarDadosPessoais();
                this.dispose();
                break;
            case "EST":
                Estagiario estagiario = (Estagiario) pessoa;
                estagiario.consultarDadosPessoais();
                this.dispose();
                break;
            case "FUN":
                Funcionario funcionario = new DAOFuncionario().readOneFuncionario(pessoa.getCpf());
                funcionario.consultarDadosPessoais();
                this.dispose();
                break;
            case "ADM":
                if(opt.equals("CadDono")){
                    pessoa.criarDono();
                    this.dispose();
                    break;
                }else{
                    pessoa.consultarDadosPessoais();
                    this.dispose();
                }
                break;
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void limparLabelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparLabelsActionPerformed
        errorLabelEstado.setText("");
        errorLabelCidade.setText("");
        errorLabelBairro.setText("");
        errorLabelRua.setText("");
        errorLabelNumero.setText("");
        errorLabelComplemento.setText("");
        
        
        
        comboboxEstado.setSelectedIndex(0);
        cidadeField.setText("");
        bairroField.setText("");
        ruaField.setText("");
        numeroCasaField.setText("");
        complementoField.setText("");
    }//GEN-LAST:event_limparLabelsActionPerformed

    private void comboboxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxEstadoActionPerformed
    
    
    private void populaComboEndereco(){
        Conexao conexao = new Conexao();
        conexao.conect();
        ArrayList<Estado> estados = new DAOEstado().readAll();
        
        if(!estados.isEmpty()){
            
            comboboxEstado.removeAllItems();
            comboboxEstado.addItem("Selecione um estado");
            for (Estado estado : estados) {
                comboboxEstado.addItem(estado.getNome()+","+estado.getUf());                
            }
            
        }else{
            comboboxEstado.removeAllItems();
            comboboxEstado.addItem("Nenhum estado cadastrado");
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
            java.util.logging.Logger.getLogger(MenuEndereco_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEndereco_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEndereco_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEndereco_Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuEndereco_Cadastro(null,null,-1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField bairroField;
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JTextField cepField;
    private javax.swing.JTextField cidadeField;
    private javax.swing.JComboBox<String> comboboxEstado;
    private javax.swing.JTextField complementoField;
    private javax.swing.JLabel errorLabelBairro;
    private javax.swing.JLabel errorLabelCep;
    private javax.swing.JLabel errorLabelCidade;
    private javax.swing.JLabel errorLabelComplemento;
    private javax.swing.JLabel errorLabelEstado;
    private javax.swing.JLabel errorLabelNumero;
    private javax.swing.JLabel errorLabelRua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton limparLabels;
    private javax.swing.JTextField numeroCasaField;
    private javax.swing.JTextField ruaField;
    // End of variables declaration//GEN-END:variables
}
