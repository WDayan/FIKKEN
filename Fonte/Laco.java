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
		this.t += 1;
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
		return (this.t == -1) ? false : true;
	}

	public int loop(String []com, int i, VarU v){
		int j, auxI = i, x;
		double a = 0, b = 0;
		boolean boo = false;
		String aux1 = com[i].substring(1);
		String []aux = aux1.split("\\<|\\>");
		aux1 = aux1.trim();
		
		this.push(i);
				
		for(i = i + 1; i < com.length; i++){
			for(j = 0; i < aux[i].length(); i++){
				if(com[i].charAt(j) == '>' || com[i].charAt(j) == '<' ){
					if(aux[j] != null){
						aux[j] = aux[j].trim();
					}
					if(v.varE(aux[0])){
						a = v.valorVar(aux[0]);
					}else {
						a = Double.parseDouble(aux[j]);
					}
					if(v.varE(aux[1])){
						b = v.valorVar(aux[0]);
					}else {
						b = Double.parseDouble(aux[j]);
					}
				}
				if(com[i].charAt(j) == '>' && a > b){
					boo = true;
				}
				if(com[i].charAt(j) == '<' && a < b){
					boo = true;
				}
			}
	
			if(com[i].charAt(0) == '#'){
				auxI = i;
				i = com.length;
			}
		}
		
		if( boo == true){
			auxI = this.pop();
			
		}else {
			return auxI;
		}
		
		return auxI;
		
	}
			
	

		
	
}
