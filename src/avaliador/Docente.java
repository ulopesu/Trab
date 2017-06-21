package avaliador;
import java.util.Date;
import java.util.List;

public class Docente {
	private String nome;
	private Date nascimento;
	private Date engresso;
	private boolean ehCoordenador;
	private List<Publicacao> publicacoes;
	private long codigo;
	
	public Docente(String nome, Date nascimento, Date engresso, boolean ehCoordenador, List<Publicacao> publicacoes, long codigo) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.engresso = engresso;
		this.ehCoordenador = ehCoordenador;
		this.publicacoes = publicacoes;
		this.codigo = codigo;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Date getEngresso() {
		return engresso;
	}
	public void setEngresso(Date engresso) {
		this.engresso = engresso;
	}
	public boolean isEhCoordenador() {
		return ehCoordenador;
	}
	public void setEhCoordenador(boolean ehCoordenador) {
		this.ehCoordenador = ehCoordenador;
	}
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}
	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
	
	public Docente pegaDocente(List<Docente> docentes, long codigo){
		for(Docente d : docentes){
			if(d.getCodigo() == codigo){
				return d;
			}
		}
		return null;
	}
//	public double calcula(){
//		double result = 0;
//		for(Publicacao publi : this.)
//		
//		
//		return 2result;
//	}
	
	public void linkaPublicacaoDocente(Publicacao publicacao){
		this.publicacoes.add(publicacao);
		publicacao.linkaPublicacaoDocente(this);
	}
	
	
}
