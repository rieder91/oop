
/**
 * test class for ElapsedTime, MeanElapsedTime and CompositeTime
 * @author OOP Gruppe 187
 *
 */

public class TimeTester implements Tester {

	/**
	 * 
	 */
	@Override
	public void runTests() {
		MeanElapsedTime met = new MeanElapsedTime();
		MeanElapsedTime met2 = new MeanElapsedTime();
		Validator.report(met.count()==0,"TimeTester: Mean Elapsed Time count");
		Validator.report(met.getMax()==0,"TimeTester: Mean Elapsed Time max");
		Validator.report(met.shorter(met2)==false,"TimeTester: Mean Elapsed Time shorter1");	
		met2.add(1.0);
		met.add(0.0);
		met.add(3.0);
		met.add(2.0);
		met.add(5.0);
		Validator.report(met.count()==4,"TimeTester: Mean Elapsed Time count");
		Validator.report(met.getMax()==5.0,"TimeTester: Mean Elapsed Time max");
		Validator.report(met.shorter(met2)==false,"TimeTester: Mean Elapsed Time shorter1");	
		met2.add(101.0);
		Validator.report(met.shorter(met2)==true,"Mean Elapsed Time shorter2");	
		
		CompositeTime ct = new CompositeTime(new Double[]{0.0,3.0,2.0,5.0});
		Double val=10.0;
		Validator.report(ct.shorter(val)==false,"TimeTester: Composite Time shorter1");
		Validator.report(ct.shorter(val+1)==true,"TimeTester: Composite Time shorter2");
		Validator.report(ct.count()==4,"TimeTester: Composite Time count");
		Validator.report(ct.getMin()==0.0,"TimeTester: Composite Time min");
	}

}
