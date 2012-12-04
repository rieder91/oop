/**
 * Die Autos bewegen sich mit unterschiedlichen möglichst einfachen Strategien weiter, 
 * z.B. zufällig, oder im Kreis oder in Schlangenlinien im Kreis, aber nie über die Fahrbahn hinaus.
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
