package matc89.exercicio3;

import android.support.annotation.NonNull;

public class Tarefa implements Comparable<Tarefa>{
    private String descricao;
    private int prioridade;

    public Tarefa(){}

    public Tarefa(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setPrioridade(int prioridade){
        this.prioridade = prioridade;
    }

    @Override
    public int compareTo(@NonNull Tarefa o) {
        return this.getPrioridade() - o.getPrioridade();
    }

}
