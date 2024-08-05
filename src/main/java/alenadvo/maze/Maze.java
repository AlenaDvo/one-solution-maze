package alenadvo.maze;

import java.util.ArrayList;
import java.util.List;

/*
Input: List of lists of Integers, with:
    2 being the start,
    3 being the destination,
    1 being a wall,
    0 being an open way.
    E.g.,
        1 2 1 1 1
        1 0 1 1 1
        1 0 0 1 1
        1 1 0 1 1
        1 1 0 3 1
Important: There is only one way through the maze.

Output: List of lists of Integers, with:
    10 being the start,
    11, 12, ... being the steps of the way,
    1 being a wall,
    0 being an open way.
    E.g.,
        1  10  1  1  1
        1  11  1  1  1
        1  12 13  1  1
        1  1  14  1  1
        1  1  15 16  1
*/
public class Maze {
    public static ArrayList<ArrayList<Integer>> findWay(ArrayList<ArrayList<Integer>> maze) {
        Integer startNumber = 2;
        Integer destinationNumber = 3;
        Integer openWay = 0;
        Integer start = 10;

//        1) print maze, prepare way
        System.out.println("Maze: ");
        for (List<Integer> row : maze) {
            System.out.println(row);
        }

        ArrayList<ArrayList<Integer>> way = maze;

//        2) find start
        List<Integer> startPosition = findStart(maze, startNumber);

//        3) find next step
/*          - enter the correct number to the way
            - start at startPosition
            - position = findNextStep(startPosition)
*/
        do {
            way.get(startPosition.get(0)).set(startPosition.get(1), start);
            startPosition = findNextPosition(startPosition, maze, destinationNumber, openWay);
            start++;
        } while (startPosition != null);

//        4) print way
        System.out.println("Way: ");
        for (List<Integer> row : way) {
            System.out.println(row);
        }
        System.out.println();
        return way;
    }

    private static List<Integer> findStart(ArrayList<ArrayList<Integer>> maze, Integer startNumber) {
        int numberOfRows = maze.size();
        int numberOfColumns = maze.get(0).size();
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            List<Integer> row = maze.get(rowIndex);
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                Integer number = row.get(columnIndex);
                if (number.equals(startNumber)) {
                    return List.of(rowIndex, columnIndex);
                }
            }
        }
        return null;
    }

    private static ArrayList<Integer> findNextPosition(List<Integer> position, ArrayList<ArrayList<Integer>> maze, Integer destinationNumber, Integer openWay) {
        Integer numberOfColumns = maze.size();
        Integer numberOfRows = maze.get(0).size();

        Integer x = position.get(0);
        Integer y = position.get(1);

//        1) go left (x - 1, y)
        if (isInBounds(x - 1, numberOfColumns)) {
            if (maze.get(x - 1).get(y).equals(openWay) || maze.get(x - 1).get(y).equals(destinationNumber)) {
                ArrayList<Integer> coordinates = new ArrayList<>();
                coordinates.add(0, x - 1);
                coordinates.add(1, y);
                return coordinates;
            }
        }

//        2) go down (x, y - 1)
        if (isInBounds(y - 1, numberOfRows)) {
            if (maze.get(x).get(y - 1).equals(openWay) || maze.get(x).get(y - 1).equals(destinationNumber)) {
                ArrayList<Integer> coordinates = new ArrayList<>();
                coordinates.add(0, x);
                coordinates.add(1, y - 1);
                return coordinates;
            }
        }

//        3) go right (x + 1, y)
        if (isInBounds(x + 1, numberOfColumns)) {
            if (maze.get(x + 1).get(y).equals(openWay) || maze.get(x + 1).get(y).equals(destinationNumber)) {
                ArrayList<Integer> coordinates = new ArrayList<>();
                coordinates.add(0, x + 1);
                coordinates.add(1, y);
                return coordinates;
            }
        }

//        4) go up (x, y + 1)
        if (isInBounds(y + 1, numberOfRows)) {
            if (maze.get(x).get(y + 1).equals(openWay) || maze.get(x).get(y + 1).equals(destinationNumber)) {
                ArrayList<Integer> coordinates = new ArrayList<>();
                coordinates.add(0, x);
                coordinates.add(1, y + 1);
                return coordinates;
            }
        }
        return null;
    }

    private static boolean isInBounds(Integer index, Integer length) {
        return (index >= 0) && (index < length);
    }
}