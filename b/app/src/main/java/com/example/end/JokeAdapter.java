package com.example.end;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    private List<String> jokes;
    private OnJokeClickListener listener;

    public JokeAdapter(List<String> jokes, OnJokeClickListener listener) {
        this.jokes = jokes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_joke, parent, false);
        return new JokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        String joke = jokes.get(position);
        holder.textView.setText(joke);

        holder.itemView.setOnClickListener(v -> listener.onJokeClick(joke));
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }

    public interface OnJokeClickListener {
        void onJokeClick(String joke);
    }

    public static class JokeViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.joke_name);
        }
    }
}
