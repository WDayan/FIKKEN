/*
*	Trabalho de programacoa 1
*
*	Feito por: 
*	Jeferson A. Schein
*	e-mail : schein.jefer@gmail.com
*	Ivair Puerari
*	e-mail : ivaair@hotmail.com
*
*
*	Classe usada pelo if e while para fazer os testes logicos, e desvio caso testes
*	nao sejam verdadeiros.
*
*
*/class Logico{
	public static boolean funcaoSe(VarU var ,String a){
		int i;
		boolean boo = false;
		String[] teste = a.split("\\>|\\<|\\!|\\&");
		double cont[] = new double[teste.length];

		for(i = 0 ; (i < teste.length) && (teste[i] != null) ; ++i){
			teste[i] = teste[i].trim();
			if(var.varE(teste[i])){
				cont[i]= var.valorVar(teste[i]);
			}
			else{
				cont[i]=Double.parseDouble(teste[i]);
			}
		}
<<<<<<< HEAD
		
=======
	
>>>>>>> e6deed6c82032b1e118c950688b54a251b7d688e
		for(i = 0 ; i < a.length() ; ++i){
			if(a.charAt(i) == '>' || a.charAt(i) == '<' || a.charAt(i) == '&' || a.charAt(i) == '!'){
					if(a.charAt(i) == '>'){
					 	if(cont[0] > cont[1]){
					 		return true;
					 	}
					}else if(a.charAt(i) == '<'){
					 	if(cont[0] < cont[1]){
					 		return true;
					 	}
					}else if(a.charAt(i) == '&'){
					 	if(cont[0] == cont[1]){
					 		return true;
					 	}
					}else if(a.charAt(i) == '!'){ 
					 	if(cont[0] != cont[1]){
					 		return true;
					 	}
					}

			}	
		}
		return false;
	}

	public static int linha( String  com[], int i){
		int x = 0;
		char aux = com[i].charAt(0);
		char aux2  = ' ';
		if(aux == '@'){
			aux2 = '#';
		}else if (aux == '.') {
			aux2 = '*';
		}

		for (i += 1 ; ((i < com.length) && (com[i] != null)) ; i++  ) {
			if(aux == com[i].charAt(0)){
				x++;
			}else if( aux2 == com[i].charAt(0)){
				if(x == 0){
					return i;
				}else{
					x--;
				}
			}
		}
		return i ;	
	}
}
