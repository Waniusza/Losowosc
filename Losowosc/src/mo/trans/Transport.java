package mo.trans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Janusz Sokołow, Student of Gdańsk University of Technology
 */
public class Transport {

    private static final int populationSize = 20;
    private static final int dominationSize = 10;
    private int width = 600;
    private int heigh = 600;

    private int cities = 25;
    private List<City> citiesList = new ArrayList<>();
    private List<Track> tracksList = new ArrayList<>();

    public static void main(String[] args) {
        Transport t = new Transport();
    }

    public Transport() {

        for (int i = 0; i < cities; i++) {
            citiesList.add(new City(Math.random() * this.width, Math.random() * this.heigh));
        }

        for (int i = 0; i < populationSize; i++) {
            Track generatedPopulation = generatePopulation();
            tracksList.add(generatedPopulation);
            System.out.println("mo.Trans.<init>() Wygenerowałem trasę o łącznej odległości : " + generatedPopulation.summaryDist);
        }
    }

    public Track getBestTrack() {
        int iterations = 0;
        int repeats = 0;
        double bestValue = Double.MAX_VALUE;
        do {
            for (int i = 0; i < dominationSize; i++) {
                tracksList.remove(tracksList.size() - 1);
            }
            for (int i = dominationSize; i < populationSize; i++) {
                Track generatedPopulation = generatePopulation();
                tracksList.add(generatedPopulation);
//                System.out.println("mo.Trans.<init>() Wygenerowałem trasę o łącznej odległości : " + generatedPopulation.summaryDist);
            }
            tracksList.sort(new TrackComparator());

            Iterator<Track> iterator = tracksList.iterator();

            while (iterator.hasNext()) {
                System.out.println("mo.Trans.<init>() " + iterations + " " + repeats + " Mam dist : " + iterator.next().summaryDist);
            }
            iterations++;
            if (tracksList.get(0).getsSummaryist() < bestValue) {
                bestValue = tracksList.get(0).getsSummaryist();
                repeats = 0;
                System.out.println("mo.trans.Trans.getBestTrack() ====== NOWY NAJLEPSZY WYNIK, ODNAWIAM REPEATS");
            }
        } while ((repeats = checkPassed(tracksList, repeats)) < 50);

        System.out.println("mo.trans.Trans.<init>()  najlepsza kombinacja :");
        iterations = 0;
        System.out.println(tracksList.get(0));
        return tracksList.get(0);
    }

    private int checkPassed(List<Track> tracks, int old) {
        boolean res = true;
        for (int i = 0; i < 3; i++) {
            if (tracks.get(i).summaryDist != tracks.get(i + 1).summaryDist) {
                res = false;
                break;
            }
        }
        if (res) {
            return 50;
        } else {
            return ++old;
        }
    }

    private Track generatePopulation() {
        ArrayList<Connection> conn = new ArrayList<>();

        City c1, c2;
        ArrayList<City> tempCities = new ArrayList<City>(citiesList);

        c2 = tempCities.remove((int) (Math.random() * (tempCities.size() - 1)));
        while (tempCities.size() > 0) {
            c1 = new City(c2);
            c2 = tempCities.remove((int) (Math.random() * (tempCities.size() - 1)));
            conn.add(new Connection(c1, c2));
        }
        return new Track(conn);
    }

   
}
