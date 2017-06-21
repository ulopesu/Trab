package avaliador;

import java.util.ArrayList;
import java.util.List;

public class Qualificacao {
	private int ano;
	private Qualis qualis;
	private Veiculo veiculo;
	
	
	public Qualificacao(int ano, Qualis qualis, Veiculo veiculo) {
		this.ano = ano;
		this.qualis = qualis;
		this.veiculo = veiculo;
	}

	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Qualis getQualis() {
		return qualis;
	}
	public void setQualis(Qualis qualis) {
		this.qualis = qualis;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Qualificacao> pegaQualificacoes(List<Qualificacao> qualificacoes, String nome){
		List<Qualificacao> qualis = new ArrayList<>();
		for(Qualificacao quali : qualificacoes){
			if(quali.getQualis().getNome().equals(nome)){
				qualis.add(quali);
			}
		}
		return qualis;
	}
	
	public Qualis pegaQualis(List<Qualificacao> qualificacoes, String nome){
		for(Qualificacao quali : qualificacoes){
			if(quali.getQualis().getNome().equals(nome)){
				return quali.getQualis();
			}
		}
		return null;
	}
}
