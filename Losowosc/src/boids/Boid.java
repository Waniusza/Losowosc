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

import java.awt.geom.Point2D;


public class Boid {

	/**
	 * The boid location (fields are modified the the object is never reallocated hence final)
	 */
	final Point2D.Double location = new Point2D.Double(100 * Math.random(),
			100 * Math.random());

	/**
	 * The boid flight vector
	 */
	final Point2D.Double speed = new Point2D.Double(Math.random(), Math
			.random());

	/**
	 * The flock where this boid belongs. The flock is not final, can theoretically change.
	 */
	Flock flock;

	/**
	 * Fly in the direction, determined by the flight vector.
	 * 
	 * @param time the duration of the model iteration. 
	 */
	public void moveAhead(double time) {
		location.x += speed.x * time * Constants.stepTime;
		location.y += speed.y * time * Constants.stepTime;

		if (flock.cooperative) {
			if (!flock.scared)
				matchSpeed(time);
			keepSpeed(time);
			flyTowardsCenterOfMass(time);
		}
		keepAway(time);
		bounceFromWalls();
	}

	/**
	 * Try to keep the speed the same as speed of other boids.
	 */
	protected void matchSpeed(double time) {
		// Compute the perceive center.
		double x = 0;
		double y = 0;

		// Do not count self
		int n = flock.size() - 1;
		for (Boid boid : flock)
			if (boid != this) {
				x += boid.speed.x;
				y += boid.speed.y;
			}

		x /= n;
		y /= n;

		// Compute the vector toward center
		double vx = x - speed.x;
		double vy = y - speed.y;

		speed.x += vx * Constants.speedAdjust * time;
		speed.y += vy * Constants.speedAdjust * time;
	}

	/**
	 * Fly towards the perceived center of mass
	 */
	protected void flyTowardsCenterOfMass(double time) {

		// Compute the perceive center.
		double x = 0;
		double y = 0;

		// Do not count self
		int n = flock.size() - 1;
		for (Boid boid : flock)
			if (boid != this) {
				x += boid.location.x;
				y += boid.location.y;
			}

		x /= n;
		y /= n;

		// Compute the vector toward center
		double vx = x - location.x;
		double vy = y - location.y;

		// If scared, fly AWAY from the center of mass
		if (flock.scared) {
			vx = -vx;
			vy = -vy;
		}

		move(time, vx, vy, Constants.holdFlockCenter);
	}

	/**
	 * Accelerate if too slow.
	 */
	public void keepSpeed(double time) {

		double v = Math.sqrt(speed.x * speed.x + speed.y * speed.y);
		double r = Constants.minSpeed - v;

		if (r > 0 && v < Constants.maxSpeed)
			r = 1 + Constants.speedAdjust;
		else
			r = 1 - Constants.speedAdjust;

		speed.x *= r;
		speed.y *= r;
	}

	/**
	 * Service method to move
	 * @param time the time quant
	 * @param vx x speed vector
	 * @param vy y speed vector
	 * @param weight the weight of this move
	 */
	private void move(double time, double vx, double vy, double weight) {
		location.x += vx * weight * time;
		location.y += vy * weight * time;
	}

	/**
	 * Keep away from walls and other boids
	 */
	protected void keepAway(double time) {
		double vx = 0;
		double vy = 0;

		// Do not try to keep away from himself
		for (Boid boid : flock) {
			double distance = boid.location.distance(location);
			if (boid != this && distance < Constants.keepAwayDistance) {
				// Handle degenerate case when boids are at the same location.
				if (distance < 1)
					distance = 1;

				// Make force inverse proportional to the distance.
				double s = 1 / distance;
				vx += s * (location.x - boid.location.x);
				vy += s * (location.y - boid.location.y);
			}
		}
		move(time, vx, vy, Constants.avoidNeibourthood);
	}

	/**
	 * Bounce from the boundaries of the modeling space (like bats in the cave). To avoid sticking on the boundary
	 * (altering vector on every iteration), this must be the last method to call.
	 */
	protected void bounceFromWalls() {

		// Soft bounce (keep away)
		if (location.x < Constants.keepAwayDistance) {
			speed.x += Constants.avoidNeibourthood;
		}

		if (location.y < Constants.keepAwayDistance) {
			speed.y += Constants.avoidNeibourthood;
		}

		if (location.x > flock.size.width - Constants.keepAwayDistance) {
			speed.x -= Constants.avoidNeibourthood;
		}

		if (location.y > flock.size.height - Constants.keepAwayDistance) {
			speed.y -= Constants.avoidNeibourthood;
		}

		// Hard bounce
		if (location.x < 0) {
			location.x = 0;
			speed.x = -speed.x;
		}

		if (location.y < 0) {
			location.y = 0;
			speed.y = -speed.y;
		}

		if (location.x > flock.size.width) {
			location.x = flock.size.width;
			speed.x = -speed.x;
		}

		if (location.y > flock.size.height) {
			location.y = flock.size.height;
			speed.y = -speed.y;
		}
	}

}
