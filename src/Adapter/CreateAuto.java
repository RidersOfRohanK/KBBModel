package Adapter;

import model.Automobile;

public interface CreateAuto {

    public Automobile buildAuto(String filename);
    public void printAuto(String modelName);
}
