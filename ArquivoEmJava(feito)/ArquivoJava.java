import java.io.RandomAccessFile;
public class ArquivoJava{
	
	//metodo para ler arquivos do pub.in e passa los para um .txt
	public static void LerArquivos(int lim){
		int controle;
		double entrada = 0;
		
		try{
			RandomAccessFile rf = new RandomAccessFile( "texto.txt", "rw" );
			for(controle=0;controle<lim;controle++){
				//escrever tudo o que for lido dentro do arquivo texto.txt
				rf.writeDouble(MyIO.readDouble()); 
			}
			rf.close();//fechando arquivo
		}catch(Exception exception){
			
		}
	}

	public static void RelerArquivos(int lim){
		int controle;
                double entrada = 0;

                try{
                        RandomAccessFile rf = new RandomAccessFile( "texto.txt", "r" );
                        for(controle=(lim-1);controle>=0;controle--){
				rf.seek(controle*8);//multiplicamos por 8, para andarmos de byte em byte 
				entrada = rf.readDouble();//lemos o numero
				if((entrada-(int)entrada==0)){//caso nao tenha nada na casa decimal
					MyIO.println((int)entrada);//printamos apenas a parte inteira
				}else{
					MyIO.println(entrada);//caso contrario, printamos normalmente
				}
                        }
                        rf.close();//fechamos arquivo

                }catch(Exception exception){
                        //tratamento de qualquer excessão
                }
	}
        
	public static void main(String[] args){
                int entrada = MyIO.readInt();
                LerArquivos(entrada);
		RelerArquivos(entrada);
        }
}

