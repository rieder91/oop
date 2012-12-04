/**
 * Die Autos bewegen sich mit unterschiedlichen m�glichst einfachen Strategien weiter, 
 * z.B. zuf�llig, oder im Kreis oder in Schlangenlinien im Kreis, aber nie �ber die Fahrbahn hinaus.
 * 
 * drive strategy of the car
 * 
 * @author OOP Gruppe 187
 */
public interface Strategy {

	/**
	 * @return the direction of the next move
	 */
	public int next();
}
