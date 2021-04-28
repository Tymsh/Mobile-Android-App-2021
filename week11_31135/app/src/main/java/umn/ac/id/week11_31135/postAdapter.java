package umn.ac.id.week11_31135;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class postAdapter extends RecyclerView.Adapter<postAdapter.postViewHolder> {

    ArrayList<retrofitModel> posts;

    public postAdapter(ArrayList<retrofitModel> posts){ this.posts = posts; }

    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new postViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull postViewHolder holder, int position) {
        holder.tvTitle.setText(posts.get(position).getTitle());
        holder.tvBody.setText(posts.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class postViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvBody;

        public postViewHolder(@NonNull View itemView){
            super(itemView);

            tvBody = itemView.findViewById(R.id.tvBody);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
