package dao.lugar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.lugar.Estado;
import sistema.Conexao;
import java.lang.NullPointerException;

public class DAOEstado {
    private Conexao conexao;

    public ArrayList<Estado> readAll(){
        try {
            ArrayList<Estado> arrayEstado = new ArrayList<Estado>();
            conexao = new Conexao();
            conexao.conect();

            String codBusca = "Select * from estado";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            while(resultado.next()){
                String nome, uf;
                uf = resultado.getString("uf");
                nome = resultado.getString("nome");
                Estado estado = new Estado(uf, nome);
                arrayEstado.add(estado);
            }
            return arrayEstado;
        } 
        catch(SQLException SQLError){
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            return null;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }

    public boolean insertEstado(Estado estado){
        try {
            conexao = new Conexao();
            conexao.conect();
            String sqlInsertion = "Insert into public Estado(uf,nome)"+
                                  "Values "+"("+estado+")";
            int resultado = conexao.executaSql(sqlInsertion);
            if(resultado != 0){
                return false; 
            }
            return true;
        } catch(SQLException SQLError){
            System.err.println("Ocorreu um erro com Inserção no Banco de Dados: " + SQLError);
            return false;
        } catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return false;
        }
    }

    public Estado readOnEstado(String uf){
        try {
            conexao = new Conexao();
            Estado estado;
            String queryEstado = "SELECT * FROM ESTADO WHERE UF = "+uf;
            ResultSet resultadoQuery = conexao.executaQuery(queryEstado);
            if (!resultadoQuery.next()) {
                throw new NullPointerException("Não foi possível achar nenhum estado");
            } else{
                String nome = resultadoQuery.getString("nome");
                estado = new Estado(uf, nome);
            }
            return estado;
        } catch(SQLException SQLError){
            System.err.println("Ocorreu um erro com Inserção no Banco de Dados: " + SQLError);
            return null;
        }
        catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            return null;
        }
    }
    public boolean deleteEstado(int id){
        try{
            Conexao conexao = new Conexao();
            conexao.conect();
            String codigoDelete = "delete from estado where id = "+ id;
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o estado");
                return true;
            }



        }catch(SQLException e){
            System.err.println("Houve um erro durante a exclusão do Banco de Dados: "+e);
            return false;
        }catch (Exception e){
            System.err.println("Houve um erro geral: "+e);
            return false;
        }
        return false;
    }
}
