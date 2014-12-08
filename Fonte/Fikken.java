/*
	Codigo original https://github.com/schein00/FIKKEN (autores, Ivair e Schein)
	
	Esse codigo foi modificado com as seguintes implementacoes:
		IF e ELSE
		funcoes sem parametro
		expressoes
		
	Use esse programa em Java para interpretar codigos .fik 
	Está incluido na pasta raiz deste programa um manual de operacao
	Para interpretar um codigo use: java Fikken arquivo.fik
	Alteracoes por: 
		Bruno Dall Orsoletta – email br-bruno@hotmail.com
		Dayan Weber – email weber.dayan@gmail.com
		https://github.com/WDayan/FIKKEN
*/

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
			
			f.interpreta(comandos);//Chama método pra começar a resolver as coisas. Eh lido LINHA por LINHA
		
		}catch(Exception e){
				System.out.println("Nao e possivel ler o arquivo: " + (args.length > 0 ? args[0] : "(desconhecido)"));
				System.out.println("Uso:\n java -jar Fikken.jar  /caminho/para/arquivo.fik");
				return;
				
		}
	}
}
