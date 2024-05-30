public class Candidato {

    String nome;
    String partido;
    int intencoesVotos;

    public Candidato(String nome, String partido, int intencoesVotos ) {
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setIntencoesVoto(int intVotos) {
        this.intencoesVotos = intVotos;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getIntencoesVotos() {
        return intencoesVotos;
    }

    public String toString() {
        return "Candidato: " +nome+ " | partido: " +partido+ " | Votos: "+intencoesVotos;
    }



}
