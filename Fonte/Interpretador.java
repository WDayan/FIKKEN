/*
*
*
*
*
*/

import java.util.Scanner;

public class Interpretador{
	private Variavel var[];
	private Laco pilha;	
	private Imprime impressao;	

	public Interpretador(){
			var = new Variavel[500];
			pilha = new Laco();

	}




	public void interpreta(String com[]){
			int i;
			char operador;
			String comando;
			for(i=0; i<com.length && com[i] != null; i++){
				com[i]=com[i].trim();
				com[i]=com[i].replace("se","*");
				com[i]=com[i].replace("fimse",".");
				com[i]=com[i].replace("var$","^");
				com[i]=com[i].replace("enquanto","@");
				com[i]=com[i].replace("fimenquanto","ª");

				com[i]=com[i].replace("imprime","¢");
				com[i]=com[i].replace("break","!");
		
		}

		for(i=0; i < com.length && com[i] != null; i++){
			String s = new String(com[i]);
			operador = com[i].charAt(0);
			comando = com[i].substring(1);
			comando = comando.trim();

			switch(operador){

				case '¢':
					impressao.imprime(s , var);
					break; 
				case '^':
					//this.atualizaVar(s , var);
					break; 
				case '*': 
						if(this.funcaoSe(instrucao,var[])== false)

					break;
				default:
					break;
			}
	
		}

	}
	

	/*public void tokenAtualiza(string c){
		String file[] = c.split("=");
		Double vet[] ;
		int i;

		for(i = 0; i < file.length; i++){
			if (File [i].variavelVerdade(file[i]) == True) {
				   
			}
		}

	}
	*/
 
	 public int atualizavar(String c[], Variavel var[]){
	 	String file[]= new String[2];

	 	String vet;
	 	if(c.split("=")){
	 		if(c.split("\\+|\\-|\\*|\\/")){
	 			vet=mat(c.substring(2),var);
	 			file[0]=c.charAt(0);
	 			return newvar(file[0],Double.parseDouble(vet),var);
			}else{
				String file[] = c.split("=");
					return newvar(file[0],Double.parseDouble(file[1]),var);
			}
		}
	 }
	
	 public int newvar(String a, double b, Variavel var[]){
		int i;
	 	for(i=0;i<var.length;i++){
	 		if((var[i].getNome()).equals(a)){
				var[i].setNome(a);
				var[i].setValor(b);
	 			return 1;
	 		}
	 		if(var[i].getNome() == null){
	
	 			var[i].setNome(a);
	 			var[i].setValor(b); 
	 			return 1;
	 		}
	 	}
	
	}
	
	public double mat(String c, Variavel var[]){
		String file[] = c.split("\\+|\\-|\\*|\\/");
		double cont[] = new double[file.length];
		double res;
		int i;
		for(i=0 ; i < file.length && file[i] != null ; i++){
			if(var[i].verificaVar(file[i], var)){
				cont[i]= var[i].getValor();
			}
			else{
				cont[i]=Double.parseDouble(file[i]);
			}
		}
		if(cont.length == 0){ //Ver como é contado de 0 ou 1
			return cont[0];
		}
		res=cont[0];
		int j = 0;
		for(i=0; ((i < file.length) && (cont.length > 1)) ;i++){
			if(c.charAt(i) == '+' || c.charAt(i) == '-' || c.charAt(i) == '*' || c.charAt(i)== '/'){
				switch(c.charAt(i)){
					case '+' : 
						res = res+cont[j];
						break;
					case '-' : 
						res = res-cont[j];
						break;
					case '*' : 
						res = res*cont[j];
						break;
					case '/' : 
						res = res/cont[j];
						break;		
				}
				
				j++;
			}
			/*
			if(c.charAt(i) == '+'){
				res = res+cont[j];
			}else if(c.charAt(i) == '-'){
				res = res-cont[j];
			}else if(c.charAt(i) == '*'){
				res = res*cont[j];
			}else if(c.charAt(i)== '/'){
				res = res/cont[j];
			}
			j++;*/
		}

		return res;
	}	
	public boolean funcaoSe(Variavel var[],Strind a){
		int i;
		String[] teste = a. split(">|<|_");
		double cont[] = new double[file.length];
		int i;
		for(i=0 ; i < file.length && file[i] != null ; i++){
			if(var[i].verificaVar(file[i], var)){
				cont[i]= var[i].getValor();
			}
			else{
				cont[i]=mat(teste[i], var[]);
			}
		}
		for(i=0,i<c.lenght;i++){
			if(c.charAt(i)=='>' || c.charAt(i)=='<' || c.charAt(i) == '&' || c.charAt(i) == '!'){
				switch(c.charAt(i)){
					case '>': 
					 	return cont[0]>cont[1];
					case '<': 
					 	return cont[0]<cont[1]);
					case '_': 
						return cont[0]==cont[1];
				}		
			}	
		}
		return false;
	}



}

		
