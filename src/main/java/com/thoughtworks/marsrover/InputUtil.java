package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.command.Command;
import com.thoughtworks.marsrover.command.CommandLookup;
import com.thoughtworks.marsrover.direction.Direction;
import com.thoughtworks.marsrover.direction.DirectionLookup;
import com.thoughtworks.marsrover.rover.Rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

class InputUtil {

    public static ArrayList<String> parseInputFromFile(InputStream fileLocation) throws IOException {
        ArrayList<String> inputsFromFile = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileLocation));
        String fileLine;

        while ((fileLine = bufferedReader.readLine()) != null)
            inputsFromFile.add(fileLine);

        bufferedReader.close();
        return inputsFromFile;
    }

    public static Plateau parsePlateauInput(String plateauInput) {
        String[] inputArray = plateauInput.split(" ");
        int plateauUpperBoundCoordinateX = Integer.parseInt(inputArray[0]);
        int plateauUpperBoundCoordinateY = Integer.parseInt(inputArray[1]);
        return new Plateau(plateauUpperBoundCoordinateX, plateauUpperBoundCoordinateY);
    }

    public static Rover parsePositionInput(String positionInput, Plateau plateau) {
        String[] inputArray = positionInput.split(" ");
        int roverLandingCoordinateX = Integer.parseInt(inputArray[0]);
        int roverLandingCoordinateY = Integer.parseInt(inputArray[1]);
        Direction direction = DirectionLookup.valueOf(inputArray[2]).getDirection();
        return new Rover(plateau, roverLandingCoordinateX, roverLandingCoordinateY, direction);
    }

    public static ArrayList<Command> parseCommandInput(String command) {
        char[] inputArray = command.toCharArray();
        ArrayList<Command> commandArrayList = new ArrayList<>();

        for (char character : inputArray) {
            Command currentCommand = CommandLookup.valueOf(Character.toString(character)).getCommand();
            commandArrayList.add(currentCommand);
        }

        return commandArrayList;
    }
//------------------------
    //  public static Obstacle parseObtacleInpuObstacle(String ObstacleInput) {
    //     String[] inputArray = ObstacleInput.split(" ");
    //     int x = Integer.parseInt(inputArray[0]);
    //     int y = Integer.parseInt(inputArray[1]);
    //     return new Obstacle(x, y);
    // }
   
    // public static Obstacle parseObstacleInput(String obstacleInput) {
    //     String[] inputArray = obstacleInput.split(" ");
    //     int x = Integer.parseInt(inputArray[0]);
    //     int y = Integer.parseInt(inputArray[1]);
    //     return new Obstacle(x, y);
    // }
    public static Obstacle parseObstacleInput(String obstacleInput, Plateau plateau) {
        String[] inputArray = obstacleInput.split(" ");
        int x = Integer.parseInt(inputArray[1]);
        int y = Integer.parseInt(inputArray[2]);
        Obstacle obstacle = new Obstacle(x, y);
        plateau.addObstacle(obstacle);
        return obstacle;
    }
    public static Obstacle parseObstacleInput(String obstacleInput) {
        String[] inputArray = obstacleInput.split(" ");
        int x = Integer.parseInt(inputArray[0]);
        int y = Integer.parseInt(inputArray[1]);
        return new Obstacle(x, y);
    }
    
}
