package avaliador;
import java.util.List;

public class Qualis {
	private List<Qualificacao> qualificacoes;
	private String nome;
	private Pontuacao pontuacao;
	
	
	public Qualis(List<Qualificacao> qualificacoes, String nome, Pontuacao pontuacao) {
		this.qualificacoes = qualificacoes;
		this.nome = nome;
		this.pontuacao = pontuacao;
	}
	
	public List<Qualificacao> getQualificacoes() {
		return qualificacoes;
	}
	public void setQualificacoes(List<Qualificacao> qualificacoes) {
		this.qualificacoes = qualificacoes;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pontuacao getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(Pontuacao pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	
}
