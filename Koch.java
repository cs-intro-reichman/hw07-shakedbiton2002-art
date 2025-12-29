/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		// Base case n=0
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        } 

        StdDraw.line(x1, y1, x2, y2);

        double x3 = x1 + (x2-x1) / 3;
        double y3 = y1 + (y2-y1) / 3;
        double x4 = x1 + 2 * (x2-x1) / 3;
        double y4 = y1 + 2 * (y2-y1) / 3;
        double xMid = 0.5 * (x1 + x2) + Math.sqrt(3) * (y1 - y2) / 6;
        double yMid = 0.5 * (y1 + y2) + Math.sqrt(3) * (x2 - x1) / 6;

        curve(n - 1, x1, y1, x3, y3);
        curve(n - 1, x3, y3, xMid, yMid);
        curve(n - 1, xMid, yMid, x4, y4);
        curve(n - 1, x4, y4, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
        StdDraw.setXscale(-0.5, 1.5); 
        StdDraw.setYscale(-Math.sqrt(3) / 2 - 0.1, Math.sqrt(3) / 2 + 0.1);

        double[] xVertex = { 0.0, 1.0, 0.5 };
        double[] yVertex = { 0.0, 0.0, -Math.sqrt(3) / 2 };

        curve(n, xVertex[0], yVertex[0], xVertex[1], yVertex[1]);  // Side 1
        curve(n, xVertex[1], yVertex[1], xVertex[2], yVertex[2]);  // Side 2
        curve(n, xVertex[2], yVertex[2], xVertex[0], yVertex[0]);  // Side 3

	}
}
