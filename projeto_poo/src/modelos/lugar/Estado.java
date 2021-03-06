package modelos.lugar;

import java.util.ArrayList;

import dao.lugar.DAOEstado;

public class Estado {
    private String uf;
    private String nome;
    private DAOEstado daoEstado;
    ArrayList<Cidade> cidades;

    public Estado(String uf, String nome) {
        this.uf = uf;
        this.nome = nome;
        //this.cidades = cidades;
    }

    public DAOEstado getDaoEstado() {
        return daoEstado;
    }

    public String toString(){
        return "(\'"+uf+"\', \'"+nome+"\')";
    }

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(ArrayList<Cidade> cidades) {
        this.cidades = cidades;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
