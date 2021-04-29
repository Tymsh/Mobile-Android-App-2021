package umn.ac.id.week11_31135;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class postAdapter extends RecyclerView.Adapter<postAdapter.postViewHolder> {

    private final ArrayList<data> data;
    public DataAdapter(ArrayList<data> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String textUid = "UID: " + data.get(position).getUserId();
            String textId = "ID: " + data.get(position).getId();

            holder.tvTitle.setText(data.get(position).getTitle());
            holder.tvBody.setText(data.get(position).getBody());
            holder.tvUid.setText(textUid);
            holder.tvId.setText(textId);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView tvTitle, tvBody, tvUid, tvId;

            public ViewHolder(View view) {
                super(view);

                tvTitle = view.findViewById(R.id.textViewTitle);
                tvBody = view.findViewById(R.id.textViewBody);
                tvUid = view.findViewById(R.id.textViewUid);
                tvId = view.findViewById(R.id.textViewId);
            }
        }
    }