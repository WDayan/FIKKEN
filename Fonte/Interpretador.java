/*
*
*
*
*
*/

import java.util.Scanner;

public class Interpretador{
	private Variavel var;
	private Laco pilha;	
	private Imprime impressão;	

	public Interpretador(){
			[500]var= new Variavel();
			pilha=new Laco();

	}




	public void interpreta(String com[]){
			 int i;
			 char operador;
			 string comando;
			for(i=0; i<com.length && com[i] != null; i++){
				com[i]=com[i].trim();
				com[i]=com[i].replace("se","*");
				com[i]=com[i].replace("fimse",".");
				com[i]=com[i].replace("var$","^");
				com[i]=com[i].replace("while","@");
				com[i]=com[i].replace("imprime","¢");
				com[i]=com[i].replace("break","!");
		
		}

		for(i=0; i<com.length && com[i] != null; i++){

			operador=com[i].charAt(0);
			comando=com[i].substring(1);
			comando=comando.trim();

			switch(operador){

				case '¢' : impressão.imprime(comando,var[]);
							break;
				case '^': this. atualizaVar(comando,var[]);
							break;
				case'*': 
							break;
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
 
 public int atualizavar(string c,var[]){
 	String file[]= new String[2];

 	Double vet;
 	if(c.split("=")){
 		if(c.split("'+'\'-'\'*'\'/'"){
 			vet=mat(c.substring(2),var[]);
 			file[0]=c.charAt(0);
 			return newvar(file[0],vet,var[]);
		}else{
			String file[]=c.split("=");
				return newVar(file[i],file[i+1],var[]);
		}
	}
 }

 public int newvar(String a, String b, Variavel var[]){
	int i;
 	for(i=0;i<var.lenght;i++){
 		if((var[i].setnome()).equals(a)){
			var[i].setnome=a;
			var[i]. setvalor=Double.parseDouble(b);
 			return 1;
 		}
 		if(var[i].setnome==NULL){

 			var[i].setnome=a;
 			var[i]. setvalor=Double.parseDouble(b); 
 			return 1;
 		}
 	}

}

}
public Double mat(string c,Variavel var[]){
	String[] file = c.split("\\+\\-\\*\\'/'");
	double[] cont = new Double(file.lenght);
	Double res;
	int i;
		for(i=0;i<file.lenght & file[i]!=NULL;i++){
			if(verificaVar(file[i])){
				cont[i]= var[i].getValor();
			}
			else{
				cont[i]=Double.parseDouble(file[i]);
			}
		}

		if(cont.lenght==1){ //Ver como é contado de 0 ou 1
	
			return cont[0];

		}
		res=cont[0];
		int j = 0;
		for(i=0;i<c.lenght && cont.lenght>1;i++){
			if(c.charAt(i) == '+' || c.charAt(i) == '-' || expressao.charAt(i) == '*' || expressao.charAt(i)== '/'){
				switch(c.charAt(i)){
					case'+' : 
						res=res+cont[j];
						break;
					case'-' : 
						res=res-cont[j];
						break;
					case'*' : 
						res=res*cont[j];
						break;
					case'/' : 
						res=res/cont[j];
						break;		
				}
				j++}
		}
	return res;
	}


}
