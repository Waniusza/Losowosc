/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boids;

/**
 *
 * @author Krzysztof
 */

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Represents the flock of boids.
 * 
 * @author Audrius Meskauskas
 */
@SuppressWarnings("serial")
public class Flock extends ArrayList<Boid> {
	
	/**
	 * The size of the drawing field.
	 */
	final Rectangle2D.Double size = new Rectangle2D.Double(); 
	
	boolean scared;
	
	boolean cooperative = true;

	/**
	 * The next step of the iteration after the given time step.
	 */
	public void iteration(double time) {
		for (Boid boid : this)
			boid.moveAhead(time);
	}

	/**
	 * When the flock is scared, boids avoid each other (flock dissolves)
	 * 
	 * @param scared if true, the flock is scared.
	 */
	public void setScared(boolean scared) {
		this.scared = scared;
	}

	/**
	 * The the flock in not cooperative, boid does not care about other boids.
	 * 
	 * @param cooperative
	 */
	public void setCooperative(boolean cooperative) {
		this.cooperative = cooperative;
	}

}
