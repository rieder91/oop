
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
		try{
			new Description(null);
			Validator.report(false,"check if exception is thrown if you make a new Description of null");
		}catch(RuntimeException ex){
			Validator.report(true,"check if exception is thrown if you make a new Description of null");
		}
		
		
		
		Validator.report(d4.length()==17,"test of length function");
		Validator.report(d.lines()==6,"test of lines function");
		Validator.report(d.shorter(d2)==false,"shorter test");
		Validator.report(d.shorter(d3)==true,"another shorter test");
		Validator.report(d.shorter(d4)==false,"too much shorter tests");
		Validator.report(d4.toString().equals(desc4), "test to string of description");

	}

}
