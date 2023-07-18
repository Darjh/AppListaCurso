package devandroid.darjh.applistacurso.model;

public class Pessoa {

    //Construtor
    //Atributos - Objetos - Molde - Modelo - Template
    //Métodos de Acesso - Getts and Setts

    private String priNome;
    private String sobreNome;
    private String cursoDesejado;
    private String telContato;

    public Pessoa() {

    }
    public String getPriNome() {
        return priNome;
    }

    public void setPriNome(String priNome) {
        this.priNome = priNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    //To String - Para textos - Para Strings de caracteres

    @Override
    public String toString() {
        return "Pessoa{" +
                "priNome='" + priNome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", telContato='" + telContato + '\'' +
                '}';
    }
}
