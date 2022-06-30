package com.weijinqian.dfs;

public class PowerSolution {
    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent >= 0) {
            return PositivePower(base, exponent);
        } else {
            return 1.0 / PositivePower(base, -exponent);
        }
    }

    private double PositivePower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent % 2 == 0) {
            double res = Power(base, exponent / 2);
            res = res * res;
            return res;
        } else {
            double res = Power(base, (exponent - 1) / 2);
            res = res * res * base;
            return res;
        }
    }
}
