📚 Sistema Escolar em Java
📌 Sobre o projeto
Este projeto é um Sistema Escolar desenvolvido em Java com o objetivo de praticar conceitos fundamentais de programação, como:
•	CRUD (Create, Read, Update, Delete)
•	manipulação de arquivos
•	lógica de programação
•	organização de menus
•	leitura e escrita de dados em arquivos
O sistema funciona no terminal (console) e permite o gerenciamento de alunos, notas e resultados acadêmicos.
Os dados são armazenados em um arquivo .txt, simulando um pequeno banco de dados.
________________________________________
🎯 Objetivo do projeto
Este projeto foi criado como prática de estudos em Java para desenvolver habilidades em:
•	construção de sistemas com menus
•	manipulação de arquivos
•	estruturas condicionais e de repetição
•	organização de métodos
•	estrutura de dados (ArrayList)
________________________________________
⚙️ Funcionalidades do sistema
O sistema possui três áreas principais de acesso:
👩‍🎓 Área do Aluno
O aluno pode acessar seu próprio registro utilizando o ID.
Funcionalidades disponíveis:
•	visualizar suas notas
•	visualizar seu resultado final (Aprovado, Recuperação ou Reprovado)
________________________________________
👨‍🏫 Área do Professor
O professor possui acesso às seguintes funcionalidades:
•	listar alunos cadastrados
•	buscar aluno por ID
•	atualizar dados de aluno
•	calcular média de aluno
•	visualizar resultado final
•	visualizar notas dos alunos
•	adicionar nota para alunos transferidos
________________________________________
🏫 Área da Coordenação
A coordenação possui controle completo do sistema:
•	cadastrar novos alunos
•	listar alunos cadastrados
•	buscar aluno por ID
•	atualizar dados
•	calcular médias
•	visualizar resultados
•	adicionar nota transferida
•	visualizar notas dos alunos
•	deletar alunos do sistema
________________________________________
🧑‍🎓 Estrutura dos dados do aluno
Cada aluno possui as seguintes informações:
•	ID
•	Nome
•	Idade
•	Sexo
•	Nota 1
•	Nota 2
•	Nota 3
•	Nota 4
Os dados são armazenados no arquivo:
DadosdeAlunos.txt
Formato utilizado no arquivo:
id|nome|idade|sexo|nota1|nota2|nota3|nota4
Exemplo:
1|Maria|18|Feminino|15.0|18.0|20.0|17.0
________________________________________
📊 Cálculo de notas
O sistema calcula:
•	soma das notas
•	média do aluno
•	maior nota
•	menor nota
________________________________________
🏆 Resultado final
O resultado do aluno é definido com base na soma das notas:
Soma das notas	Resultado
≥ 60	APROVADO
≥ 40	RECUPERAÇÃO
< 40	REPROVADO
________________________________________
🛠 Tecnologias utilizadas
•	Java
•	Eclipse IDE
•	Git
•	GitHub
•	Manipulação de arquivos
•	ArrayList
________________________________________
📂 Estrutura do projeto
SistemaEscolar
│
├── SistemaEscolar.java
│
├── menu
│   └── Menu.java
│
├── sistema
│   └── SistemaAluno.java
│
├── aluno
│   └── Aluno.java
│
└── DadosdeAlunos.txt
________________________________________
💡 Conceitos aplicados
Durante o desenvolvimento foram utilizados diversos conceitos importantes da programação:
•	Programação orientada a objetos
•	Encapsulamento (classe Aluno)
•	Manipulação de arquivos
•	Estruturas condicionais (if, else)
•	Estruturas de repetição (while, for)
•	Conversão de tipos (parseInt, parseDouble)
•	Separação de dados com split
•	Estrutura de menus
•	Uso de ArrayList
________________________________________
Projeto desenvolvido por Larissa Caroline como prática de estudos em Java e construção de lógica de programação.
