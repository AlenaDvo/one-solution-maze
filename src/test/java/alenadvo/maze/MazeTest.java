package alenadvo.maze;

import alenadvo.maze.Maze;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class MazeTest {

    @Test
    void case00() {
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        maze.add(new ArrayList<>(List.of(1, 2, 1, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 0, 1, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 0, 0, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 3, 1)));

//          1 2 1 1 1
//          1 0 1 1 1
//          1 0 0 1 1
//          1 1 0 1 1
//          1 1 0 3 1

        ArrayList<ArrayList<Integer>> way = new ArrayList<>();
        way.add(new ArrayList<>(List.of(1, 10, 1, 1, 1)));
        way.add(new ArrayList<>(List.of(1, 11, 1, 1, 1)));
        way.add(new ArrayList<>(List.of(1, 12, 13, 1, 1)));
        way.add(new ArrayList<>(List.of(1, 1, 14, 1, 1)));
        way.add(new ArrayList<>(List.of(1, 1, 15, 16, 1)));

//          1  10  1  1  1
//          1  11  1  1  1
//          1  12 13  1  1
//          1  1  14  1  1
//          1  1  15 16  1

        assertThat(Maze.findWay(maze)).isEqualTo(way);
    }

    @Test
    void case01() {
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        maze.add(new ArrayList<>(List.of(1, 2, 1, 1, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 0, 1, 1, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 0, 0, 1, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 1, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 3, 1, 1)));

        ArrayList<ArrayList<Integer>> way = new ArrayList<>();
        way.add(new ArrayList<>(List.of(1, 10, 1, 1, 1, 1)));
        way.add(new ArrayList<>(List.of(1, 11, 1, 1, 1, 1)));
        way.add(new ArrayList<>(List.of(1, 12, 13, 1, 1, 1)));
        way.add(new ArrayList<>(List.of(1, 1, 14, 1, 1, 1)));
        way.add(new ArrayList<>(List.of(1, 1, 15, 16, 1, 1)));

        assertThat(Maze.findWay(maze)).isEqualTo(way);
    }

    @Test
    void case02() {
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        maze.add(new ArrayList<>(List.of(1, 2, 1, 1, 1, 0)));
        maze.add(new ArrayList<>(List.of(1, 0, 1, 1, 1, 0)));
        maze.add(new ArrayList<>(List.of(1, 0, 0, 1, 1, 0)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 1, 1, 1)));
        maze.add(new ArrayList<>(List.of(1, 1, 0, 3, 1, 1)));

        ArrayList<ArrayList<Integer>> way = new ArrayList<>();
        way.add(new ArrayList<>(List.of(1, 10, 1, 1, 1, 0)));
        way.add(new ArrayList<>(List.of(1, 11, 1, 1, 1, 0)));
        way.add(new ArrayList<>(List.of(1, 12, 13, 1, 1, 0)));
        way.add(new ArrayList<>(List.of(1, 1, 14, 1, 1, 1)));
        way.add(new ArrayList<>(List.of(1, 1, 15, 16, 1, 1)));

        assertThat(Maze.findWay(maze)).isEqualTo(way);
    }
}