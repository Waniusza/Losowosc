/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.trans;

import java.util.Comparator;

/**
 *
 * @author Janusz Sokołow, Student of Gdańsk University of Technology
 */
public class TrackComparator implements Comparator<Track>{

    @Override
    public int compare(Track o1, Track o2) {
        return (int) (o1.summaryDist - o2.summaryDist);
    }
    
}
