package com.antonioleiva.mvpexample.app.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.antonioleiva.mvpexample.app.R;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private LayoutInflater layoutInflater;
    private ItemClickListener listener;
    private ArrayList<String> items;


    public MainAdapter(ArrayList<String> items, ItemClickListener listener) {
        Log.e("MainAdapter", "MainAdapter: ");

        this.items = items;
        this.listener = listener;
    }

    /**
     * Functional interface
     * A functional interface is an interface that contains one and only one abstract method.
     */

    /**
     * interface Listener {
     * void onItemClicked(String item);
     * <p>
     * }
     * <p>
     * public interface ItemClickListener {
     * void onClick(View view, int position, boolean isLongClick);
     * }
     * <p>
     * <p>
     * private Listener listener;
     */

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        TextView v = (TextView) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.food_item, parent, false);
        layoutInflater = LayoutInflater.from(parent.getContext());
        View row = layoutInflater.inflate(R.layout.food_item, parent, false);

        MainViewHolder mainViewHolder = new MainViewHolder(row);
//        mainViewHolder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onClick( int position, boolean isLongClick, String btnType) {
////                Toast.makeText(this, " "+position, Toast.LENGTH_SHORT).show();
//                Log.e("onClick: ", position + "");
//            }
//        });
//        mainViewHolder.onClick();

        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
//        final String item = items.get(position);
//        holder.textView.setText(item);
//        holder.textView.setOnClickListener(v -> listener.onItemClicked(item));

        holder.food_name.setText(items.get(position));

        holder.food_image.setOnClickListener(f -> listener.onClick(position, false, "background"));
        holder.like_image.setOnClickListener(f -> listener.onClick(position, false, "like"));
        holder.fav_image.setOnClickListener(f -> listener.onClick(position, false, "fav"));
        holder.share_image.setOnClickListener(f -> listener.onClick(position, false, "share"));
//        holder.delete_img.setOnClickListener(f -> listener.onClick(position, false, "delete"));

        holder.delete_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAt(position);
                listener.onClick(position, false, "delete");
            }
        });

        /** using lambda expression*/
//        holder.delete_img.setOnClickListener((View v) -> {
//            removeAt(position);
//            listener.onClick(position, false, "delete");
//
//        });

//        holder.quick_cart_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("onClick: ", "quick_cart_img");
//
//            }
//        });
//        holder.like_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("onClick: ", "like_image");
//
//            }
//        });
//
//        holder.share_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("onClick: ", "share_image");
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        public ImageView food_image, like_image, fav_image, share_image, delete_img;
        TextView food_name;

        MainViewHolder(View itemView) {
            super(itemView);

            food_name = itemView.findViewById(R.id.food_name);
            food_image = itemView.findViewById(R.id.food_image);

            like_image = itemView.findViewById(R.id.like);
            fav_image = itemView.findViewById(R.id.fav);
            share_image = itemView.findViewById(R.id.imgShare);
            delete_img = itemView.findViewById(R.id.delete_img);

//            itemView.setOnClickListener(this);

        }


//        private ItemClickListener itemClickListener;

//        public void setItemClickListener(ItemClickListener itemClickListener) {
//            this.itemClickListener = itemClickListener;
//        }
//
//        @Override
//        public void onClick(int position, boolean isLongClick, String btnType) {
//
//            Log.e( "onClick: ", btnType);
//        }


//
//        @Override
//        public void onClick(View v) {
//            itemClickListener.onClick(v, getAdapterPosition(), false,);
//        }
    }

    public void removeAt(int position) {
        Log.e("removeAt: ", position + "");
        items.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, items.size());
    }
}
