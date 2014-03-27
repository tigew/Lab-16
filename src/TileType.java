import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TileType {

    private String[] floorType;
    static int test = 0;

    private final String tileTypes[][] = {{"s", "STATUE"}, {"d", "DIFFICULT"}, {"c", "SACRED_CIRCLE"}, {"u", "SUMMONING_CIRCLE"}, {"^", "SPIKE_STONES"}, {"r", "RISKY"},
            {"6", "BLOOD_ROCK"}, {"h", "HAUNTED"}, {"p", "PIT"}, {"l", "LAVA"}, {"k", "SMOKE"}, {"f", "FOREST"}, {"t", "TELEPORTER"}, {"e", "ELEMENTAL_WALL"}, {"z", "ZONE_OF_DEATH"},
            {"\\", "STEEP_SLOPE"}, {"~", "WATERFALL"}, {"a", "START_A"}, {"b", "START_B"}, {"A", "VICTORY_A"}, {"B", "VICTORY_B"}, {"x", "exit_A"}, {"z", "exit_B"}, {"w", "SOLID"},
            {"0", "GRID"}, {"m", "CREATURE"}};

    public TileType(int x, int y, String map)
    {
        floorType = getTile(x, y, map);
    }

    private String[] getTile(int x, int y, String map)
    {
        ArrayList<String> output = new ArrayList<String>();
        String line = "";
        String[] chuncks = {};
        String[] single = {};
        String[] done = {};
        try {
            FileInputStream fs = new FileInputStream(map + ".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            for (int i = 0; i < x; i++)
            {
                br.readLine();
            }
            line = br.readLine();
            test++;
            chuncks = line.split(" ");
            if (chuncks[y].length() > 1)
            {
                single = chuncks[y].split("");
                for (int j = 0; j > single.length;j++)
                {
                    output.add(single[j]);
                }
            }
            else
            {
                output.add(chuncks[y]);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        }
        done = output.toArray(new String[output.size()]);
        done = translateTile(done);
        return done;
    }

    private String[] translateTile(String[] tile)
    {
        ArrayList<String> output = new ArrayList<String>();
        String[] done = {};
        for (int i = 0; i < tile.length;i++)
        {
            for (int j = 0; j < tileTypes.length;j++)
            {
                if (tile[i].equalsIgnoreCase(tileTypes[j][0]))
                {
                    output.add(tileTypes[j][1]);
                }
            }
        }
        done = output.toArray(new String[output.size()]);
        return done;
    }

    public String[] getFloorType() {
        return this.floorType;
    }

}