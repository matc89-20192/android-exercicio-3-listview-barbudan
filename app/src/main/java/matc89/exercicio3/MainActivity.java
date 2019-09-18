package matc89.exercicio3;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MyAdapter listAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private Button btnAdd;
    private Button btnRemove;
    private EditText desc;
    private EditText prioridade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.buttonAdicionar);
        btnRemove = (Button) findViewById(R.id.buttonRemover);
        desc = (EditText) findViewById(R.id.editDescricao);
        prioridade = (EditText) findViewById(R.id.editPrioridade);
        btnRemove.setEnabled(false);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Tarefa t = (Tarefa) listView.getItemAtPosition(position);
                listaTarefas.remove(t);
                if(listaTarefas.isEmpty()){
                    btnRemove.setEnabled(false);
                }
                listAdapter.notifyDataSetChanged();
            }
        });
        listAdapter = new MyAdapter(this, listaTarefas);
        listView.setAdapter(listAdapter);
    }

    public void adicionar(View view){
        Tarefa t = new Tarefa();
        t.setDescricao(desc.getText().toString());
        t.setPrioridade(Integer.parseInt(prioridade.getText().toString()));
        String s = prioridade.getText().toString();

        if(t.getDescricao().equals("") || s.equals("")) {
            return;
        }
        for(Tarefa x : listaTarefas){
            if(t.getDescricao().equals(x.getDescricao())){
                Toast.makeText(this, "Tarefa já cadastrada.", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        if(t.getPrioridade()<1 || t.getPrioridade()>10){
            Toast.makeText(this, "A prioridade deve estar entre 1 e 10.", Toast.LENGTH_SHORT).show();
            return;
        }

        listaTarefas.add(t);
        Collections.sort(listaTarefas);
        btnRemove.setEnabled(true);
        listAdapter.notifyDataSetChanged();
    }

    public void remover(View view){
        listaTarefas.remove(listaTarefas.get(0));
        if(listaTarefas.isEmpty()){
            btnRemove.setEnabled(false);
        }
        listAdapter.notifyDataSetChanged();
    }
}
