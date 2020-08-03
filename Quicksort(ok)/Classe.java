import java.time.*;
import java.io.*;
import java.net.*;
import java.time.format.*;
import java.util.*;


class Presidente{

	DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	//--------------------------------------- || DECLARAÇAO DE VARIAVEIS || ---------------------------------------------
	//id: ordem em que a pessoa for presidente
	private int id;
	private String nome;
	private int idade;
	private LocalDateTime dataNascimento;
	private String localNascimento;
	private LocalDateTime inicioMandato;
	private LocalDateTime fimMandato;
	private LocalDateTime dataMorte;
	private String localMorte;
	private String antecessor;
	private String sucessor;
	private String vice;
	//pagina: nome da pagina 
	private String pagina;
	//paginaTam: tamanho da pagina
	private long paginaTam;

	//--------------------------------------- || CONSTRUTOR PADRAO DE INICIALIZAÇÃO || ---------------------------------------------
	//construtor um vazio
	public Presidente(){
		this.id = 0;
		this.nome = null;
		this.idade = 0;
		this.inicioMandato = null; //como inicia essa variavel
		this.dataNascimento = null;
		this.localNascimento = "";
		this.fimMandato = null;//como inicia 
		this.dataMorte = null;  //como inicia
		this.localMorte = null;
		this.antecessor = null; 
		this.vice = null;
		this.pagina = null;
		this.paginaTam = 0; //como inicia long
	}


	//--------------------------------------- || CONTRUTOR COM VALOR || ---------------------------------------------
	//construtor dois
	public Presidente(int id1, String nome1, int idade1, LocalDateTime inicioMandato1, LocalDateTime dataNascimento1, String localNascimento1,
			LocalDateTime fimMandato1, LocalDateTime dataMorte1, String localMorte1, 
			String antecessor1, String sucessor1, String vice1, String pagina1, long paginaTam1){

		this.id = id;
		this.nome = nome1;
		this.idade = idade1;
		this.inicioMandato = inicioMandato1;
		this.dataNascimento = dataNascimento1;
		this.localNascimento = localNascimento1;
		this.fimMandato = fimMandato1;
		this.dataMorte =  dataMorte1;
		this.localMorte = localMorte1;
		this.antecessor = antecessor1; 
		this.sucessor =sucessor1;
		this.vice = vice1;
		this.pagina = pagina1;
		this.paginaTam = paginaTam1;
	}

	//------------------------------------  || SETS ||  ---------------------------------------------------------- 
	public void setId(int id1){
		this.id = id1;
	}

	public void setNome(String nome1){
		this.nome = nome1;
	}

	public void setIdade(int idade1){
		this.idade = idade1;
	}

	public void setInicioMandato(LocalDateTime inicioMandato1){
		this.inicioMandato = inicioMandato1;
	}

	public void setDataNascimento(LocalDateTime dataNascimento1){
		this.dataNascimento = dataNascimento1;
	}

	public void setLocalNascimento(String localNascimento1){
		this.localNascimento = localNascimento;
	}

	public void setFimMandato(LocalDateTime fimMandato1){
		this.fimMandato = fimMandato1;
	}

	public void setDataMorte(LocalDateTime dataMorte1){
		this.dataMorte =  dataMorte1;
	}

	public void setLocalMorte(String localMorte1){
		this.localMorte = localMorte1;
	}
	public void setAntecessor(String antecessor1){
		this.antecessor = antecessor1; 
	}

	public void setSucessor(String sucessor1){
		this.sucessor =sucessor1;
	}

	public void setVice(String vice1){
		this.vice = vice1;
	}

	//pagina: nome da pagina 
	public void setPagina(String pagina1){
		this.pagina = pagina1;
	}

	//paginaTam: tamanho da pagina
	public void setPaginaTam(long paginaTam1){
		this.paginaTam = paginaTam1;
	}

	//------------------------------------  || GETS ||  ----------------------------------------------------------

	public int getId(){//ok
		return id;
	}
	public String getNome(){
		return nome;
	}
	public int getIdade(){
		return idade;
	}
	public LocalDateTime getInicioMandato(){
		return inicioMandato;
	}

	public LocalDateTime getDataNascimento(){
		return this.dataNascimento;
	}

	public String getLocalNascimento(){
		return this.localNascimento;
	}

