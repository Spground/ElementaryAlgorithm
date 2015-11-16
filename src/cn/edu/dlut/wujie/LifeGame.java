package cn.edu.dlut.wujie;

/**
 * Created by wujie on 2015/11/15.
 * The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, 
 * each of which is in one of two possible states, alive or dead. Every cell interacts with its eight 
 * neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each 
 * step in time, the following transitions occur:

    1.Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    2.Any live cell with two or three live neighbours lives on to the next generation.
    3.Any live cell with more than three live neighbours dies, as if by over-population.
    4.Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.


The initial pattern constitutes the seed of the system. The first generation is created by applying 
the above rules simultaneously to every cell in the seed¡ªbirths and deaths occur simultaneously, and 
the discrete moment at which this happens is sometimes called a tick (in other words, each generation is 
a pure function of the preceding one). The rules continue to be applied repeatedly to create further generations.
 */
public class LifeGame {
    private int[][] life;

    public LifeGame(int[][] originLife){
        this.life = originLife;
    }

    public int[][] getNextGenLife(int[][] oldGenLife){
        this.life = oldGenLife;
        int[][] nextGen = new int[this.life.length][this.life[0].length];
        for(int i = 0; i < life.length; i++)
            for(int j = 0; j < life[i].length; j++ )
                nextGen[i][j] = getNextGenStatus(i + 1, j + 1);
        return nextGen;
    }
    
    /**
     *
     * @param x cell's row index (range 1 to r)
     * @param y cell's clomun index (range 1 to c)
     * @return the next status of the cell
     */
    private  final int getNextGenStatus(int x, int y){
        //no life living off the edge
        if((y == 1) || (y == life[0].length) || (x == 1 || x == life.length ))
            return 0;
        int neighborNums = getLivingNeighborNums(x, y);
        //rule
        if(neighborNums < 2 || neighborNums > 3 )
            return 0;
        if(neighborNums == 3)
            return 1;
        //return status as the same as  it's current status
        return life[x - 1][y - 1];
    }

    /**
     * get the number of living neighbor by giving x, y
     * @param x :the row index (range 1 to r)
     * @param y : the column index (range 1 to c)
     * @return the number of living neighbor
     */
    private final int getLivingNeighborNums(int x, int y){
        int cnt = 0;
        //eight directions 
        int[][] dir = {{-1,-1}, {-1,0}, {-1,1}, {1,-1}, {1,0}, {1,1},{0,-1}, {0,1}};
        for(int i = 0; i < 8; i++){
            int xx = dir[i][0] + x - 1;
            int yy = dir[i][1] + y - 1;
            cnt += life[xx][yy];
        }
        return cnt;
    }
}