package invoking;

import external.*;

import java.util.Observable;


public class Invoker extends Observable implements Invokable{
    private ModelTurtle myTurt;

    public Invoker(){
        myTurt = new StdModelTurtle(0);
    }

    @Override
    public void acceptCommand(SLogoExecutable cmd) {
        cmd.execute(myTurt);
        if(cmd instanceof SLogoStringReturnable){
            notifyObservers(((SLogoStringReturnable) cmd).returnValue());
        }
        setChanged();
        notifyObservers(((SLogoReturnable) cmd).returnValue());
        clearChanged();

    }
}
