package game;

//determine what is in view and to remember what has already been seen
public class FieldOfView {
    private World world;

    private boolean[][] visible;
    public boolean isVisible(int x, int y){
        return x >= 0 && y >= 0 && x < visible.length && y < visible[0].length && visible[x][y];
    }

    private Tile[][] tiles;
    public Tile tile(int x, int y){
        return tiles[x][y];
    }

    public FieldOfView(World world){
        this.world = world;
        this.visible = new boolean[world.width()][world.height()];
        this.tiles = new Tile[world.width()][world.height()];

        for (int x = 0; x < world.width(); x++){
            for (int y = 0; y < world.height(); y++){

                tiles[x][y] = Tile.UNKNOWN;

            }
        }
    }

    public void update(int wx, int wy, int r){
        visible = new boolean[world.width()][world.height()];

        for (int x = -r; x < r; x++){
            for (int y = -r; y < r; y++){
                if (x*x + y*y > r*r)
                    continue;

                if (wx + x < 0 || wx + x >= world.width()
                        || wy + y < 0 || wy + y >= world.height())
                    continue;

                for (Point p : new Line(wx, wy, wx + x, wy + y)){
                    Tile tile = world.tile(p.x, p.y);
                    visible[p.x][p.y] = true;
                    tiles[p.x][p.y] = tile;

                    if (!tile.isGround())
                        break;
                }
            }
        }
    }
}