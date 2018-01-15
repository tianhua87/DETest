package DeApp1.problem;

import DeApp1.de.T_DEOptimizer;

public class Branin extends DEProblem{

    double   lower_limit;
    double   higer_limit;

    public Branin(){
        best = new double [dim = 2];
        lower_limit = -5;
        higer_limit = 15;
    }

    @Override
    public boolean completed ()
    /***********************************************************
     ** Is TRUE if the value-to-reach (VTR) has been reached   **
     ** or passed.                                             **
     ***********************************************************/
    {
        if (Math.abs (mincost - 0.397889 ) <= 1.0e-6)
        {
            for(int i = 0;i<dim; i++)
                System.out.print(best[i]+ " ");
            System.out.println();
        }
        return Math.abs (mincost - 0.397889 ) <= 1.0e-6;
    }

    @Override
    public double evaluate(T_DEOptimizer t_DEOptimizer, double[] X, int dim) {
        double s, x0;
        x0 = X[0];
        s = X[1] -
                ( 5.1/(4.0*Math.PI*Math.PI) * x0 - 5.0/Math.PI) * x0 - 6.0;
        return s*s + 10*(1.0 - 1.0/(8.0*Math.PI)) * Math.cos(x0) + 10.0;
    }
}
