package avaliador;

import java.util.Date;
import java.util.List;

public class Regras {
	private Date dataInic;
	private Date dataFim;
	private double multPeriodico;
	private int qtdAnos;
	private int pontMin;
	private List<Pontuacao> pontuacoes;
	
	public Regras(Date dataInic, Date dataFim, double multPeriodico, int qtdAnos, int pontMin, List<Pontuacao> pontuacoes) {
		this.dataInic = dataInic;
		this.dataFim = dataFim;
		this.multPeriodico = multPeriodico;
		this.qtdAnos = qtdAnos;
		this.pontMin = pontMin;
		this.pontuacoes = pontuacoes;
	}
	
	public Date getDataInic() {
		return dataInic;
	}
	public void setDataInic(Date dataInic) {
		this.dataInic = dataInic;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public double getMultPeriodico() {
		return multPeriodico;
	}
	public void setMultPeriodico(double multPeriodico) {
		this.multPeriodico = multPeriodico;
	}
	public int getQtdAnos() {
		return qtdAnos;
	}
	public void setQtdAnos(int qtdAnos) {
		this.qtdAnos = qtdAnos;
	}
	public int getPontMin() {
		return pontMin;
	}
	public void setPontMin(int pontMin) {
		this.pontMin = pontMin;
	}
	public List<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}
	public void setPontuacoes(List<Pontuacao> pontuacoes) {
		this.pontuacoes = pontuacoes;
	}

	
}
