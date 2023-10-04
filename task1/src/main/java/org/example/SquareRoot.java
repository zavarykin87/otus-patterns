package org.example;

public class SquareRoot {

    double[] solve(double a, double b, double c) {
        Double da = a;
        Double db = b;
        Double dc = c;
        if (da.equals(Double.NaN) || db.equals(Double.NaN) || dc.equals(Double.NaN)) {
            throw new IllegalArgumentException("argument can not be NaN");
        }
        if (da.equals(Double.POSITIVE_INFINITY) || db.equals(Double.POSITIVE_INFINITY) || dc.equals(Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("argument can not be positive infinity");
        }
        if (da.equals(Double.NEGATIVE_INFINITY) || db.equals(Double.NEGATIVE_INFINITY) || dc.equals(Double.NEGATIVE_INFINITY)) {
            throw new IllegalArgumentException("argument can not be negative infinity");
        }

        double[] result = new double[0];
        double epsilon = 0.001;
        if (Math.abs(a) <= epsilon) {
            throw new IllegalArgumentException("first coefficient can not be zero");
        }
        double discriminant = b*b - 4*a*c;
        if (discriminant < -epsilon) {
            return result;
        } else if (discriminant > epsilon) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            result = new double[]{x1, x2};
        } else if (Math.abs(discriminant) <= epsilon) {
            double x1 = -b / (2 * a);
            double x2 = -b / (2 * a);
            result = new double[]{x1, x2};
        }
        return result;
    }
}
