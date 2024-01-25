import java.util.*;

public class graph2
{
    static class Edge
    {
        int src;
        int dest;
        // int wt;

        // public Edge(int s, int d, int w)
        public Edge(int s, int d)
        {
            this.src = s;
            this.dest = d;
            // this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[])
    {
        for(int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }

        /*
        // Kosaraju's Algorithm
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
        */

        /*
        // Bridge
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
             // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
             // graph[4].add(new Edge(4, 5));

             // graph[5].add(new Edge(5, 3));
             // graph[5].add(new Edge(5, 4));
        */

        // Tarjan's Algo
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
             graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
             graph[4].add(new Edge(4, 5));

             graph[5].add(new Edge(5, 3));
             graph[5].add(new Edge(5, 4));

    }

    public static void topSortk(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s)
    {
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest])
            {
                topSortk(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }

    public static void dfsk(ArrayList<Edge> graph[], int curr, boolean vis[])
    {
        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest])
            {
                dfsk(graph, e.dest, vis);
            }
        }
    }

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V)
    {
        // Step 1 - O(V+E)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            {
                topSortk(graph, i, vis, s);
            }
        }

        // Step 2 - O(V+E)
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i = 0; i < graph.length; i++)
        {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < V; i++)
        {
            for(int j = 0; j < graph[i].size(); j++)
            {
                Edge e = graph[i].get(j);   // e.src(i) -> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // Step 3 - O(V+E)
        while(!s.isEmpty())
        {
            int curr = s.pop();
            if(!vis[curr])
            {
                dfsk(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void dfsBridge(ArrayList<Edge> graph[], int curr, 
                boolean vis[], int dt[], int low[], int time, int par)
    {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(e.dest == par)
                continue;
            else if(!vis[e.dest])
            {
                dfsBridge(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(dt[curr] < low[e.dest])
                    System.out.println("Bridge is: " + curr + "---" + e.dest);
            }
            else
            {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge> graph[], int V)
    {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            {
                dfsBridge(graph, i, vis, dt, low, time, -1);
            }
        }
    }

    // Tarjan's Algo
    // O(V+E)
    public static void dfsAP(ArrayList<Edge> graph[], int curr, int par, 
        int dt[], int low[], boolean vis[], int time, boolean ap[])
    {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh)
                continue;
            else if(vis[neigh])
            {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
            else
            {
                dfsAP(graph, neigh, curr, dt, low, vis, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]);

                if(dt[curr] <= low[neigh] && par != -1)
                {
                    ap[curr] = true;
                }
                children++;
            }
        }

        if(par == -1 && children > 1)
        {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int V)
    {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            {
                dfsAP(graph, i, -1, dt, low, vis, time, ap);
            }
        }

        for(int i = 0; i < V; i++)
        {
            if(ap[i])
                System.out.println("AP: " + i);
        }
    }

    public static void main(String args[]) // O(V+E)
    {
        // int V = 5;  // Kosaraju, Bridge2, AP
        int V = 6;   // Bridge1
        // int V = 7;        

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        kosarajuAlgo(graph, V);
        System.out.println();

        getBridge(graph, V);
        System.out.println();

        // Tarjan's Algo
        getAP(graph, V);


    }
}