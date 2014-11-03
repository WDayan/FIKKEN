/*
*
*	Trabalho de programacoa 1
*
*	Feito por: 
*	Jeferson A. Schein
*	e-mail : schein.jefer@gmail.com
*	Ivair Puerari
*	e-mail : ivaair@hotmail.com
*
*
*	Classe usada para declarar variaveis, 
*	que quando instanciada colocara uma String no nome e um double no valor.
*	A classe tb possui metodos para alterar nome e valores.
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

	public Variavel(String s, double d){
		this.nome = s;
		this.valor = d;
	}
	
}
