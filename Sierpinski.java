public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		// Setting up the canvas size and scale
		StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		
		// Setting the coordinates of the vertices of the equilateral triangle
		double[] xVertex = { 0.0, 1.0, 0.5 };
		double[] yVertex = { 0.0, 0.0, Math.sqrt(3) / 2 };
		sierpinski(n, xVertex[0], xVertex[1], xVertex[2], yVertex[0], yVertex[1], yVertex[2]);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3, double y1, double y2, double y3) {
		// Base Case: Number of iterations reaches 0.
        if (n == 0)
        return;

        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);

        // Finding the midpoints of the triangle's sides
        double x1Mid = (x1 + x2) / 2;
        double y1Mid = (y1 + y2) / 2;
        double x2Mid = (x2 + x3) / 2;
        double y2Mid = (y2 + y3) / 2;
        double x3Mid = (x3 + x1) / 2;
        double y3Mid = (y3 + y1) / 2;

        // Recursive calls for the 3 smaller triangles
        sierpinski(n - 1, x1, x1Mid, x3Mid, y1, y1Mid, y3Mid); // Top
        sierpinski(n - 1, x1Mid, x2, x2Mid, y1Mid, y2, y2Mid); // Left
        sierpinski(n - 1, x2Mid, x3, x3Mid, y2Mid, y3, y3Mid); // Right
	}
}
