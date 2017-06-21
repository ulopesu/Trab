package avaliador;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class LeiaCSV {

	 public void lerDocentes(List<Docente> docentes, String diretorio){
		 
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    String arquivoCSV = diretorio;
	    BufferedReader br = null;
	    String linha = "";
	    String csvDivisor = ";";
	    
	    try {
	        br = new BufferedReader(new FileReader(arquivoCSV));
	        linha = br.readLine();	      
	        String nome;
	        long codigo;
	        Date nascimento = null;
	        Date engresso = null;
	        boolean ehCoordenador;
	        
	        while ((linha = br.readLine()) != null) {
	            String[] leitura = linha.split(csvDivisor);
	            
	            codigo = Long.parseLong(leitura[0].trim());
	            nome = leitura[1].trim();
	            
				try {
					nascimento = formato.parse(leitura[2].trim());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
	            try {
					engresso = formato.parse(leitura[3].trim());
				} catch (ParseException e) {
					e.printStackTrace();
				} 
	            
	            if(leitura.length <= 4)
	            	ehCoordenador = false;
	            else{
	            	if(leitura[4] == "X")
	            		ehCoordenador = true;
	            	else
	            		ehCoordenador = false;	
	            }
	            if(nascimento != null && engresso != null){
		            Docente docente = new Docente(nome, nascimento, engresso, ehCoordenador, new ArrayList<Publicacao>(), codigo);
		            docentes.add(docente);
	            }
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	 
	 public void lerVeiculos(List<Veiculo> veiculos, String diretorio){		 	
		    String arquivoCSV = diretorio;
		    BufferedReader br = null;
		    String linha = "";
		    String csvDivisor = ";";
		    NumberFormat nf = NumberFormat.getInstance();
		    
		    try {
		        br = new BufferedReader(new FileReader(arquivoCSV));        
		        linha = br.readLine();
		        
		        while ((linha = br.readLine()) != null) {
		        	String[] leitura = linha.split(csvDivisor);
		        	char tipo = leitura[2].charAt(0);
		        	String nome = leitura[1].trim();
		        	String sigla = leitura[0].trim();
		        	String issn;
		        	double fatorDeImpacto = 0;
		        	
					try {
						fatorDeImpacto = nf.parse(leitura[3].trim()).doubleValue();
					} catch (ParseException e) {
						e.printStackTrace();
					}
		        	
		            if(leitura.length <= 4)
		            	issn  = null;
		            else
		            	issn = leitura[4];
		            
		            Veiculo veiculo = new Veiculo(tipo, nome, sigla, issn, fatorDeImpacto, new ArrayList<Qualificacao>(), new ArrayList<Publicacao>());
		            veiculos.add(veiculo);
		        }

		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        if (br != null) {
		            try {
		                br.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		}
	
	 public void lerQualificacao(List<Qualificacao> qualificacoes, String diretorio, List<Veiculo> veiculos) {

		String arquivoCSV = diretorio;
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			linha = br.readLine();
			while ((linha = br.readLine()) != null) {
				String[] leitura = linha.split(csvDivisor);
				int ano = Integer.parseInt(leitura[0].trim());
				Veiculo veiculo = veiculos.get(0).pegaVeiculo(veiculos, leitura[1].trim());
				if (veiculo != null){
					Qualis qualis = new Qualis(new ArrayList<Qualificacao>(), leitura[2].trim(), null);
					Qualificacao quali = new Qualificacao(ano, qualis, veiculo);
					veiculo.getQualificacoes().add(quali);
					qualificacoes.add(quali);
				} else {
					System.out.println("\nVeiculo: "+ leitura[1].trim()+ ", não foi encontrado");
				}
			}
			
			for(Qualificacao quali : qualificacoes){
				quali.getQualis().setQualificacoes(quali.pegaQualificacoes(qualificacoes, quali.getQualis().getNome()));
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	 public void lerPublicacao(List<Publicacao> publicacoes, String diretorio, List<Veiculo> veiculos, List<Docente> docentes) {
		String arquivoCSV = diretorio;
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		Veiculo veiculo;
		int ano;
		String titulo;
		int num;
		String local;
		int volume;
		int pagInic;
		int pagFim;
		

		try {
			br = new BufferedReader(new FileReader(arquivoCSV));
			linha = br.readLine();
			while ((linha = br.readLine()) != null) {

				String[] leitura = linha.split(csvDivisor);
				ano = Integer.parseInt(leitura[0]);
				titulo = leitura[2];
				num = Integer.parseInt(leitura[4]);
				pagInic = Integer.parseInt(leitura[7]);
				pagFim = Integer.parseInt(leitura[8]);
				veiculo = veiculos.get(0).pegaVeiculo(veiculos, leitura[1]);

				String[] leituraAutores = leitura[3].split(",");

				if (leitura[5].equals("")) {
					if (veiculo != null) {
						local = leitura[6];
						Conferencia conf = new Conferencia(ano, veiculo, titulo, new ArrayList<Docente>(), num, local, pagInic, pagFim);
						publicacoes.add(conf);
						
						for (int i = 0; i < leituraAutores.length; i++) {
							for(Docente autor: docentes){
								if(autor.getCodigo() == Long.parseLong(leituraAutores[i].trim())){
									autor.linkaPublicacaoDocente(conf);
									break;
								}
							}
						}

						veiculo.getPublicacoes().add(conf);
				
					}
				} else {
					if (veiculo != null) {
						volume = Integer.parseInt(leitura[5]);
						Periodico periodico = new Periodico(ano, veiculo, titulo,new ArrayList<Docente>(), num, volume, pagInic, pagFim);
						publicacoes.add(periodico);
						
						for (int i = 0; i < leituraAutores.length; i++) {
							for(Docente autor: docentes){
								if(autor.getCodigo() == Long.parseLong(leituraAutores[i].trim()))
									autor.linkaPublicacaoDocente(periodico);
							}
						}

						veiculo.getPublicacoes().add(periodico);
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	 
	public void lerRegras(List<Regras> regras, String diretorio, List<Qualificacao> qualificacoes, List<Pontuacao> pontuacoes){

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat nf = NumberFormat.getInstance();
	    String arquivoCSV = diretorio;
	    BufferedReader br = null;
	    String linha = "";
	    String csvDivisor = ";";
	    
	    Date dataInic = null;
	    Date dataFim = null;
	    double multPeriodico = 0;
	    int qtdAnos;
	    int pontMin;
	    Pontuacao pontuacao;
	    Qualis qualis;
	    
	    try {
	        br = new BufferedReader(new FileReader(arquivoCSV));
	        linha = br.readLine();
	        while ((linha = br.readLine()) != null) {
	            String[] leitura = linha.split(csvDivisor);
	            
	            try {
					dataInic = formato.parse(leitura[0]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
	            
	            try {
					dataFim = formato.parse(leitura[1]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
	            
	            String[] leituraQualis = leitura[2].split(",");
	            String[] leituraPontos = leitura[3].split(",");
	            
	            for(int i=0; i < leituraQualis.length; i++){   	
	            	qualis = qualificacoes.get(0).pegaQualis(qualificacoes, leituraQualis[i]);
	            	if(qualis != null){
	            		pontuacao = new Pontuacao(qualis, Integer.parseInt(leituraPontos[i].trim()));
	            		
	            		for (Qualificacao quali : qualificacoes){
	            			if(quali.getQualis().getNome().equals(qualis.getNome())){
	            				quali.getQualis().setPontuacao(pontuacao);
	            			}
	            		}
	            		
		            	pontuacoes.add(pontuacao);
	            	}
	            }

	            try {
					multPeriodico = nf.parse(leitura[4].trim()).doubleValue();
				} catch (ParseException e) {
					e.printStackTrace();
				}
	            qtdAnos = Integer.parseInt(leitura[5].trim());
	            pontMin = Integer.parseInt(leitura[6].trim());

	            if (dataInic != null && dataFim != null){
	            	Regras regra = new Regras(dataInic, dataFim, multPeriodico, qtdAnos, pontMin, pontuacoes);
	            	regras.add(regra);
	            }
	        }

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
