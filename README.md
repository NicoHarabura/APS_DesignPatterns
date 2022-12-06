# APS_DesignPatterns

Alunos 
125111373105 RA - NICOLAU HARABURA
125111351384 RA - Douglas Fidelis Lopes
125111375288 RA - Rafael Alexandre das graças
125111345177 RA - Daniel Pereira Nascimento    
125111347652 RA - Leonardo Cassiolato Silva
125111350080 RA - Fabricio Santana do Carmo

----------------------------------------------------------------------------------------------------------------------------------------------------------------------

# O que são padrões de projetos

Padrões de projetos (ou Design Patterns inglês) são soluções gerais para problemas recorrentes durante o desenvolvimento de softwares. Não é um framework ou um código de ouro, mas uma definição de alto nível para resolver problema comum e repetido.

Em 1978 Christopher Alexander, Sara Ishikawa e Murray Silverstein escreveram um livro chamado “A Pattern Language: Towns, Buildings, Construction” e neste livro foram catalogados 253 tipos de problemas, as causas por trás de cada um deles e propondo uma solução padrão para os mesmos.

Mas esses conceitos foram verdadeiramente conhecidos em 1994, quando os engenheiros de software Erich Gamma, Richard Helm, Ralph Johnson e John Vlissides escreveram o livro “Design Patterns: Elements of Reusable Object-Oriented Software”, catalogando 23 padrões que utilizaram ao longo de suas carreiras. Os autores desse livro ficaram conhecidos como Gang of Four (Gangue dos quatro) ou “GoF”. E são os padrões deles que iremos aprofundar.  Mais precisamente 3 padrões: Prototype, Composite e Strategy.


# Prototype

Prototype está como um padrão de projeto criação (Creational Design Patterns). A ideia por trás do ‘Protótipo’ é simples: clonar um objeto já existente, gerando um novo objeto a partir dele. Esse novo objeto criado, será alterado de acordo com suas necessidades sem fazer seu código ficar dependente de suas classes.

Mas quando e porque seria útil utilizarmos essa solução? Bom digamos que sua aplicação em determinado momento precisa gerar 30 objetos idênticos ao protótipo em tempo de execução, e que desses objetos criados sofrerão alteração em apenas um único atributo cada um. Então normalmente você tem que criar um novo objeto da mesma classe e teria que ir por todos os campos do objeto original e copiar seus valores para o novo objeto.  Mas ai vamos nos deparar com o primeiro problema, Nem todos os objetos podem ser copiados dessa forma porque alguns campos de objeto podem ser privados e não serão visíveis fora do próprio objeto. Outro problema é que se precisamos saber a classe do objeto para criar uma cópia, o código se torna dependente daquela classe.

É aí que o Prototype se torna útil. Ele delega o processo de clonagem para o próprio objeto que está sendo clonado, declarando uma interface comum entre eles. Dessa forma é possível clonar um objeto sem acoplar seu código à classe daquele objeto. Geralmente, essa interface contém apenas um único método clonar.
A implementação do método ‘clonar’ é muito parecida em todas as classes: ele cria um objeto da classe atual e carrega todos os valores de campo para do antigo objeto para o novo. Assim podemos copiar até campos privados porque a maioria das linguagens de programação permite que objetos acessem campos privados de outros objetos que pertençam a mesma classe. Um objeto que suporta clonagem é chamado de um protótipo (o nosso Prototype). 

Vantagens de se usar o Prototype: Clonar objetos sem acoplá-los a suas classes concretas; Acabar com códigos de inicialização repetidos, clonando protótipos pré-construídos; Criar objetos complexos facilmente; Herança alternativa quando precisar tratar configurações pré-determinadas para objetos complexos.
E uma desvantagem seria a complexidade em clonar objetos que possuem referências circulares.


# Composite

A intenção do Composite é montar uma árvore onde tanto as folhas (objetos individuais) quanto os compostos (grupos de objetos) sejam tratados de maneira igual. O Composto é um padrão de projeto Estrutural. Quando falamos em termos de orientação a objetos, isso significa aplicarmos polimorfismo e assim chamar métodos de um objeto na árvore sem nos preocuparmos se ele é uma folha ou um composto.
Para isso os objetos em estruturas de árvore representam hierarquias parte-todo, permitindo tratarmos de maneira uniforme objetos individuais e composições de objetos.
Dentro da estrutura do Composite, temos 3 participantes: O Componente que é a interface que define métodos comuns às classes dentro da composição e, por opção, define uma interface para acessar o objeto “pai” de um componente; A Folha, que não possui filhos (está nas extremidades da árvore); O Composto, que é um componente composto por outros componentes, que podem ser folhas ou outros compostos.

