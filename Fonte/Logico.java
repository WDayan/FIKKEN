class Logico{
	public static boolean funcaoSe(VarU var[],String a){
		int i;
		String[] teste = a. split("\\>|\\<|\\!|\\&");
		double cont[] = new double[teste.length];

		for(i = 0 ; ((i < teste.length) && (teste[i] != null)) ; i++){
			if(VarU.varE(teste[i]){
				cont[i]= VarU.valorVar(teste[i]);
			}
			else{
				cont[i]=Double.parseDouble(teste[i]);
			}
		}
		for(i = 0 ; i < a.length() ; i++){
			if(a.charAt(i) == '>' || a.charAt(i) == '<' || a.charAt(i) == '&' || a.charAt(i) == '!'){
				switch(a.charAt(i)){
					case '>': 
					 	return cont[0]>cont[1];
					case '<': 
					 	return cont[0]<cont[1];
					case '&': 
						return cont[0]==cont[1];
					case '!':
						  if(cont[0]>cont[1] || connt[0]<cont[1]) return True; 				}		
				}
			}	
		}
		return false;
	}

	
}
