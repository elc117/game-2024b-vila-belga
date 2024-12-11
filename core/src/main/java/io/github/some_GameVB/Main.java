package io.github.some_GameVB;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture background;
    private Music music;
    private Texture tremtexture;
    private Texture trilhotexture;
    private Sound tremsound;
    private FitViewport viewport;
    private Texture retangulo;
    private Texture caixa;
    private QuizManager quizManager;
    private BitmapFont font;
    private GlyphLayout layout;
    private boolean gameStarted = false;

    @Override
    public void create() {
        batch = new SpriteBatch();
        caixa = new Texture("retangulor.png");
        background = new Texture("vilinha.jpg");
        retangulo = new Texture("retangulo.png");

        trilhotexture = new Texture("trilho.png");
        tremtexture = new Texture("trenzinho.png");
        tremsound = Gdx.audio.newSound(Gdx.files.internal("tremsom.mp3"));

        viewport = new FitViewport(20, 10);

        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.07f);
        music.play();

        quizManager = new QuizManager(batch);


        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(2f);
        layout = new GlyphLayout();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(retangulo, 5, 20, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (!gameStarted) {

            drawCenteredText("Vila Belga Game", Gdx.graphics.getHeight() - 200);
            

            drawCenteredText("Pressione ENTER para iniciar", Gdx.graphics.getHeight() - 300);


            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                gameStarted = true;
                quizManager.iniciarQuiz();
            }
        } else {
            if (quizManager.estaEmAndamento()) {
                quizManager.renderQuiz();
            } else if (!quizManager.estaEmAndamento() && quizManager.getPontuacao() > 0) {
                quizManager.renderPontuacao();
                drawCenteredText("Pressione R para reiniciar", Gdx.graphics.getHeight() / 2 - 100);

                if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                    quizManager.iniciarQuiz();
                }
            }
        }

        batch.end();
    }

    private void drawCenteredText(String text, float y) {
        layout.setText(font, text);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        font.draw(batch, text, x, y);
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        tremtexture.dispose();
        trilhotexture.dispose();
        tremsound.dispose();
        music.dispose();
        retangulo.dispose();
        quizManager.dispose();
        font.dispose();
    }
}
