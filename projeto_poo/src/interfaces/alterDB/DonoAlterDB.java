package interfaces.alterDB;

public interface DonoAlterDB {
    public abstract void admitirDiretor();
    public abstract void demitirDiretor();
    public abstract void alterarNomeEmpresa();
    public abstract void alterarOrcamentoEmpresa();
    public abstract void adicionarSetores(String cnpj);
    public abstract void alterarNomeSetor();
    public abstract void alterarOrcamentoSetor();
    public abstract void demitirFuncionario();
    public abstract void bonificarFuncionario();
    public abstract void admitirFuncionario(int setor);
    public abstract void admitirEstagiario();
    public abstract void dispensarEstagiario();
    public abstract void trocarEstagiarioSetor();
}
