/*
*	Trabalho de programacoa 1
*
*	Feito por: 
*	Jeferson A. Schein
*	e-mail : schein.jefer@gmail.com
*	Ivair Puerari
*	e-mail : ivaair@hotmail.com
*	
*	classe que sere para gravar a linha onde comeca o while, para pode retornar
*	para o comeco do while e fazer o teste novamente
*
*
*/

class Laco{
	private int p[];
	private int t;	

	public Laco(){
		p = new int[1000];
		t = -1;
	}

	public void push(int s){
		this.t++;
		this.p[this.t] = s;
	}

	public int pop(){
		if(this.t != -1){
			this.t--;
			return (p[this.t + 1]);
		}else{
			return (-1);
		}
	}
	
	public boolean vazio(){
		return (this.t == -1) ? false:true;
	}






	
}
