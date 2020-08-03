public class IssRecursivo{

	//metodo de parada pra String FIM	
	private static int compareTo(String fim, String entrada){
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

	//teste de vogal, caso haja algo que nao seja vogal, retorna se false
	private static boolean Vogal(String testar,int x){
		boolean resp = true;

		if(x<testar.length()){
			if(testar.charAt(x)=='a' || testar.charAt(x)=='e' || testar.charAt(x)=='i'
			|| testar.charAt(x)=='o' || testar.charAt(x)=='u'|| testar.charAt(x)=='A' 
			|| testar.charAt(x)=='E' || testar.charAt(x)=='I'
                        || testar.charAt(x)=='O' || testar.charAt(x)=='U'){
				resp = resp && Vogal(testar,x+1);
			}else{
				resp = false;
				x= testar.length();
			}	
		}
		return resp;
	} 

	private static boolean Consoante (String testar, int x){
                boolean resp = true;

                if(x<testar.length()){
                        if(testar.charAt(x)=='a' || testar.charAt(x)=='e' || testar.charAt(x)=='i' 
			||testar.charAt(x)=='o' || testar.charAt(x)=='u'|| testar.charAt(x)=='A' 
			|| testar.charAt(x)=='E' || testar.charAt(x)=='I'
                        || testar.charAt(x)=='O' || testar.charAt(x)=='U'){
                                resp = false;
				x=testar.length();
                        }else{
				if(testar.charAt(x)>='0' && testar.charAt(x)<='9'){
					resp = false;
					x=testar.length();
				}else{
					Consoante(testar,x+1);
				}
			}
                }
                return resp;
        }

	private static boolean Inteiro(String testar, int x){
                boolean resp = true;

                if(x<testar.length()){
                        if(testar.charAt(x)>='0' && testar.charAt(x)<='9'){
                                resp = Inteiro(testar,x+1);

                        }else{
				resp = false;
				x=testar.length();
			}
                }
                return resp;
        }

	private static boolean Real(String testar,int x){
                int contagem=0,cont=0;
                boolean resp = true;

                if(x<testar.length()){
                        if(testar.charAt(x)>='0' && testar.charAt(x)<='9'){
                                resp = Real(testar,x+1);
                        }else{
				if(testar.charAt(x)=='.'){
					contagem++;
					Real(testar,x+1);
				}else{
					if(testar.charAt(x)==','){
						cont++;
						Real(testar,x+1);
					}else{
						resp = false;
					}
				}
				
			}
                }
		if(contagem>=1 && cont==0){ 
			if(resp==true){
                		return resp;
			}else{
				resp = false;
				return resp;
			}
		}else{
			if(contagem==0 && cont>=1){ 
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

	public static void ChamadaIs(String entrada){
		if(Vogal(entrada,0)==true){
                	MyIO.print("SIM ");
                }else{
                        MyIO.print("NAO ");
                }
                if(Consoante(entrada,0)==true){
                        MyIO.print("SIM ");
		}else{
                        MyIO.print("NAO ");
                }
                if(Inteiro(entrada,0)==true){
                        MyIO.print("SIM ");
                }else{
                        MyIO.print("NAO ");
                }
                if(Real(entrada,0)==true){
                        MyIO.println("SIM");
                }else{
                        MyIO.println("NAO");
                }
	}


	
	public static void main(String[] args){
		String saida = "FIM", entrada;
		entrada = MyIO.readLine();
		while(compareTo(saida,entrada)!=1){
			ChamadaIs(entrada);		
			entrada = MyIO.readLine();	
		}	
	}
}
