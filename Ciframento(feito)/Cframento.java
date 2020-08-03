public class Cframento{

	//metodo de parada quando receber a String contendo FIM	
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

	//metodo de onversõa de String, recebe testar como parametro 
	public static void Ciframento(String testar){
		String nova="";
		int tamanho = testar.length();
		int x;
		char z;

		for(x=0;x<tamanho;x++){
			z = (char)(testar.charAt(x)+3);//adiciona 3 no valor numero do codigo da letra em relacao a tabela ascii, e depois transforma novamente em char
			nova = nova + z;//concate na se a string a ser printada
		}
		MyIO.println(nova);//printa se a string
	}
	
	public static void main(String[] args){
		String saida = "FIM", entrada;
		entrada = MyIO.readLine();
		while(compareTo(saida,entrada)!=1){
			Ciframento(entrada);
			entrada = MyIO.readLine();	
		}	
	}
}
