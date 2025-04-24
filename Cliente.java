package LanHouse;

class Cliente{
    private String nome;
    private String cpf;
    private String telefone;
    private String plano;
    int minutosRestantes = 0;

    public Cliente(String nome, String cpf,  String telefone, String planoEscolhido) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setPlano(planoEscolhido);
        setMinutos(planoEscolhido);
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }
    public int getMinutos() {
        return minutosRestantes;
    }
    public void setMinutos(String plano) {
        switch (plano) {
            case "semanal":
                minutosRestantes = 20 * 60;
                break;
            case "mensal":
                minutosRestantes = 100 * 60;
                break;
            case "semestral":
                minutosRestantes = 800 * 60;
                break;
        }
    }

}