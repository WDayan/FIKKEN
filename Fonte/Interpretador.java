/*
*	Trabalho de programacoa 1
*
*	Feito por: 
*	Jeferson A. Schein
*	e-mail : schein.jefer@gmail.com
*	Ivair Puerari
*	e-mail : ivaair@hotmail.com
*	
*	classe que substitui palavras chaves por tokens e interpreta os mesmo, fazendo
*	chamada a metodos e classe e metodos do arquivo.
*
*
*/


import java.util.Scanner;

class Interpretador{
	private VarU var;
	private Laco laco;
	private Scaner scan;

	public Interpretador(){
			var = new VarU();
			laco = new Laco();
			scan = new Scaner(System.in);
	}

	public void interpreta(String com[]){
		int i, contv = 0, j;
		char tok;
		String aux;
		

		for(i=0; i<com.length && com[i] != null; i++){
			com[i]=com[i].trim();
			com[i]=com[i].replace("se",".");
			com[i]=com[i].replace("fimse",",");
			com[i]=com[i].replace("op","$");
			com[i]=com[i].replace("enquanto","@");
			com[i]=com[i].replace("fimenquanto","#");
			com[i]=com[i].replace("imprime","!");
			com[i]=com[i].replace("le","?");
		}

		for(i = 0; i < com.length; i++){
			tok = com[i].charAt(0);
			aux = com[i].substring(1);
			aux = aux.trim();
						
			switch(tok){
				case '.':	//if
					if(Logico.funcaoSe(var, aux) == false){
						Logico.linha(com, i)
					}
					break;
					
				case '.': 	//fim if
					break;
					
				case '$':	//operacoes				
					Mate.soma(aux, var);
					break;
					
				case '@':	//while
					if(Logico.funcaoSe(var, aux) == true){
						Logico.linha(com, i)
					}else{
						laco.push(i);
					}
					break;
					
				case '#':	//fim while
					if(laco.vazio() != true){
						i = laco.pop;
					}
					break;
					
				case '!':	//imprime
					Imp.imprime(aux);
					break;

					
				case '?':	//scaner leitur
					double get = scan..nextDouble();
					VarU.atlVar(aux, get);
					break;
				
			}
			
		}

	}



}
