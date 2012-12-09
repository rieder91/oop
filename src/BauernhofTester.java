/**
 * this class runs test cases for the Bauernhof and Traktoren as well as
 * statistics
 * 
 * @author Thomas
 * 
 */
@Creator(name = "Thomas", lastUpdate = "08.12.2012")
public class BauernhofTester implements Tester {

	@Override
	@Creator(name = "Thomas", lastUpdate = "08.12.2012")
	public void runTests() {

		// Hoefe erstellen
		
		Bauernhof hof1 = new Bauernhof("Hof #1");
		Bauernhof hof2 = new Bauernhof("Hof #2");
		Bauernhof hof3 = new Bauernhof("Hof #3");
		Bauernhof hof4 = new Bauernhof("Hof #4");
		Bauernhof hof5 = new Bauernhof("Hof #5");
		
		
		// Hoefe in einer Collection speichern!
		
		Liste hoefe = new Liste();
		hoefe.add(hof1);
		hoefe.add(hof2);
		hoefe.add(hof3);
		hoefe.add(hof4);
		hoefe.add(hof5);
		
		
		// Traktoren erstellen
		
		Traktor d1 = new DieselTraktor("Diesel #1", 10);
		Traktor d2 = new DieselTraktor("Diesel #2", 20);
		Traktor d3 = new DieselTraktor("Diesel #3", 30);
		Traktor d4 = new DieselTraktor("Diesel #4", 40);
		Traktor d5 = new DieselTraktor("Diesel #5", 50);
		Traktor d6 = new DieselTraktor("Diesel #6", 60);
		Traktor d7 = new DieselTraktor("Diesel #7", 70);
		Traktor d8 = new DieselTraktor("Diesel #8", 80);
		Traktor d9 = new DieselTraktor("Diesel #9", 90);
		Traktor d0 = new DieselTraktor("Diesel #10", 100);
		
		Traktor b1 = new BiogasTraktor("Bio #1", 110);
		Traktor b2 = new BiogasTraktor("Bio #2", 120);
		Traktor b3 = new BiogasTraktor("Bio #3", 130);
		Traktor b4 = new BiogasTraktor("Bio #4", 140);
		Traktor b5 = new BiogasTraktor("Bio #5", 150);
		Traktor b6 = new BiogasTraktor("Bio #6", 160);
		Traktor b7 = new BiogasTraktor("Bio #7", 170);
		Traktor b8 = new BiogasTraktor("Bio #8", 180);
		Traktor b9 = new BiogasTraktor("Bio #9", 190);
		Traktor b0 = new BiogasTraktor("Bio #10", 200);
		
		
		// Traktoren hinzufuegen
		
		((Bauernhof) hoefe.searchFor("Hof #1")).addTraktor(d1);
		((Bauernhof) hoefe.searchFor("Hof #1")).addTraktor(d2);
		((Bauernhof) hoefe.searchFor("Hof #2")).addTraktor(d3);
		((Bauernhof) hoefe.searchFor("Hof #2")).addTraktor(d4);
		((Bauernhof) hoefe.searchFor("Hof #3")).addTraktor(d5);
		((Bauernhof) hoefe.searchFor("Hof #3")).addTraktor(d6);
		((Bauernhof) hoefe.searchFor("Hof #4")).addTraktor(d7);
		((Bauernhof) hoefe.searchFor("Hof #4")).addTraktor(d8);
		((Bauernhof) hoefe.searchFor("Hof #5")).addTraktor(d9);
		((Bauernhof) hoefe.searchFor("Hof #5")).addTraktor(d0);
		
		((Bauernhof) hoefe.searchFor("Hof #1")).addTraktor(b1);
		((Bauernhof) hoefe.searchFor("Hof #1")).addTraktor(b2);
		((Bauernhof) hoefe.searchFor("Hof #2")).addTraktor(b3);
		((Bauernhof) hoefe.searchFor("Hof #2")).addTraktor(b4);
		((Bauernhof) hoefe.searchFor("Hof #3")).addTraktor(b5);
		((Bauernhof) hoefe.searchFor("Hof #3")).addTraktor(b6);
		((Bauernhof) hoefe.searchFor("Hof #4")).addTraktor(b7);
		((Bauernhof) hoefe.searchFor("Hof #4")).addTraktor(b8);
		((Bauernhof) hoefe.searchFor("Hof #5")).addTraktor(b9);
		((Bauernhof) hoefe.searchFor("Hof #5")).addTraktor(b0);
		
		
		// Traktoren mit Geraeten ausstatten
		
		((Bauernhof) hoefe.searchFor("Hof #1")).changeUsageOfTraktor(10, new Drillmaschine(10));
		((Bauernhof) hoefe.searchFor("Hof #1")).changeUsageOfTraktor(20, new Drillmaschine(11));
		((Bauernhof) hoefe.searchFor("Hof #2")).changeUsageOfTraktor(30, new Drillmaschine(12));
		((Bauernhof) hoefe.searchFor("Hof #2")).changeUsageOfTraktor(40, new Drillmaschine(13));
		((Bauernhof) hoefe.searchFor("Hof #3")).changeUsageOfTraktor(50, new Drillmaschine(14));
		((Bauernhof) hoefe.searchFor("Hof #3")).changeUsageOfTraktor(60, new Duengerstreuer(15.0));
		((Bauernhof) hoefe.searchFor("Hof #4")).changeUsageOfTraktor(70, new Duengerstreuer(16.0));
		((Bauernhof) hoefe.searchFor("Hof #4")).changeUsageOfTraktor(80, new Duengerstreuer(17.0));
		((Bauernhof) hoefe.searchFor("Hof #5")).changeUsageOfTraktor(90, new Duengerstreuer(18.0));
		((Bauernhof) hoefe.searchFor("Hof #5")).changeUsageOfTraktor(100, new Duengerstreuer(19.0));
		
		((Bauernhof) hoefe.searchFor("Hof #1")).changeUsageOfTraktor(110, new Drillmaschine(20));
		((Bauernhof) hoefe.searchFor("Hof #1")).changeUsageOfTraktor(120, new Drillmaschine(21));
		((Bauernhof) hoefe.searchFor("Hof #2")).changeUsageOfTraktor(130, new Drillmaschine(22));
		((Bauernhof) hoefe.searchFor("Hof #2")).changeUsageOfTraktor(140, new Drillmaschine(23));
		((Bauernhof) hoefe.searchFor("Hof #3")).changeUsageOfTraktor(150, new Drillmaschine(24));
		((Bauernhof) hoefe.searchFor("Hof #3")).changeUsageOfTraktor(160, new Duengerstreuer(25.0));
		((Bauernhof) hoefe.searchFor("Hof #4")).changeUsageOfTraktor(170, new Duengerstreuer(26.0));
		((Bauernhof) hoefe.searchFor("Hof #4")).changeUsageOfTraktor(180, new Duengerstreuer(27.0));
		((Bauernhof) hoefe.searchFor("Hof #5")).changeUsageOfTraktor(190, new Duengerstreuer(28.0));
		((Bauernhof) hoefe.searchFor("Hof #5")).changeUsageOfTraktor(200, new Duengerstreuer(29.0));
		
		
		
		// Aktuellen Stand ausgeben
		
		System.out.println("Bauernhoefe am Anfang des Tests: ");
		System.out.println(hoefe.searchFor("Hof #1"));
		System.out.println(hoefe.searchFor("Hof #2"));
		System.out.println(hoefe.searchFor("Hof #3"));
		System.out.println(hoefe.searchFor("Hof #4"));
		System.out.println(hoefe.searchFor("Hof #5"));
		
		System.out.println();
		
		// ein paar Geraete aendern
		
		((Bauernhof) hoefe.searchFor("Hof #1")).changeUsageOfTraktor(10, new Duengerstreuer(200.0));
		((Bauernhof) hoefe.searchFor("Hof #1")).changeUsageOfTraktor(120, new Duengerstreuer(300.0));
		((Bauernhof) hoefe.searchFor("Hof #2")).changeUsageOfTraktor(30, new Duengerstreuer(400.0));
		((Bauernhof) hoefe.searchFor("Hof #2")).changeUsageOfTraktor(130, new Drillmaschine(500));
		((Bauernhof) hoefe.searchFor("Hof #3")).changeUsageOfTraktor(40, new Duengerstreuer(600.0));
		((Bauernhof) hoefe.searchFor("Hof #3")).changeUsageOfTraktor(50, new Drillmaschine(300));
		((Bauernhof) hoefe.searchFor("Hof #4")).changeUsageOfTraktor(60, new Drillmaschine(400));
		((Bauernhof) hoefe.searchFor("Hof #4")).changeUsageOfTraktor(170, new Drillmaschine(500));
		((Bauernhof) hoefe.searchFor("Hof #5")).changeUsageOfTraktor(90, new Drillmaschine(600));
		((Bauernhof) hoefe.searchFor("Hof #5")).changeUsageOfTraktor(200, null);
		
		
		// Treibstoffverbrauch erhoehen
		
		((Bauernhof) hoefe.searchFor("Hof #1")).increaseFuelUsage(10, 100);
		((Bauernhof) hoefe.searchFor("Hof #1")).increaseFuelUsage(110, 200.0);
		((Bauernhof) hoefe.searchFor("Hof #1")).increaseFuelUsage(120, 300.0);
		((Bauernhof) hoefe.searchFor("Hof #2")).increaseFuelUsage(30, 300);
		((Bauernhof) hoefe.searchFor("Hof #2")).increaseFuelUsage(140, 500.0);
		((Bauernhof) hoefe.searchFor("Hof #3")).increaseFuelUsage(50, 700);
		((Bauernhof) hoefe.searchFor("Hof #3")).increaseFuelUsage(160, 800.0);
		((Bauernhof) hoefe.searchFor("Hof #4")).increaseFuelUsage(70, 900);
		((Bauernhof) hoefe.searchFor("Hof #4")).increaseFuelUsage(80, 1100);
		((Bauernhof) hoefe.searchFor("Hof #5")).increaseFuelUsage(90, 1300);
		((Bauernhof) hoefe.searchFor("Hof #5")).increaseFuelUsage(200, 1200.0);
		
		
		// Betriebsstunden erhoehen
		
		((Bauernhof) hoefe.searchFor("Hof #1")).increaseHoursOfTraktor(10, 390);
		((Bauernhof) hoefe.searchFor("Hof #2")).increaseHoursOfTraktor(120, 250);
		((Bauernhof) hoefe.searchFor("Hof #3")).increaseHoursOfTraktor(40, 5000);
		((Bauernhof) hoefe.searchFor("Hof #4")).increaseHoursOfTraktor(70, 90);
		((Bauernhof) hoefe.searchFor("Hof #5")).increaseHoursOfTraktor(90, 500);
		
		
		// Traktoren entfernen
		
		((Bauernhof) hoefe.searchFor("Hof #1")).removeTraktor(20);
		((Bauernhof) hoefe.searchFor("Hof #2")).removeTraktor(30);
		((Bauernhof) hoefe.searchFor("Hof #3")).removeTraktor(150);
		((Bauernhof) hoefe.searchFor("Hof #4")).removeTraktor(170);
		
		
		// Hoefe erneut ausgeben
		
		System.out.println("Bauernhoefe nach den Veraenderungen: ");
		System.out.println(hoefe.searchFor("Hof #1"));
		System.out.println(hoefe.searchFor("Hof #2"));
		System.out.println(hoefe.searchFor("Hof #3"));
		System.out.println(hoefe.searchFor("Hof #4"));
		System.out.println(hoefe.searchFor("Hof #5"));
		
		
		// Statistiken berechnen und ausgeben
		
		Liste result;
		MyIterator it;
	
		
		// Statistik #1
		
		result = ((Bauernhof) hoefe.searchFor("Hof #3")).getWorkingHoursStatsByDevice();
		it = result.iterator();
		System.out.println("\nArbeitsstundenstatistik nach Geraet von Hof 3: ");
		System.out.println("Durchschnittliche Anzahl Betriebsstunden Gesamt:\t" + it.next());
		System.out.println("Durchschnittliche Anzahl Betriebsstunden Saeen:\t\t" + it.next());
		System.out.println("Durchschnittliche Anzahl Betriebsstunden Duengn:\t" + it.next());
		
		
		// Statistik #2
		
		result = ((Bauernhof) hoefe.searchFor("Hof #4")).getWorkingHoursStatsByTractor();
		it = result.iterator();
		System.out.println("\nArbeitsstundenstatistik nach Typ von Hof 4: ");
		System.out.println("Durchschnittliche Anzahl Betriebsstunden Gesamt:\t" + it.next());
		System.out.println("Durchschnittliche Anzahl Betriebsstunden Diesel:\t" + it.next());
		System.out.println("Durchschnittliche Anzahl Betriebsstunden Gas:\t\t" + it.next());
		
		
		// Statistik #3
		
		result = ((Bauernhof) hoefe.searchFor("Hof #5")).getAverageFuelDiesel();
		it = result.iterator();
		System.out.println("\nTreibstoffstatitik der Dieseltraktoren von Hof 5: ");
		System.out.println("Durchschnittlicher Dieselverbrauch Gesamt:\t" + it.next());
		System.out.println("Durchschnittlicher Dieselverbrauch Duengen:\t" + it.next());
		System.out.println("Durchschnittlicher Dieselverbrauch Saeen:\t" + it.next());
		
		
		// Statistik #4
		
		result = ((Bauernhof) hoefe.searchFor("Hof #1")).getAverageFuelBio();
		it = result.iterator();
		System.out.println("\nTreibstoffstatistik der Biogastraktoren von Hof 1: ");
		System.out.println("Durchschnittlicher Gasverbrauch Gesamt:\t\t" + it.next());
		System.out.println("Durchschnittlicher Gasverbrauch Duengen:\t" + it.next());
		System.out.println("Durchschnittlicher Gasverbrauch Saeen:\t\t" + it.next());
		
		
		// Statistik #5
		
		result = ((Bauernhof) hoefe.searchFor("Hof #2")).getSaescharenStats();
		it = result.iterator();
		System.out.println("\nSaescharenstatistik von Hof 2: ");
		System.out.println("Maximale Anzahl Gesamt:\t" + it.next());
		System.out.println("Minimale Anzahl Gesamt:\t" + it.next());
		System.out.println("Maximale Anzahl Biogas:\t" + it.next());
		System.out.println("Minimale Anzahl Biogas:\t" + it.next());
		System.out.println("Maximale Anzahl Diesel:\t" + it.next());
		System.out.println("Minimale Anzahl Diesel:\t" + it.next());
		
		
		// Statistik #6
		
		result = ((Bauernhof) hoefe.searchFor("Hof #1")).getCapacityStats();
		it = result.iterator();
		System.out.println("\nKapazitaetisstatistik von Hof 1: ");
		System.out.println("Gesamtdurchschnitt:\t" + it.next());
		System.out.println("Dieselschnitt:\t\t" + it.next());
		System.out.println("Gasschnitt:\t\t" + it.next());
		
	}
}
