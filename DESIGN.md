DESIGN
=
* High-level design goals of your project
    * Allow users write and run programs in a simplified logo language
    * Provide a versatile workspace to allow users to:
        *  save user-defined variables and commands
        *  keep track of previously run commands
        *  edit turtle, pen, and background state via UI controls
        *  write, run Slogo programs written in a variety of languages
        *  manipulate multiple turtles in a common workspace
* explains, in detail, how to add new features to your project
    * Adding a new language
        * Add language to list of recognized languages
        * Create resource files in the languages and GUIProperties directories in the different language
        * Create Reference_language_ directory for command reference
    * Adding a new feature to the Model
        * Create a new class that extends the class of the object (StdModelTurtle, StdModelPen, or StdModel Background to which you would like to add a feature
    * Adding a new Command 
      1. Change the Command properties file
         For a new basic command (not defined via to), a new entry has to be added to the command.properties file under the Model -> languages package. It should be added to the appropriate number of parameters.
      2. Add a Command Class in the commands package
         The next step is to subclass a command from one of the following abstract classes - Operator, UnaryOperator, BinaryOperator, TenaryOperator - depending on the number of parameters it takes. It also has to implement the execute method. Within the method, it has to define the function through a PentaConsumer interface, and return the result by setting the replacement value of the TreeExecutor.
    * Adding a new background/pen color
        * In the StdColorObject class add a new {r, g, b} int array to the 2D palette array
    * (Finish) Adding shape functionality
        * Create SetShape and GetShape commands (new classes) which use ModelTurtle's setShapeIndex and getShapeIndex methods 
        * In the GraphicsWindows' update method, call setImage on the TurtleView with the correct ID (this line was started but commented out). The argument to setImage should be a new Image constructed with a URL derived from the shapePath local variable
        * In the turtlePicker method in the ButtonPanel class, call setOnAction and pass to it a lambda expression which executes the setShape command with the desired shape index as the argument. The lambda expression can be a call to Parser.parseCommand.
    * Adding a new turtle shape/image (after adding shape functionality)
        * Add file to TurtleImages directory
        * Add name of file to GUITurtles_language_.properties in GUIProperties directory
        * Add name of file to list of possible shapes in the GUI 
    * Multiple project workspaces
        * create a new superclass called Workspace in the main package to set up a new Invoker, Parser, Stage and GUI. 
        * in the start method of main, create and execute setup for a workspace
        * add a button to the ButtonPanel (part of the GUI) which will create a new workspace when pressed
    * Allowing another aspect of state to be controlled or seen via view
        * One could add another button, ComboBox, or the like to the buttonPanel and have the button parse a specific command using the parsing lambda or execute some other lambda which could be contained in and obtained from either the ConsumerMap or the SupplierMap
        * One could also add a new component to the GUI by declaring its size and location, intializing the contents and desired action for the component in the initalizeComponents method, and setting its size and location in the initializeLayout method
    * Loading/saving files
        * Add methods loadFiles and saveFiles to DefinitionList class. loadFiles sets the text of ProjectWindow tabs to text given from a file. saveFiles places text from tabs into a new file.
        * Add buttons to GUI that call the loadFiles and saveFiles methods when clicked. Easiet placement of buttons is in a VBox or something similar that also contains the ProjectWindow.
* justifies major design choices, including trade-offs (i.e., pros and cons), made in your project
    * Where to initialize ModelTurtles (ModelTurtles are initialized in the Invoker)
        * Pros
            * Invoker executes Commands, so this way the Commands have easy access to the ModelTurtle(s) they need to act on
        * Cons
            * A lambda expression must be used to add the GraphicsWindow as an observer to each ModelTurtle that is created in the Invoker
    * What should observe what (Parser observes Invoker, GraphicsWindow observes each ModelTurtle)
        * Pros
            * The alternative to the Graphics Window observing each ModelTurtle is that the graphicsWindow could observe the Invoker and receive the state of all ModelTurtles at once. This alternative would be very complicated because the GraphicsWindow and the Parser each expect to recieve a different type of Object when their update method is called. In this regard, the version we chose is simpler.
        * Cons
            * If the GraphicsWindow were able to recieve the state of all objects initialized in the Invoker by observing the Invoker, the GraphicsWindow could avoid initializing the first TurtleView without first receiving through the update method the state of the ModelTurtle with the corresponding ID.
            * Implementations of ModelTurtle and other Model objects would not have to extend the Observable class, which makes it easier to create new implementations and new types of objects
    * Encapsulation with interfaces
        * An important and major aspect of our design involves the usage of interfaces. When a valid user-typed comand is parsed by the Parser, the corresponding command object is created by the CommandFactory. To minimize dependencies, we decided not to include references to the Parser and its components. However, in order for some functionalities to work, the command object needs parts of the parser and the invoker to call their own methods. This is done through functional interfaces and lambda expressions. We made a choice to define a consumer that takes in 5 objects instead of one, allowing the command object to delegate work to other parts of the program without having references to them. Oftentimes,  we also create several interfaces for a single class, so that it increases separation between different parts of the program. With the creation of internal and external interfaces, other parts of the program would only be able to access methods exposed through the respective interfaces,keeping the code "SHY".
      
    * Preventing dependencies between model and view by using many lambdas in Main.java
        * Pros
            * The implementation of the Model or View could change without having to rewrite the code as long as the API stays the same
        * Cons
            * The code in Main.java is hard to read and requires some pretty complex data structures (a Map of Consumers and a Map of Suppliers).
            * Two parameters needed to be added to the GUI and ButtonPanel for them to use these lambdas
    * Creating ButtonPanel class (instead of leaving that code in the GUI)
        * Pros
            * the GUI class has fewer dependencies (before this refactroing it had 29, now it has 21, which is much closer to the limit of 20 dependencies imposed by the online checklist)
        * Cons
            * The ButtonPanel has a large constructor and doesn't have any methods that are used outside of the constructor; it's essentially just holding data.
            * Its constructor takes a lot of parameters
    * how to structure Model state
        * ModelState consists of some one or more instances of ModelTurtle, each of which has a ModelPen; there is also one representation of the Background in the Model. Both the StdModelPen and the StdModelBackground extend StdColorObject to provide color functionality
        * Pros
            * The code for color functionality does not have to be duplicated for different types of pens or backgrounds, 
            * Classes that access color functionality of objects do so in a uniform way
        * Cons
            * Some flexibility is lost; one would have to make some changes to the way color functionality is interited to, say, have an object have more than two colors
* states any assumptions or decisions made to simplify or resolve ambiguities in your the project's functionality
    * Because of the ambiguity in how commands should be executed over groups, we limited the commands groups can work with to sum, difference, multiplication, division, and 
    * the text in the view changes when the language is changed
    * we assumed that all turtle shapes would be image files
    * we assumed that there would only be one background
    * we assumed that each turtle only has one pen
    * we assumed that in commands such as if, ifelse, for, expr only refers to values or variables and not commands that are to be evaluated.