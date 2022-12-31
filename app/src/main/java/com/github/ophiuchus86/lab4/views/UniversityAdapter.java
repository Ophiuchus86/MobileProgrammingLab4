package com.github.ophiuchus86.lab4.views;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ophiuchus86.lab4.MainActivity;
import com.github.ophiuchus86.lab4.R;
import com.github.ophiuchus86.lab4.UniversityActivity;
import com.github.ophiuchus86.lab4.models.University;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>{
    private List<University> universities;

    public UniversityAdapter(List<University> universities){
        this.universities = universities;
    }

    @NonNull
    @NotNull
    @Override
    public UniversityViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int listItemId = R.layout.university_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(listItemId, parent, false);

        UniversityViewHolder viewHolder = new UniversityViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UniversityViewHolder holder, int position) {
        holder.universityName.setText(universities.get(position).getName());
        holder.university = universities.get(position);
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

    class UniversityViewHolder extends RecyclerView.ViewHolder {
        University university;
        TextView universityName;

        public UniversityViewHolder(View itemView){
            super(itemView);
            universityName = itemView.findViewById(R.id.list_item_university_name);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), UniversityActivity.class);
                intent.putExtra("name", university.getName())
                        .putExtra("country", university.getCountry())
                        .putStringArrayListExtra("domains", (ArrayList<String>) university.getDomains())
                        .putStringArrayListExtra("pages", (ArrayList<String>) university.getPages());
                itemView.getContext().startActivity(intent);
            });
        }

    }
}
