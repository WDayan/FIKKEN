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
	public void imprime(String comando,Variavel var[]){
		int i;
		String aux[] = comando.split(" ");
		String aux2[];
		Interpretador ii = new Interpretador();
		for(i = 0; i< (aux.length) && aux[i]==null;i++){
			if(aux[i].charAt(0) == '*'){
				aux2 = aux[i].split("*");
				System.out.println(aux2);
			}
			else{
				System.out.println( ii.mat(comando,var));

			}

		}
	}
}
