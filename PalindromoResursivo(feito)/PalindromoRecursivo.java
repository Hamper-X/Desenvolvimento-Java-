public class PalindromoRecursivo{

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

	public static boolean Palindromo (String testar){
		boolean resp=PalindromoRecur(testar,0);
		return resp;
	}

	private static boolean PalindromoRecur(String testar, int cont){
		boolean resposta=true;

		if(cont<(testar.length()/2)){
			if(testar.charAt(cont)!=testar.charAt(testar.length()-(cont+1))){
					resposta= false;
					cont=testar.length();
			}else{
				resposta=PalindromoRecur(testar, cont+1);
			}
		}
		return resposta;
	}

        public static void main(String[] args){
                String saida = "FIM";
                String entrada;
                entrada = MyIO.readLine();
                while(compareTo(saida,entrada)!=1){
			if(Palindromo(entrada)==true){
				MyIO.println("SIM");
			}else{
				MyIO.println("NAO");
			}
                        entrada = MyIO.readLine();
                }
        }
} 
