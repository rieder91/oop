/**
 * Die Autos bewegen sich mit unterschiedlichen moeglichst einfachen Strategien weiter,
 * z.B. zufaellig, oder im Kreis oder in Schlangenlinien im Kreis, aber nie ueber die Fahrbahn hinaus.
 * 
 * Implementieren Sie zumindest zwei unterschiedliche Bewegungsstrategien.
 * 
 * drive strategy of the car
 * 
 * @author OOP Gruppe 187
 */
public interface Strategy {

	/**
	 * @return the direction of the next move ( the value is between -2 and 2)
	 */
	public int next();
}
