import java.io.*;
import java.net.*;

public class http{
	//metodo pra testar se a String lida e FIM
        public static int compareTo(String fim, String entrada){
                if(fim.charAt(0)==entrada.charAt(0)){
                        if(fim.charAt(1)==entrada.charAt(1)){
                                if(fim.charAt(2)==entrada.charAt(2)){
                                        return 1;
                                }
                                else{return 0;}
                        }
                        else{return 0;}
                }
                else{return 0;}
        }
	
	//Teste para ver se e vogal
	public static int []Vogal(String testar){
		int tamanho = testar.length();
		int x;
		
		//ar[0]=a ar[1]=e ar[2]=i ar[3]=o ar[4]=u ar[5]=á ar[6]=é
		//ar[7]=í ar[8]=ó ar[9]=ú ar[10]=à ar[11]=è ar[12]=ì ar[13]=ò
		//ar[14]=ù ar[15]=ã ar[16]=õ ar[17]=â ar[18]=ê ar[19]=î 
		//ar[20]=ô ar[21]=û
		//cada posicao do array representa uma letra conforme a legenda acima
		int []array=new int[22];

		//estrtura for pra inicializar os valores do array
		for(x=0;x<22;x++){
			array[x]=0;
		}

		//pra cada letra lida, avaliar que tipo de vogal ela e, se tem ou nao acento
		for(x=0;x<tamanho;x++){
			if(testar.charAt(x)=='a'){
				array[0]= array[0]+1;
			} 
			if(testar.charAt(x)=='e'){
                                array[1]= array[1]+1;
			}
			if(testar.charAt(x)=='i'){
                                array[2]= array[2]+1;
                        }
			if(testar.charAt(x)=='o'){
                                array[3]= array[3]+1;
                        }
			if(testar.charAt(x)=='u'){
                                array[4]= array[4]+1;
                        }
			if(testar.charAt(x)=='á'){
                                array[5]= array[5]+1;
                        }
			if(testar.charAt(x)=='é'){
                                array[6]= array[6]+1;
                        }
			if(testar.charAt(x)=='í'){
                                array[7]= array[7]+1;
                        }
			if(testar.charAt(x)=='ó'){
                                array[8]= array[8]+1;
                        }
			if(testar.charAt(x)=='ú'){
                                array[9]= array[9]+1;
                        }
			if(testar.charAt(x)=='à'){
                                array[10]= array[10]+1;
                        }
			if(testar.charAt(x)=='è'){
                                array[11]= array[11]+1;
                        }
			if(testar.charAt(x)=='ì'){
                                array[12]= array[12]+1;
                        }
			if(testar.charAt(x)=='ò'){
                                array[13]= array[13]+1;
                        }
			if(testar.charAt(x)=='ù'){
                                array[14]= array[14]+1;
                        }
			if(testar.charAt(x)=='ã'){
                                array[15]= array[15]+1;
                        }
			if(testar.charAt(x)=='õ'){
                                array[16]= array[16]+1;
                        }
			if(testar.charAt(x)=='â'){
                                array[17]= array[17]+1;
                        }
			if(testar.charAt(x)=='ê'){
                                array[18]= array[18]+1;
                        }
			if(testar.charAt(x)=='î'){
                                array[19]= array[19]+1;
                        }
			if(testar.charAt(x)=='ô'){
                                array[20]= array[20]+1;
                        }
			if(testar.charAt(x)=='û'){
                                array[21]= array[21]+1;
                        }

		}
		return array; //retornar array com o valor de cada letra alocado
	}

	public static int Consoante(String testar){
                int tamanho = testar.length();
                int x,contador=0;

                for(x=0;x<tamanho;x++){
                        if(testar.charAt(x)>='a'&& testar.charAt(x)<='z'){
				if(testar.charAt(x)!= 'a' && testar.charAt(x)!= 'e' && testar.charAt(x)!= 'i' && testar.charAt(x)!= 'o' &&
				testar.charAt(x)!= 'u'){
					contador++;
				}
                        }else{
				//Max(ou felipe), não foi necessario o reste com maiscula, visto que, colocando esse trecho, meu programa gerava um valor incorreto
				/*
				if(testar.charAt(x)>='A' && testar.charAt(x)<='Z'){
					if(testar.charAt(x)!= 'A' && testar.charAt(x)!= 'E' && testar.charAt(x)!= 'I' && testar.charAt(x)!= 'O' &&
                                	testar.charAt(x)!= 'U'){
                                        	contador++;

					}
				}
				*/
			}

                }
                return contador; //retornar a quantidade de consoantes
        }

