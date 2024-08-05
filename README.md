## One-solution maze
### Input:
List of lists of Integers, with:
* 2 being the start,
* 3 being the destination,
* 1 being a wall,
* 0 being an open way.

E.g.,

    1 2 1 1 1
    1 0 1 1 1
    1 0 0 1 1
    1 1 0 1 1
    1 1 0 3 1

Important: There is only one way through the maze.

### Output:

List of lists of Integers, with:

* 10 being the start,
* 11, 12, ... being the steps of the way,
* 1 being a wall,
* 0 being an open (unused) way.

E.g.,

    1  10  1  1  1
    1  11  1  1  1
    1  12 13  1  1
    1  1  14  1  1
    1  1  15 16  1