SLOGO DESIGN PLAN 
=================


# Introduction (Jay)

This section describes the problem your team is trying to solve by writing this program, the primary design goals of the project (i.e., where is it most flexible), and the primary architecture of the design (i.e., what is closed and what is open). Discuss the program at a high-level (i.e., without referencing specific classes, data structures, or code).

Our team is writing this program to provide users with an IDE in which to write and run programs written with simplified logo syntax. Our program will have two main components: a Model and a View. The view will allow users to write commands on a commandline; the user input will then be parsed by the model, and the model will give the view back information on how to update what is drawn on the campus as a result of the user input. With this structure, changes to the implementation of either the model or the view should not require changes in the implementation of the other component.

# Design Overview (Jason)

For our SLOGO program, we are using the Model-View model. The Model will have the Turtle class, which is an abstract representation of the turtle, and the Model class, which has the turtle and manages the lines. It will also have the Parser class, the Factory class, the Command interface with specific commands being individual classes, and the Invoker class. The View will comprise the CommandWindow, the VariableWindow and the GraphicsWindow class.

In our case, we feel that a dedicated Controller was unnecessary to serve as the intermediary between the View and the Model. We instead decide to use features from java to handle the data transfer between the view and the model, such as implementing the Observer interfaces and Observable classes.

The program starts in Main, which creates an instance of the controller. The controller instantiates the GUI, Model, and Parser and waits for user input. After the user enters a command into the command text field, that string is passed to the controller which then passes the string to the Parser. The parser calls the createCommand method of the Factory, passing in the parameters and receives the command object. The parser then puts the command object in the Invoker to which the controller has a reference. The Controller then executes the command object on the model. The change in the state of the model is conveyed to the UI and the UI renders the updated view after it has received the updated representation of the model.

Here are the four APIs:
## Model: Internal API
TurtleModel (Jay)
* see src/Model/src/ModelTurtle.java

Invoker (Jonathan)
* public void acceptCommand(Command cmd)

## Model: external API
ModelTurtle (Jay)
* see src/Model/src/ModelTurtle.java

Invoker

* public Invoker(Turtle turt, Parser pars)

Parser

* public Parser(List updateLst, Factory fact)
* public void parseCommand(String cmd)
* public void update(Observable o, Object arg)

Command Factory
* Command createCommand(String cmd, List params);

Command
* public void execute();
* public int returnVal();
* public getTurtle();

## View: Internal API

TurtleView
* void update(Observable observable, Object args)

CommandHistory
* void saveCommand(String command)
* void setName(String name)

CommandReference
* void show()
* void hide()
* void setLanguage(String language)

## View: external API

CommandWindow
* String getInput()
* void setInput(String command)
* void setName(String name)

VariableWindow
* void saveVariable(String name, String value)
* String loadVariable(String name)
* void setName(String name)

GraphicsWindow
* TurtleView getTurtle()

GUI
* void run()
* CommandHistory getCommandHistory()
* CommandReference getCommandReference()
* CommandWindow getCommandWindow()
* VariableWindow getVariableWindow()
* GraphicsWindow getGraphicsWindow()
* void setLanguage(String language)

# User Interface
This section describes how the user will interact with your program (keep it simple to start). Describe the overall appearance of program's user interface components and how users interact with these components (especially those specific to your program, i.e., means of input other than menus or toolbars). Include one or more pictures of the user interface (these pictures can be hand drawn and scanned in, created with a standard drawing program, or screen shots from a dummy program that serves as a exemplar). Describe any erroneous situations that are reported to the user (i.e., bad input data, empty data, etc.).

The user will type text into the command window at the bottom of the screen and press the run button to execute commands. The clear button clears the command window. An error message will be returned to the user upon receiving bad input that cannot be translated into a command.

There are two scrollable panes on the right side that will display the variables (including user-defined commands) and the command history. The user can click on a command in the command history to place that command in the command window.

At the top, there are four drop down boxes that can be used to select the background color, turtle image, pen color, and language. Additionally, there is a button that, when pressed, opens a new stage containing the command reference page.

