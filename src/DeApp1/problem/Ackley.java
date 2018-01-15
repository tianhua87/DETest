package DeApp1.problem;

import DeApp1.de.T_DEOptimizer;

public class Ackley extends DEProblem {

    int      evaluation_samples;
    double   lower_limit;
    double   higer_limit;

    public Ackley(){
        best = new double [dim = 5];
        lower_limit = -30;
        higer_limit = 30;
        evaluation_samples = 60;
    }

    @Override
    public boolean completed ()
    /***********************************************************
     ** Is TRUE if the value-to-reach (VTR) has been reached   **
     ** or passed.                                             **
     ***********************************************************/
    {
        if (mincost <= 1.0e-6)
        {
            for(int i = 0;i<dim; i++)
                System.out.print(best[i]+ " ");
            System.out.println();
        }
        return mincost <= 1.0e-6; // TRUE if mincost is <= 1.e-6
    }

    @Override
    public double evaluate(T_DEOptimizer t_DEOptimizer, double[] x, int n) {
        int i;
        double t, s1, s2;
        s1 = s2 = 0.0;
        for (i = 0; i < n; i++) {
            t = x[i];
            s1 += t * t;
            s2 += Math.cos(2.0*Math.PI * x[i]);
        }
        return -20.0 * Math.exp(-0.2 * Math.sqrt(s1/n)) - Math.exp(s2 / n) +
                20.0 + Math.E;
    }
}
