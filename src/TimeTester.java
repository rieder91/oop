
/**
 * test class for ElapsedTime, MeanElapsedTime and CompositeTime
 * @author OOP Gruppe 187
 *
 */

public class TimeTester implements Tester {

	@Override
	public void runTests() {
		
		/*******************/
		
		Set<Double> test=new Set<Double>();
		test.insert(1.0);
		Double a=0.0;
		MeanElapsedTime met = new MeanElapsedTime();
		MeanElapsedTime met2 = new MeanElapsedTime(test);
		MeanElapsedTime met3 = new MeanElapsedTime(met2);
		
		Validator.report(met.count()==0,"TimeTester: check that the right number of elements is returned bevore elements are added");
		Validator.report(met.getMax()==0,"TimeTester: check that Max is 0 bevor a element was edded");
		Validator.report(met.shorter(met)==false,"TimeTester: check that shorter works bevore elements are added");	
		met.add(a);
		met.add(3.0);
		met.add(2.0);
		met.add(5.0);
		Validator.report(met.count()==4,"TimeTester: count Test after some elements were added");
		Validator.report(met.getMax()==5.0,"TimeTester: max Test after some elements were added");
		Validator.report(met.shorter(met2)==false,"TimeTester: shorter Test after some elements were added");	
		met2.add(10.0);
		Validator.report(met.shorter(met2)==true,"TimeTester: shorter Test after some elements were added");	
		met2.add(met3);
		/***************/
		
		CompositeTime ct = new CompositeTime(new Double[]{0.0,3.0,2.0,5.0});
		CompositeTime ct2 = new CompositeTime(10.0);
		CompositeTime ct3 = new CompositeTime(11.0);
		Double val=10.0;
		Validator.report(ct.shorter(ct2)==false,"TimeTester: shorter Test");
		Validator.report(ct.shorter(ct3)==true,"TimeTester: shorter Test");
		Validator.report(ct.shorter(val)==false,"TimeTester: shorter Test");
		Validator.report(ct.shorter(val+1)==true,"TimeTester: shorter Test");
		Validator.report(ct.count()==4,"TimeTester: count Test");
		Validator.report(ct.getMin()==0.0,"TimeTester: Composite Time min");
		
		try{
			met.add(a);
			Validator.report(false,"TimeTester: check if exception is thrown if the same element is added twice");
		}catch(RuntimeException es){
			Validator.report(true,"TimeTester: check if exception is thrown if the same element is added twice");
		}
		
		/***************/
	}

}
