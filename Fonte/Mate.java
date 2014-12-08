class Mate{
	private double a,b;
	private double[] valores = new double[30];
	private int LetNum;
			
	public double subtrai(){
		return a - b;
	}
	public double somas(){
		return a + b;
	}
	public double multiplica(){
		return a * b;
	}
	public double divide(){
		return a / b;
	}
	public double resto(){
		return a % b;
	}
	

	public double fazDouble(String s){//Só devolve o número Double já encontrado.
		return Double.parseDouble(s);
	}
	
	public int prioridade(char c){//Para a funcao Calcula, recebe um char, e devolve a prioridade dele.
		if(c == '(')
			return 1;
		else if(c == '+' || c == '-')
			return 2;
		else if(c == '*' || c == '/') 
			return 3;
		else if(c == '%') // quando tiver um resto
			return 4;
		return 0;
	}
	
	public String deletaChar(String s, int i){//Recebe a String e a posicao do CHAR que deve ser deletada.
		int j;
		String nova = new String();
		for(j = 0;j < i; j++)//Deleta o ultimo caracter.
			nova += s.charAt(j);
		return nova.toString();	
	}
	
	public double valorLetra(String s, char c){ //Controle interno, pra saber o valor de cada coisa num vetor. Tudo só para a função Calcula.
		int i = - 1;
		switch(c){
			case 'a': i = 0; break;
			case 'b': i = 1; break;
			case 'c': i = 2; break;
			case 'd': i = 3; break;
			case 'e': i = 4; break;
			case 'f': i = 5; break;
			case 'g': i = 6; break;
			case 'h': i = 7; break;
			case 'i': i = 8; break;
			case 'j': i = 9; break;
			case 'k': i = 10; break;
			case 'l': i = 11; break;
			case 'm': i = 12; break;
			case 'n': i = 13; break;
			case 'o': i = 14; break;
			case 'p': i = 15; break;
			case 'q': i = 16; break;
			case 'r': i = 17; break;
			case 's': i = 18; break;
			case 't': i = 19; break;
			case 'u': i = 20; break;
			case 'v': i = 21; break;
			case 'w': i = 22; break;
			case 'x': i = 23; break;
			case 'y': i = 24; break;
			case 'z': i = 25; break;
		}
			if(i < 0)
				return - 1;
		return valores[i];	
	}	
	public int giraAteNaoCaracter(String s, int i){ //Recebe alguma posicao do Caracter
		char c = s.charAt(i);
		for(i = i + 1; Character.isLetter(c); i++)
			c = s.charAt(i);
		return i - 1;
	}
	
	public String achaTodoONome(String s, int i){ //Recebe a posicao do 1° Caracter! Devolve o nome encontrado.
		char c;
		String nome = new String();
		c = s.charAt(i);
		while(Character.isLetter(c)){
			nome += c;
			i++;
			c = s.charAt(i);
		}
		return nome.toString();	
	}

	public int giraAteNaoNumero(String s, int i){//Recebe alguma posicao do Numero.
		char c;
		c = s.charAt(i);
		for(i = i + 1; Character.isDigit(c) || c == '.'; i++)
			c = s.charAt(i);
		return i - 1;
	}
	
	public double achaTodoONumero(String s, int i){ //Recebe a 1° posicao do Numero. Devolve o Numero, já em Double.
		char c;
		String numero = new String();
		c = s.charAt(i);
		while(Character.isDigit(c) || c == '.'){
			numero += c;
			i++;
			c = s.charAt(i);
		}
		return Double.parseDouble(numero);	
	}
	
		public double calcula(String s, int i, VarU v){//Recebe a String, o próximo char depois do '=' e o conjunto de variaveis.
		//infixaToPosfixa!!
		char c;
		int posicao, keep = 1,indice=0;
		String letras = new String("abcdefghijklmnopqrstuvwxyz");
		String pilhaInfixa = new String();
		String result = new String();
		String aux = new String();
		c = s.charAt(i);
		i++;
		for(posicao = 0; i < s.length() && c != ';'; i++){
			if(Character.isLetter(c)){//Se encontrar uma letra,
				aux = achaTodoONome(s, i-1);
				result += letras.charAt(indice); //Depois irá colocar um nome temporário, no resultado, deixando tudo como a+b+c-d/e ..... y;
				valores[indice] = v.valorVar(aux);//Pega o valor. e o guarda no mesmo indice
				indice++;
				i = giraAteNaoCaracter(s, i-1);
				aux = "";
			}
			else if(Character.isDigit(c)){ //Se encontrar um Numero.
				aux += achaTodoONumero(s, i-1);
				result += letras.charAt(indice); //Guarda indice
				valores[indice] = fazDouble(aux);//Pega o valor. e o guarda no mesmo indice
				indice++;
				i = giraAteNaoNumero(s, i-1);
				aux = "";
			}
			else if(c == '*' || c == '/' || c == '+' || c == '-' || c == '%'){ //Empilha ou não os operadores
				if(posicao > 0 && (prioridade(pilhaInfixa.charAt(posicao-1)) >= prioridade(c))){
						result += pilhaInfixa.charAt(posicao-1);
						pilhaInfixa = deletaChar(pilhaInfixa, posicao-1);
						posicao--;
				}
				pilhaInfixa += c;
				posicao++;
			}
			
			else if(c == '('){
				pilhaInfixa += c;
				posicao++;
			}
			else if(c == ')'){ //Desempilha.
				do{
					result += pilhaInfixa.charAt(posicao-1);
					pilhaInfixa = deletaChar(pilhaInfixa, posicao-1);
					posicao--;
					c = pilhaInfixa.charAt(posicao-1);
				}while(c != '(');
				pilhaInfixa = deletaChar(pilhaInfixa, posicao-1);
				posicao--;
			}
		if(i < s.length())
			c = s.charAt(i);
		}
		
		while(posicao > 0){
			result += pilhaInfixa.charAt(posicao-1);
			posicao--;
		}
		//Até aqui vai a infixaToPosfixa!!!
		
		//Começa Posfixa!!!
		double [] pilha = new double[100];
		posicao = 0;
		for(i = 0; i < result.length(); i++){
			c = result.charAt(i);
			if(Character.isLetter(c)){
				pilha[posicao] = valorLetra(result, c);
				posicao++;
			}
			else if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%'){
					a = pilha[posicao-2];
					b = pilha[posicao-1];
					posicao -= 2;
					switch(c){ //Faz o calculo.
						case '+':
							pilha[posicao] = somas();
							posicao++;
							break;
						case '-':
							pilha[posicao] = subtrai();
							posicao++;
							break;
						case '*':
							pilha[posicao] = multiplica();
							posicao++;
							break;
						case '/':
							pilha[posicao] = divide();
							posicao++;
							break;
						case '%':
							pilha[posicao] = resto();
							posicao++;
							break;
					}
				}
			}
		return pilha[0];
	}


	public static double soma(String c, VarU a){
			
			String file[] =  c.split("\\+|\\-|\\/|\\*");
	
			double ve[] = new double[file.length];
			
			int i;
			int j;
			double res;
			for (i=0;i<file.length ; i++ ){
				file[i] = file[i].trim();
				if(a.varE(file[i])){
					ve[i] = a.valorVar(file[i]);
				}
				else{
					ve[i] = Double.parseDouble(file[i]);
				}
			}
			if (ve.length == 1) {
				return res= ve[0];	
			}
			j=1;
			res=ve[0];
			for (i=0;i<c.length() ;i++ ) {
				if(c.charAt(i) == '+' || c.charAt(i) == '-' || c.charAt(i) == '*' || c.charAt(i)== '/'){
					switch(c.charAt(i)){
						case '+' :
							res  = res + ve[j];
							break;
						case '*' : 
							res  = res * ve[j];
							break;
						case '-' : 
							res  = res - ve[j];
							break;
						case '/' : 
							res  = res / ve[j];
							break;
					}
					j++;
				}
			}
 			return res;	
		}
}	