Para entendermos melhor, vamos pensar em quando e como usar esse padrão. Primeiro: Composite só faz sentido quando o modelo central da aplicação pode ser representado como uma árvore. Por exemplo, uma aplicação com 2 objetos: Produtos e Caixas. 1 Caixa pode ter vários Produtos e também Caixas menores dentro dela. As mesmas Caixas menores por sua vez, podem ter mais Produtos ou até mesmo Caixas menores dentro delas, e assim por diante. E por fim, o software irá precisar processar os pedidos desse sistema e calcular, por exemplo, o valor total desse pedido.
Para implementar um código para esse problema, (um sistema que use essas classes onde os pedidos podem conter produtos simples sem qualquer compartimento ou como caixas com mais produtos ou outras caixas!) seria tentar uma solução direta: abrir todas as caixas, verificar cada produto e então calcular o total. Isso não seria tão simples como executar uma iteração. É preciso conhecer s classes dos Produtos e Caixas que você está examinando, o grau de aninhamento das caixas e o que está contido nelas. Por fim teríamos uma solução direta muito confusa ou até impossível.

Nessa situação o Composite viria como uma ótima ajuda. Trabalhando com as classes Produtos e Caixas através de uma interface comum que declara um método para a contagem do preço total. Ou seja, cada produto retorna simplesmente o preço dele. Então para cada caixa, o sistema teria que ver cada item que ela contém, chamar o método do seu preço e então retornar o total para essa caixa. Caso um desses itens for uma caixa menor, aquela caixa também deve verificar seu conteúdo e os preços de cada produto e assim em diante, até que o preço de todos os componentes internos seja calculado. Uma caixa pode um método que adiciona um custo extra para o preço final, como um preço de embalagem, taxa por peso e etc.
Vantagens desde padrão: Trabalhar com estruturas de árvore complexas mais convenientemente; Introduzir novos tipos de elemento na aplicação sem quebrar o código existente, o que agora funciona com a árvore de objetos.
Uma desvantagem é a dificuldade em implementar uma interface comum para classes cuja funcionalidade difere muito. Em certos cenários, você precisaria generalizar muito a interface componente, fazendo dela uma interface de difícil compreensão.


# Strategy

Talvez o mais popular dos padrões, não por acaso um com a ideia mais simples (obviamente não tirando em nada o mérito de ser usado, muito pelo contrário). O Strategy (Estratégia) é um padrão de projeto Comportamental e ele permite: definir uma família de algoritmos; coloca-los em classes separadas; e fazem com que os objetos deles sejam intercambiáveis.

Simples, e pode ser aplicado afim de resultados muito uteis. Vamos usar de exemplo uma aplicação similar a outras mais conhecida, um calculador ou planejador de rotas. Onde o usuário pode informar um endereço e ver a rota mais rápida no mapa para quem dirige. Mas nem todo mundo tem ou vai usar carro e moto para chegar no destino. Alguns usuários podem ir a pé. Outras pessoas podem utilizar o transporte público, ou ir de bicicleta. Uma grande ideia de aplicativo, mas a parte técnica e de manutenção de código seria bem complicada. Por exemplo ao adicionava um novo algoritmo de rota, a classe principal do navegador dobra de tamanho. Seguindo nossa ideia, no final do projeto, o código seria 4 vezes maior.
Assim qualquer mudança a um dos algoritmos ou uma simples correção de bug afeta toda a classe, aumentando a chance de criar um erro no código já existente. Sem falar que a programação em equipe seria ineficiente, com muito tempo resolvendo conflitos de fusão de código. E a implementação de novas funcionalidades causaria mudanças muito grandes na classe, conflitando com os códigos criados por outras pessoas.

O Estratégia usa uma classe que faz algo específico em diversas maneiras diferentes e transfere todos esses algoritmos para classes separadas chamadas Estratégias. A classe original, chamada de contexto, precisa de um campo para armazenar uma referência para um dessas estratégias. A classe contexto delega o trabalho para um objeto estratégia ao invés de executá-lo por conta própria.
Então o contexto não é responsável por selecionar um algoritmo apropriado para o trabalho: o usuário passa a estratégia desejada para o contexto, e ele trabalha com todas as estratégias através de uma interface genérica, que somente expõe um único método para acionar o algoritmo encapsulado dentro da estratégia selecionada. Assim o contexto se torna independente das estratégias e podemos adicionar novos algoritmos ou modificar os existentes sem interferir no código do contexto ou outras estratégias.

Retornando ao nosso aplicativo de rotas, cada algoritmo pode ser extraído para sua própria classe com um único método montarRota() por exemplo. O método aceita uma origem e um destino e retorna uma coleção de pontos da rota para cada tipo de transporte. Mesmo com os mesmos argumentos, cada classe de roteamento pode construir uma rota diferente, e a classe navegadora principal não se com qual algoritmo é selecionado uma vez que seu trabalho é renderizar um conjunto de pontos num mapa. A classe tem um método para trocar a estratégia ativa de rota, de forma dinâmica.
