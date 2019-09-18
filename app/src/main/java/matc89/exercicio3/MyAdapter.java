package matc89.exercicio3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.PriorityQueue;

public class MyAdapter extends ArrayAdapter<Tarefa> {

    public MyAdapter(Context context, List<Tarefa> tarefas){
        super(context, 0, tarefas);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;

        Tarefa tarefa = getItem(position);
        if(tarefa!= null){
            if(view == null){
                LayoutInflater inflater = (LayoutInflater) getContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                view = inflater.inflate(android.R.layout.simple_list_item_2, null);

                ViewHolder myHolder = new ViewHolder();
                myHolder.textDescricao = view.findViewById(android.R.id.text1);
                myHolder.textPrioridade = view.findViewById(android.R.id.text2);
                view.setTag(myHolder);
            }
            ViewHolder myHolder = (ViewHolder) view.getTag();
            myHolder.textDescricao.setText(tarefa.getDescricao());
            myHolder.textPrioridade.setText("Prioridade: " + String.valueOf(tarefa.getPrioridade()));
        }
        return view;
    }

    static class ViewHolder {
        public TextView textDescricao;
        public TextView textPrioridade;
    }
}
