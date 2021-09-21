package scale;

import Adapter.BuildAuto;
import model.Automobile;

public interface editThreads {

    public void addAutomobile(Automobile a);

    public void removeAuto(String name);

    public void removeAuto(Automobile a);

    public void updateOptionPrice(String modelName, String optionName, String Option, double newPrice);

    public void updateOptionSetName(String modelName, String optionSetName, String newName);

    public void updateAuto(Automobile a);


    public Automobile getAuto(String name);

    public Automobile buildAuto(String filename);
}

