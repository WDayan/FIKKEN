/*
 * *	Trabalho de programacoa 1
*
*	Feito por: 
*	Jeferson A. Schein
*	e-mail : schein.jefer@gmail.com
*	Ivair Puerari
*	e-mail : ivaair@hotmail.com
*
*	classe usada para fazer impresao do valor de uma variavel ou de uma string ou 
*	valor qualquer.
*
 */


class Imp{
	public static void imprime(String c, VarU v){		
		String imp = c.substring(1);
		imp = imp.trim();
		int p;

		if(v.varE(imp)){	
			System.out.println(v.valorVar(imp));
			
		}else{
			System.out.println(imp);
		}
		
	}

}
