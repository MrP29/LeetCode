//DFS (Time: O(N * M) Space: O(N * M))
class Solution {
    char[][] board;
    int ROW;
    int COL;
    
    public void solve(char[][] board) {
        this.board = board;
        this.ROW = board.length;
        this.COL = board[0].length;
        
        for(int r = 0; r < ROW; r++) {
            if(board[r][0] == 'O')
                dfs(r, 0);
            if(board[r][COL - 1] == 'O')
                dfs(r, COL - 1);
        }
        
        for(int c = 1; c < COL - 1; c++) {
            if(board[0][c] == 'O')
                dfs(0, c);
            if(board[ROW - 1][c] == 'O')
                dfs(ROW - 1, c);
        }
        
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                board[r][c] = board[r][c] == 'E' ? 'O' : 'X';
            }
        }
        
        return;
    }
    
    private void dfs(int r, int c) {
        if(r < 0 || r >= ROW || c < 0 || c >= COL || board[r][c] != 'O')
            return;
        
        board[r][c] = 'E';
        
        dfs(r - 1, c);
        dfs(r + 1, c); 
        dfs(r, c - 1);
        dfs(r, c + 1);
    }
}

//BFS (Time: O(N * M) Space: O(N * M))
class Solution {
    int ROW;
    int COL;
    
    public void solve(char[][] board) {
        this.ROW = board.length;
        this.COL = board[0].length;
        
        for(int r = 0; r < ROW; r++) {
            if(board[r][0] == 'O')
                bfs(board, r, 0);
            if(board[r][COL - 1] == 'O')
                bfs(board, r, COL - 1);
        }
        
        for(int c = 1; c < COL - 1; c++) {
            if(board[0][c] == 'O')
                bfs(board, 0, c);
            if(board[ROW - 1][c] == 'O')
                bfs(board, ROW - 1, c);
        }
        
        for(int r = 0; r < ROW; r++) {
            for(int c = 0; c < COL; c++) {
                board[r][c] = board[r][c] == 'E' ? 'O' : 'X';
            }
        }
        
        return;
    }
    
    private void bfs(char[][] board, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{r, c});
        while(!queue.isEmpty()) {
            r = queue.peek()[0];
            c = queue.poll()[1];
            
            if(r < 0 || r >= ROW || c < 0 || c >= COL || board[r][c] != 'O')
                continue;

            board[r][c] = 'E';
            queue.offer(new int[]{r - 1, c});
            queue.offer(new int[]{r + 1, c});
            queue.offer(new int[]{r, c - 1});
            queue.offer(new int[]{r, c + 1});
        }
    }
}