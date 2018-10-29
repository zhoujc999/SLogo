REFACTORING_DISCUSSION_jyn2jgp17jz192tms62
=

# Duplication Refactoring
You should know by now that code duplication is number one in the Code Smell stink parade. Still, as things need to get done, you rush and copy code anyway or you may not realize that similar code was written in different places in the project. One of the tabs on the Checklist Report is Duplicated Code, which shows a side by side comparison of places in your project that contain duplicated code.

Finding duplicated code is easy (so easy a computer can do it :), but refactoring it can take some thought. Sometimes the refactoring is as simple as creating a new method, sometimes it requires creating an inheritance hierarchy, sometimes a new class or abstraction is required. Discuss the options as a team and decide how best to refactor the chosen code section to remove the duplication.

In your discussion file, describe why you chose the fixes you did and what, if any, alternatives you considered.

Removed duplication in GraphicsWindow.update by extracting a single method to either get the pen color or background color.

# Checklist Refactoring
Three "tabs" organizes the variety of possible coding issues into the higher level design goals given in the project's Design Checklist. Some items on the checklist may not have any issues (green — YAY) and some may have a lot of issues (red — BOO). Your team should focus on the items with many issues and decide how best to refactor the code to fix them.

In your discussion file, describe why you chose the fixes you did and what, if any, alternatives you considered.

Communication issues such as magic values were easy to refactor. 

We could not refactor the flexibility issues involving the use of HashMap because Map.putAll throws an UnsupportedOperationException.

Some modularity issues, such as adding a constructor to StdColorObject, were easy to refactor. There were too many dependencies in the GUI so we decided to refactor the ButtonPanel to a separate file to reduce the dependencies in the GUI.

# General Refactoring
Two "tabs" organizes the variety of possible coding issues into the categories Code Smells or Java Notes. Code Smells are based on those items we have studied earlier in the semester. Java Notes are based on Joshua Bloch's Effective Java book which describes typical issues in Java code that should be fixed in a standard idiomatic way. As usual, some of these may have easy fixes and some may require more thought. Your team should discuss how best to refactor the code to fix each one.

In your discussion file, describe why you chose the fixes you did and what, if any, alternatives you considered. Use SOLID Design Principles to justify your larger refactoring efforts.

Some Java Notes were easy to refactor such as removing parentheses for one-parameter lambdas and returning a clone of the palette in getPalette.



# Long Methods
Long methods are another Code Smell that can reveal more than just centralization of your code — they are often also the source of inflexibility in your code because they are a sign of an object doing too much. By looking beyond simply breaking these methods up into smaller pieces, you may find violations of the Single Responsibility Principle or hard coded assumptions that can be reversed by creating an abstraction to support the Dependency Inversion Principle. Design Patterns can often help given you specific guidance in how to refactor your code to better support these principles.

Shortened GraphicsWindow.update by removing duplication