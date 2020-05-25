package br.com.sky.javacore.l31padroesdeprojeto.classes;

public class Pessoa {
    private String nome;
    private String nomeMeio;
    private String ultimoNome;
    private String apelido;
    private String nomeDoPai;

    private Pessoa(String nome, String nomeMeio, String ultimoNome, String apelido, String nomeDoPai) {
        this.nome = nome;
        this.nomeMeio = nomeMeio;
        this.ultimoNome = ultimoNome;
        this.apelido = apelido;
        this.nomeDoPai = nomeDoPai;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", nomeMeio='" + nomeMeio + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", nomeDoPai='" + nomeDoPai + '\'' +
                '}';
    }

    public static class PessoaBuilder {
        private String nome;
        private String nomeMeio;
        private String ultimoNome;
        private String apelido;
        private String nomeDoPai;

        public PessoaBuilder(String nome) {
            this.nome = nome;
        }

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder nomeMeio(String nomeMeio) {
            this.nomeMeio = nomeMeio;
            return this;
        }

        public PessoaBuilder ultimoNome(String ultimoNome) {
            this.ultimoNome = ultimoNome;
            return this;
        }

        public PessoaBuilder apelido(String apelido) {
            this.apelido = apelido;
            return this;
        }

        public PessoaBuilder nomeDoPai(String nomeDoPai) {
            this.nomeDoPai = nomeDoPai;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(nome, nomeMeio, ultimoNome, apelido, nomeDoPai);
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMeio() {
        return nomeMeio;
    }

    public void setNomeMeio(String nomeMeio) {
        this.nomeMeio = nomeMeio;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }
}
