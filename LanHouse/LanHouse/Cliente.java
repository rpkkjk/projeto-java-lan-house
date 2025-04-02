package LanHouse;

class Cliente{
    private String nome;
    private String cpf;
    private String telefone;
    private int plano;
    private int minutosRestantes = 0;

    public Cliente(String nome, String cpf,  String telefone, int plano) {
        setNome(nome);
        setCpf(cpf);
        setTelefone(telefone);
        setPlano(plano);
        setMinutos(plano);
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
        switch (plano) {
            case 1:
                return "Semanal";
            case 2: 
                return "Mensal";
            case 3: 
                return "Semestral";
            default:
                return "Sem plano";
        }
    }

    public void setPlano(int plano) {
        this.plano = plano;
    }
    public int getMinutos() {
        return minutosRestantes;
    }
    public void setMinutos(int plano) {
        switch (plano) {
            case 1:
                minutosRestantes = 20 * 60;
                break;
            case 2:
                minutosRestantes = 100 * 60;
                break;
            case 3:
                minutosRestantes = 800 * 60;
                break;
        }
    }

}