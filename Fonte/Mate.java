class Mate{
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



