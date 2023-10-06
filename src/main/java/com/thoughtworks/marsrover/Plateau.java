package com.thoughtworks.marsrover;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    private final int lowerBoundCoordinateX = 0;
    private final int lowerBoundCoordinateY = 0;
    private final int upperBoundCoordinateX;
    private final int upperBoundCoordinateY;
    
    private final List<Obstacle> obstacles = new ArrayList<>();
    

    public Plateau(int upperBoundCoordinateX, int upperBoundCoordinateY) {
        this.upperBoundCoordinateX = upperBoundCoordinateX;
        this.upperBoundCoordinateY = upperBoundCoordinateY;
    }
   
    public int getUpperBoundCoordinateX() {
        return upperBoundCoordinateX;
    }

    public int getUpperBoundCoordinateY() {
        return upperBoundCoordinateY;
    }

    public int getLowerBoundCoordinateX() {
        return lowerBoundCoordinateX;
    }

    public int getLowerBoundCoordinateY() {
        return lowerBoundCoordinateY;
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public boolean hasObstacleAt(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                return true;
            }
        }
        return false;
    }
    
}