	public LocalDateTime getFimMandato(){
		return fimMandato;
	}

	public LocalDateTime getDataMorte(){
		return this.dataMorte;
	}

	public String getLocalMorte(){
		return this.localMorte;
	}

	public String getAntecessor(){
		return antecessor; 
	}

	public String getSucessor(){
		return sucessor;
	}

	public String getVice(){
		return vice;
	}

	//pagina: nome da pagina 
	public String getPagina(){
		return pagina;
	}

	//paginaTam: tamanho da pagina
	public long getPaginaTam(){
		return paginaTam;
	}

	//------------------------------------  || CLONE ||  ----------------------------------------------


	//------------------------------------  || PRINT ||  ----------------------------------------------

	public String Limpar0(String entrada){
		if(entrada.charAt(0)=='0'){
			entrada = entrada.substring(1,10);
			if(entrada.charAt(2)=='0'){
				entrada = entrada.substring(0,2 ) + entrada.substring(3,9);
			}

		}else{
			if(entrada.charAt(3)=='0'){
				entrada = entrada.substring(0,3)+ entrada.substring(4,10);
			}
		}
		return entrada;
	}
	public void imprimir(){
		String aux = "";
		MyIO.print(this.id + " ## "+ this.nome + " ## " + Limpar0(this.inicioMandato.format(formatar).substring(0,10)) + " (I) ## " + Limpar0(this.fimMandato.format(formatar).substring(0,10))+ " (F) ## " + Limpar0(this.dataNascimento.format(formatar).substring(0,10))+" em " + this.localNascimento + " (N) ## " + this.idade + " ## ");
		if(this.dataMorte==null){
			//chora mais
		}else{
			MyIO.print(Limpar0(this.dataMorte.format(formatar).substring(0,10))+" em "+this.localMorte+ " (M) ## ");
		}	

		MyIO.print(this.pagina +" ## "+ this.paginaTam + " ## " + this.antecessor + " ## ");
		if(this.sucessor==null){
			//chora mais bb
		}else{  	
			MyIO.print(this.sucessor);

		}
		MyIO.print(" ## ");
		if(this.vice==null){
			//ja to chorando
		}else{
			MyIO.print( this.vice);
		}
		MyIO.println("");
	}




	//___________________________________________________  || LER ATRIBUTOS DO REGISTRO || _____________________________________________________________________//




	//--------------------------------------- || METODOS E FUNÇÕES AUXILIARES || ---------------------------------------------	

	//METODO PARA REVOR TAGS E LIBERAR O TEXTO PRINCPIAL 
	public String RemoverTags(String entrada){
		String nova = "";
		int tamanho = entrada.length();

		for(int x=0; x<tamanho;x++){
			if(entrada.charAt(x)=='<'){
				for(int y=x;y<tamanho;y++){
					if(entrada.charAt(y)=='>'){
						x = y;
						y=tamanho;
					}
				}
			}else{
				nova = nova + entrada.charAt(x);
			}
		}

		return nova;
	}

	public String LimparData(String data){
		String reserva2;
		String array[] = new String[data.length()];
		array = data.split(" ");
		String nova = "";
		if(data.charAt(0)>='0' && data.charAt(0)<='9'){
			if(data.charAt(1)>='0' && data.charAt(1)<='9'){
				nova = nova + data.charAt(0) + data.charAt(1);
			}else{
				nova  = nova +'0'+ data.charAt(0);
			}

		}


		if(array[2].compareTo("janeiro")==0){
			nova = nova + "/01";
		}else if(array[2].compareTo("fevereiro")==0){
			nova = nova + "/02"; 
		}else if(array[2].contains("mar")){ 
			nova = nova + "/03";
		}else  if(array[2].compareTo("abril")==0){
			nova = nova + "/04";
		}else  if(array[2].compareTo("maio")==0){
			nova = nova + "/05";
		}else  if(array[2].compareTo("junho")==0){
			nova = nova + "/06";
		}else  if(array[2].compareTo("julho")==0){
			nova = nova + "/07";
		}else  if(array[2].compareTo("agosto")==0){
			nova = nova + "/08";
		}else  if(array[2].compareTo("setembro")==0){
			nova = nova + "/09";
		}else if(array[2].compareTo("outubro")==0){
			nova = nova + "/10";
		}else if(array[2].compareTo("novembro")==0){  			
			nova = nova + "/11";
		}else if(array[2].compareTo("dezembro")==0){    
			nova = nova + "/12";						
		}

		nova = nova + "/"+ data.substring(data.length()-4,data.length());
		return(nova);
	}


