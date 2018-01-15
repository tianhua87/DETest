package DeApp1.problem;

import DeApp1.de.T_DEOptimizer;

public class Bohachevsky1 extends DEProblem{

    double   lower_limit;
    double   higer_limit;

    public Bohachevsky1(){
        best = new double [dim = 2];
        lower_limit = -50;
        higer_limit = 50;
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
        return X[0] * X[0] + 2.0 * X[1]*X[1]
                - 0.3 * Math.cos(3.0 * Math.PI * X[0])
                - 0.4 * Math.cos(4.0 * Math.PI * X[1])
                + 0.7;
    }
}
