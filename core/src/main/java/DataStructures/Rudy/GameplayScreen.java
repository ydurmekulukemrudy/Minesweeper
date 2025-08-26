package DataStructures.Rudy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameplayScreen implements Screen{
    //object that draws all of our sprite graphics: JPEG, PNG, etc. 
    private SpriteBatch spriteBatch;

    //object that draws shapes: rectangle, ovals, lines, etc.
    private ShapeRenderer shapeRenderer;

    //object that allows a view of the virtual world 
    private Camera camera;

    //object that controls how the camera views the world
    //zoom in/out? Keep everything scaled?
    private Viewport viewport;

    private GameBoard board;
    
    /*
     * This runs one time at the very beginning
     * all setup should happen here
     *      loading graphics
     *      start values for variables
     */
    @Override
    public void show() {
        //OrthographicCamera is a 2D camera
        camera = new OrthographicCamera();

        //set the camera position to the middle of the world
        camera.position.set(1280/2, 720/2, 0);

        //required to save and update the camera changes above
        camera.update();

        //freeze my view to 1280x720, no
        //matter the resolution of the window the camera will
        //always show the same amount of world space
        viewport = new FitViewport(1280, 720);

        //empty initialization of objects that will draw graphics for us
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        //???????????????????????????????????, this is the solution to an annoying problem I had :P
        shapeRenderer.setAutoShapeType(true);

        board = new GameBoard(this);
    }

    /*
     * this method runs as fast as it can(or to a set FPS)
     * repeatedly, constantly looped
     * Things to include in this method:
     *      (1) Process user input
     *      (2) A.I.
     *      (3) Draw all graphics 
     */
    @Override
    public void render(float delta) {
        //get player input

        //process player input, AI

        //all drawings of shapes MUST go bbetween begin/end
        shapeRenderer.begin();
        shapeRenderer.end();

        //all graphics must go between begin/end
        spriteBatch.begin();
        board.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        shapeRenderer.dispose();
    }

}
