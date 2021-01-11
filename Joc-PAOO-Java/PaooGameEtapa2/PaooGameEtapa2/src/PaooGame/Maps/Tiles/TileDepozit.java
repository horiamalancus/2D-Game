package PaooGame.Maps.Tiles;

public class TileDepozit {
    private static final int NO_TILES   = 32;
    public static Tile[] tiles = new Tile[NO_TILES];

    public static Tile rockIceTile      = new RockIceTile(1);      /*!< Dala de tip sol/roca cu gheata*/
    public static Tile rock             = new RockTile(2);

    public static void Init()
    {
        tiles[0]=null;
        tiles[1]=rockIceTile;
        tiles[2]=rock;
    }
}
