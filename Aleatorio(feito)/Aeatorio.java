import java.util.Random;
public class Aeatorio{

	//metodo compareTo para parar o loop quando entrar "FIM"
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

	//metodo que recebe as duas variaveis que serao localizadas e trocadas
	public static String Aleatorio (String modificar, char letra1, char letra2){
		int tamanho = modificar.length();
		int x;
		String nova=""; //nova String a ser gerada

		for(x=0;x<tamanho;x++){
			if(modificar.charAt(x)==letra1){
				nova = nova + letra2;
			}else{
				nova = nova + modificar.charAt(x);
			}
		}
		return nova;
	}
	
	public static void main(String[] args){
		String saida = "FIM";
		String entrada, arm;
		//criando gerador e setando seed padrao
                Random gerador = new Random();
                gerador.setSeed(4);
		//criando variaveis que receberão os char gerados
                char letra1,letra2;

		entrada = MyIO.readLine();
		while(compareTo(saida,entrada)!=1){
			letra1 = ((char)('a'+(Math.abs(gerador.nextInt())%26)));
                	letra2 = ((char)('a'+(Math.abs(gerador.nextInt())%26)));
			//chamada do metodo
			arm=Aleatorio(entrada,letra1,letra2);
			MyIO.println(arm);
			entrada = MyIO.readLine();	
		}	
	}
}
