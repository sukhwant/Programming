package mission.red.leetcode.medium;

import java.util.Arrays;

public class NetworkConnections {

    public int find(int[] parent, int i)
    {
        if (parent[i] == -1)
            return i;

        if(i == parent[i]){
            return i;
        }

        parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    public void union(int[] parent, int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);

        parent[xset] = yset;
    }

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1)
            return -1;

        int[] parent = new int[connections.length + 1 ];
        Arrays.fill(parent, -1);

        int components = n;

        for (int i = 0; i < connections.length; i++) {
            int x = find(parent, connections[i][0]);
            int y = find(parent, connections[i][1]);

            if (x != y)
                components--;

            union(parent, x, y);
        }
        return components - 1;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};

        System.out.println(new NetworkConnections().makeConnected(n, connections));
    }
}
