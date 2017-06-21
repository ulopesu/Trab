package avaliador;
import java.util.List;

public class Periodico extends Publicacao{	
	private int volume;

	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public Periodico(int ano,Veiculo veiculo,String titulo, List<Docente> autores,int num,int volume,int pagInic,int pagFim) {
		super.setAno(ano);
		super.setPagInic(pagInic);
		super.setPagFim(pagFim);
		super.setTitulo(titulo);
		super.setVeiculo(veiculo);
		super.setAutores(autores);
		super.setNum(num);
		this.volume = volume;
	}
	
}
