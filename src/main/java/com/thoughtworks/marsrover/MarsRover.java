package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.command.Command;
import com.thoughtworks.marsrover.rover.Rover;
//import com.thoughtworks.marsrover.Plateau;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

class MarsRover {

    public static void main(String[] args) throws IOException {

        ArrayList<String> inputFileAsList = InputUtil.parseInputFromFile(MarsRover.class.getResourceAsStream("/input.txt"));
        
        // The first instruction is separated out, as this is for creating the Plateau, which is global for all Rovers
        

        List<String> roverInput = inputFileAsList.subList(1, inputFileAsList.size());

        System.out.println("Input:" + "\n");

        for (String line : inputFileAsList)
            System.out.println(line);

        System.out.println("\n" + "Output:" + "\n");

        Plateau plateau = InputUtil.parsePlateauInput(inputFileAsList.get(0));
       
        for (int i = 0; i < roverInput.size(); i++) {
            String line = roverInput.get(i);
        
            if (line.startsWith("O ")) {
                String obstacleInput = line.substring(2);
                Obstacle obstacle = InputUtil.parseObstacleInput(obstacleInput);
                plateau.addObstacle(obstacle);
            } else {
                // Handle rover position and command input as before
                String positionInput = line;
                String commandInput = roverInput.get(++i);
                Rover rover = InputUtil.parsePositionInput(positionInput, plateau);
                ArrayList<Command> commands = InputUtil.parseCommandInput(commandInput);
                rover.executeCommandList(commands);
                System.out.println(rover.broadcastLocation());
            }
        }

    }
}
