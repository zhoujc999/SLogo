package invoking;

import external.*;

import java.util.Observable;


public class Invoker extends Observable implements Invokable{
    private ModelTurtle myTurt;


    public Invoker(){
        myTurt = new StdModelTurtle();
    }

    @Override
    public void acceptCommand(SLogoExecutable cmd) {
        cmd.execute(myTurt);
        notifyObservers(cmd.returnValue());

    }
}