# API Details 
This section describes each API introduced in the Overview in detail. Describe how each API supports specific features given in the assignment specification, what resources it might use, how it is intended to be used, and how it could be extended to include additional requirements (from the assignment specification or discussed by your team). Finally, justify the decision to create each class introduced with respect to the design's key goals, principles, and abstractions. Your APIs should be written as Java interfaces, types that cannot contain instance variables or private methods, in appropriate packages. These should be Java code files that compile and contain extensive comments to explain the purpose of each interface and each method within the interface (note this code can be generated directly from a UML diagram). Include any Exceptions you plan to throw because of errors that might occur within your methods. Note, this does not require that all of these types will remain as interfaces in the final implementation, just that the goal is for you to focus on each type's behavior and purpose.

# API Example Code

```java=
//Here's how we have things set up for now according to the code below. Main.java instantiates a Model myModel which contains a Parser myParser, a CommandFactory myCommandFactory, an Invoker myInvoker, and a ModelTurtle myModelTurtle, and Main.java also instanties a View myView which contains an instance of each interface in both View APIs.
        
String str = myView.myCommandWindow.getInput() //getInput() returns "fd 50"
myView.myCommandHistory.saveCommand(str)
myModel.myParser.parseCommand(str) 
    ...
    Executable cmd = myModel.myCommandFactory.createCommand("fd",{50})
    Invoker.acceptCommand(cmd)
        ...
        cmd.execute(ModelTurtle t)
            ...
            ModelTurtle.forward(50)
                ...
                TurtleView.update(ModelTurtle t, Obj val)
                ...
            ...
        ...
    ...
```            

Use cases:

* Use case 1: rt ht 
```java=
myView.myCommandWindow.getInput()

    myView.myCommandHistory.saveCommand(str)
    myModel.myParser.parseCommand(str) 

        myModel.myCommandFactory.createCommand("ht", {})
        
            Invoker.acceptCommand(Commmand cmd)
        
                Command.execute(Turtle t)
                
                    TurtleModel.home()
                    
                        TurtleView.update(Turtle t, Obj val)
                    
                        Parser.update(Turtle t, Obj val)
                        
        
        myModel.myCommandFactory.createCommand("rt", {1})
            Invoker.acceptCommand(Command cmd)
            
                Command.execute(Turtle t)
                
                    TurtleModel.right(1)
                    
                        Parser.update(Turtle t, Obj val)
        
                        TurtleView.update(Turtle t, Obj val)
```
* Use case 2: fd sum 50 50
```java=
myView.myCommandWindow.getInput()

    myView.myCommandHistory.saveCommand(str)
    myModel.myParser.parseCommand(str) 

        myModel.myCommandFactory.createCommand("ht", {})
        
            Invoker.acceptCommand(Commmand cmd)
        
                Command.execute(Turtle t)
                
                    TurtleModel.home()
                    
                        Parser.update(Turtle t, Obj val)
        
        myModel.myCommandFactory.createCommand("rt", {1})
            Invoker.acceptCommand(Command cmd)
            
                Command.execute(Turtle t)
                
                    TurtleModel.right(1)
                    
                        Parser.update(Turtle t, Obj val)
        
                    
```

* Use case 3: User types XCOR
```java=
myView.myCommandWindow.getInput()

    myView.myCommandHistory.saveCommand(str)
    myModel.myParser.parseCommand(str) 

        myModel.myCommandFactory.createCommand("XCOR", {})
            Invoker.acceptCommand(Commmand cmd)
        
                Command.execute(ModelTurtle t)
                
                    t.getX()
                    
                        TurtleView.update(ModelTurtle t, Obj val)
                    
                        Parser.update(ModelTurtle t, Obj val)
```



