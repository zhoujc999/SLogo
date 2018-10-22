package Invoking;

import external.Invokable;
import external.ModelTurtle;
import external.SLogoExecutable;
import external.StdModelTurtle;
import java.util.Observable;


public class Invoker extends Observable implements Invokable{
    private ModelTurtle myTurt;


    public Invoker(){
        myTurt = new StdModelTurtle();
    }

    @Override
    public void acceptCommand(SLogoExecutable cmd) {
        cmd.execute(myTurt);
        setChanged();
        notifyObservers(cmd.returnValue());
        clearChanged();

    }
}
