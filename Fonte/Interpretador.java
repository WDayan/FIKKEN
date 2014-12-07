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

	public boolean interpreta(String com[]){//Chega aqui a String com o PROGRAMA
		int i, contv = 0, j;
		char tok;
		String aux;
		
		for(i = 0 ; i < com.length && com[i] != null; i++){
			com[i]=com[i].trim();
			com[i]=com[i].trim();
			com[i]=com[i].replace("fun:","[");//Para chamar a funcao abacaxi:
			com[i]=com[i].replace("fimenquanto","#");
			com[i]=com[i].replace("fimse","*");
			com[i]=com[i].replace("else",",");
			com[i]=com[i].replace("se",".");
			com[i]=com[i].replace("op","$");
			com[i]=com[i].replace("{","+");
			com[i]=com[i].replace("}","-");
			com[i]=com[i].replace("end",":");//Fim do ELSE
			com[i]=com[i].replace("enquanto","@");
			com[i]=com[i].replace("imprime","%");
			com[i]=com[i].replace("le","?");
		}
		boolean baleado=false;
		int[] salvaFuncao = new int[100]; 
		int jaEntrou = 1, indice = 0;
		Mate mat = new Mate();

		for(i = 0; i < (com.length - 1) && com[i] != null; ++i){
			tok = com[i].charAt(0);
			aux = com[i].substring(1);
			aux = aux.trim();
			
			switch(tok){//Caso IF
				case '.':
					baleado = Logico.funcaoSe(var, aux, 2);
					if(baleado == false){
						i = Logico.linha(com, i);
					}
					break;
				case ',': //Caso ELSE IF
					if(baleado)
						i = Logico.linha(com, i);
					else
						baleado = true;
					break;
				case '*': 	//fim if
					break;
				case ':':   //fim ELSE
					break;
					
				case '$': 	//criar variavel
					String[] nova = aux.split("=");
					String nok = new String();
					nova[1] = nova[1].trim();
					nok = nova[1].substring(0);
					int jaka,contador, contV, contN,posi=0;
					double value = 0.0;
					char jui = ' ';
					for(jaka=0,contador=0, contV=0,contN=0; jaka < nok.length(); ++jaka){
						jui = nova[1].charAt(jaka);
						if(jui == '+' || jui == '-' || jui == '*' || jui == '/'){
							contador++;
							posi = jaka;
						}
						if(Character.isLetter(jui))
							contV++;
						if(Character.isDigit(jui))
							contN++;
					}
					if((contV == 1 && contador == 1) || (contN == 1 && contador == 1)){
						jui = nova[1].charAt(posi);
						String[] nuum;
						if(jui == '-'){
							nuum = aux.split("\\=|\\-|\\;");
						}
						else
							nuum = aux.split("\\=|\\;");
						if(contN == 1){
							value = Double.parseDouble(nuum[2]) * -1;
							contador = -1;
							
						}
						if(contV == 1 && jui == '-'){
							value = Mate.soma(nuum[2], var) * -1;
							contador = -1;
						}
					}
					if(contador > 0){
						value = mat.calcula(nok, 0, var);
					}
					else if (contador == 0){
						String[] ki = aux.split("\\=|\\;");
						value = Mate.soma(ki[1], var);
					}
					nova[0] = nova[0].trim();
					var.atlVar( nova[0] , value);				
					break;
					
				case '@':	//while
					if(Logico.funcaoSe(var, aux, 1) == true){
						laco.push(i);
					}else{
						i = Logico.linha(com, i);
					}
					break;
					
				case '#':	//fim while
					if(laco.vazio() == true){
							i = (laco.pop() - 1);
					}
					break;
				
				case '[': //Onde está a FUNCAO. Necessário guardar essa posicao
					salvaFuncao[indice] = i;
					indice++;
					String[] nome = aux.split(";");
					nome[0] = nome[0].trim();
					i = Logico.achaFuncao(com, i, nome[0]);
					jaEntrou++;
					break;
				case '-':
					jaEntrou--;
					if(jaEntrou == 0)
						return true;
					indice--;	
					i = salvaFuncao[indice];
					break;
				case '+':
					return true;
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
		return true;
	}



}
