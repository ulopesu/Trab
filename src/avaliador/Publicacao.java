package avaliador;

import java.util.List;

public abstract class Publicacao {
	private int ano;
	private int pagInic;
	private int pagFim;
	private String titulo;
	private Veiculo veiculo;
	private List<Docente> autores;
	private int num;

	
	public int getAno(){
		return this.ano;
	}
	public void setAno(int ano){
		this.ano = ano;
	}
	public int getPagInic(){
		return this.pagInic;
	}
	public void setPagInic(int pagInic){
		this.pagInic = pagInic;
	}
	public int getPagFim(){
		return this.pagFim;
	}
	public void setPagFim(int pagFim){
		this.pagFim = pagFim;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public List<Docente> getAutores() {
		return autores;
	}
	public void setAutores(List<Docente> autores) {
		this.autores = autores;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void linkaPublicacaoDocente(Docente autor){
		this.autores.add(autor);
	}
	
}
