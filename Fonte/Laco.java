class Laco{
	private String p[];
	private int t;	

	public Laco(){
		p = new String[1000];
		t = -1;
	}

	public void push(String s){


		this.t++;
		this.p[this.t] = s;
	}

	public String pop(){
		if(this.t != -1){
			this.t--;
			return (p[this.t + 1]);
		}else{
			return ",";
		}
	}
	
	public boolean vazio(){
		return (this.t==-1)? false:true;
	}

	public int linha( String  com[], int i){
		int x;
		String aux = com[i].charAt(0);
		String aux2;
		if(aux == '£'){
			aux2 = '.';
		}
		else if (aux == '@') {
			aux2 = 'ª';
		}

		for (i+=1;i<com.lenght && com[i] =!null; i++  ) {
			if(aux = com[i].charAt(0)){
				x++;
			}
			else if(com[i].charAt(0)== aux2){
				if(cont==0)
						return i;
				else
					x--;
			}
		}
		return i ;	
		}




	
}
