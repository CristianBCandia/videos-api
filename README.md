# videos

## Deploy na Heroku
Este projeto foi hospedado na Heroku e está disponível para teste em https://nttdata-video-app.herokuapp.com

## Testando a API
### Busa por videos por nome de banda ou artista
- Busque por uma lista de videos atraves do endpoint https://nttdata-video-app.herokuapp.com/videos?band_name=eminem, para personalizar sua busca basta substiuir o nome "eminem" pelo nome de uma banda ou artista

### Busca por comentários referentes a um vídeo

- Para buscar comentário referentes a um vídeo utilize o endpoint https://nttdata-video-app.herokuapp.com/videos/ {id} /comments
- Exemplo: https://nttdata-video-app.herokuapp.com/videos/_Yhyp-_hX2s/comments

### Busca por playlist

- Busque por uma playlist utilizando o pasando o <i>query param</i> "<b>id</b>" referente ao id da playlist conforme no exemplo abaixo
- Exemplo: https://nttdata-video-app.herokuapp.com/playlists?PL7E436F1EC114B001

### Paginação
- Por padrão sua consulta retornará paginada com 20 resultados de busca, para redifinir a paginação utilize o <i>query param</i> <b>"size"</b> Ex: https://nttdata-video-app.herokuapp.com/videos?band_name=eminem&size=10
- Para carregar a próxima ou a página anterior utilize os valores de retorno "<b>nextPage</b>" e <b>prevPage</b>, colocando seu respectivo valor em um <i>query param</i> nomeado <b>"page"</b>
- Ex (próxima página): https://nttdata-video-app.herokuapp.com/videos?band_name=eminem&page=CBQQAA
- Ex (página anterior) https://nttdata-video-app.herokuapp.com/videos?band_name=eminem&page=CBQQAQ

## Iniciando

Siga os passoa abaixo para rodar o projeto em sua máquina.

## Clonando o Projeto

Abra um terminal de sua preferência e digite os seguintes comandos

```
cd existing_repo
git remote add origin https://gitlab.com/n4516/videos.git
git branch -M main
git push -uf origin main
```

## Pré-requisitos
- Para rodar o projeto será necessário <a href="https://www.devmedia.com.br/instalacao-e-configuracao-do-pacote-java-jdk/23749">instalar o JDK do java 8+ </a> em sua máquina
- Você também precisará <a href=""> instalar o Intellij IDE </a> ou uma IDE para Java de sua preferência.
