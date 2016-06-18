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
public class City {
        int x, y;

        public City(City oldCity) {
            this.x = oldCity.x;
            this.y = oldCity.y;
        }

        public City(int x, int y) {
            this.x = x;
            this.y = y;
            System.out.println("Tworze miasto o kordach x: " + this.x + " i y: " + this.y);
        }

        public City(double x, double y) {
            this.x = (int) x;
            this.y = (int) y;
            System.out.println("Tworze miasto o kordach x: " + x + " i y: " + y);
        }
        public int getX() {
            return this.x;
        }
        public int getY() {
            return this.y;
        }
        @Override
        public String toString() {
            return "City(" + this.x + ":" + this.y + ")";
        }

    }