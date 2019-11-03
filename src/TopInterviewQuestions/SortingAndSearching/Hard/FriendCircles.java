package TopInterviewQuestions.SortingAndSearching.Hard;

public class FriendCircles {

    public int findCircleNum(int[][] M) {

        UnionFind uf = new UnionFind(M.length);

        for(int i = 0; i < M.length - 1; i++) {
            for(int j = i + 1; j < M[0].length; j++) {
                if(M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count;
    }

    class UnionFind {

        private int count;
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {

            count = n;
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++)
                parent[i] = i;
        }

        public int find(int p) {

            while(p != parent[p]) {

                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {

            int rootP = find(p);
            int rootQ = find(q);

            if(rootP == rootQ)
                return;

            if(rank[rootP] < rank[rootQ])
                parent[rootP] = rootQ;

            else {

                parent[rootQ] = rootP;
                if(rank[rootP] == rank[rootQ])
                    rank[rootP]++;
            }
            count--;
        }

        public int count() {
            return count;
        }
    }

}
