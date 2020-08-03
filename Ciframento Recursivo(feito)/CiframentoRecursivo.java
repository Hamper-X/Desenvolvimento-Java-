public class CiframentoRecursivo{

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

	public static String CiframentoRecur ( String teste){
		return Cifrar(teste,0);
	}

	//metodo receber um contador e a string a ser cifrada
	private static String Cifrar(String teste,int cont){
		String nova = "";
		//if que controla o loop de repeticao
		if(cont<teste.length()){
			//pega a char, soma se 3 nela, e concatena com o return da chamada do metodo
			nova = (char)(teste.charAt(cont)+3) + Cifrar(teste, cont+1);
		}
			return nova;
	}

        public static void main(String[] args){
                String saida = "FIM";
                String entrada;
                entrada = MyIO.readLine();
                while(compareTo(saida,entrada)!=1){
			MyIO.println(CiframentoRecur(entrada));
                        entrada = MyIO.readLine();
                }
        }
}
   
