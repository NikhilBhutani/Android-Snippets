package github.nikhilbhutani.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nikhil Bhutani on 5/12/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<String> arraylist;

    //Constructor for list dataset
    public RecyclerViewAdapter(List<String> arrayList)
    {
        this.arraylist = arrayList;

    }

   //Creating new View, This method is invoked by layoutmanager
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //new view creation
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);
        return new MyViewHolder(v);
    }

    //Contents of the view replaced, this method is invoked by layout manager
    // - get element from your dataset at this position
    // - replace the contents of the view with that element
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv.setText(arraylist.get(position));
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
         TextView tv;

         MyViewHolder(View view)
         {
             super(view);
             tv = (TextView)view.findViewById(R.id.mytextview);
         }
    }
}
