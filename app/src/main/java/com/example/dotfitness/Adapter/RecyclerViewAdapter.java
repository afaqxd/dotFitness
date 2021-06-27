package com.example.dotfitness.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dotfitness.Model.Exercises;
import com.example.dotfitness.R;
import com.example.dotfitness.TimerActivity;

import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    List<Exercises> ExercisesList;
    Context context;
    OnExerciseListener mOnExerciseListener;

    public RecyclerViewAdapter(List<Exercises> ExercisesList, Context context,OnExerciseListener onExerciseListener) {
        this.ExercisesList = ExercisesList;
        this.context = context;
        this.mOnExerciseListener = onExerciseListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view,mOnExerciseListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Exercises temp = ExercisesList.get(position);

        Exercises Exercises = ExercisesList.get(position);
        holder.txIndex.setText(Exercises.getIndex());
        holder.txExerciseName.setText(Exercises.getExercise_name());
        holder.txExerciseName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TimerActivity.class);
                intent.putExtra("exerIndex",temp.getIndex());
                intent.putExtra("exerName",temp.getExercise_name());
                intent.putExtra("exerNumber",position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

                if(position==0){
                    final MediaPlayer mp1 = MediaPlayer.create(context, R.raw.armraises);
                    mp1.start();
                }if(position==1){
                    final MediaPlayer mp1 = MediaPlayer.create(context, R.raw.tricepsdips);
                    mp1.start();
                }if(position==2){
                    final MediaPlayer mp1 = MediaPlayer.create(context, R.raw.diamondpushups);
                    mp1.start();
                }if(position==3){
                    final MediaPlayer mp1 = MediaPlayer.create(context, R.raw.jumpingjacks);
                    mp1.start();
                }if(position==4){
                    final MediaPlayer mp1 = MediaPlayer.create(context, R.raw.diagonalplank);
                    mp1.start();
                }if(position==5){
                    final MediaPlayer mp1 = MediaPlayer.create(context, R.raw.burpees);
                    mp1.start();
                }if(position==6){
                    final MediaPlayer mp1 = MediaPlayer.create(context, R.raw.armscissors);
                    mp1.start();
                }if(position==7){
                    final MediaPlayer mp1 = MediaPlayer.create(context, R.raw.shouldergators);
                    mp1.start();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return ExercisesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnExerciseListener onExerciseListener;
        TextView txIndex,txExerciseName;
        ImageView image_delete;

        public ViewHolder(@NonNull View itemView,OnExerciseListener onExerciseListener) {
            super(itemView);

            txIndex = itemView.findViewById(R.id.tv_stName);
            txExerciseName = itemView.findViewById(R.id.tv_stRoll);
            this.onExerciseListener = onExerciseListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onExerciseListener.OnExerciseClick(getAdapterPosition());
        }
    }

    public interface OnExerciseListener{

        void OnExerciseClick(int position);

    }
}
