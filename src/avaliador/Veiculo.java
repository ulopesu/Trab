package avaliador;

import java.util.List;

public class Veiculo {
	private char tipo;
	private String nome;
	private String sigla;
	private String issn;
	private double fatorDeImpacto;
	private List<Qualificacao> qualificacoes;
	private List<Publicacao> publicacoes;
	
	public Veiculo(char tipo, String nome, String sigla, String issn, double fatorDeImpacto, List<Qualificacao> qualificacoes, List<Publicacao> publicacoes) {
		this.tipo = tipo;
		this.nome = nome;
		this.sigla = sigla;
		this.issn = issn;
		this.fatorDeImpacto = fatorDeImpacto;
		this.qualificacoes = qualificacoes;
		this.publicacoes = publicacoes;
	}

	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getIssn() {
		return issn;
	}
	public void setIssn(String issn) {
		this.issn = issn;
	}
	public double getFatorDeImpacto() {
		return fatorDeImpacto;
	}
	public void setFatorDeImpacto(double fatorDeImpacto) {
		this.fatorDeImpacto = fatorDeImpacto;
	}
	public List<Qualificacao> getQualificacoes() {
		return qualificacoes;
	}
	public void setQualificacoes(List<Qualificacao> qualificacoes) {
		this.qualificacoes = qualificacoes;
	}
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
	
	public Veiculo pegaVeiculo(List<Veiculo> veiculos, String sigla){
		for(Veiculo v : veiculos){
			if(v.getSigla().equals(sigla)){
				return v;
			}
		}
		return null;
	}
	
}
