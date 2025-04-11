package AlgoComp;

// A Java program to find maximal
// Bipartite matching.
import java.lang.*;

class GFG
{
    // M is number of applicants
    // and N is number of jobs
    private int M; // Number of applicants
    private int N; // Number of jobs

    public GFG(int M, int N) {
        this.M = M;
        this.N = N;
    }

    // A DFS based recursive function that
    // returns true if a matching for
    // vertex u is possible
    boolean bpm(boolean[][] bpGraph, int u,
                boolean[] seen, int[] matchR)
    {
        // Try every job one by one
        for (int v = 0; v < N; v++)
        {
            // If applicant u is interested
            // in job v and v is not visited
            if (bpGraph[u][v] && !seen[v])
            {

                // Mark v as visited
                seen[v] = true;

                // If job 'v' is not assigned to
                // an applicant OR previously
                // assigned applicant for job v (which
                // is matchR[v]) has an alternate job available.
                // Since v is marked as visited in the
                // above line, matchR[v] in the following
                // recursive call will not get job 'v' again
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                        seen, matchR))
                {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // Returns maximum number
    // of matching from M to N
    int maxBPM(boolean[][] bpGraph)
    {
        // An array to keep track of the
        // applicants assigned to jobs.
        // The value of matchR[i] is the
        // applicant number assigned to job i,
        // the value -1 indicates nobody is assigned.
        int[] matchR = new int[N];

        // Initially all jobs are available
        for(int i = 0; i < N; ++i)
            matchR[i] = -1;

        // Count of jobs assigned to applicants
        int result = 0;
        for (int u = 0; u < M; u++)
        {
            // Mark all jobs as not seen
            // for next applicant.
            boolean[] seen =new boolean[N] ;
            for(int i = 0; i < N; ++i)
                seen[i] = false;

            // Find if the applicant 'u' can get a job
            if (bpm(bpGraph, u, seen, matchR))
                result++;
        }
        return result;
    }

    // Driver Code
    public static void main (String[] args)
            throws java.lang.Exception
    {
        // Let us create a bpGraph shown
        // in the above example
        boolean[][] bpGraph = new boolean[][]{
                {false, true, true,
                        false, false, false},
                {true, false, false,
                        true, false, false},
                {false, false, true,
                        false, false, false},
                {false, false, true,
                        true, false, false},
                {false, false, false,
                        false, false, false},
                {false, false, false,
                        false, false, true}};

        boolean[][] bpGraph2 = new boolean[][]{
                {true, false, false, false, false, false},
                {false, true, false, false, false, false},
                {false, false, true, false, false, false},
                {false, false, false, true, false, false},
                {false, false, false, false, true, false},
                {false, false, false, false, false, true}
        };


        boolean[][] bpGraph3 = new boolean[][]{
                {true, true, false, false},
                {true, false, false, false},
                {false, true, true, false},
                {false, false, true, true},
                {false, false, false, true},
                {false, false, false, false}
        };


        GFG m = new GFG(6, 6);
        System.out.println( "Maximum number of applicants that can"+
                " get job is "+ m.maxBPM(bpGraph));
        GFG mm = new GFG(6, 6);
        System.out.println( "Maximum number of applicants that can"+
                " get job is "+ mm.maxBPM(bpGraph2));
        GFG mmm = new GFG(6, 4);
        System.out.println( "Maximum number of applicants that can"+
                " get job is "+ mmm.maxBPM(bpGraph3));
    }
}

