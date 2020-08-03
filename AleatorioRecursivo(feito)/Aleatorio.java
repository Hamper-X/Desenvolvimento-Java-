import java.util.Random;
public class Aleatorio{

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

	//metodo recebe 2 variaveis com as chars que serao pesquisadas e alocadas, alem de um contador
	public static String Aleatorio (String modificar, char letra1, char letra2,int x){
		String nova="";
		if(x<modificar.length()){ //o contador e que controla a recursividade
			if(modificar.charAt(x)==letra1){ //teste pra ver se a letra dessa posicao e igual a letra recebida
				nova = letra2+Aleatorio(modificar,letra1,letra2,x+1);//caso seja, coloca la no lugar da outra, mais o return do metodo
			}else{
				nova =modificar.charAt(x)+ Aleatorio(modificar,letra1,letra2,x+1);//caso nao seja, apenas seguir com a colocação padrão chamando o metodo novamente
			}
		}
		return nova; //retornar a nova palavra
	}
	
	public static void main(String[] args){
		String saida = "FIM";
		String entrada, arm;
		//criando gerador e setando seed padrao
                Random gerador = new Random();
                gerador.setSeed(4);
                char letra1,letra2;

		entrada = MyIO.readLine();
		while(compareTo(saida,entrada)!=1){
			letra1 = ((char)('a'+(Math.abs(gerador.nextInt())%26)));
                	letra2 = ((char)('a'+(Math.abs(gerador.nextInt())%26)));
			arm=Aleatorio(entrada,letra1,letra2,0);
			MyIO.println(arm);
			entrada = MyIO.readLine();	
		}	
	}
}
