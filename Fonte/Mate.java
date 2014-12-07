class Mate{
	private double a,b;
	private double[] valores = new double[30];
			
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
	
	public int ehNegativo(String s, int posicao){ //Recebe no -, Vai descobrir se eh um n° negativo.Devolver 1 => Eh n°. Devolver 2 => Eh toda expressão. 0 não faz nada
		char c = s.charAt(posicao+1);
		int i, num = 1, keep = 2;
		for(i = posicao+2; keep > 1; i++){
			if(Character.isDigit(c)){
				num++;
			}
			if(c != '+' && c != '-' && c != '*' && c != '/' && c != ' ' && c != ')'){
				if(num == 2)
					return 1;
			}
			if(c == ')')
				if(num == 2)
					return 1;
			if(c == '('){
				if(num == 1)
					return 2;
			}
			c = s.charAt(i);
			if(c == ';')
				keep = 0;
		}
		return 0;
	}
	
	public double fazProximoNumNegativo(String s, int posicao){ //Recebe o -. Vai devolver o próximo n° * -1;
		char c = s.charAt(posicao+1);
		int i, keep = 2;
		String aux = new String();
		for(i = posicao + 2; keep > 1; i++){
			if(Character.isDigit(c))
				aux += c;
			if(c != '+' && c != '-' && c != '*' && c != '/' && c != ' '){
				double jaca =  Double.parseDouble(aux);
				return jaca * -1;
			}
			c = s.charAt(i);
		}
		return 0;
	}
	
	/*public String achaDouble(String s, int posicao){//Venha a String inteira, e a posicao do começo do numero.
		String result = new String();
		char c;
		do{
			c = s.charAt(posicao);
			if(c == '+' || c == ')' || c == '-' || c == '(' || c == '*' || c == '/' || c == ';')
				posicao = s.length();
			else{
				result += c;
				posicao++;
			}
		}while(posicao < s.length());
		return result.toString();
	}*/

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
	public int multiplicaPorMenos(String s, int i){
		char c = s.charAt(i-1);
		for(i = i-1; c != '*' && c != '/'; i--){
			c = s.charAt(i);
			if(i == 0)
				return 1;
			if(c == '(' || c == ')')
				return 1;
		}
		return -1;	
	}
	
		public double calcula(String s, int i, VarU v){//Recebe a String, o próximo char depois do '=' e o conjunto de variaveis.
		//infixaToPosfixa!!
		char c;
		//System.out.println("           "+s);
		int posicao, keep = 1,indice=0, entrou = 2, jacare = 1;
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
				//valores[indice] = v[Variavel.achaVariavel(v, aux)].getValor(); //Vai pegar o valor dessa variável e guardá-lo tbm!
				valores[indice] = v.valorVar(aux);
				indice++;
				i = giraAteNaoCaracter(s, i-1);
				aux = "";
			}
			else if(Character.isDigit(c)){ //Se encontrar um Numero.
				aux += achaTodoONumero(s, i-1);
				result += letras.charAt(indice);
				valores[indice] = fazDouble(aux);
				indice++;
				i = giraAteNaoNumero(s, i-1);
				aux = "";
			}
			else if(c == '*' || c == '/' || c == '+' || c == '-' || c == '%'){
				if(c == '-'){
					if(ehNegativo(s, i-1) == 2){
						jacare = multiplicaPorMenos(s, i-1);
						if(jacare == -1)
							entrou = 1;
						else
							entrou = 2;
					}
				}
				else if(c == '-'){
					if(ehNegativo(s, i-1) == 1){
						result += letras.charAt(indice);
						valores[indice] = fazProximoNumNegativo(s, i-1);
						indice++;
						i = giraAteNaoNumero(s, i);
						entrou = 1;
					}
				}
				else if(posicao > 0 && (prioridade(pilhaInfixa.charAt(posicao-1)) >= prioridade(c))){
						result += pilhaInfixa.charAt(posicao-1);
						pilhaInfixa = deletaChar(pilhaInfixa, posicao-1);
						posicao--;
					}
				if(entrou > 1){
					pilhaInfixa += c;
					posicao++;
				}
				entrou = 2;
			}
			else if(c == '('){
				pilhaInfixa += c;
				posicao++;
			}
			else if(c == ')'){
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
					switch(c){
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
		return pilha[0] * jacare;
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



