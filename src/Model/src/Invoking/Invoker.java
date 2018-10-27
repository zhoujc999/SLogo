package invoking;

import external.*;

import java.util.Observable;
import java.util.function.Consumer;


public class Invoker extends Observable implements Invokable{
    private StdModelTurtle myTurt;
    private Consumer<StdModelTurtle> addObserver;

    public Invoker(){
        myTurt = new StdModelTurtle(0);
    }

    /**
     * Use this method to add the graphicsWindow as an observer for all turtles once the graphicsWindow
     * has been instantiated (it is instantiated when the GUI is instantiated)
     *
     * @param addObserver (StdModelTurtle turt) -> turt.addObserver(graphicsWindow)
     */
    public void setAddObserver(Consumer<StdModelTurtle> addObserver) {
        this.addObserver = addObserver;
        this.addObserver.accept(myTurt);
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
