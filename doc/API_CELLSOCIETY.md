# API Critique for team07

## Simulation

 ### Node
 - internal
    - updateNode
    - setReplacement
    - getMyCell
    - getAdjacentNodes
    - getNeighborCells
    - finishUpdate
 - external
    - setMap
 - not in API
 
 ### AlgoNode
 - internal
    - setFunc
 ### Game
 - internal
 - external
    - step
 - not in API
    - endState
 
 ### Cell
 - internal
    - updateCell
    - getReplacementCell
    - getMySquare
    - replaceMySquare
    - getTargets
    - resetTarget
    - choose
    - wasChosen
    - resetChosen
 - external
 - not in API
 ### AnimalCell
 - internal
 - external
 - not in API
    - findDestinations
    - chooseCell
    - findSpawn
 
 ## Configuration
 
 ### Initializer
 
 ### Handle
 ### HexagonCreator
 ### TriangleCreator
 ### Grid
 
 ## Visualization
 
 ### main.Main
 
 ## Final Descriptions
 
 ### Simulation
 #### internal
 - The highest level class is a Game class which contains a map of Nodes. A Node superclass serves a the
 vertices in an adjacency map. Every Node implements an updateNode method which updates cells based on its current conditions.
 It also implements getAdjacentNodes and getAdjacentCells which allow for easy access to the map and it implement
 setMyReplacementCell so
 #### external
 - The game is outward facing manifestation of simulation. The step function is called by other classes to
 iterate through the game. The map for each Node also needs to be set using the setMap function.
 
 ### Configuration
 ### Visualization