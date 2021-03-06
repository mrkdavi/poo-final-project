package dao.lugar;

import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.lugar.Cidade;

public class DAOCidade {
    private Conexao conexao;

    public DAOCidade(){
        this.conexao = new Conexao();
    }

    public ArrayList<Cidade> readAll() {
        try {
            ArrayList<Cidade> arrayCidade = new ArrayList<Cidade>();

            conexao.conect();

            String codBusca = "Select * from cidade";
            ResultSet resultado = conexao.executaQuery(codBusca);
            
            if (!resultado.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma cidade");
            }else{
                do{
                    int id;
                    String uf, nome;
                    id = resultado.getInt("id");
                    uf = resultado.getString("uf");
                    nome = resultado.getString("nome");
                    Cidade cidade = new Cidade( nome, uf);
                    cidade.setId(id);
                    arrayCidade.add(cidade);
                }while (resultado.next());
            }

            conexao.disconect();
            return arrayCidade;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            conexao.disconect();
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return null;
        }
    }

    public Cidade readOnCidade(int id) {
        try {
            conexao.conect();

            Cidade cidade;
            String queryCidade = "SELECT * FROM CIDADE WHERE ID = " + id;
            ResultSet resultadoQuery = conexao.executaQuery(queryCidade);
            if (!resultadoQuery.next()) {
                throw new NullPointerException("Não foi possível achar nenhuma cidade");
            } else {
                String nome = resultadoQuery.getString("nome"), uf = resultadoQuery.getString("uf");
                cidade = new Cidade( nome, uf);
                cidade.setId(id);
            }
            conexao.disconect();
            return cidade;
        } catch (SQLException SQLError) {
            System.err.println("Ocorreu um erro na leitura do Banco de Dados: " + SQLError);
            conexao.disconect();
            return null;
        } catch (Exception geralError) {
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return null;
        }
    }
    public boolean deleteCidade(int id){
        try{
            conexao.conect();

            String codigoDelete = "delete from cidade where id = "+ id;
            boolean resultado = conexao.executaSql(codigoDelete);
            
            if(resultado){
                System.out.println("Você teve sucesso em deletar a cidade");
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

    public boolean insertCidade(Cidade cidade){
        try{
            conexao.conect();

            String sqlInsertion = "Insert into Cidade(nome, uf)"
                                + "values (\'"+ cidade.getNome()+"\' , \'"+cidade.getUf()+"\')";
            boolean resultado = conexao.executaSql(sqlInsertion);

            if(resultado){
                System.out.println("Deu certo Cidade");
                conexao.disconect();
                return true;
            }

            conexao.disconect();
            return false;

        } catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return false;
        }
    }

    public boolean updateCidade(String opt, int id, String dado){
        try {
            conexao.conect();
            
            String sqlUpdate;

            switch (opt) {
                case "id":
                    sqlUpdate = "Update Cidade set id = "+dado+" where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;
    
                case "nome":
                    sqlUpdate = "Update Cidade set nome = \'"+dado+"\' where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "uf":
                    sqlUpdate = "Update Cidade set uf = \'"+dado+"\' where id = " + id;
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