	public static int Br(String testar){
		int tamanho = testar.length();
		int x, cont=0;

		//for para testar se determinada sequencia e <br>
		for(x=0;x<tamanho;x++){
			if(testar.charAt(x)=='<'){	
				if(testar.charAt(x+1)=='b'){
					if(testar.charAt(x+2)=='r'){
						if(testar.charAt(x+3)=='>'){
							cont++;
						}
					}
				}
			}
		}
		return cont;
	}

	public static int Table(String testar){
                  int tamanho = testar.length();
                  int x, cont=0;
 
		  //for pra determinar se determinada sequencia de letras e <table>
                  for(x=0;x<tamanho;x++){
                          if(testar.charAt(x)=='<'){
                          	if(testar.charAt(x+1)=='t'){
                                	if(testar.charAt(x+2)=='a'){
                                         	 if(testar.charAt(x+3)=='b'){
					  		if(testar.charAt(x+4)=='l'){
								if(testar.charAt(x+5)=='e'){
									if(testar.charAt(x+6)=='>'){
										cont++;
										x=x+6;
									}
								}
							}
						  }
                                  	  }
                        	 }
                  	}
		 }
		return cont;		  
          }

	//metodo que le a pagina e gera a uma String com o o texto repassado
	public static String LerHttp(String ender){
		URL url;
		InputStream is = null;
		BufferedReader br;
		String resp="",line;

		try{
			url = new URL(ender);
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is));

			while((line = br.readLine()) != null){//loop rodando enquanto ouvir linhas a serem lidas
				resp = resp + line; //alocando tudo na string resp
			}
		}catch(MalformedURLException mue){
			mue.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}

		try{
			is.close();
		}catch(IOException ioe){
			//nada
		}
		return resp;//retorna a string resp
	}
	
	//metodo para chamada geral dos metodos e para printar de forma personalizada a saida
	public static void VerificarPrintar(String testar, String nome){
		int []array = Vogal(testar);
		int consoantes = Consoante(testar);
		int br = Br(testar);
		int table = Table(testar);
		
		if(br>0){
			consoantes = consoantes - (2*br);//ajuste para a retirada de consoantes que ja tem no br
		}
		if(table>0){ //ajuste de consoantes para a retirada das consoantes que ja tem no table
			consoantes = consoantes - (3*table);
			array[0]=array[0]-table;
			array[1]=array[1]-table;
		}
		

		MyIO.print("a("+array[0]+") ");
		MyIO.print("e("+array[1]+") ");
		MyIO.print("i("+array[2]+") ");
		MyIO.print("o("+array[3]+") ");
		MyIO.print("u("+array[4]+") ");
		MyIO.print("á("+array[5]+") ");
		MyIO.print("é("+array[6]+") ");
		MyIO.print("í("+array[7]+") ");
		MyIO.print("ó("+array[8]+") ");
		MyIO.print("ú("+array[9]+") ");
		MyIO.print("à("+array[10]+") ");
		MyIO.print("è("+array[11]+") ");
		MyIO.print("ì("+array[12]+") ");
		MyIO.print("ò("+array[13]+") ");
		MyIO.print("ù("+array[14]+") ");
		MyIO.print("ã("+array[15]+") ");
		MyIO.print("õ("+array[16]+") ");
		MyIO.print("â("+array[17]+") ");
		MyIO.print("ê("+array[18]+") ");
		MyIO.print("î("+array[19]+") ");
		MyIO.print("ô("+array[20]+") ");
		MyIO.print("û("+array[21]+") ");
		MyIO.print("consoante("+consoantes+") ");
		MyIO.print("<br>("+br+") ");
		MyIO.print("<table>("+table+") ");
		MyIO.println(nome);

	}

        public static void main(String[] args)throws Exception { 
		MyIO.setCharset("UTF-8"); //metodo para gerar o print correto
		String saida = "FIM";
                String endereco, nome, http;
		nome = MyIO.readLine();
		while(compareTo(saida,nome)!=1){
				endereco = MyIO.readLine();
				http=LerHttp(endereco);
				VerificarPrintar(http, nome);
				nome = MyIO.readLine(); 
		}
    }
}
