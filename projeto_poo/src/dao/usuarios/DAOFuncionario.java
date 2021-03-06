package dao.usuarios;

import sistema.Conexao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.usuarios.Funcionario;

public class DAOFuncionario {
    
    private Conexao conexao;
    
    public DAOFuncionario(){
        this.conexao = new Conexao();
    }

    public ArrayList<Funcionario> readAll(){
        try {
            ArrayList<Funcionario> arrayFuncionario = new ArrayList<>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from funcionario";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            if (!resultado.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma funcionario");
            }else{
                do{
                    int id_categoria=0, 
                        id_setor=0, dia_pagamento=0;
                    Double bonificacao = 0.0;
                    Date data_inicio = null;
                    String cpf = "";
                    
                    id_categoria = resultado.getInt("id_categoria");
                    id_setor = resultado.getInt("id_setor");
                    dia_pagamento = resultado.getInt("dia_pagamento");
                    bonificacao = resultado.getDouble("bonificacao");
                    cpf = resultado.getString("cpf");
                    data_inicio = resultado.getDate("data_inicio");
                
                    String sqlQueryPessoa = "Select * from pessoa where cpf = \'" +cpf+"\';";
                    ResultSet resultQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
                            
                    String nome = "", 
                        login = "", 
                        senha = "", tipo = "";
                    int id_endereco = 0;
                    Date data_nasc = new Date(System.currentTimeMillis());
                    
                    if(!resultQueryPessoa.next()){
                        throw new NullPointerException();
                    }
                    else {
                        do {
                            nome = resultQueryPessoa.getString("nome");
                            login = resultQueryPessoa.getString("login");
                            senha = resultQueryPessoa.getString("senha");
                            tipo = resultQueryPessoa.getString("tipo");
                            id_endereco = resultQueryPessoa.getInt("id_endereco");
                            data_nasc = resultQueryPessoa.getDate("data_nasc");
                            id_endereco = resultQueryPessoa.getInt("id_endereco");                		
                        }
                        while(resultQueryPessoa.next());
                    }


                    Funcionario funcionario = new Funcionario(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), id_endereco, bonificacao,id_categoria,id_setor, dia_pagamento,data_inicio.toLocalDate());
                    arrayFuncionario.add(funcionario); 
                }while(resultado.next());
            }
            conexao.disconect();
            return arrayFuncionario;
        } 
        catch(SQLException SQLError){
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            conexao.disconect();
            return null;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return null;
        }
    }

    public boolean deleteFuncionario(String cpf){
        try{
            conexao.conect();
            String codigoDelete = "delete from Funcionario where cpf = "+ cpf;
            boolean resultado = conexao.executaSql(codigoDelete);
            
            if(resultado){
                System.out.println("Você teve sucesso em deletar o Funcionario");
                conexao.disconect();
                return true;
            }



            conexao.disconect();
            return false;
        }catch (Exception e){
            System.err.println("Houve um erro geral: "+e);
            conexao.disconect();
            return false;
        }
    }
    
    
    public Funcionario readOneFuncionario(String cpf){
        try {
            conexao.conect();
            String sqlQueryFuncionario = "Select * From Funcionario Where cpf = \'"+cpf+"\'";
            ResultSet resultadoQueryFuncionario = conexao.executaQuery(sqlQueryFuncionario);
            
            if(!resultadoQueryFuncionario.next()){
                throw new NullPointerException("Não foi possível encontrar o funcionário com este cpf");            
            } else{
                int idsetor = resultadoQueryFuncionario.getInt("id_setor"), 
                              diapagamento = resultadoQueryFuncionario.getInt("dia_pagamento"), 
                              idcat = resultadoQueryFuncionario.getInt("id_categoria");
                double bonificacao = resultadoQueryFuncionario.getDouble("bonificacao");
                Date inicio = resultadoQueryFuncionario.getDate("data_inicio");
                String sqlQueryPessoa = "Select * from pessoa where cpf = \'"+cpf+"\'";
                ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
                
                if(!resultadoQueryPessoa.next()){
                    throw new NullPointerException("Não foi possível encontrar o funcionário com este cpf");
                }else{
                    String nome = resultadoQueryPessoa.getString("nome"), login = resultadoQueryPessoa.getString("login"), senha = resultadoQueryPessoa.getString("senha"), tipo = resultadoQueryPessoa.getString("tipo");
                    int idendereco = resultadoQueryPessoa.getInt("id_endereco");
                    Date data = resultadoQueryPessoa.getDate("data_nasc");
                    Funcionario funcionario = new Funcionario(nome, login, senha, tipo, cpf, data.toLocalDate(), idendereco, bonificacao,idcat, idsetor, diapagamento, inicio.toLocalDate());
                    conexao.disconect();
                    return funcionario;
                }
            }
        } catch(SQLException e){
            System.err.println("Houve um erro durante a exclusão do Banco de Dados: "+e);
            conexao.disconect();
            return null;
        }catch (Exception e){
            System.err.println("Houve um erro geral: "+e);
            conexao.disconect();
            return null;
        }
    }
    
    
    public boolean insertFuncionario(Funcionario funcionario){
        try {
            conexao.conect();
            String sqlInsertFuncionario = "insert into public.Funcionario(bonificacao, cpf, id_categoria, id_setor, dia_pagamento, data_inicio)\n"
            +"values ("+funcionario.getBonificacao()+" , \'"+funcionario.getCpf()+"\' , "+funcionario.getId_categoria()+" , "+funcionario.getId_setor()+" , "+funcionario.getDia_pagamento()+" , \'"+funcionario.getData_inicio()+"\')";
            boolean resultado = conexao.executaSql(sqlInsertFuncionario);
            
            if(resultado){
                System.out.println("Deu certo funcionário");
                conexao.disconect();
                return true;
            }
            conexao.disconect();
            return false;
        } catch(Exception e){
            System.err.println("Houve um erro geral: "+e);
            return false;
        }
    }

    public boolean updateFuncionario(String opt, String cpf ,String dado){
        try {
            conexao.conect();
            String sqlUpdate;

            switch (opt) {

                case "nome":
                sqlUpdate = "Update Pessoa set nome = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    System.out.println(sqlUpdate);
                    conexao.executaSql(sqlUpdate);
                    break;

                case "login":
                    sqlUpdate = "Update Pessoa set login = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "senha":
                    sqlUpdate = "Update Pessoa set senha = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "tipo":
                    sqlUpdate = "Update Pessoa set tipo = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "cpf":
                    sqlUpdate = "Update Pessoa set cpf = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "data_nasc":
                    sqlUpdate = "Update Pessoa set data_nasc = \'" + dado + "\' where cpf = \'" + cpf+"\';";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_endereco":
                    sqlUpdate = "Update Pessoa set id_endereco = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                
                //Funcionario
                case "bonificacao":
                    sqlUpdate = "Update Funcionario set bonificacao = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_categoria":
                    sqlUpdate = "Update Funcionario set id_categoria = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_setor":
                    sqlUpdate = "Update Funcionario set id_setor = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "dia_pagamento":
                    sqlUpdate = "Update Funcionario set dia_pagamento = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "data_inicio":
                    sqlUpdate = "Update Funcionario set data_inicio = \'" + dado + "\' where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                default:
                    throw new Exception("Valor não encontrado");
            }

            conexao.disconect();
            return true;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro durante a atualização do Banco de Dados: " + SQLError);
            conexao.disconect();
            return false;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return false;
        }
    }


}