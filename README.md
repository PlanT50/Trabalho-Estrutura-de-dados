# Escalonador de Processos 

**Disciplina:** Algoritmos e Estrutura de Dados I  
**Professor:** Dimmy Magalhães  
  

# Integrante:
Manoel Alves Nunes Bezerra - 0030720


## 📖 Descrição do Projeto
Este projeto implementa um **escalonador de processos** para o sistema fictício *iCEVOS*.  
O escalonador gerencia **múltiplos níveis de prioridade** e aplica uma regra de **prevenção de inanição** (anti-starvation), além de lidar com **processos bloqueados por recurso** (ex.: DISCO).  


---

## ⚙️ Estrutura do Código
O projeto está dividido em 5 classes principais:

- **Processo.java** → Estrutura que representa cada processo (id, nome, prioridade, ciclos, recurso).  
- **ListaDeProcessos.java** → Lista encadeada implementada manualmente para gerenciar processos.  
- **Scheduler.java** → Contém a lógica central do escalonador (execução por ciclos, anti-inanição, bloqueio e desbloqueio).  
- **LeitorDeProcessos.java** → Responsável por ler os processos de um arquivo TXT.  
- **Main.java** → Ponto de entrada do programa.  

---

## 📂 Entrada de Dados
O programa recebe os processos a partir de um arquivo texto chamado **`processos.txt`**, no formato:
1,Google,2,5,null

1 - O id do processo|
Google - Nome do processo|
2 - Nivel de prioridade|
5 - Ciclos necessários|
null - Recurso necessário|

ADENDO-
O nivel de prioridade vai de 1 a 3|
O numero de ciclos máximo é 20|
Há dois recursos disponiveis: null ou DISCO(Deve obrigatoriamente ser escrito em maiusculo)|
Todos os parâmetros devem ser separados por virgula.

