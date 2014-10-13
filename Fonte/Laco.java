class Laco{
	private String p[];
	private int t;	

	public Fluxo(){
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
			return p[this.t + 1];
		}
	}
	
	public boolean vazio(){
		return (this.t==-1)? false:true;
	}

}
