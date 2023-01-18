package day2es3;

public class Main {

public static void main(String[] args) {
		
		RubricaTelefonica r1 = new RubricaTelefonica();
		
		r1.inserisciContatto("Riccardo", "3931456345");
		r1.inserisciContatto("Alice", "3336458679");
		r1.inserisciContatto("Andrea", "3456689909");
		
		r1.stampaContatti();
		
		r1.cancellaContatto("Alice");
		
		r1.stampaContatti();
		
		System.out.println(r1.cercaContattoPerNumero("3456689909"));
		System.out.println(r1.cercaNumeroPerContatto("Andrea"));
		
		
		
		

	}
}
