package classes.sistema;

import java.sql.Timestamp;

public class LogAlteracao {
    private Timestamp data;
    private String tipo,codigo,mensagem;
    private int id;

    public LogAlteracao(Timestamp data, String tipo, String codigo, String mensagem, int id) {
        this.data = data;
        this.tipo = tipo;
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.id = id;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
