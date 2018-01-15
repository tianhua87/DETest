package DeApp1.problem;

import DeApp1.de.T_DEOptimizer;

public class Beale extends DEProblem {

    int      evaluation_samples;
    double   lower_limit;
    double   higer_limit;

    public Beale(){
        best = new double [dim = 2];
        lower_limit = -4.5;
        higer_limit = 4.5;
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
    public double evaluate(T_DEOptimizer t_DEOptimizer, double[] X, int dim) {
        return Math.pow(1.5 - X[0] + X[0]*X[1], 2) +
                Math.pow(2.25 - X[0] + X[0] * X[1]*X[1], 2) +
                Math.pow(2.625 - X[0] + X[0] * Math.pow(X[1], 3), 2);
    }
}
