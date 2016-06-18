package mo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Janusz Sokołow, Student of Gdańsk University of Technology
 */
public class Trans {

    private int width = 600;
    private int heigh = 400;

    private int cities = 5;
    private List<City> citiesList = new ArrayList<>();

    public static void main(String[] args) {
        Trans t = new Trans();
    }

    public Trans() {

        for (int i = 0; i < cities; i++) {
            citiesList.add(new City(i * 100, i + 75));
        }

    }

    class City {

        int x, y;

        public City(int x, int y) {
            this.x = x;
            this.y = y;

            System.out.println("Tworze miasto o kordach x: " + this.x + " i y: " + this.y);
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }
    }

    class Disance {

        City c1, c2;
        int dist;

        public  Disance() {
            
        }
        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }
    }
}
