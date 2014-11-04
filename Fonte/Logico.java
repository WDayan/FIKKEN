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
		String[] teste = a. split("\\>|\\<|\\!|\\&");
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
		/*
		for(i = 0; i < teste.length; i++){
			System.out.println(teste[i]);
			System.out.println(cont[i]);
		}
		*/
		for(i = 0 ; i < a.length() ; ++i){
			//System.out.println(a.charAt(i));
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

	public static int linha(String[] cmd, int i, char inicio){
		int cont= 0;		
		char fim='*';	

		//System.out.println(i);
		
		if(inicio=='@')
			fim='#';	
		for(i=i+1;i<cmd.length && cmd[i] != null; i++){
			//System.out.println("f"+i);
			if(cmd[i].charAt(0) == inicio){
				cont++;
				//System.out.println(cont);
			}else if(cmd[i].charAt(0) != fim){
					if(cont==0){
						
					}else{
						cont--;
					}
			}else {
				//System.out.println("ai "+i);
				return i;
			}
		}
		return i;
	}
}