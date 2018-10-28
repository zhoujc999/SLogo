package invoking;

import external.*;

import java.util.Observable;
import java.util.function.Consumer;


public class Invoker extends Observable implements Invokable{
    private StdModelTurtle myTurt;
    private Consumer<StdModelTurtle> addTurtleObserver;
    private Parse myParse;

    public Invoker(){
        myTurt = new StdModelTurtle(0);
    }

    public void setMyParse(Parse myParse) {
        this.myParse = myParse;
        this.addObserver(myParse);
    }

    /**
     * Use this method to add the graphicsWindow as an observer for all turtles once the graphicsWindow
     * has been instantiated (it is instantiated when the GUI is instantiated)
     *
     * @param addTurtleObserver (StdModelTurtle turt) -> turt.addObserver(graphicsWindow)
     */
    public void setAddTurtleObserver(Consumer<StdModelTurtle> addTurtleObserver) {
        this.addTurtleObserver = addTurtleObserver;
        this.addTurtleObserver.accept(myTurt);
    }

    @Override
    public void acceptCommand(SLogoExecutable cmd) {
        cmd.execute(myTurt);
        setChanged();
//        if(cmd instanceof SLogoStringReturnable){
//            notifyObservers(((SLogoStringReturnable) cmd).returnValue());
//        }
//        else if (cmd instanceof SLogoConsumerReturnable){
//
//        }
        notifyObservers(((SLogoReturnable) cmd).returnValue());
        clearChanged();

    }

    public int[][] getBackgroundPalette() {
        return myTurt.getBackground().getPalette();
    }

    public int[][] getPenPalette() {
        return myTurt.getPen().getPalette();
    }
}
