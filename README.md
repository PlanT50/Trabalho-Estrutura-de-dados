# Escalonador de Processos com Listas de Prioridade e Prevenção de Inanição

**Disciplina:** Algoritmos e Estrutura de Dados I  
**Professor:** Dimmy Magalhães  
**Projeto P1 – Valor: 40% da avaliação**  

# Integrante:
Manoel Alves Nunes Bezerra - 0030720


## 📖 Descrição do Projeto
Este projeto implementa um **escalonador de processos** para o sistema fictício *iCEVOS*.  
O escalonador gerencia **múltiplos níveis de prioridade** e aplica uma regra de **prevenção de inanição** (anti-starvation), além de lidar com **processos bloqueados por recurso** (ex.: DISCO).  

Todas as listas de processos foram implementadas **do zero**, sem o uso de estruturas prontas do Java (`ArrayList`, `LinkedList`, `Queue`, etc.), conforme exigido no enunciado.  

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

