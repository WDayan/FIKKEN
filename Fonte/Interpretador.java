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
				com[i]=com[i].replace("var","^");
				com[i]=com[i].replace("while","@");
				com[i]=com[i].replace("imprime","¢");
				com[i]=com[i].replace("break","!");
		
		}

		for(i=0; i<com.length && com[i] != null; i++){
<<<<<<< .mine
							
			
=======
					
>>>>>>> .r15
			operador=com[i].charAt(0);
			comando=com[i].substring(1);
			comando=comando.trim();

			switch(operador){

				case '-' : this.imprime(comando);
							break;
				case '^': this. tokens(comando);
							break;
				case'*': 
							break;
	}


<<<<<<< .mine
	}

	public void tokenAtualiza(string c){
		String file[] = c.split("=");
		
		int i;

		for(i = 0; i < file.length; i++){
			if (File [i].variavelVerdade(file[i]) == True) {
				   
			}
		}

	}
	//public BooleaN variavelVerdade(var a);
 

}
