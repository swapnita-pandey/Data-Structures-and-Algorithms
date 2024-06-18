class Solution {
    public static boolean dfs(Map<Integer, List<Integer>> graph, int curr, int destination, Set<Integer> visited)
    {
        if(curr == destination)
            return true;
        
        visited.add(curr);

        for (int neighbor : graph.get(curr))
        {
            if (!visited.contains(neighbor))
            {
                if(dfs(graph, neighbor, destination, visited))
                    return true;
            }           
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(graph, source, destination, visited);        
    }
}

import java.util.*;

public class graphapnacllg
{
    static class Edge
    {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w)
        // public Edge(int s, int d)
        {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[])
    {
        for(int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }

        /*
        // For printing the neighbours
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
        */

        /*
        // For traversals
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[5].add(new Edge(6, 5));
        */

        /*        
        // Cycle Undirected
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
            // graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
            // graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
        */

        /*
        // Directed Cycle Detection
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

            // graph[3].add(new Edge(3, 0));
        */

        /*
        // topSort
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        */

        /*
        // Dijkstra
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        */
        
        /*
        // Bellman Ford +ve wt cycle
        // Bellman Ford -ve wt cycle
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

            // graph[4].add(new Edge(4, 1, -1));
        
        graph[4].add(new Edge(4, 1, -10));
        */

        // Prims's Algo
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));        
    }

    public static void bfs(ArrayList<Edge> graph[], int V, boolean vis[], int start)
    {
        Queue<Integer> q = new LinkedList<>();
        // boolean vis[] = new boolean[V];
        q.add(start);

        while(!q.isEmpty())
        {
            int curr = q.remove();
            if(vis[curr] == false)
            {
                System.out.print(curr + " ");
                vis[curr] = true;

                for(int i = 0; i < graph[curr].size(); i++)
                {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[])
    {
        // O(V+E)
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == false)
                dfs(graph, e.dest, vis);
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int tar)
    {
        // O(V^V)
        if(curr == tar)
        {
            System.out.println(path);
            return;
        }

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest])
            {
                vis[curr] = true;
                printAllPath(graph, vis, e.dest, path + " " + e.dest, tar);
                vis[curr] = false;
            }
        }
    }

    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean vis[], int curr, int par)
    {
        vis[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] && e.dest != par)
            {
                return true;
            }
            else if(!vis[e.dest])
            {
                if(isCycleUndirected(graph, vis, e.dest, curr))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[])
    {
        vis[curr] = true;
        rec[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(rec[e.dest])
            {
                // cycle
                return true;
            }
            else if(!vis[e.dest])
            {
                if(isCycleDirected(graph, vis, e.dest, rec))
                    return true;
            }
        }
        rec[curr] = false;
        return false;
    }
    
    public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack)
    {
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);

            if(!vis[e.dest])
            {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void topSort(ArrayList<Edge> graph[], int V)
    {
        boolean vis[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            {
                topSortUtil(graph, i, vis, stack);
            }
        }
        
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop() + " ");
        }
    }

    public static class Paird implements Comparable<Paird>
    {
        int node;
        int dist;

        public Paird(int n, int d)
        {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Paird p2)
        {
            return this.dist - p2.dist; // ascending
            // return p2.dist - this.dist;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src, int V)
    {
        // O(E + E log V)
        PriorityQueue<Paird> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for(int i = 0; i < V; i++)
        {
            if(i != src)
            {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[V];

        pq.add(new Paird(0, 0));

        while(!pq.isEmpty())
        {
            Paird curr = pq.remove();   // shortest
            if(!vis[curr.node])
            {
                vis[curr.node] = true;

                for(int i = 0; i < graph[curr.node].size(); i++)
                {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.wt < dist[v])    // relaxation
                    {
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Paird(v, dist[v]));
                    }
                }
            }
        }

        for(int i = 0; i < V; i++)
        {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src, int V)
    {
        int dist[] = new int[V];
        for(int i = 0; i < V; i++)
        {
            if(i != src)
            {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        for(int k = 0; k < V-1; k++)    // O(V)
        {
            for(int i = 0; i < V; i++)  // O(E)
            {
                for(int j = 0; j < graph[i].size(); j++)
                {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.dest;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v])
                    {
                        dist[v] = dist[u] + e.wt;
                    }
                }
            }
        }

        // detect -ve wt cycles
        for(int i = 0; i < V; i++)
        {
            for(int j = 0; j < graph[i].size(); j++)
            {
                Edge e = graph[i].get(j);
                int u = e.src;
                int v = e.dest;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v])
                {
                    System.out.println("Negative wt cycle");
                }
            }
        }

        for(int i = 0; i < dist.length; i++)
        {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static class Pairc implements Comparable<Pairc>
    {
        int node;
        int cost;

        public Pairc(int n, int c)
        {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pairc p2)
        {
            return this.cost - p2.cost; // ascending
        }
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int V)
    {
        // (node - int, cost - int)
        PriorityQueue<Pairc> pq = new PriorityQueue<>(); // ElogE // non-mst
        boolean vis[] = new boolean[V]; // mst
        pq.add(new Pairc(0, 0));

        int mstCost = 0;

        while(!pq.isEmpty())
        {
            Pairc curr = pq.remove();
            if(!vis[curr.node])
            {
                vis[curr.node] = true;
                mstCost += curr.cost;

                for(int i = 0; i < graph[curr.node].size(); i++)
                {
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.dest])
                    {
                        pq.add(new Pairc(e.dest, e.wt));
                    }
                }
            }
        }
        System.out.println("Min cost of mst = " + mstCost);
    }

    public static void main(String args[]) // O(V+E)
    {
        // int V = 10;
        // int V = 12;
        // int V = 4;
        // int V = 7;
        // int V = 5;  // Bellman Ford
        // int V = 6;  // TopSort
        int V = 4; // Prim's
        /*
                1 ---3
               /     | \
              0      |  5 -- 6
               \     | /
                2 ---4
        */

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);


        //print 2's neighbours
        System.out.print("2's neighbours: ");
        for(int i = 0; i < graph[2].size(); i++)
        {
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
            //System.out.println(e.dest + " , " + e.wt);
        }
        System.out.println();
        System.out.println();


        System.out.print("BFS: ");
        boolean vis[] = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            if(vis[i] == false)
            {
                bfs(graph, V, vis, i);
            }
        }
        System.out.println();
        System.out.println();

        for(int i = 0; i < V; i++)
        {
            vis[i] = false;
        }

        System.out.print("DFS: ");
        for(int i = 0; i < V; i++)
        {
            if(vis[i] == false)
            {
                dfs(graph, i, vis);
            }
        }
        System.out.println();
        System.out.println();

        for(int i = 0; i < V; i++)
        {
            vis[i] = false;
        }

        System.out.println("Print all Path: ");
        int src = 0, tar = 5;
        printAllPath(graph, new boolean[V], src, "0", tar);
        System.out.println();

        for(int i = 0; i < V; i++)
        {
            vis[i] = false;
        }

        System.out.println("Is Cycle Undirected? ");
        System.out.println(isCycleUndirected(graph, new boolean[V], 0, -1));
        System.out.println();

        for(int i = 0; i < V; i++)
        {
            vis[i] = false;
        }

        System.out.println("Is Cycle Directed? ");
        boolean rec[] = new boolean[V];
        int m = 0;
        for(int i = 0; i < V; i++)
        {
            if(!vis[i])
            {
                boolean isCycle = isCycleDirected(graph, vis, 0, rec);
                if(isCycle)
                {
                    m = 1;
                    System.out.println(isCycle);
                    break;
                }
                // System.out.println(isCycleDirected(graph, new boolean[V], 0, new boolean[V]));
            }
        }
        if(m == 0)
        {
            System.out.println(false);
        }
        System.out.println();

        for(int i = 0; i < V; i++)
        {
            vis[i] = false;
        }

        System.out.println("Top Sort: ");
        topSort(graph, V);
        System.out.println();
        System.out.println();

        System.out.println("Dijkstra: ");
        dijkstra(graph, 0, V);
        System.out.println();

        System.out.println("Bellman Ford Algo: ");
        bellmanFord(graph, 0, V);
        System.out.println();

        System.out.println("Prims Algo: ");
        primsAlgo(graph, V);
        System.out.println();

    }
}
