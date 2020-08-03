public class AquecimentoRecursivo{
	//metodo para testar se a entrada e igual a fim
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

	//metodo que conta a quantidade de vogais maiusculas
	public static int Maiuscula (String testar, int x){
		int contar=0;
		if(x<testar.length()){
			//teste para ver se esta no alfabeto e e maiuscula
			if(testar.charAt(x)>='A' && testar.charAt(x)<='Z'){
				///caso seja, adiciona se 1 ao contador e chama se novamente o metodo
				contar = 1 + Maiuscula(testar,x+1);
			}else{
				//caso nao seja, nao se adiciona nada ao metodo e segue se chamando o metodo novamente
				contar = Maiuscula(testar,x+1);
			}
		}

		return contar;
	}

        public static void main(String[] args){
                String saida = "FIM";
                String entrada;
		int resultado;
                entrada = MyIO.readLine();
                while(compareTo(saida,entrada)!=1){
			resultado =Maiuscula(entrada,0);
			MyIO.println(resultado);
			entrada = MyIO.readLine();
		}
        }
} 
