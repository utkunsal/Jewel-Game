# Bejeweled Game

Game  
Bejeweled® is a puzzle game created by PopCap Games in 2001. Various versions are available to play online, and on devices such as iPhone, 
iPad and Android. The game consists of a grid (of any size, e.g. 10x10) of “jewels”. Some example jewels are Diamond (D), 
Square (S), Triangle (T) and Wildcard (W). The goal is to find three jewels that are match in a row, column or diagonal by selecting the right 
coordinate. When this occurs, the three jewels are deleted, and other jewels fall from the top to fill in gaps. If the selected coordinate is empty 
or out of grid, then a warning message ("Please enter a valid coordinate") is displayed to the user and a new coordinate is requested.
Each jewel match in a different way. For the shape types defined as above, Diamond (D) can match with other Diamonds only in diagonal coordinates. 
Square (S) can match with its kind only in horizontal coordinate (x-axis). Triangle (T) can match with its kind only in vertical coordinate (y-axis). 
Wildcard (W) can match any jewel in any direction. Each jewel in a triple is worth a predetermined number of points. Diamond, Square, Triangle and Wildcard 
are scored as 30, 15, 15, 10 points respectively. So, a triple of all Diamonds will get 90 points, but a triple of 2 Diamonds and a Wildcard will be 70 points. 
The coordinate specified by user can be either first or last item in triple. The triplet should be searched using the rules defined below.
  
  1 2 3  
  4 X 6  
  7 8 9  
  
• If the coordinate contains a D, the program searches triple first in left (1 and 9) and then in right diagonal direction (3 and 7),  
• If the coordinate contains an S, the program searches triple first in left and then in right horizontal direction,  
• If the coordinate points to a T, the program searches the triple first in upward and then in downward vertical direction,  
• If the coordinate contains a W, the program starts searching from vertical (2 and 8) followed by horizontal (4 and 6) and finally diagonals left (1 and 9) and right (3 and 7).

Extending the jewels with Mathematical Symbols

All Mathematical symbols are worth 20 points.  
• “/” : Matches any other mathematical symbol jewel only in right diagonal. Search 3 first, then 7.  
• “-“ : Matches any other mathematical symbol jewel by searching horizontally (4 and 6).  
• “+” : Matches any other mathematical symbol jewel by searching first horizontally (4 and 6) then vertically (2 and 8).  
• “\” : Matches any other mathematical symbol jewel only in left diagonal. Search 1 first, then 9.  
• “|” : Matches any other mathematical symbol jewel vertically. Search 2 first, then 8.

# Input and Output
• gameGrid.txt file has initial grid of the game. In this file, each jewels/mathematical symbols is separated by space and ending with new line.  
• command.txt file contains coordinates entered at each step (two numbers separated by a space and ending with new line).Finally, to end the program it will contain an “E” character and a name for the leaderboard.  
• leaderboard.txt file should contain name and score of players. They should be separated by a space and ending with new line.  
• monitoring.txt file contains the output.  

# Execution
  javac *.java  
  java Main gameGrid.txt command.txt
