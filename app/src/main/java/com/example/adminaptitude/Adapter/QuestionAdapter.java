package com.example.adminaptitude.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminaptitude.ModelData.Modeldata;
import com.example.adminaptitude.R;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>
{
    private List<Modeldata.ModelQuestion> modelqsnlist;
    private Context context;

    public QuestionAdapter(List<Modeldata.ModelQuestion> modelqsnlist, Context context) {
        this.modelqsnlist = modelqsnlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.questioncardview, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i)
    {
        Modeldata.ModelQuestion modeldata = modelqsnlist.get(i);

        holder.questions.setText(modeldata.getQuestions());
        holder.optionA.setText(modeldata.getOptionA());
        holder.optionB.setText(modeldata.getOptionB());
        holder.optionC.setText(modeldata.getOptionC());
        holder.optionD.setText(modeldata.getOptionD());
        holder.correctans.setText(modeldata.getCorrectans());
    }

    @Override
    public int getItemCount() {
        return modelqsnlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView questions,optionA,optionB,optionC,optionD,correctans;

        public ViewHolder( View itemView) {
            super(itemView);

            this.questions = itemView.findViewById(R.id.question);
            this.optionA = itemView.findViewById(R.id.optionA);
            this.optionB = itemView.findViewById(R.id.optionB);
            this.optionC = itemView.findViewById(R.id.optionC);
            this.optionD = itemView.findViewById(R.id.optionD);
            this.correctans = itemView.findViewById(R.id.correct_ans);
        }
    }
}
