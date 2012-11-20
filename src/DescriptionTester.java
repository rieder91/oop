
/**
 * test class for ElapsedTime, MeanElapsedTime and CompositeTime
 * @author OOP Gruppe 187
 *
 */

public class DescriptionTester implements Tester {

	/**
	 * 
	 */
	@Override
	public void runTests() {
		String desc = "Ich"+'\n'+"bin"+'\n'+"ein"+'\n'+"Description"+'\n'+"Test"+'\n'+"String";
		String desc2 = "Ich"+'\n'+"bin"+'\n'+"ein"+'\n'+"Description"+'\n'+"Comp"+'\n'+"String";
		String desc3 = "Ich"+'\n'+"bin"+'\n'+"ein"+'\n'+"Description"+'\n'+"Test"+'\n'+"String"+'\n'+"der laenger ist";
		String desc4 ="short test string";
		Description d = new Description(desc);
		Description d2 = new Description(desc2);
		Description d3 = new Description(desc3);
		Description d4 = new Description(desc4);
		
		Validator.report(d4.length()==17,"Description Test laenge");
		Validator.report(d.lines()==6,"Description Test lines");
		Validator.report(d.shorter(d2)==false,"Description Test shorter1");
		Validator.report(d.shorter(d3)==true,"Description Test shorter2");
		Validator.report(d.shorter(d4)==false,"Description Test shorter3");

	}

}
