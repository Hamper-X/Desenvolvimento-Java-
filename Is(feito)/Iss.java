public class Iss{
	//metodo que testar se a entrada e uma String FIM	
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

	//testando se a string so tem vogais
	public static boolean Vogal(String testar){
		int tamanho = testar.length(), x;
		boolean resp = true;

		for(x=0;x<tamanho;x++){
			if(testar.charAt(x)=='a' || testar.charAt(x)=='e' || testar.charAt(x)=='i'
			|| testar.charAt(x)=='o' || testar.charAt(x)=='u'|| testar.charAt(x)=='A' 
			|| testar.charAt(x)=='E' || testar.charAt(x)=='I'
                        || testar.charAt(x)=='O' || testar.charAt(x)=='U'){
				resp = resp;
			}else{
				resp = false;//se alguma hora entra aqui, sempre sera false
			}	
		}
		return resp;
	} 

	//teste para ver se e consoante, caso seja alguma vogal ele ja retorna false
	public static boolean Consoante (String testar){
                int tamanho = testar.length(), x;
                boolean resp = true;

                for(x=0;x<tamanho;x++){
                        if(testar.charAt(x)=='a' || testar.charAt(x)=='e' || testar.charAt(x)=='i' 
			||testar.charAt(x)=='o' || testar.charAt(x)=='u'|| testar.charAt(x)=='A' 
			|| testar.charAt(x)=='E' || testar.charAt(x)=='I'
                        || testar.charAt(x)=='O' || testar.charAt(x)=='U'){
                                resp = false;
                        }else{
				if(testar.charAt(x)>='0' && testar.charAt(x)<='9'){
					resp = false;
				}
			}
                }
                return resp;
        }

	//Para testar se e interio e muito facil, basta testar se todos as posicoes sao numeros entre 0 e 9
	public static boolean Inteiro(String testar){
                int tamanho = testar.length(), x;
                boolean resp = true;

                for(x=0;x<tamanho;x++){
                        if(testar.charAt(x)>='0' && testar.charAt(x)<='9'){
                                resp = resp;
                        }else{
				resp = false;//caso alguem nao seja, ja temos um false permanente
			}
                }
                return resp;
        }

	//para testar se e real testamos se e um inteiro 
	public static boolean Real(String testar){
                int tamanho = testar.length(), x,contagem=0,cont=0;
                boolean resp = true;

                for(x=0;x<tamanho;x++){
                        if(testar.charAt(x)>='0' && testar.charAt(x)<='9'){
                                resp = resp;
                        }else{
				if(testar.charAt(x)=='.'){
					contagem++;
				}else{
					if(testar.charAt(x)==','){
						cont++;
					}else{
						resp = false;
					}
				}
				
			}
                }

		//caso seja interiro e tenha apenas uma virgula ou apenas um ponto ou nenhum dos dois entao e true
		if(contagem==1 && cont==0){ 
			if(resp==true){
                		return resp;
			}else{
				resp = false;
				return resp;
			}
		}else{
			if(contagem==0 && cont==1){ 
                        	if(resp==true){
                                	return resp;
                        	}else{
                                	resp = false;
                                	return resp;
                        	}
			}else{
				if(contagem==0 && cont==0){
					if(resp==true){
                                        	return resp;
                                	}else{
                                        	resp = false;
                                        	return resp;
                                	}
				}else{
					return (resp=false);
				}
	       		 }
		}
	}


	
	public static void main(String[] args){
		String saida = "FIM", entrada;
		entrada = MyIO.readLine();
		while(compareTo(saida,entrada)!=1){
			if(Vogal(entrada)==true){
				MyIO.print("SIM ");
			}else{
				MyIO.print("NAO ");
			}
			if(Consoante(entrada)==true){
                                MyIO.print("SIM ");
                        }else{
                                MyIO.print("NAO ");
                        }
			if(Inteiro(entrada)==true){
                                MyIO.print("SIM ");
                        }else{
                                MyIO.print("NAO ");
                        }
			if(Real(entrada)==true){
                                MyIO.println("SIM");
                        }else{
                                MyIO.println("NAO");
                        }			
			entrada = MyIO.readLine();	
		}	
	}
}
