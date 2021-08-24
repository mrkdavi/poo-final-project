package dao.usuarios;

import modelos.usuarios.Diretor;
import sistema.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class DAODiretor {
    private Conexao conexao;

    public ArrayList<Diretor> readAll() {
        try {
            ArrayList<Diretor> arrayDiretores = new ArrayList<Diretor>();
            conexao = new Conexao();
            conexao.conect();

            String codigoBusca = "select * from diretor";
            ResultSet resultado = conexao.executaQuery(codigoBusca);

            while (resultado.next()) {
                String cnpjEmpresa = "", cpf="";
                int idCategoria = 0;

                String sqlQueryPessoa = "Select * from pessoa where cpf = \'"+cpf+"\'";
                ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);

                String nome = "", login="", senha="", tipo="";
                int id_endereco = 0;
                Date dataNasc = new Date(System.currentTimeMillis());
                boolean achou = false;

                if(resultadoQueryPessoa.next()){
                    nome = resultado.getString("nome");
                    login = resultado.getString("login");
                    senha = resultado.getString("senha");
                    tipo = resultado.getString("tipo");
                    dataNasc = resultado.getDate("data_nasc");
                    id_endereco = resultado.getInt("id_endereco");
                    achou = true;
                }
                if (!achou) {
                    throw new NullPointerException("Não foi achada nenhuma pessoa com esse cpf");
                }

                Diretor diretor = new Diretor(nome, login, senha, tipo, cpf, dataNasc.toLocalDate(), cnpjEmpresa, idCategoria,id_endereco);
                arrayDiretores.add(diretor);

            }
            return arrayDiretores;
        } catch (SQLException erroSQL) {
            System.err.println("Erro ao recuperar do banco de dados: " + erroSQL);
            return null;
        } catch (Exception erroGeral) {
            System.err.println("Erro Geral: " + erroGeral);
            return null;
        }
    }   





    public Diretor readOneDiretor(String cpf){

        try{
            conexao.conect();
            String sqlQueryDiretor = "Select * from DIRETOR where cpf = \'"+cpf+"\'";
            ResultSet resultadoQueryDiretor = conexao.executaQuery(sqlQueryDiretor);
            if(!resultadoQueryDiretor.next()){
                throw new NullPointerException("O Diretor que você está procurando não foi encontrado, retornou nulo");
            }else{ 
                String cnpj_empresa = resultadoQueryDiretor.getString("cnpj_empresa");
                int id_categoria = resultadoQueryDiretor.getInt("id_categoria");

                String sqlQueryPessoa = "select * from pessoa where cpf = \'"+cpf+"\'";
                ResultSet resultadoQueryPessoa = conexao.executaQuery(sqlQueryPessoa);
                if (!resultadoQueryPessoa.next()){
                    throw new NullPointerException("O Dono que você está procurando não foi encontrado, retornou nulo");
                }else{
                    String  nome = resultadoQueryPessoa.getString("nome"),
                            login = resultadoQueryPessoa.getString("login"),
                            senha = resultadoQueryPessoa.getString("senha"),
                            tipo = resultadoQueryPessoa.getString("tipo");
                    Date data_nasc  = resultadoQueryPessoa.getDate("data_nasc");
                    int id_endereco = resultadoQueryPessoa.getInt("id_endereco");

                    Diretor diretor = new Diretor(nome, login, senha, tipo, cpf, data_nasc.toLocalDate(),cnpj_empresa, id_categoria, id_endereco);
                    return diretor;

                }
                
            }
        }catch (SQLException erroSQL) {
            System.err.println("Ocorreu um erro durante a busca do banco de dados: " + erroSQL);
            return null;
        } catch (Exception erroGeral) {
            System.err.println("ocorreu um erro Geral: " + erroGeral);
            return null;
        }
    }





    public boolean deleteDiretor(String cpf){
        try{
            Conexao conexao = new Conexao();
            conexao.conect();
            
            String codigoDelete = "delete from Diretor where cpf = \'"+ cpf +"\'";
            int resultado = conexao.executaSql(codigoDelete);
            if(resultado != 1){
                System.out.println("Você teve sucesso em deletar o diretor");
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



    

    public boolean insertDiretor(Diretor diretor){
        try{

            conexao.conect();
            String sqlInsertDiretor = "insert into public.Diretor(cpf, cnpj_empresa, id_categoria)\n"
                                 + "values (\'"+diretor.getCpf()+"\' , \'"+diretor.getCnpj_empresa()+"\' , "+diretor.getId_categoria()+ ")\n";
            int resultado = conexao.executaSql(sqlInsertDiretor);
            return (resultado != 0);
        } catch(SQLException e){
            System.err.println("Houve um erro durante a inserção no banco de dados: "+e);
            return false;
        }catch(Exception e){
            System.err.println("Houve um erro geral: "+e);
            return false;

        }

    }
}