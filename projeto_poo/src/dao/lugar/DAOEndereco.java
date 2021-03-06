package dao.lugar;

import java.util.ArrayList;
import modelos.lugar.Endereco;
import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOEndereco {
    private Conexao conexao;
    public DAOEndereco(){
        this.conexao = new Conexao();
    }

    public ArrayList<Endereco> readAll() {
        try {
            ArrayList<Endereco> arrayEnderecos = new ArrayList<Endereco>();
            conexao.conect();

            ResultSet resultado = conexao.executaQuery("select * from Endereco");

            if (!resultado.next()) {
                throw new NullPointerException("Não foi possível achar nenhum Endereco");
            }else{
                do{
                    String cep, rua, complemento;
                    int id, id_bairro, numero;

                    cep = resultado.getString("cep");
                    rua = resultado.getString("rua");
                    complemento = resultado.getString("complemento");

                    id = resultado.getInt("id");
                    id_bairro = resultado.getInt("id_bairro");
                    numero = resultado.getInt("numero");

                    Endereco endereco = new Endereco( numero, cep, rua, complemento, id_bairro);
                    endereco.setId(id);
                    arrayEnderecos.add(endereco);
                }while(resultado.next());
            }
            conexao.disconect();
            return arrayEnderecos;
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar do banco de dados" + e);
            conexao.disconect();
            return null;
        } catch (Exception e) {
            System.err.println("Erro Geral: " + e);
            conexao.disconect();
            return null;
        }
    }
    public boolean deleteEndereco(int id){
        try{
            conexao.conect();

            String codigoDelete = "delete from endereco where id = "+ id;
            boolean resultado = conexao.executaSql(codigoDelete);
            
            if(resultado){
                System.out.println("Você teve sucesso em deletar o Endereco");
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

    public boolean insertEndereco(Endereco endereco){
        try{
            conexao.conect();
            String sqlInsertion = "Insert into Endereco(numero, cep, rua, complemento, id_bairro)"
                                + "values " + "("+endereco.getNumero()+" , \'" + endereco.getCep() +"\' , \'"+endereco.getRua()+"\' , \'"+endereco.getComplemento()+"\',"+endereco.getId_bairro()+")";
                boolean resultado = conexao.executaSql(sqlInsertion);

                if(!resultado){
                conexao.disconect();
                return false;
            }
                System.out.println("Deu certo Endereco");
            conexao.disconect();
            return true;
        } catch(Exception geralError){
            System.err.println("Ocorreu um erro geral: " + geralError);
            conexao.disconect();
            return false;
        }
    }
    
    public Endereco readOnEndereco(int id) {
        try {
            conexao.conect();

            Endereco endereco;
            String queryEndereco = "SELECT * FROM endereco WHERE ID = " + id;
            ResultSet resultadoQuery = conexao.executaQuery(queryEndereco);
            if (!resultadoQuery.next()) {
                throw new NullPointerException("Não foi possível achar o endereco");
            } else {
                String cep = resultadoQuery.getString("cep"), rua = resultadoQuery.getString("rua"), complemento = resultadoQuery.getString("complemento");
                int numero = resultadoQuery.getInt("numero"), idbairro = resultadoQuery.getInt("id_bairro");
                endereco = new Endereco( numero, cep, rua, complemento, idbairro);
                endereco.setId(id);
            }
            conexao.disconect();
            return endereco;
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

    public boolean updateEndereco(String opt, int id ,String dado){
        try {
            conexao.conect();
            String sqlUpdate;

            switch (opt) {
                case "id":
                    sqlUpdate = "Update Endereco set id = " + dado + " where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "numero":
                    sqlUpdate = "Update Endereco set numero = " + dado + " where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "cep":
                    sqlUpdate = "Update Endereco set cep = \'" + dado + "\' where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "rua":
                    sqlUpdate = "Update Endereco set rua = \'" + dado + "\' where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "complemento":
                    sqlUpdate = "Update Endereco set complemento = \'" + dado + "\' where id = " + id;
                    conexao.executaSql(sqlUpdate);
                    break;

                case "id_bairro":
                    sqlUpdate = "Update Endereco set id_bairro = " + dado + " where id = " + id;
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
