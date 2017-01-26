package rpn.rpn;

public enum Operateur {
	ADDITION       ("+") { public double calc(double op1, double op2){return op1 + op2;} },
	SOUSTRACTION   ("-"),
	MULTIPLICATION ("*"),
	DIVISION       ("/"),
	RACINE         ("sqrt"),
	CARRE          ("carré"),
	SINUS          ("sin"),
	COSINUS        ("cos"),
	TANGENTE       ("tan"),
	INVERSE        ("inv"),
	OPPOSE         ("op"),
	PUISSANCE      ("puiss"),
	FACTORIELLE    ("!"),
	EULER          ("elr");
	
	private final String symbole;
	
	Operateur(String symbole) {
		this.symbole = symbole;
	}
	
	public String getSymbole() {
		return this.symbole;
	}

	public double calc() {
		// TODO Auto-generated method stub
		return 0;
	}

}