* Use case 4: RT 180
```java=
myView.myCommandWindow.getInput()

    myView.myCommandHistory.saveCommand(str)
    myModel.myParser.parseCommand(str) 

        myModel.myCommandFactory.createCommand("RT", {180})
            Invoker.acceptCommand(Commmand cmd)
        
                Command.execute(ModelTurtle t)
    
                    t.right(180)
                    
                        TurtleView.update(ModelTurtle t, Obj val)
                        
                        Parser.update(ModelTurtle t, Obj val)

```

* Use case 5: User types the string “fd goto 1 1” to set the turtle’s position to (1, 1) and then move the turtle forward by the same amount the turtle just moved
```java=
        
String str = myView.myCommandWindow.getInput() //getInput() returns "fd goto 1 1"
myView.myCommandHistory.saveCommand(str)
myModel.myParser.parseCommand(str) 
    ...
    myModel.myCommandFactory.createCommand("goto",{1, 1})
        ...
        Invoker.acceptCommand(Commmand cmd)
        
            Command.execute(myModel.myModelTurtle)
                
                myModel.myModelTurtle.goTo(1, 1)  
             
                    TurtleView.update(ModelTurtle t, Obj val)
                    
                    Parser.update(ModelTurtle t, Obj val)
        
    myModel.myCommandFactory.createCommand("fd", dist)
            
            Invoker.acceptCommand(Command cmd)
            
                Command.execute(Turtle t)
                
                    myModel.myModelTurtle.forward(dist)
                    
                        TurtleView.update(ModelTurtle t, Obj val)
                    
                        Parser.update(ModelTurtle t, Obj val)
```            
* Use case 6: User types the string "clearscreen” to clear the turtle‘s trails

```java=
        
String str = myView.myCommandWindow.getInput() //getInput() returns "clearscreen"
myView.myCommandHistory.saveCommand(str)
myModel.myParser.parseCommand(str) 
    ...
    myModel.myCommandFactory.createCommand("clearscreen",{})
        ...
        Invoker.acceptCommand(Commmand cmd)
        
            Command.execute(ModelTurtle t)
                
                myModel.myModelTurtle.clearscreen()
                
                    TurtleView.update(ModelTurtle t, Obj val)
                
                    Parser.update(ModelTurtle t, Obj val)
        
``` 

* Use case 7: Saving commands to history
```java=
...
String str = myCommandWindow.getInput()
...
myCommandHistory.saveCommand(str)
```
* Use case 8: Setting language
```java=
GUI.setLanguage()
    ...
    myCommandReference.setLanguage()
    myCommandHistory.setName()
    myCommandWindow.setName()
    myVariableWindow.setName()
```

# Design Considerations 

A major design decision we considered was whether to use a controller class and work under the MVC model or bypass it and use the MV model. We ultimately decided to not include a controller because of the complexities of moving the neccessary data from the Model to the View. Instead we are using lambda expressions to retrieve and pass data from the view to the model and observables and observers to pass data from the model to the view. The major benefit of this choice is that it reduces the need for long chains of passing parameters from where the data is generated to where it is consumed. On the other hand, it makes the dependencies in the code less obvious. Insted of allowing the controller to abstract everything, the model and view actually have to interact. However, we feel that this isn't a major concern as long as our design is flexible/modular and we have robust APIs. 

Another idea we debated is the use of the Command Design Pattern. The idea of this structure is to seperate the request for a command from the execution of the command. Some of the benefits of this choice is that it allows for delayed execution, the encapsulation of command behaviors into classes, and the inclusion of the factory design pattern. A drawback of this design is that it put a separation between the data generated by the command and the place where the command is called. To get the data back requires more dependency. For example in the call fd fd 50 after fd 50 is evalued 50 has to be returned to the parser. However, because the inner fd 50 is evaluated in a different location there needs to be some dependency path that relays it back. 



# Team Responsibilities
This section describes the program components each team member plans to take primary and secondary responsibility for and a high-level plan of how the team will complete the program.

Jonathan:

Design and implement the Parser and Invoker classes.

Jason:

Design and implement the various Command classes and the Command Factory.

Jay:
Design and implement the ModelTurtle class and write controller-related code as necessary.

Tahj:
Design and implement the View.