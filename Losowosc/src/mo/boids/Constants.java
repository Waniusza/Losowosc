

package mo.boids;


public class Constants {

	/**
	 * Conversion between the model time and real time.
	 */
	public static double stepTime = 0.1;

	/**
	 * The "fly towards center" factor.
	 */
	public static double holdFlockCenter = 0.001;

	public static double avoidNeibourthood = 0.01;

	/**
	 * The number of boids in the flock.
	 */
	public static int count = 8;

	/**
	 * The keep away zone around boids
	 */
	public static double keepAwayDistance = 50;

	/**
	 * Minimal speed (accelerate if slower).
	 */
	public static double minSpeed = 2;

	/**
	 * Max speed (slow down if faster).
	 */
	public static double maxSpeed = minSpeed * 5;

	/**
	 * The acceleration for speed adjustment.
	 */
	public static double speedAdjust = 0.001;

}
