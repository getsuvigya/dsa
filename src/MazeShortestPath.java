import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MazeShortestPath {

    static int maze[][] =
                   {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                    {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                    {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                    {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                    {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                    {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
    static int M = 9;
    static int N=10;

    public static void main(String[] args) {
        int visited[][]=new int[M][N];
        System.out.println(shortestDist(maze,visited,M,M,0,0,3,4,0));

    }

    public static int shortestDist(int mat[][], int visited[][], int M, int N, int i, int j, int x, int y, int dist){
        if(x==i && y==j){
            return dist;
        }
        Cell c = new Cell(i,j);
        Queue<Cell> q = new LinkedList<>();
        q.add(c);
        while (!q.isEmpty()){
            Cell c1 = q.remove();
            if(visited[c1.x][c1.y]==1){
                continue;
            }
            visited[c1.x][c1.y]=1;
            List<Cell> adjacentCells = getAdjacentCells(c1,mat);
            for(Cell adjCell : adjacentCells){
                if(visited[adjCell.x][adjCell.y]!=1){
                    adjCell.dist = c1.dist+1;
                    if(adjCell.x==x && adjCell.y==y){
                        return adjCell.dist;
                    }
                    q.add(adjCell);
                }
            }

        }
        return -1;
    }
    public static List<Cell> getAdjacentCells(Cell cell, int mat[][]){
        List<Cell> cells = new LinkedList<>();
        int x1 = cell.x-1;
        int y1 = cell.y-1;
        int x2 = cell.x+1;
        int y2 = cell.y+1;
        if(x1>=0 && mat[x1][cell.y]==1){
            Cell c1 = new Cell(x1,cell.y);
            cells.add(c1);
        }
        if(x2<N && mat[x2][cell.y]==1){
            Cell c2 = new Cell(x2,cell.y);
            cells.add(c2);
        }
        if(y1>=0 && mat[cell.x][y1]==1){
            Cell c3 = new Cell(cell.x,y1);
            cells.add(c3);
        }

        if(y2<M && mat[cell.x][y2]==1){
            Cell c4 = new Cell(cell.x,y2);
            cells.add(c4);
        }
        return cells;
    }
}

class Cell{
    int x;
    int y;
    int dist;
    public Cell(int x, int y){
        this.x=x;
        this.y=y;
    }

    public boolean equals(Object o){
        if(o.getClass().equals(Cell.class) && ((Cell)o).x==this.x && ((Cell)o).y==this.y){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return x*31+y*31;
    }
}
