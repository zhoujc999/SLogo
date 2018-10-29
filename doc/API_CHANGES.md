API_CHANGES
=

# Model

* ModelTurtle
    * getState returns Map\<String, Double> instead of List\<Integer>. The Map provides a more intuitive/readable way to pass the state to GraphicsWindow.update, and one does not have to alter indicies in the Model or the View if something is added to the state. The change to Double instead of Integer was made because some state variables, such as position and heading, could be decimal values.
    * pen methods moved to ModelPen
    * activate and deactivate added for multiple turtle functionality
    * 
* ModelPen
    * a turtle's ModelPen is really its own seperate Object; one should be able to swap out different implementations/extensions of ModelPen easily. Thus we moved penUp and penDown and getPenDown to this interface, and also added a getter and setter for penSize and a method to return the state of the ModelPen.
* ColorObject
    * This interface was created because the ModelPens and the Background have the same implementation for getting and setting color and palette and returning state. With this interface we were able to avoid duplicating that code 

# View

* Many classes were moved to the internal package because they are not directly provided by the GUI. The classes that remain in the external package are CommandWindow, GraphicsWindow, and GUI. This is because GUI is instantiated by the Main class and it contains getters for CommandWindow and GrpahicsWindow.
* VariableWindow was made into an inheritance hierarchy containing GUIList interface (requiring save and load behaviors), DefinitionList abstract class, and finally the VariableList and CommandList classes.
* The update method was moved to the GraphicsWindow because drawing involves more than just the turtle. Instead, the TurtleView has behavior for setting its position and active status.
* The setName method from CommandHistory, CommandWindow, and VariableWindow were removed because they were not needed since they extend certain classes.
* getTurtle() in GraphicsWindow was changed to getTurtles() to reflect extension for multiple turtles.