	public String LimparMes (String entrada){
		String retur="";
		if(entrada.compareTo("janeiro")==0){
			retur = "/01/";
		}else if(entrada.compareTo("fevereiro")==0){
			retur = "/02/";
		}else if(entrada.contains("mar")){
			retur = "/03/";
		}else  if(entrada.compareTo("abril")==0){
			retur = "/04/";
		}else  if(entrada.compareTo("maio")==0){
			retur = "/05/";
		}else  if(entrada.compareTo("junho")==0){
			retur = "/06/";
		}else  if(entrada.compareTo("julho")==0){
			retur = "/07/";
		}else  if(entrada.compareTo("agosto")==0){
			retur = "/08/";
		}else  if(entrada.compareTo("setembro")==0){
			retur = "/09/";
		}else if(entrada.compareTo("outubro")==0){
			retur = "/10/";
		}else if(entrada.compareTo("novembro")==0){
			retur = "/11/";
		}else if(entrada.compareTo("dezembro")==0){
			retur = "/12/";
		}
		return retur;
	}
	public String AbrirLeitura(String endereco) throws IOException {
		this.pagina = endereco;
		this.paginaTam = new File(endereco).length();
		String linha = "";
		int idade01=0, idade02=0, idade03=0;
		int controle01=0,controle02=0,controle03=0,controle04=0,controle05=0,controle06=0,controle07=0;
		String reserva="",armazem="";

		URL url = new URL("file://" + endereco);
		InputStream is = null;
		try{
			is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			linha = br.readLine();

			//Teste em loop por todo o html em busca de um deterinado padrao
			while(linha != null){

				//pra achar o ID(ok)
				if(controle07==0 && linha.contains("<th colspan=\"2\" style=\"text-align:center; background-color: #E6E6FA\"><a href=\"/wiki/Lista_de_presidentes_do_Brasil\" title=\"Lista de presidentes do Brasil\">")){			    
					armazem = RemoverTags(linha);
					if(armazem.charAt(0)>='0' && armazem.charAt(0)<='9'){
						if(armazem.charAt(1)>='0' && armazem.charAt(1)<='9'){
							this.id= Integer.parseInt(""+armazem.charAt(0) + armazem.charAt(1));
						}else{
							this.id = Integer.parseInt(""+armazem.charAt(0));
						}

					}
					controle07++;
				}


				//achar vice presidente(ok) 
				if(linha.contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Vice-presidente")){
					linha = br.readLine();
					linha = br.readLine();
					armazem = RemoverTags(linha);
					/*MyIO.println(armazem);
					  for(int z=0;z<armazem.length();z++){
					  if(armazem.charAt(z)!='('){
					  reserva = reserva + armazem.charAt(z);
					  }else{
					  z=armazem.length();
					  }
					  }
					  MyIO.println("=> "+reserva);
					/*String neew="";
					boolean oi=false;
					for(int x=0; x<reserva.length();x++){
					if((reserva.charAt(x)>='0' && reserva.charAt(x)<='9') && (reserva.charAt(x+1)>='0' && reserva.charAt(x+1)<='9') && (reserva.charAt(x+2)>='0' && reserva.charAt(x+2)<='9') && (reserva.charAt(x+3)>='0' && reserva.charAt(x+3)<='9')){
					oi = true;
					x=x+4;
					}
					if(oi==true){
					neew = neew + reserva.charAt(x);
					}



					}
					//MyIO.println(neew);
					*/
					this.vice = armazem;	

				}

				//Achar periodo INICIO e FIM do Mandato(LocalTime <nomr> = LocalTime.of(ano,mês,dia);)(ok)
				if(linha.contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Per") && controle01==0){
					linha = br.readLine();
					linha = br.readLine();
					armazem = RemoverTags(linha);
					//MyIO.println(armazem);
					reserva = "";
					int i=0,i2=0;
					String reserva2 = "";
					for(i=0;i<armazem.length();i++){
						if(armazem.charAt(i)>='0' && armazem.charAt(i)<='9'){

							if(i<(armazem.length()-1) && armazem.charAt(i+1)=='a'){
								reserva2 = reserva2 + armazem.charAt(i) + " ";
							}else{
								reserva2 = reserva2 + armazem.charAt(i);
							}
						}else{
							if(armazem.charAt(i)=='&'){
								reserva2 = reserva2 + " ";
								i=i+3;
							}else{
								if(armazem.charAt(i)==';'){
									reserva2 = reserva2 + " ";
								}else{
									reserva2 = reserva2 + armazem.charAt(i);
								}
							}
						}
					}

					String array[] = new String[armazem.length()];
					array = reserva2.split(" ");
					int tamArray = array.length;
					String auxx= "";
					if(array[0].charAt(0)>='0' && array[0].charAt(0)<='9'){
						if(array[0].length()>1 && array[0].charAt(1)>='0' && array[0].charAt(1)<='9'){
							auxx = array[0];
						}else{
							auxx = "0"+ array[0].substring(0,1);
						}

					}

					auxx = auxx+ LimparMes(array[2]) + array[4];
					/*
					   String auxx;
					   if(array[tamArray-1].equals("1]")){
					   if(array[0].length()>1 && array[tamArray-5].charAt(1)>='0' && array[tamArray-5].charAt(1)<='9'){
					   auxx= array[tamArray-6].substring(0,1)+LimparMes(array[tamArray-4])+array[tamArray-2].substring(0,4);
					   }else{
					   auxx= "0"+array[tamArray-6].substring(0,1)+LimparMes(array[tamArray-4])+array[tamArray-2].substring(0,4);
					   }
					   }else{
					   if(array[tamArray-5].length()>1 && array[tamArray-5].charAt(1)>='0' && array[tamArray-5].charAt(1)<='9'){ 
					   auxx= array[tamArray-5]+LimparMes(array[tamArray-3])+array[tamArray-1];

					   }else{
					   auxx="0"+ array[tamArray-5].substring(0,1)+LimparMes(array[tamArray-3])+array[tamArray-1];
					   }
					//MyIO.println(auxx);		
					}*/



					//MyIO.println(reserva);

					//------------------------------- COMO SETAR O DATETIMELOCAL -----------------------------------------

					//String array2[] = new String[reserva.length()];
					//array2 = reserva.split(" "); 
					LocalDateTime dataFormatada = LocalDateTime.parse(auxx+" 00:00", formatar);
					//System.out.println(dataFormatada.format(formatar).substring(0,10));
					this.inicioMandato = dataFormatada;
					//System.out.println(dataFormatada);

					//-------------------------------------------- FIM MANDATO ---------------------------------------------

					reserva = "";
					boolean teste = false;


					//MyIO.println("armazem       " +armazem); 
					for(i=0;i<armazem.length();i++){
						//MyIO.print(i+"("+armazem.charAt(i)+") ");
						if(armazem.charAt(i)=='a' && armazem.charAt(i+1)==' '){
							i=i+2;
							teste = true;	
						}else{
							if(armazem.charAt(i)=='a' && armazem.charAt(i+1)=='&'){
								i=i+6;
								teste = true;
							}else{
								if(armazem.charAt(i)=='['){
									i= i+8;
									teste = false;
								}else{
									if(armazem.charAt(i)=='a' && armazem.charAt(i+1)=='t'){
										i=i+4;
										teste = true;
									}
								}
							}
						}
						if(teste ==true){
							reserva = reserva + armazem.charAt(i);
						}
					}





					auxx="";
					if(array[tamArray-1].equals("1]")){
						if(array[tamArray-6].length()>1 && array[tamArray-6].charAt(1)>='0' && array[tamArray-6].charAt(1)<='9'){
							auxx= array[tamArray-6]+LimparMes(array[tamArray-4])+array[tamArray-2].substring(0,4);
						}else{
							auxx= "0"+array[tamArray-6].substring(0,1)+LimparMes(array[tamArray-4])+array[tamArray-2].substring(0,4);
						}
					}else{
						if(array[tamArray-5].length()>1 && array[tamArray-5].charAt(1)>='0' && array[tamArray-5].charAt(1)<='9'){
							auxx= array[tamArray-5]+LimparMes(array[tamArray-3])+array[tamArray-1];

						}else{
							auxx="0"+ array[tamArray-5].substring(0,1)+LimparMes(array[tamArray-3])+array[tamArray-1];
						}
						//MyIO.println(auxx);           
					}

					//MyIO.println(reserva);
					//MyIO.println(reserva);
					reserva2 = "";

					/*String array3[] = new String[reserva.length()];
					  array3 = reserva.split(" ");

					//MyIO.println("entrei: "+array3[0]+" | "+array3[1]+" | "+array3[2]);
					if(!reserva.isEmpty() && reserva.charAt(0)>='0' && reserva.charAt(0)<='9'){
					if(reserva.charAt(1)>='0' && reserva.charAt(1)<='9'){
					reserva2 = reserva2 + reserva.charAt(0) + reserva.charAt(1);
					}else{
					reserva2  = reserva2 +'0'+ reserva.charAt(0);
					}
					//MyIO.println("carregando: "+reserva2);

					}*/



					LocalDateTime dataFormatada2 = LocalDateTime.parse(auxx+" 00:00", formatar);
					//System.out.println(dataFormatada.format(formatar).substring(0,10));
					this.fimMandato = dataFormatada2;

					//MyIO.println(reserva2);
					controle01++;

				}


				//Achar antecessor(ok)
				if(controle02==0 && linha.contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Antecessor")){
					linha = br.readLine();
					linha = br.readLine();
					armazem = RemoverTags(linha);
					this.antecessor = armazem;
					controle02++;
				}

				//Achar Sucessor(ok)
				if(controle03==0 && linha.contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Sucessor")){
					linha = br.readLine();
					linha = br.readLine();
					armazem = RemoverTags(linha);
					if(this.antecessor.equals("Michel Temer")){
						this.sucessor =null;
					}else{
						this.sucessor = armazem;
					}
					controle03++;

				}
				//Achar Nome(ok)
				if(controle04==0 && linha.contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Nome completo")){
					linha = br.readLine();
					linha = br.readLine();
					armazem = RemoverTags(linha);
					this.nome=armazem;
					//MyIO.println(this.nome);
					controle04++;
				}

				//Achar Nascimento(ok)
				if(controle05==0 && linha.contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Nascimento")){
					DateTimeFormatter padrao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					linha = br.readLine();
					linha = br.readLine();
					armazem = RemoverTags(linha);
					String local="";

					//------------------------------- COMO SETAR O DATETIMELOCAL -----------------------------------------
					//
					String data=armazem.substring(0,armazem.indexOf(" ", 10)+8);
					//this.dataNascimento.parse(LimparData(data),padrao);
					LocalDate dt = LocalDate.parse(LimparData(data),padrao);
					this.dataNascimento = dt.atStartOfDay();
					String array5[] = new String[data.length()];
					array5 = data.split(" ");
					idade02 = Integer.parseInt(array5[4]);
					this.idade = 2019 - idade02;
					//System.out.println(this.dataNascimento);

					//--------------------------------------------- || LOCAL || ------------------------------------

					//local = armazem.substring(armazem.indexOf(" ", 18)+1, armazem.length());
					if(armazem.contains(")")){
						local=armazem.substring(armazem.lastIndexOf(")")+2, armazem.length());
					}else{
						boolean test = false;
						for(int i=0;i<armazem.length();i++){
							if((armazem.charAt(i)>='0' && armazem.charAt(i)<='9') && (armazem.charAt(i+1)>='0' &&  armazem.charAt(i+1)<='9') &&
									(armazem.charAt(i+2)>='0' && armazem.charAt(i+2)<='9') && (armazem.charAt(i+3)>='0' && armazem.charAt(i+4)<='9')){
								i = i + 5;
								test = true;

									}
							if(test == true){
								local = local + armazem.charAt(i);


							}
						}


					}

					this.localNascimento = local;
					controle05++
						;			
				}


				//Achar Morte
				if(controle06==0 && linha.contains("<td scope=\"row\" style=\"vertical-align: top; text-align: left;\">Morte")){
					DateTimeFormatter pod = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					linha = br.readLine();
					linha = br.readLine();
					armazem = RemoverTags(linha);
					reserva = "";	
					String data=armazem.substring(0,armazem.indexOf(" ", 10)+8);
					LocalDate dc = LocalDate.parse(LimparData(data),pod);
					this.dataMorte = dc.atStartOfDay();;	

					for(int i=0;i<armazem.length();i++){
						if(armazem.charAt(i)=='&'){
							i = armazem.length();
						}else{
							reserva = reserva + armazem.charAt(i);
						}
					}

					String array4[] = new String[reserva.length()];
					array4 = reserva.split(" ");


					String reserva2 = "";
					idade01 = Integer.parseInt(array4[4]);
					controle06++;
					idade03=2019;
					//this.idade = idade03-idade02;
					//MyIO.println("idade01:"+idade01);
					//MyIO.println("idade02:"+idade02);	

					/*if((idade03-idade01)>=0){
					//ta vivo ainda -_-
					this.dataMorte=null;
					MyIO.println("IF: "+this.dataMorte);
					} else{
					//morreuuuuu!!
					this.dataMorte = dc.atStartOfDay();
					MyIO.println("ELSE: "+this.dataMorte);


					}*/

					//------------------------------------------------------ || Local Morte || -----------------------------------------------------------------
					boolean test = false;
					//MyIO.println(armazem);
					for(int i=0;i<armazem.length();i++){
						if(armazem.charAt(i)==')'){
							i=i+2;
							test = true;

						}
						if(test == true){
							reserva2 = reserva2 +armazem.charAt(i);
						}
					}

					this.localMorte = reserva2;
					//MyIO.println(localMorte);

				}




				linha = br.readLine();

			}
			//MyIO.setCharset("ISO-8859-1");
			//imprimir();
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		} 
		return linha;
	}

