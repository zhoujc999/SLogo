SLogo Architecture Design
-------------------------
1. The result of parsing is a Command object and it is passed to the Control and then to Model and this sometimes
results in a change in the View.
2. Parsing takes place in Parser. It needs text input from user.
3. Errors are handled by the Parser.
4. Commands know a certain behavior.
5. The GUI calls a method and renders the change it that was made.