

package Server;

import Adapter.BuildAuto;
import Adapter.ProxyAutomobile;
import model.Automobile;


public class BuildCarModelOptions extends ProxyAutomobile implements AutoServer {

	////////// PROPERTIES //////////

	private static final int WAITING = 0;
	private static final int REQUEST_BUILD_AUTO = 1;
	private static final int REQUEST_CONFIGURE_AUTO = 2;

	private int state = WAITING;

	////////// CONSTRUCTORS //////////

	public BuildCarModelOptions() {

	}

	////////// INSTANCE METHODS //////////

	public Object processRequest(Object obj) {
		BuildAuto build = new BuildAuto();
		Object toClient = null;

		if (state == REQUEST_BUILD_AUTO) {


			build.addAuto((Automobile)obj);

			toClient = "Automobile object successfully added to database\n"
					+ "Press any key to return to main menu";
		}
		else if (state == REQUEST_CONFIGURE_AUTO) {

			Automobile automobile = build.getAuto((String)obj);

			return automobile;

		}
		else {

		}

		this.state = WAITING;

		return toClient;
	}

	public String setRequest(int i) {
		String output = null;

		if (i == 1) {
			this.state = REQUEST_BUILD_AUTO;
			output = "Upload a file to create an Automobile";
		}
		else if (i == 2) {
			this.state = REQUEST_CONFIGURE_AUTO;
			System.out.println(state+" is the state");
			output = "Select an Automobile from the following list to configure: \n" +
					super.getAllModels();
		}
		else {
			output = "Invalid request";
		}

		return output;
	}

	//needs to be able to get properties obj over stream then create an auto
	//add the auto to a linked hash map

}
