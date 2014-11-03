/*
*	Feito por: 
*	Jeferson A. Schein
*	e-mail : schein.jefer@gmail.com
*	Ivair Puerari
*	e-mail : ivaair@hotmail.com
*
*	classe interpretador, usada para substituir coandos por tokens, e fazer a interpretacao
*	dos mesmos, declara a classe VarU que sao as variaveis usadas, e chema metodos 
*	estaticos para interpretar as linahs de comandoo conforme token testado
*
*/

import java.util.Scanner;
class Interpretador{
	private VarU var;

	public Interpretador(){
			var = new VarU();
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
				case '.':

					break;
					
				case ',':

					break;
					
				case '$':
					Mate.soma(aux, var);
					break;
					
				case '@':
					break;
					
				case '#':
					break;
					
				case '!':
					Imp.imprime(aux);
					break;

					
				case '?':
					break;
				
			}
			
		}

	}




}

		
