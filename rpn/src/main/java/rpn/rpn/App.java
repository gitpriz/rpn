package rpn.rpn;

import java.util.Stack;

public class App 
{
	
	Stack<Double> stack = new Stack<Double>();
	
	public App(String s) {
		evaluer(s);
	}
	public App() {

	}


	private void evaluer(String s) {
		String tab[] = s.split(" ");
		
		for(int i = 0; i < tab.length; i++) {
			String elem = tab[i];
			System.out.println(elem);


			try {
				if(elem.equals("+")) {
					Double d1 = stack.pop();
					Double d2 = stack.pop();
					stack.push(d2 + d1);
				}
				else if(elem.equals("-")) {
					Double d1 = stack.pop();
					Double d2 = stack.pop();
					stack.push(d2 - d1);		
				}
				else if(elem.equals("*")) {
					Double d1 = stack.pop();
					Double d2 = stack.pop();
					stack.push(d2 * d1);
				}
				else if(elem.equals("/")) {
					Double d1 = stack.pop();
					Double d2 = stack.pop();
					stack.push(d2 / d1);
				}
				else if(elem.equals("sqrt")) {
					Double d1 = stack.pop();
					stack.push(Math.sqrt(d1));
				}
				else if(elem.equals("carré")) {
					Double d1 = stack.pop();
					stack.push(d1 * d1);
				}
				else if(elem.equals("sin")) {
					Double d1 = stack.pop();
					stack.push(Math.sin(d1));
				}
				else if(elem.equals("cos")) {
					Double d1 = stack.pop();
					stack.push(Math.cos(d1));
				}
				else if(elem.equals("tan")) {
					Double d1 = stack.pop();
					stack.push(Math.tan(d1));
				}
				else if(elem.equals("inv")) {
					Double d1 = stack.pop();
					stack.push(1 / d1);
				}
				else if(elem.equals("op")) {
					Double d1 = stack.pop();
					stack.push(-d1);
				}
				else if(elem.equals("puiss")) {
					Double d1 = stack.pop();
					Double d2 = stack.pop();
					stack.push(Math.pow(d1, d2));
				}
				else if(elem.equals("!")) {
					
				}
				else {
					stack.push(Double.parseDouble(elem));
				}
			}
			catch(java.util.EmptyStackException e) {
				System.out.println("Erreur : l'expression passée en paramètre est incorrecte; un opérateur n'a pas ou pas assez d'opérandes.");
			}

		}
		System.out.println("Résultat : " + stack.peek());

	}
	
	public Double sommet() {
		return stack.peek();
	}
	
	public static void main( String[] args )
	{
		/*if(args.length == 0) {
			new App();
		}
		else if (args.length == 1) {*/
				new App("3 4 sqrt + 10 3 - *");
		/*}
		else {
			System.out.println("Erreur. Le programme doit être appellé avec 0 ou 1 paramètre.");
		}*/
				
		for(Operateur o : Operateur.values()) {
			System.out.println(o.getSymbole());
			double i = o.ADDITION.calc();
		}	
	}
}
