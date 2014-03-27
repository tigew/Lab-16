import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by chc238u20 on 3/13/14.
 */
public class Map {

    private TileType tileType[][];
    private String map;
    private int mapX;
    private int mapY;

    public Map(String cCapname)
    {
        map = cCapname;
        mapX = getXaxis(map);
        mapY = getYaxis(map);
        tileType = new TileType[mapY][mapX];
        getTileTypes();
    }

    private void getTileTypes()
    {
        for (int i = 0; i < this.mapY; i++)
        {
            for (int j = 0; j < this.mapX; j++)
            {
                tileType[i][j] = new TileType(i, j, this.map);
            }
        }
    }

    public void listTiles()
    {
        String[] loop = {};
        for (int i = 0; i < this.mapY;i++)
        {
            for (int j = 0; j < this.mapX;j++)
            {
                loop = tileType[i][j].getFloorType();
                for (int k = 0; k < loop.length;k++)
                {
                    System.out.println(loop[k]);
                }
            }
        }
    }

    private int getYaxis(String map)
    {
        int count = 0;
        String test = "";
        try {
            FileInputStream fs = new FileInputStream(map + ".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            while(true)
            {
                test = br.readLine();
                if (test == null)
                {
                    break;
                }
                count++;
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        }
        return count;
    }

    private int getXaxis(String map)
    {
        int count = 0;
        String test = "";
        String[] testSplit;
        try {
            FileInputStream fs = new FileInputStream(map + ".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));

            test = br.readLine();
            testSplit = test.split(" ");
            count = testSplit.length;
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        }
        return count;
    }
}
