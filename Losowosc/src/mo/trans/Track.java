/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.trans;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Janusz Sokołow, Student of Gdańsk University of Technology
 */public class Track {

    ArrayList<Connection> connections;
    double summaryDist;

    public Track(ArrayList<Connection> connections) {
        this.connections = connections;
        this.summaryDist = 0;
        Iterator<Connection> iterator = this.connections.iterator();
        while (iterator.hasNext()) {
            this.summaryDist += iterator.next().getDist();
        }
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public double getsSummaryist() {
        return this.summaryDist;
    }

    @Override
    public String toString() {
        String s = "Traack summary " + this.summaryDist + "\n";
        Iterator<Connection> iterator = this.connections.iterator();
        while (iterator.hasNext()) {
            Connection next = iterator.next();
            s += next.c1 + " " + next.c2 + " dist=" + next.dist + "\n";
        }
        return s + "\n";
    }

}
