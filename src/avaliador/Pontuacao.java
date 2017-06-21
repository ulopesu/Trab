package avaliador;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Pontuacao {
	private Qualis qualis;
	private int valor;
	
	
	public Pontuacao(Qualis qualis, int valor) {
		this.qualis = qualis;
		this.valor = valor;
	}
	
	public Qualis getQualis() {
		return qualis;
	}
	public void setQualis(Qualis qualis) {
		this.qualis = qualis;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public static void main(String args[]){
			
		List<Docente> docentes = new ArrayList<>(); 
		List<Veiculo> veiculos = new ArrayList<>();
		List<Qualificacao> qualificacoes = new ArrayList<>();
		List<Publicacao> publicacoes = new ArrayList<>();
		List<Regras> regras = new ArrayList<>();
		List<Pontuacao> pontuacoes = new ArrayList<>();
		
		LeiaCSV arquivo = new LeiaCSV();
		
		Locale.setDefault(new Locale("pt", "BR"));
		
	    arquivo.lerDocentes(docentes,"src/teste/in/docentes.csv");
	    arquivo.lerVeiculos(veiculos,"src/teste/in/veiculos.csv");
	    arquivo.lerQualificacao(qualificacoes,"src/teste/in/qualis.csv", veiculos);
	    arquivo.lerPublicacao(publicacoes,"src/teste/in/publicacoes.csv", veiculos, docentes);
	    arquivo.lerRegras(regras, "src/teste/in/regras.csv", qualificacoes, pontuacoes);
	    
	    //OBSERVAR NO UML SE QUALIS POSSUI PONTUACAO, CASO TENHA, ALTERAR QUALIS E ALTERAR LER REGRAS
	    //LER PDF E PARTIR PARA PROX ETAPA DO PROG
	    
	    
//	    for (Qualificacao quali : qualificacoes){
//	    	if (quali.getQualis().getPontuacao() != null){
//	    		System.out.println(quali.getQualis().getPontuacao().getValor());
//	    	} else {
//	    		System.out.println("NÃO TEM");
//	    	}
//	    }
	    
	    
	    System.out.println(docentes.get(0).getPublicacoes().get(0).getTitulo());
	    
	  }
}
