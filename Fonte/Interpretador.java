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
	private Scanner scan;


	public Interpretador(){
			var = new VarU();
			laco = new Laco();
			scan = new Scanner(System.in);
	}

	public void interpreta(String com[]){
		int i, contv = 0, j;
		char tok;
		String aux;
		
		for(i = 0 ; i < com.length && com[i] != null; i++){
			com[i]=com[i].trim();
			com[i]=com[i].trim();
			com[i]=com[i].replace("se",".");
			com[i]=com[i].replace("fimse","*");
			com[i]=com[i].replace("op","$");
			//com[i]=com[i].replace("op","$");
			com[i]=com[i].replace("enquanto","@");
			com[i]=com[i].replace("fimenquanto","#");
			com[i]=com[i].replace("imprime","%");
			com[i]=com[i].replace("le","?");
		}

		for(i = 0; i < (com.length - 1); ++i){
			tok = com[i].charAt(0);
			aux = com[i].substring(1);
			aux = aux.trim();
						
			
			switch(tok){
				case '.':	//if
					boolean b = Logico.funcaoSe(var, aux);
					System.out.println(b);
					if(b == false){
						i = Logico.linha(com, i, tok);
					}
					break;
					
				case '*': 	//fim if
					break;
					
				case '$': 	//criar variavel
					String[] nova = aux.split("=");
					nova[1] = nova[1].trim();
					double valor = Mate.soma(nova[1], var);
					nova[0] = nova[0].trim();
					var.atlVar( nova[0] , valor);
					
					break;
					
				case '@':	//while
					i = laco.loop(com, i, var);
					//if(Logico.funcaoSe(var, aux) == true){
					//	System.out.println("whi1");
					//	laco.push(i);
					//}else{
					//	System.out.println("whi2");
					//'	Logico.linha(com, i, tok);
					//}
					break;
					
				case '#':	//fim while
					//if(laco.vazio() != true){
					//	i = laco.pop();
					//}
					break;
					
				case '%':	//imprime
					aux = aux.trim();
					Imp.imprime(aux, var);
					break;

					
				case '?':	//scaner leitur
					double get = scan.nextDouble();
					var.atlVar(aux, get);
					break;
					
				default:
					break;
				
			}
			
		}

	}



}
