package io.github.some_GameVB;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class QuizManager {
    private String[] perguntas = { 
        "Quando os imigrantes belgas chegaram à Vila Belga em Santa Maria?", 
        "Qual era o principal propósito da Vila Belga quando foi construída?", 
        "A Vila Belga foi fundada por imigrantes de qual país?", 
        "Qual é a principal característica arquitetônica da Vila Belga?", 
        "A Vila Belga foi tombada como patrimônio histórico em qual década??" 
    };
    
    private String[][] respostas = { 
        {"1875", "1900", "1850", "1920"}, 
        {"Ser um centro comercial da cidade", "Acomodar trabalhadores ferroviários", "Servir como base militar", "Ser um bairro para imigrantes franceses"}, 
        {"Alemanha", "França", "Bélgica", "Itália"}, 
        {"Casas com estilo europeu", "Casas de madeira", "Casas coloridas", "Casas modernas"}, 
        {"1960", "1980", "1990", "2000"} 
    };
    
    private int[] respostasCorretas = {0, 1, 2, 0, 2}; // Índices das respostas corretas
    
    private int perguntaAtual = 0;
    private int pontuacao = 0;
    private boolean quizEmAndamento = false;
    
    private BitmapFont font;
    private SpriteBatch batch;
    private GlyphLayout layout;
    
    public QuizManager(SpriteBatch batch) {
        this.batch = batch;
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(1.5f);
        layout = new GlyphLayout();
    }
    

    private void drawCenteredText(String text, float y) {
        layout.setText(font, text);
        float x = (Gdx.graphics.getWidth() - layout.width) / 2;
        font.draw(batch, text, x, y);
    }
    
    public void iniciarQuiz() {
        perguntaAtual = 0;
        pontuacao = 0;
        quizEmAndamento = true;
    }
    
    public void renderQuiz() {
        if (!quizEmAndamento) return;
        

        drawCenteredText(perguntas[perguntaAtual], Gdx.graphics.getHeight() - 250);
        

        for (int i = 0; i < respostas[perguntaAtual].length; i++) {
            String opcao = (i+1) + ": " + respostas[perguntaAtual][i];
            drawCenteredText(opcao, Gdx.graphics.getHeight() - 350 - (i * 50));
        }
        

        processarEntrada();
    }
    
    private void processarEntrada() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) verificarResposta(0);
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) verificarResposta(1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) verificarResposta(2);
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) verificarResposta(3);
    }
    
    private void verificarResposta(int indiceResposta) {
        if (indiceResposta == respostasCorretas[perguntaAtual]) {
            pontuacao++;
        }
        
        // Próxima pergunta ou finalizar quiz
        perguntaAtual++;
        if (perguntaAtual >= perguntas.length) {
            finalizarQuiz();
        }
    }
    
    private void finalizarQuiz() {
        quizEmAndamento = false;
        System.out.println("Quiz finalizado! Pontuação: " + pontuacao + " de " + perguntas.length);
    }
    
    public boolean estaEmAndamento() {
        return quizEmAndamento;
    }
    

    public void renderPontuacao() {
        String textoPontuacao = "Pontuação Final: " + pontuacao + " de " + perguntas.length;
        drawCenteredText(textoPontuacao, Gdx.graphics.getHeight() / 2);
    }
    
    public int getPontuacao() {
        return pontuacao;
    }
    
    public int getTotalPerguntas() {
        return perguntas.length;
    }
    
    public void dispose() {
        font.dispose();
    }
}