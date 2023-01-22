package assignment07;

import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestPathFinder {
    public static void main(String[] args) throws FileNotFoundException {
        PathFinder.solveMaze("bigMaze.txt", "outputMazes/bigMazeOutput.txt");
        PathFinder.solveMaze("classic.txt", "outputMazes/classicMazeOutput.txt");
        PathFinder.solveMaze("demoMaze.txt", "outputMazes/demoMazeOutput.txt");
        PathFinder.solveMaze("mediumMaze.txt", "outputMazes/mediumMazeOutput.txt");
        PathFinder.solveMaze("randomMaze.txt", "outputMazes/randomMazeOutput.txt");
        PathFinder.solveMaze("straight.txt", "outputMazes/straightMazeOutput.txt");
        PathFinder.solveMaze("tinyMaze.txt", "outputMazes/tinyMazeOutput.txt");
        PathFinder.solveMaze("tinyOpen.txt", "outputMazes/tinyOpenMazeOutput.txt");
        PathFinder.solveMaze("turn.txt", "outputMazes/turnMazeOutput.txt");
        PathFinder.solveMaze("unsolvable.txt", "outputMazes/unsolvableMazeOutput.txt");
        ArrayList<String> outputList = new ArrayList<>(Arrays.asList("outputMazes/bigMazeOutput.txt", "outputMazes/classicMazeOutput.txt", "outputMazes/demoMazeOutput.txt",
                "outputMazes/mediumMazeOutput.txt", "outputMazes/randomMazeOutput.txt", "outputMazes/straightMazeOutput.txt", "outputMazes/tinyMazeOutput.txt",
                "outputMazes/tinyOpenMazeOutput.txt", "outputMazes/turnMazeOutput.txt", "outputMazes/unsolvableMazeOutput.txt"));

        ArrayList<String> solList = new ArrayList<>(Arrays.asList("bigMazeSol.txt", "classicSol.txt", "demoMazeSol.txt", "mediumMazeSol.txt",
                "randomMazeSol.txt", "straightSol.txt", "tinyMazeSol.txt", "tinyOpenSol.txt", "turnSol.txt", "unsolvableSol.txt"));
        /*
         * The below code assumes you have a file "tinyMaze.txt" in your project folder.
         * If PathFinder.solveMaze is implemented, it will create a file "tinyMazeOutput.txt" in your project folder.
         *
         * REMEMBER - You have to refresh your project to see the output file in your package explorer.
         * You are still required to make JUnit tests...just lookin' at text files ain't gonna fly.
         */

        for (int o = 0; o < outputList.size(); o++) {
            File myFile = new File(outputList.get(o));
            File solFile = new File(solList.get(o));
            Scanner mySC = new Scanner(myFile);
            int myCount = 0;
            int solCount = 0;
            while (mySC.hasNextLine()) {
                var temp = mySC.nextLine();
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == '.') {
                        myCount++;
                    }

                }
            }
            Scanner solSC = new Scanner(solFile);
            while (solSC.hasNextLine()) {
                var temp = solSC.nextLine();
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == '.') {
                        solCount++;
                    }
                }
            }
            System.out.println("Solution dots count: " + solCount);
            System.out.println("Output dots count: " + myCount);
            Assertions.assertEquals(myCount, solCount);
        }


    }


}

