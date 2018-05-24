package com.starks.donatebooks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by RCP on 5/16/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder>{

    List<Postfeed> listdata;

    public RecyclerAdapter(List<Postfeed> listdata) {
        this.listdata = listdata;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }


    public void onBindViewHolder(MyHolder holder, int position) {
        Postfeed data = listdata.get(position);
        holder.vbname.setText(data.getStrBookName());
        holder.vcat.setText(data.getStrCategory());
        holder.vsubcat.setText(data.getStrSubcat());
        holder.vaddress.setText(data.getStrLoc());
        //holder.vcont.setText(data.getCinfo());
        holder.vdesc.setText(data.getDescription());

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView vbname,vaddress,vcat,vsubcat,vcont,vdesc;
        ItemClickListener itemClickListener;

        public MyHolder(View itemView) {
            super(itemView);
            vbname = itemView.findViewById(R.id.texttitle);
            vaddress =  itemView.findViewById(R.id.location);
            vcat =  itemView.findViewById(R.id.category);
            vsubcat =  itemView.findViewById(R.id.subcategory);
            //vcont = itemView.findViewById(R.id.contact);
            vdesc = itemView.findViewById(R.id.descrip);
        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener=itemClickListener;
        }

        @Override
        public void onClick(View view) {
            //Toast.makeText(this,"Clicked",Toast.LENGTH_LONG).show();
             clicked();

        }



    }

    private void clicked() {
       // Toast.makeText(this,"Clicked", Toast.LENGTH_LONG).show();
    }


}
