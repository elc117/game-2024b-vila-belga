# Vila Belga Game

## Descrição do Projeto

Vila Belga Game é um jogo educativo desenvolvido em Java usando o framework LibGDX, que explora a história da Vila Belga em Santa Maria, Rio Grande do Sul. O jogo apresenta um quiz interativo com perguntas sobre a origem, características e importância histórica da Vila Belga.

## Funcionalidades

- Quiz educativo com 5 perguntas sobre a Vila Belga
- Interface gráfica desenvolvida com LibGDX
- Sistema de pontuação
- Música de fundo e efeitos sonoros
- Tela inicial com instruções de início

## Como Jogar

1. Inicie o jogo
2. Na tela inicial, pressione ENTER para começar
3. Responda às perguntas usando as teclas numéricas (1-4)
4. Ao final do quiz, veja sua pontuação
5. Pressione R para reiniciar o jogo

## Requisitos

- Java Development Kit (JDK) 8 ou superior
- LibGDX framework

## Instalação

1. Clone o repositório
2. Importe o projeto em sua IDE
3. Baixe as dependências do LibGDX
4. Configure o classpath e as bibliotecas necessárias

## Tecnologias Utilizadas

- Linguagem: Java
- Framework: LibGDX
- Renderização: SpriteBatch
- Fonte: BitmapFont
- Gerenciamento de Input: Classe Input do LibGDX

## Referências e Recursos

### LibGDX (Framework de Desenvolvimento de Jogos)
- Site Oficial: https://libgdx.com/
- Repositório GitHub: https://github.com/libgdx/libgdx
- Documentação: https://libgdx.com/dev/

### Tutoriais e Documentação
- Tutoriais do LibGDX: 
  - https://github.com/libgdx/libgdx/wiki/Tutorials
  - https://github.com/libgdx/libgdx/wiki/Starter-classes-and-configuration

### Inspirações e Conceitos
- Padrões de design para gerenciamento de estado de jogo
- Conceitos de UI em jogos 2D

### Componentes Específicos
- SpriteBatch: Classe nativa do LibGDX para renderização
- BitmapFont: Renderização de texto em jogos 2D
- Input: Gerenciamento de entrada do usuário

![imagem_2024-12-11_210417390](https://github.com/user-attachments/assets/fcbcd7e8-c627-4a5a-94aa-ada46709c9f0)

## Diagrama de Classes do Vila Belga Game
O diagrama representa a estrutura organizacional do jogo, mostrando as principais classes e suas interações:
## Classe Main

Função principal: Gerenciar o ciclo de vida do jogo
Responsabilidades:

Inicialização do jogo (create())
Renderização contínua (render())
Gerenciamento de recursos (dispose())


Componentes principais:

SpriteBatch: Para renderização de gráficos
Texture: Para imagens do jogo
Music: Para música de fundo
QuizManager: Para gerenciar o quiz



## Classe QuizManager

Função: Gerenciar a lógica do quiz
Características:

Armazena perguntas e respostas
Controla o estado atual do quiz
Gerencia a pontuação


## Métodos principais:

iniciarQuiz(): Começa um novo quiz
renderQuiz(): Renderiza perguntas e opções
verificarResposta(): Valida as respostas do jogador



## Relações entre Classes

A classe Main contém (composição) o QuizManager
Usa múltiplos componentes do LibGDX como:

Texture: Para imagens
SpriteBatch: Para renderização
BitmapFont: Para texto
Music: Música de fundo


## Componentes LibGDX Importantes

SpriteBatch: Responsável por renderizar gráficos
BitmapFont: Renderiza texto no jogo
Texture: Carrega e gerencia imagens
Music: Reproduz música de fundo
FitViewport: Gerencia o viewport do jogo

## Fluxo de Funcionamento

Classe Main inicializa o jogo
QuizManager é instanciado
Renderização acontece continuamente
Entrada do usuário é processada
Quiz é gerenciado com pontuação e estad


## Autores

[Eduardo Possani e Gloria Pedroso]
