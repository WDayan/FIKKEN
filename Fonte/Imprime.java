class Imprime{
	private String impresao;

	public void setImp(String a){
		this.impresao=a;
	}
	
	public String getImp(){
		return this.impresao;
	}

	/*public void setIres(String a){
		this.impresao = a;
	}

	public String getIres(){
		return this.impresao;
	}
    */
	public void imprime(String comando,Variavel var){
		int i;
		String[] aux = comando.split(' ')
		for(int i=0; i<aux.lenght && aux[i]==NULL;i++){
			if(aux[i].charAt(0)=="*"){
				aux[i]=aux[i].split("*");
				system.out.println(aux[i]);
			}
			else{
				system.out.println( this.mat(comando,var[]));

			}

		}
	}
}
