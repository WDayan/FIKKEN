import java.io.File;
import java.util.Scanner;	

public class Centrum{

	public static void main(String[] args) {
		
		File arquivo;
		Scanner conteudo;
		Interpretador f; 
		String comandos[] = new String[5000];

		try{
			arquivo = new File(args[0]);
			conteudo = new Scanner(arquivo);
			f = new Interpretador();

			int i = 0;
			while(conteudo.hasNext()){
				comandos[i] = conteudo.nextLine();
				i++;
			}
			fi.interpreta(comandos);
		
		}catch(Exception e){
				System.out.println("Nao e possivel ler o arquivo: " + (args.length > 0 ? args[0] : "(desconhecido)"));
				System.out.println("Uso:\n Java Centrum /caminho/para/arquivo.cem");
				return;
				
		}
	}
}
