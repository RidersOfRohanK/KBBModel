
package Client;

import model.*;
import scale.EditOptions;
import util.Serializer;

import java.util.*;

public class SelectCarOptions {

	////////// PROPERTIES //////////
	private Scanner in = new Scanner(System.in);

	////////// CONSTRUCTORS //////////

	public SelectCarOptions() {

	}

	////////// INSTANCE METHODS //////////

	public void configureAuto(Object obj) {
		EditOptions eop = new EditOptions();


		System.out.println(obj.toString());
		CarProperties cp = new CarProperties();//make auto from the file server gave it

//		Automobile a =(Automobile) cp.create(obj.toString());//fix
		Automobile a =(Automobile) cp.load("src/TestFiles/PropertiesTest.prop");


		System.out.println("You OptionSets are as follow:");
		System.out.println(cp.getOptionSetNames());
		Scanner sc = new Scanner(System.in);
		boolean keepChoosing = true;
		while(keepChoosing) {
			String OptionSetName = in.nextLine();
			if (cp.getOptionSetNames().contains(OptionSetName)) {
				System.out.println("What Option would you like to choose?");
				System.out.println(cp.getOptionNames(OptionSetName));
				String OptionName = in.nextLine();
				eop.makeChoice(a,OptionSetName,OptionName);
			}
			System.out.println("Do you want to keep making choices? y/n");
			String resp = in.nextLine();
			if(!resp.equals("y")){
				keepChoosing = false;
			}
		}

	}

	public boolean isAutomobile(Object obj) {
		boolean isAutomobile = false;

		try {
			Automobile a1 = (Automobile) obj;
			isAutomobile = true;
		}
		catch (ClassCastException e) {
			isAutomobile = false;
		}

		return isAutomobile;
	}

}
