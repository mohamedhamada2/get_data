package com.example.mhamada.session13;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by M.Hamada on 01/05/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
     ArrayList<Contact>list;
     Context context;
     Adapter(ArrayList<Contact>list,Context context){
         this.context=context;
         this.list=list;
     }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
     Contact contact=list.get(position);
     holder.name.setText(contact.getName());
     holder.email.setText(contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
       TextView name;
       TextView email;
        public Holder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txtname);
            email=itemView.findViewById(R.id.txtemail);
        }
    }
}
