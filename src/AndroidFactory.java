import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * speichert eine Liste aller erstellten Roboter
 * 
 * es werden nur Roboter gespeichert, deren Konfiguration auch gueltig ist
 * 
 * falls ein Roboter mit einer bereits vorhandenen Seriennummer hinzugefuegt
 * wird, wird der Eintrag nur als Aenderung betrachtet und es aendert sich nichts
 * am Produktionszeitpunkt des Roboters
 * 
 * @author OOP Gruppe 187
 *
 */
public class AndroidFactory implements Iterable<Android> {
	private HashMap<String, Android> containedRobots;
	private ArrayList<Android> timeList;
	
	/**
	 * default constructor
	 */
	public AndroidFactory() {
		timeList = new ArrayList<Android>();
		containedRobots = new HashMap<String, Android>();
	}
	
	/**
	 * versucht einen Roboter zusammenzubauen und speichert ihn ab, falls er gueltig ist
	 * wenn der Roboter bereits vorhanden ist, wird er nur upgedatet
	 * @param skeleton Skelett der Roboter
	 * @param skin Haut des Roboters
	 * @param software Software des Roboters
	 * @param kit SensorenAktorenKit des Roboters
	 * @return null bei Fehler, ansonsten den zusammengebauten Androiden
	 */
	public Android insert(Android skeleton, Skin skin, Software software, SensorenAktorenKit kit) {
		
		Skin previousSkin = skeleton.getSkin();
		Software previousSoftware = skeleton.getSoftware();
		SensorenAktorenKit previousKit = skeleton.getKit();
		
		skeleton.uninstallAll();
		skeleton.installSkin(skin);
		skeleton.installSoftware(software);
		skeleton.installKit(kit);
		
		if (skeleton.getKit() == null 
				|| skeleton.getSeriennummer() == null
				|| skeleton.getSkin() == null
				|| skeleton.getSoftware() == null) {
			
			// roll back changes made to droid, as one of it's components
			// couldn't be installed
			skeleton.installSkin(previousSkin);
			skeleton.installSoftware(previousSoftware);
			skeleton.installKit(previousKit);
			return null;
		} else {
			String seriennummer = skeleton.getSeriennummer();
			if(containedRobots.get(seriennummer) == null) {
				containedRobots.put(seriennummer, skeleton);
				timeList.add(containedRobots.get(seriennummer));
			} else {
				if(containedRobots.get(skeleton.getSeriennummer()).replaceRobotWith(skeleton) != null) {
					containedRobots.put(seriennummer, skeleton);
				} else {
					return null;
				}
			}
			return skeleton;
		}
	}

	/**
	 * liefert eine Beschreibung des Roboters, falls er vorhanden ist
	 * 
	 * @param serial
	 *            Seriennummer des Roboters
	 * @return String-Representation des Roboters
	 */
	public String find(String serial) {
		if(containedRobots.get(serial) == null) {
			return null;
		} else {
			return containedRobots.get(serial).toString();
		}
	}

	/**
	 * liefert einen Iterator ueber alle gespeicherten Roboter beginnend beim
	 * aeltesten
	 */
	public Iterator<Android> iterator() {
		return timeList.iterator();
	}

}
