/*
* 	Feito por: 
*	Jeferson A. Schein
*	e-mail : schein.jefer@gmail.com
*	Ivair Puerari
*	
* 
* 	Classe VarU é usada para as variaveis usadas ela possui um vetor de variavei d 500
* 	posicoes, ser para incerir uma nova variavel como fazer alteracoes em seus valores,
* 	mas nao è possivel trocar o nome de uma variavel, possui tb metodo para testa quais
* 	variaveis existem e seus valores.
* 
*/



class VarU{
	Variavel []vetor;
	private int ult;
	
	public VarU(){
		vetor = new Variavel[500];
		ult = 0;
	}
	
	public boolean varE(String s){
		int i;
		
		for(i = 0; i < this.ult; i++){
			if((vetor[i].getNome()).equals(s)){
				return true;
			}
		}
		
		return false;	
	}
	
	public double valorVar(String s){
		int i;
		
		for(i = 0; i < this.ult; i++){
			if( vetor[i] != null && (vetor[i].getNome()).equals(s)){
				return vetor[i].getValor();
			}
		}
		
		return 0;
	}
	
	public int atlVar(String s, double d){
		int i;
		
		for(i = 0; i < this.ult; i++){
			if(vetor[i] != null && (vetor[i].getNome()).equals(s)){
				vetor[i].setValor(d);
				return 1;
			}
		}
		
		this.vetor[i].setNome(s);
		this.vetor[i].setValor(d);
		this.ult++;
		return 0;
		
	}
	
	
}