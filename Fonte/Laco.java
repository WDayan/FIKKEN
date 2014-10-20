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
		return (this.t==-1)? false:true;
	}

	public int linha( String  com[], int i){
		int x = 0;
		String aux = ""+com[i].charAt(0);
		String aux2 =  new String();
		if(aux == ""+'£'){
			aux2 = ""+'.';
		}
		else if (aux == ""+'@') {
			aux2 = ""+'ª';
		}

		for (i += 1 ; ((i < com.length) && (com[i] != null)) ; i++  ) {
			if(aux == ""+com[i].charAt(0)){
				x++;
			}else if( aux2 == ""+com[i].charAt(0)){
				if(x == 0){
						return i;
				}else{
					x--;
				}
			}
		}
		return i ;	
		}




	
}