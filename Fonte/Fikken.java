import java.io.File;
import java.util.Scanner;	

class Fikken{

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
			
			f.interpreta(comandos);
		
		}catch(Exception e){
				System.out.println("Nao e possivel ler o arquivo: " + (args.length > 0 ? args[0] : "(desconhecido)"));
				System.out.println("Uso:\n java -jar Fikken.jar  /caminho/para/arquivo.fik");
				return;
				
		}
	}
}
