 package com.example.taskapp26.ui.home;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.taskapp26.R;
import com.example.taskapp26.interfacee.OnItemClickListener;
import com.example.taskapp26.ui.OnclickPositionn;
import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.Viewholder>{

    private ArrayList<String> list = new ArrayList<>();
    private OnclickPositionn onclickPositionn;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public TaskAdapter() {

    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_task,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    public void addList(ArrayList<String> list) {
        this.list.addAll(list );
        notifyDataSetChanged();
    }

    public void addItem(String text) {
        list.add(text);
        notifyItemInserted(list.size()- 1);
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        private TextView textView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(getAdapterPosition());
                onclickPositionn.clickListener(getAdapterPosition());
               //  Toast.makeText(this, "паст на "+ getAdapterPosition(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void bind(String s) {
            textView.setText(s);
            if (getAdapterPosition() % 2 == 0)
                itemView.setBackgroundColor(itemView.getResources().getColor(R.color.design_default_color_primary_dark));
            else
                itemView.setBackgroundColor(itemView.getResources().getColor(R.color.design_default_color_secondary ));
        }
    }
}
