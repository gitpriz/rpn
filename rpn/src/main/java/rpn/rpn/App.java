package rpn.rpn;

import java.util.Stack;

public class App 
{	
	public App(String s) {
		evaluer(s);
	}
	public App() {

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

	private void evaluer(String s) {
		String tab[] = s.split(" ");
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < tab.length; i++) {
			String elem = tab[i];
			System.out.println(elem);


			try {
				if(elem.equals("+")) {
					Double d1 = Double.parseDouble(stack.pop());
					Double d2 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(d2 + d1));
				}
				else if(elem.equals("-")) {
					Double d1 = Double.parseDouble(stack.pop());
					Double d2 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(d2 - d1));		
				}
				else if(elem.equals("*")) {
					Double d1 = Double.parseDouble(stack.pop());
					Double d2 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(d2 * d1));
				}
				else if(elem.equals("/")) {
					Double d1 = Double.parseDouble(stack.pop());
					Double d2 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(d2 / d1));
				}
				else if(elem.equals("sqrt")) {
					Double d1 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(Math.sqrt(d1)));
				}
				else if(elem.equals("carré")) {
					Double d1 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(d1 * d1));
				}
				else if(elem.equals("sin")) {
					Double d1 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(Math.sin(d1)));
				}
				else if(elem.equals("cos")) {
					Double d1 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(Math.cos(d1)));
				}
				else if(elem.equals("tan")) {
					Double d1 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(Math.tan(d1)));
				}
				else if(elem.equals("inv")) {
					Double d1 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(1 / d1));
				}
				else if(elem.equals("op")) {
					Double d1 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(-d1));
				}
				else if(elem.equals("puiss")) {
					Double d1 = Double.parseDouble(stack.pop());
					Double d2 = Double.parseDouble(stack.pop());
					stack.push(Double.toString(Math.pow(d1, d2)));
				}
				else if(elem.equals("!")) {
					
				}
				else {
					stack.push(elem);
				}
			}
			catch(java.util.EmptyStackException e) {
				System.out.println("Erreur : l'expression passée en paramètre est incorrect; un opérateur n'a pas ou pas assez d'opérandes.");
			}

		}
		System.out.println("Résultat : " + stack.peek());

	}
}
