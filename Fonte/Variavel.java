/*
*
*
*
*	Classe usada para declarar variaveis, que podem ser inicializadas sem nome nem valor.
*	As variaveis so podem ser do tipo double.
*
*/


class Variavel{
	private String nome;
	private double valor;

	public void setNome(String n){
		this.nome = n;
	}

	public void setValor(double v){
		this.valor = v;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public double getValor(){
		return this.valor;
	}

	
}
