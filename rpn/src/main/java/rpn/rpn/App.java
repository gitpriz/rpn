package rpn.rpn;

import java.util.Scanner;
import java.util.Stack;

public class App 
{
	
	Stack<Double> stack = new Stack<Double>();
	boolean trace = false;
	
	public App(String s) {
		evaluer(s);
	}
	public App() {
		Scanner sc = new Scanner(System.in);
		String s;
		while(true) {
			s = sc.nextLine();
			if(s.equals("stop")) {
				System.out.println("Arrêt du programme");
				sc.close();
				return;
			}
			else if(s.equals("pile")) {
				affPile();
			}
			else if(s.equals("trace")) {
				traceOn();
			}
			else if (s.equals("notrace")) {
				traceOff();
			}
			else {
				entree(s);
				if(trace)
					affPile();
			}
		}

	}

	private void traceOn() {
		System.out.println("Trace activée");
		trace = true;
	}
	
	private void traceOff() {
		System.out.println("Trace désactivée");
		trace = false;
	}
	
	private void affPile() {
		System.out.println(stack);
	}
	
	private void entree(String elem) {
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
				if(d1 == 0) {
					System.out.println("Erreur : Division par 0.");
					System.out.println("Opérateur : [" + elem + "]");
					//System.out.println("Position : [" + (i+1) + "]");
					return;
				}
					
				stack.push(d2 / d1);
			}
			else if(elem.equals("sqrt")) {
				Double d1 = stack.pop();
				if(d1 < 0) {
					System.out.println("Erreur : Tentative de calcul de la racine carrée d'un nombre négatif.");
					System.out.println("Opérateur : [" + elem + "]");
					//System.out.println("Position : [" + (i+1) + "]");
					return;
				}
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
				Double d1 = stack.pop();
				stack.push(euler(d1));
			}
			else {
				stack.push(Double.parseDouble(elem));
			}
		}
		catch(java.util.EmptyStackException e) {
			System.out.println("Erreur : l'expression passée en paramètre est incorrecte; un opérateur n'a pas ou pas assez d'opérandes.");
			System.out.println("Opérateur : [" + elem + "]");
		//	System.out.println("Position : [" + (i+1) + "]");
			return;
		}
		catch(java.lang.NumberFormatException e) {
			System.out.println("Une erreur est survenue lors de la lecture de l'expression. Le programme a tenté de continuer l'évaluation en ignorant l'item erroné.");
			System.out.println("Item ignoré : [" + elem + "]");
			//System.out.println("Position : [" + (i+1) + "]");
		}
	}


	private void evaluer(String s) {
		String tab[] = s.split(" +");
		
		for(int i = 0; i < tab.length; i++) {
			String elem = tab[i];
			System.out.println(elem);

			entree(elem);
			
			
		}
		
		
		if(stack.size() != 1) {
			System.out.println("Erreur : La pile contient plus d'un élément après évaluation de l'expression. L'expression doit être mauvaise.");
			System.out.println("Etat de la pile : " + stack);
			return;
		}
		System.out.println("Résultat : " + sommet());

	}
	
	private Double sommet() {
		return stack.peek();
	}
	
	private Double euler(Double x) {
		
			
		Double a, b, c, d = 0.0;
		for(int i = 0; i < 10000; i++) {
			a = Math.exp(-i);
			b = Math.pow(i, x-1);
			c = a*b;
			d += c;
		}
		/* Si l'opérande est un entier, le résultat est arrondi */
		if(x == Math.round(x)) {
			return (double) Math.round(d);
		}
		return d;
	}
	
	public static void main( String[] args ) {
		/*if(args.length == 0) {
			new App();
		}
		else if (args.length == 1) {*/
				new App("3 4 sqrt + 10 3 - *");
				new App("5 !");
				new App();
		/*}
		else {
			System.out.println("Erreur. Le programme doit être appellé avec 0 ou 1 paramètre.");
		}*/
	}
}
