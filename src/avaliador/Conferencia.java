package avaliador;
import java.util.List;

public class Conferencia extends Publicacao{
	private String local;

	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Conferencia(int ano,Veiculo veiculo,String titulo,List<Docente> autores,int num,String local,int pagInic,int pagFim) {
		super.setAno(ano);
		super.setPagInic(pagInic);
		super.setPagFim(pagFim);
		super.setTitulo(titulo);
		super.setVeiculo(veiculo);
		super.setAutores(autores);
		super.setNum(num);
		this.local = local;
	}
	
}
