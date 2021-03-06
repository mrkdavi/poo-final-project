package dao.usuarios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.usuarios.Estagiario;
import sistema.Conexao;

public class DAOEstagiario{
    private Conexao conexao;

    public DAOEstagiario(){
        this.conexao = new Conexao();
    }

    public ArrayList<Estagiario> ReadAll(){
        try {
            ArrayList<Estagiario> arrayEstagiario = new ArrayList<>();
            conexao.conect();

            String sqlQueryEstagiario = "Select * from Estagiario";
            ResultSet resultQueryEstagiario = conexao.executaQuery(sqlQueryEstagiario);

            if (!resultQueryEstagiario.next()) {
                throw new NullPointerException("Não foi possível achar nenhum Estagiario");
            }else{
                do{
                String cpf = "";
                int id_categoria = 0, id_setor = 0, diaPagamento = 0, tempoEstagio = 0;
                Date inicioEstagio = new Date(System.currentTimeMillis()); 
                
                cpf = resultQueryEstagiario.getString("cpf");
                id_categoria = resultQueryEstagiario.getInt("id_categoria");
                id_setor = resultQueryEstagiario.getInt("id_setor");
                diaPagamento= resultQueryEstagiario.getInt("diaPagamento");
                tempoEstagio = resultQueryEstagiario.getInt("tempoEstagio");
                inicioEstagio = resultQueryEstagiario.getDate("inicioEstagio");
                id_categoria = resultQueryEstagiario.getInt("id_categoria");
                id_setor = resultQueryEstagiario.getInt("id_setor");

                String sqlQueryPessoa = "Select * from pessoa where cpf = \'"+cpf+"\'";
                ResultSet resultQueryPessoa = conexao.executaQuery(sqlQueryPessoa);

                String nome ="", 
                       login = "", 
                       senha = "", 
                       tipo = "";

                Date data_nasc= new Date(System.currentTimeMillis());
                
                int id_endereco = 0;


                if(!resultQueryPessoa.next()){
                    throw new Exception("Não foi achada nenhuma pessoa com o cpf especificado");
                }else{
                    do {
                        nome = resultQueryPessoa.getString("nome");
                        login = resultQueryPessoa.getString("login");
                        senha = resultQueryPessoa.getString("senha");
                        tipo = resultQueryPessoa.getString("tipo");
                        data_nasc = resultQueryPessoa.getDate("data_nasc");
                        id_endereco = resultQueryPessoa.getInt("id_endereco");
                        
                    } while (resultQueryPessoa.next());
                }


                Estagiario estagiario = new Estagiario(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), inicioEstagio.toLocalDate(), tempoEstagio, diaPagamento, id_categoria, id_setor, id_endereco);
                arrayEstagiario.add(estagiario);
                }while(resultQueryEstagiario.next());
            }
            conexao.disconect();
            return arrayEstagiario;
        } 
        catch (SQLException sqlError) {
            System.err.println("Ocorreu um erro durante a busca no banco de dados:" +sqlError);      
            conexao.disconect();      
            return null; 
        } 
        catch (Exception geralError){
            System.err.println("Ocorreu um erro geral:" +geralError);    
            conexao.disconect();        
            return null;
        }
    }

    public Estagiario readOneEstagiario(String cpf){
        try{
            conexao.conect();
            String sqlQueryEstagiario = "Select * from Estagiario where cpf: \'"+cpf+"\'" ;
            ResultSet resultadoQueryEstagiario = conexao.executaQuery(sqlQueryEstagiario);
            if(!resultadoQueryEstagiario.next()){
                throw new NullPointerException("Não foi possível encontrar o Estagiário com este CPF");
            }else{
                int id_categoria = resultadoQueryEstagiario.getInt("id_categoria");
                int id_setor = resultadoQueryEstagiario.getInt("id_setor");
                int dia_pagamento = resultadoQueryEstagiario.getInt("dia_pagamento");
                int tempo_estagio = resultadoQueryEstagiario.getInt("tempo_estagio");
                Date inicio_estagio = resultadoQueryEstagiario.getDate("incio_estagio");
                
                String sqlQueryPessoa = "Select * from Pessoa where cpf = \'"+cpf+"\'";
                ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
                if(!resultadoQueryPessoa.next()){
                    throw new NullPointerException("Não foi possível encontrar o Estagiário com este CPF");
                    
                }else{
                    String nome = resultadoQueryPessoa.getString("nome");
                    Date data_nasc = resultadoQueryPessoa.getDate("data_nasc");
                    String login = resultadoQueryPessoa.getString("login");
                    String senha = resultadoQueryPessoa.getString("senha");
                    String tipo = resultadoQueryPessoa.getString("tipo");
                    int id_endereco = resultadoQueryPessoa.getInt("id_endereco");

                    Estagiario estagiario = new Estagiario(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(), inicio_estagio.toLocalDate(), tempo_estagio, dia_pagamento, id_categoria, id_setor, id_endereco);
                    conexao.disconect();
                    return estagiario;
                }
            }

        }catch (SQLException sqlError) {
            System.err.println("Ocorreu um erro durante a busca no banco de dados:" +sqlError);
            conexao.disconect();            
            return null; 
        } 
        catch (Exception geralError){
            System.err.println("Ocorreu um erro geral:" +geralError);
            conexao.disconect();            
            return null;
        }
    }

    public boolean insertEstagiario(Estagiario estagiario){
        try{
            
            conexao.conect();
            String sqlInsertion = "Insert into public.Estagiario(cpf, inicio_estagio, tempo_estagio, dia_pagamento, id_categoria, id_setor, id_endereco)\n"
                                +"values (\'"+estagiario.getCpf()+"\', "+estagiario.getInicio_estagio()+", \'"+estagiario.getTempo_estagio()+", "+estagiario.getDia_pagamento()+", "+estagiario.getId_categoria()+", "+estagiario.getId_setor()+", "+estagiario.getId_endereco()+")";
            boolean resultado = conexao.executaSql(sqlInsertion);

            if(resultado){
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

    public boolean updateEstagiario(String opt, String cpf ,String dado){
        try {

            String sqlUpdate;

            switch (opt) {
                
                case "nome":
                    sqlUpdate = "Update Pessoa set nome = \'" + dado + "\' where cpf = \'" + cpf+"\';";
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

                //Estagiario
                case "inicio_estagio":
                    sqlUpdate = "Update Estagiario set inicio_estagio = \'" + dado + "\' where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                
                case "tempo_estagio":
                    sqlUpdate = "Update Estagiario set tempo_estagio = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;
                
                case "dia_pagamento":
                    sqlUpdate = "Update Estagiario set dia_pagamento = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_categoria":
                    sqlUpdate = "Update Estagiario set id_categoria = " + dado + " where cpf = \'" + cpf+"\'";
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_setor":
                    sqlUpdate = "Update Estagiario set id_setor = " + dado + " where cpf = \'" + cpf+"\'";
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
    
    public boolean deleteEstagiario(String cpf){
        try{
            conexao.conect();
            String codigoDelete = "delete from estagiario where cpf = "+ cpf;
            boolean resultado = conexao.executaSql(codigoDelete);
            
            if(resultado){
                System.out.println("Você teve sucesso em deletar o estagiario");
                conexao.disconect();
                return true;
            }else{
                throw new Exception("Não foi possível deletar o funcionário");
            }
        }catch(SQLException SQLError){
            System.err.println("Houve um erro durante a exclusão do Banco de Dados: " +SQLError);
            conexao.disconect();
            return false;
        }
        catch(Exception geralError){
            System.err.println("Houve um erro geral: " +geralError);
            conexao.disconect();
            return false;
        }
        
    }
}




/*
    if(!resultQueryClasse.next()){
        throw new Exception("Não foi achada nenhuma pessoa com o cpf especificado");
    }else{
        do {
            
        } while (resultQueryClasse.next());
    }

*/