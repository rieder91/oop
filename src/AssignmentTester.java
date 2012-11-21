import java.util.ArrayList;
import java.util.Iterator;

/**
 * this class contains all tests cases that are required according to the 
 * assignment itself
 * 
 * @author OOP Gruppe 187
 *
 */
public class AssignmentTester implements Tester {

	public void runTests() {
		/*
		 * Test Case 1 of Assignment 5
		 */

		Description desc1 = new Description("Ein Text");
		Description desc2 = new Description("Wieder ein Text");
		Description desc3 = new Description("Noch ein Text");
		Description desc4 = new Description("Text");
		Description desc5 = new Description("Thomas");

		OrderedSet<Description> os = new OrderedSet<Description>();
		Iterator<Description> it1;
		Integer count = 0;

		os.insert(desc1);
		os.insert(desc2);
		os.insert(desc3);
		os.insert(desc4);

		it1 = os.iterator();

		while(it1.hasNext()) {
			it1.next();
			count++;
		}

		Validator.report(count == 4, "AssignmentTester: add four elements to an orderedset and verify their existance");
		
		if(Validator.debug) {
			Validator.debuggingLog.append("\n\nAssignmentTester: add four elements to an orderedset and verify their existance\nOutput: " + count);
		}
		
		os.insert(desc5);

		count = 0;
		it1 = os.iterator();
		while(it1.hasNext()) {
			count++;
			it1.next();
			if(count == 0 || count == 1) {
				it1.remove();
			}
		}
		Validator.report(count - 2 == 3, "AssignmentTester: add one additional element and remove two");

		if(Validator.debug) {
			Validator.debuggingLog.append("\n\nAssignmentTester: add one additional element and remove two\nOutput: " + count);
		}
		
		it1 = os.iterator();
		
		while(it1.hasNext()) {
			it1.next();
			it1.remove();
		}

		count = 0;
		it1 = os.iterator();
		while(it1.hasNext()) {
			it1.next();
			count++;
		}

		Validator.report(count == 0, "AssignmentTester: remove ALL the elements");
		
		if(Validator.debug) {
			Validator.debuggingLog.append("\n\nAssignmentTester: remove ALL the elements\nOutput: " + count);
		}
		

		/*****************/

		/*
		 * Test Case 2 of Assignment 5
		 */

		OrderedMap<MeanElapsedTime, CompositeTime> om = new OrderedMap<MeanElapsedTime, CompositeTime>();

		Set<Double> sd1 = new Set<Double>();
		sd1.insert(5.4);
		sd1.insert(2.3);
		sd1.insert(4.8);

		Set<Double> sd2 = new Set<Double>();
		sd2.insert(6.2);
		sd2.insert(2.7);
		sd2.insert(9.0);

		Set<Double> sd3 = new Set<Double>();
		sd3.insert(1.4);
		sd3.insert(4.9);
		
		
		Double[] c1 = {2.3, 4.1, 7.3, 1.4};
		Double[] c2 = {0.3, 5.5};
		Double[] c3 = {1.7, 8.3, 3.0};
		Double[] c4 = {2.3, 6.2, 7.3, 4.4};
		Double[] c5 = {2.3, 4.1, 1.6, 0.4};

		CompositeTime comp1 = new CompositeTime(c1);
		CompositeTime comp2 = new CompositeTime(c2);
		CompositeTime comp3 = new CompositeTime(c3);
		CompositeTime comp4 = new CompositeTime(c4);
		CompositeTime comp5 = new CompositeTime(c5);

		MeanElapsedTime met1 = new MeanElapsedTime(sd1);
		MeanElapsedTime met2 = new MeanElapsedTime(sd2);
		MeanElapsedTime met3 = new MeanElapsedTime(sd3);
		

		// fill om
		om.insert(met1);
		om.insert(met2);
		om.insert(met3);


		MapIterator<MeanElapsedTime,CompositeTime> it2 = om.iterator();
		InMapIterator<CompositeTime> inIt2;

		if(it2.hasNext()) {
			it2.next();
			inIt2 = it2.iterator();
			inIt2.add(comp1);
			inIt2.add(comp2);
			inIt2.add(comp3);
		}

		if(it2.hasNext()) {
			it2.next();
			inIt2 = it2.iterator();
			inIt2.add(comp4);
			inIt2.add(comp1);
			inIt2.add(comp3);
		}

		if(it2.hasNext()) {
			it2.next();
			inIt2 = it2.iterator();
			inIt2.add(comp4);
			inIt2.add(comp5);
			inIt2.add(comp2);
		}
		
		ArrayList<Double> maxValuesForSet = new ArrayList<Double>();

		ArrayList<Double> maxValues = new ArrayList<Double>();
		ArrayList<Double> minValues = new ArrayList<Double>();
		
		maxValues.add(4.9);
		maxValues.add(5.4);
		maxValues.add(9.0);
		
		maxValuesForSet.add(3.14);
		maxValuesForSet.addAll(maxValues);
		
		minValues.add(1.7);
		minValues.add(0.3);
		minValues.add(1.4);
		minValues.add(1.7);
		minValues.add(1.4);
		minValues.add(2.3);
		minValues.add(0.3);
		minValues.add(0.4);
		minValues.add(2.3);
		
		Iterator<Double> maximumIt = maxValues.iterator();
		Iterator<Double> minimumIt = minValues.iterator();
		
		Double t1;
		
		boolean result = true;
		
		// get min/max values
		it2 = om.iterator();
		
		if(Validator.debug) {
			Validator.debuggingLog.append("\n\nAssignmentTester: validating the minimum and maximum values from an OrderedMap<MET, CT>\nOutput: \n");
		}

		while(it2.hasNext()) {
			
			t1 = it2.next().getMax();
			inIt2 = it2.iterator();

			result = result && (t1.equals(maximumIt.next()));
			
			if(Validator.debug) {
				Validator.debuggingLog.append("Max: " + t1);
			}
			
			while(inIt2.hasNext()) {
				t1 = inIt2.next().getMin();
				result = result && (minimumIt.next().equals(t1));
				
				if(Validator.debug) {
					Validator.debuggingLog.append("\tMin: " + t1);
				}
			}
			
			if(Validator.debug) {
				Validator.debuggingLog.append("\n");
			}
		}
		
		Validator.report(result, "AssignmentTester: validating the minimum and maximum values from an OrderedMap<MET, CT>");
		
		it2 = om.iterator();
		while(it2.hasNext()) {
			it2.next();
		}
		it2.remove();
		
		
		maxValues = new ArrayList<Double>();
		minValues = new ArrayList<Double>();
		
		maxValues.add(4.9);
		maxValues.add(5.4);
		
		minValues.add(1.7);
		minValues.add(0.3);
		minValues.add(1.4);
		minValues.add(1.7);
		minValues.add(1.4);
		minValues.add(2.3);
		
		maximumIt = maxValues.iterator();
		minimumIt = minValues.iterator();

		it2 = om.iterator();
		
		result = true;
		
		if(Validator.debug) {
			Validator.debuggingLog.append("\n\nAssignmentTester: removed the last element of the map and recalculated min/max\nOutput: \n");
		}

		while(it2.hasNext()) {
			
			t1 = it2.next().getMax();
			result = result && (t1.equals(maximumIt.next()));
			inIt2 = it2.iterator();
			if(Validator.debug) {
				Validator.debuggingLog.append("Max: " + t1);
			}
			
			while(inIt2.hasNext()) {
				
				t1 = inIt2.next().getMin();
				result = result && (minimumIt.next().equals(t1));
				
				if(Validator.debug) {
					Validator.debuggingLog.append("\tMin: " + t1);
				}
			}
			
			if(Validator.debug) {
				Validator.debuggingLog.append("\n");
			}
		}
		
		
		Validator.report(result, "AssignmentTester: removed the last element of the map and recalculated min/max");
		

		it2 = om.iterator();
		it2.next();
		inIt2 = it2.iterator();
		inIt2.next();
		inIt2.remove();

		
		maxValues = new ArrayList<Double>();
		minValues = new ArrayList<Double>();
		
		maxValues.add(4.9);
		maxValues.add(5.4);
		
		minValues.add(0.3);
		minValues.add(1.4);
		minValues.add(1.7);
		minValues.add(1.4);
		minValues.add(2.3);

		maximumIt = maxValues.iterator();
		minimumIt = minValues.iterator();
		
		if(Validator.debug) {
			Validator.debuggingLog.append("\n\nAssignmentTester: removed the first element of the second subset\nOutput: \n");
		}
		
		it2 = om.iterator();
		result = true;

		while(it2.hasNext()) {

			t1 = it2.next().getMax();
			
			result = result && (t1.equals(maximumIt.next()));
			inIt2 = it2.iterator();

			if(Validator.debug) {
				Validator.debuggingLog.append("Max: " + t1);
			}

			while(inIt2.hasNext()) {
				t1 = inIt2.next().getMin();
				
				result = result && (minimumIt.next().equals(t1));
				
				if(Validator.debug) {
					Validator.debuggingLog.append("\tMin: " + t1);
				}
			}
			
			if(Validator.debug) {
				Validator.debuggingLog.append("\n");
			}
		}

		
		Validator.report(result, "AssignmentTester: removed the first element of the second subset");


		/*
		 * Test Case 3 of Assignment 5 FAIL
		 */
		
		
		
		OrderedSet<MeanElapsedTime> os3 = new OrderedSet<MeanElapsedTime>();
		os3.insert(met1);
		os3.insert(met2);
		os3.insert(met3);
		
		Set<Double> sd4 = new Set<Double>();
		sd4.insert(3.14);
		sd4.insert(2.72);
		
		
		
		MeanElapsedTime met4 = new MeanElapsedTime(sd4);
		
		os3.insert(met4);
		
		Iterator<Double> itm = maxValuesForSet.iterator();
		result = true;
		
		if(Validator.debug) {
			Validator.debuggingLog.append("\nAssignmentTester: creating an orderedset out of the input for the orderedmap and comparing the results\nOutput:\n");
		}
		
		
		for(MeanElapsedTime m : os3) {
			t1 = m.getMax();
			result = result && (t1.equals(itm.next()));
			
			if(Validator.debug) {
				Validator.debuggingLog.append("Max: " + t1 + "\n");
			}
		}
		
		Validator.report(result, "AssignmentTester: creating an orderedset out of the input for the orderedmap and comparing the results");
		
		/*
		 * Test Case 4 of Assignment 5
		 */
		OrderedSet<ElapsedTime> osEt = new OrderedSet<ElapsedTime>();

		// fill osEt with all MeanElapsedTime- and CompositeTime-instances of om
		it2 = om.iterator();

		while(it2.hasNext()) {
			inIt2 = it2.iterator();

			osEt.insert(it2.next());

			while(inIt2.hasNext())
				osEt.insert(inIt2.next());
		}
		
		if(Validator.debug) {
			Validator.debuggingLog.append("\n\nAssignmentTester: entered all elements from test case #2 into an orderset and counted the number of elements\nOutput:\n");
		}

		// print count() of all values
		Iterator<ElapsedTime> osEtIt = osEt.iterator();
		int i = 0;
		
		int verify[] = new int[]{2, 3, 2, 4};
		result = true;

		while(osEtIt.hasNext()) {
			int t = osEtIt.next().count();
			
			if(Validator.debug) {
				Validator.debuggingLog.append("Subset #" + (i+1) + " = " + t + "\n");
			}
			
			result = result && (t == verify[i]);
			i++;
		}
		
		Validator.report(result, "AssignmentTester: entered all elements from test case #2 into an orderset and counted the number of elements");
	}
}