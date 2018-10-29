package invoking;

import external.*;

import java.util.*;
import java.util.function.Consumer;


public class Invoker extends Observable implements Invokable{
    private Consumer<StdModelTurtle> addTurtleObserver;
    private Parse myParse;
    private Map<Integer, StdModelTurtle> myTurtles;
    private List<Integer> activeTurtles;
    private List<Integer> savedTurtles;

    public Invoker(){
        activeTurtles = new ArrayList<>();
        myTurtles = new HashMap<>();
        StdModelTurtle turt = new StdModelTurtle(1);
        myTurtles.put(1, turt);
        activeTurtles.add(1);
    }

    public void setMyParse(Parse myParse) {
        this.myParse = myParse;
        this.addObserver(this.myParse);
    }

    /**
     * Use this method to add the graphicsWindow as an observer for all turtles once the graphicsWindow
     * has been instantiated (it is instantiated when the GUI is instantiated)
     *
     * @param addTurtleObserver (StdModelTurtle turt) -> turt.addObserver(graphicsWindow)
     */
    public void setAddTurtleObserver(Consumer<StdModelTurtle> addTurtleObserver) {
        this.addTurtleObserver = addTurtleObserver;
        addTurtleObserver.accept(myTurtles.get(1));
    }

    private void makeTurtle(Integer id){
        StdModelTurtle turt = new StdModelTurtle(id);
        myTurtles.put(id, turt);
        activeTurtles.add(id);
        addTurtleObserver.accept(turt);
    }

    @Override
    public void acceptCommand(SLogoExecutable cmd) {
        for(Integer id: activeTurtles){
            cmd.execute(myTurtles.get(id));
            setChanged();
            notifyObservers(((SLogoReturnable) cmd).returnValue());
            clearChanged();
        }
    }

    @Override
    public void activateTurtles(List<String> ids) {
        for(Integer oldid: activeTurtles){
            myTurtles.get(oldid).deactivate();
        }
        activeTurtles = new ArrayList<>();
        for(String id: ids){
            if(!myTurtles.containsKey(Integer.parseInt(id))){
                makeTurtle(Integer.parseInt(id));
            }
            else {
                myTurtles.get(Integer.parseInt(id)).activate();
                activeTurtles.add(Integer.parseInt(id));
            }
        }
    }

    @Override
    public String getNumTurtles() {
        return String.valueOf(myTurtles.entrySet().size());
    }

    @Override
    public void saveActiveState() {
        savedTurtles = new ArrayList<>(activeTurtles);
    }

    @Override
    public void resetActiveState() {
        activeTurtles = new ArrayList<>(savedTurtles);
    }

    public int[][] getBackgroundPalette() {
        return myTurtles.get(1).getBackground().getPalette();
    }

    public int[][] getPenPalette() {
        return myTurtles.get(1).getPen().getPalette();
    }
}