	public void ler(String endereco) throws IOException {
		String nova = AbrirLeitura(endereco);

	}
}
//---------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------|| LISTA COM ALOCAÇÃO SEQUENCIAL ||-----------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------

class QuickSort{

	private Presidente [] array;
	private int n;

	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
	public QuickSort(int tamanho){
		array = new Presidente[tamanho];
		n=0;
	}

	public void inserir(Presidente pres){
		array[n]=pres;
		n++;
	}

	public int getN(){
		return n;
	}



	/**
	 * Troca o conteudo de duas posicoes do array
	 * @param i int primeira posicao
	 * @param j int segunda posicao
	 */
	public void swap(int i, int j) {
		Presidente temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public void imprimir(int x){
		array[x].imprimir();

	}

	public void ordQuick() {
		quicksort(0, n-1);
	}

	public int converterMandato(int i){
		DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String nova;
		String ret="";
		int ter;
		nova = ""+array[i].Limpar0(array[i].getInicioMandato().format(formatar).substring(0,10));
		for(int x=0;x<nova.length();x++){
			if(nova.charAt(x)>='0' && nova.charAt(x)<='9'){
				ret = ret +nova.charAt(x);
			}
		}
		ter = Integer.parseInt(ret);
			return ter;
	}

	/**
	 * Algoritmo de ordenacao Quicksort.
	 * @param int esq inicio do array a ser ordenado
	 * @param int dir fim do array a ser ordenado
	 */
	private void quicksort(int esq, int dir) {
		int i = esq, j = dir;
		int pivo = converterMandato((dir+esq)/2);
		while (i <= j) {
			while (converterMandato(i) < pivo) i++;
			while (converterMandato(j) > pivo) j--;
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if (esq < j)  quicksort(esq, j);
		if (i < dir)  quicksort(i, dir);
	}
}






//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//------------------------------------------------------------------------------------------|| CLASSE PRINCIPAL || -----------------------------------------------------------------------------------------//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	


public class Classe{

	public static long now(){
		return new Date().getTime();
	}
	public static void main(String[] args)throws Exception{

		long comeco = now();
		String entrada;
		MyIO.setCharset("UTF-8");
		QuickSort QuickPresidentes = new QuickSort(60);
		entrada = MyIO.readLine();
		while(!entrada.equals("FIM")){
			Presidente pres = new Presidente();
			pres.ler(entrada);
			QuickPresidentes.inserir(pres);
			entrada = MyIO.readLine();
		}
		QuickPresidentes.ordQuick();
		long fim= now();
		long tempo = fim-comeco;


		MyIO.setCharset("ISO-8859-1");
		for(int x=0;x<QuickPresidentes.getN();x++){
			QuickPresidentes.imprimir(x);
		}
	}
}
