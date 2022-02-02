import decide.Connectors;
import decide.Coordinate;
import decide.Decider;
import decide.Parameters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LIC2_Test {

    @Test
	void testLIC2_0() {//example that does not work
        Parameters test_params = new Parameters(10, 3.4, 3, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 4);
        points[1] = new Coordinate(3, 2);
        points[2] = new Coordinate(1, 3);
        points[3] = new Coordinate(4, 4);
        points[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points, test_params, new Connectors[5][5], new boolean[5][5]);

        assertFalse(decide.lic2());
    }

    @Test
	void testLIC2_1() {//Example that works 
        Parameters test_params = new Parameters(10, 3.4, 1, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 4);
        points[1] = new Coordinate(3, 2);
        points[2] = new Coordinate(1, 3);
        points[3] = new Coordinate(4, 4);
        points[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points, test_params, new Connectors[5][5], new boolean[5][5]);

        assertTrue(decide.lic2());
    }

    @Test
	void testLIC2_2() {// If Epsilon = 0
        Parameters test_params = new Parameters(10, 3.4, 0, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 4);
        points[1] = new Coordinate(3, 2);
        points[2] = new Coordinate(1, 3);
        points[3] = new Coordinate(4, 4);
        points[4] = new Coordinate(1, 85);

        Decider decide = new Decider(5, points, test_params, new Connectors[5][5], new boolean[5][5]);

        assertTrue(decide.lic2());
    }

    @Test
    void testLIC2_3() {//Less than 3 points
        Parameters test_params = new Parameters(10, 3.4, 1, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 4);
        points[1] = new Coordinate(3, 2);

        Decider decide = new Decider(2, points, test_params, new Connectors[5][5], new boolean[5][5]);

        assertFalse(decide.lic2());
    }

    @Test
    void testLIC2_4() {//with 2 identical points 
        Parameters test_params = new Parameters(10, 3.4, 1, 1.0, 34, 12, 3.4,
                5, 4, 3, 2, 1, 4, 3, 2, 5, 2.03, 4.34, 3.4);

        Coordinate[] points = new Coordinate[5];
        points[0] = new Coordinate(1, 4);
        points[1] = new Coordinate(3, 2);
        points[2] = new Coordinate(3, 2);

        Decider decide = new Decider(3, points, test_params, new Connectors[5][5], new boolean[5][5]);

        assertFalse(decide.lic2());
    }
}