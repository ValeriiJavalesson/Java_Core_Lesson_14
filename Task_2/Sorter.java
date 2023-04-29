package Task_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorter {
	public static void sortByName(ArrayList<Commodity> list) {
		Collections.sort(list, new Comparator<Commodity>() {

			@Override
			public int compare(Commodity o1, Commodity o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	public static void sortByLength(ArrayList<Commodity> list) {
		Collections.sort(list, new Comparator<Commodity>() {

			@Override
			public int compare(Commodity o1, Commodity o2) {
				if(o1.getLength() - (o2.getLength())==0)
					return o1.getName().compareTo(o2.getName());
				return o1.getLength() - (o2.getLength());
			}
		});
	}

	public static void sortByWidth(ArrayList<Commodity> list) {
		Collections.sort(list, new Comparator<Commodity>() {

			@Override
			public int compare(Commodity o1, Commodity o2) {
				if(o1.getWidth() - (o2.getWidth())==0)
					return o1.getName().compareTo(o2.getName());
				return o1.getWidth() - (o2.getWidth());
			}
		});
	}

	public static void sortByWeight(ArrayList<Commodity> list) {
		Collections.sort(list, new Comparator<Commodity>() {

			@Override
			public int compare(Commodity o1, Commodity o2) {
				if (o1.getWeight() - (o2.getWeight()) == 0)
					return o1.getName().compareTo(o2.getName());
				return o1.getWeight() - (o2.getWeight());
			}
		});
	}

}
