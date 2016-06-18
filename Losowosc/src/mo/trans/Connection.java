/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.trans;

/**
 *
 * @author Janusz Sokołow, Student of Gdańsk University of Technology
 */
public class Connection {

    City c1, c2;
    double dist;

    public Connection(City c1, City c2) {
        this.c1 = c1;
        this.c2 = c2;
//            System.out.println("mo.Trans.Connection.<init>() łączę miasta : " + c1.getX() + "::" + c1.getY() + " i " + c2.getX() + "::" + c2.getY());
        this.dist = Math.sqrt(
                Math.abs(this.c1.getX() - this.c2.getX()) * Math.abs(this.c1.getX() - this.c2.getX())
                + Math.abs(this.c1.getY() - this.c2.getY()) * Math.abs(this.c1.getY() - this.c2.getY()));
    }

    public double getDist() {
        return this.dist;
    }

    public City getCity1() {
        return this.c1;
    }

    public City getCity2() {
        return this.c2;
    }
}
