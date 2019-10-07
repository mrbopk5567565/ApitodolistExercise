package thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.R;
import thinhtien.pntt.phannguyentruongthinh.apptodolistexercise.model.Work;

public class Work_Apdater extends RecyclerView.Adapter<Work_Apdater.Holder> {

    // muon lam su kien setOnClickListen thi vao project ExcerciseResearch

    ArrayList<Work> mangCongViec;

    public Work_Apdater(ArrayList<Work> mangCongViec) {
        this.mangCongViec = mangCongViec;
    }

    public ArrayList<Work> getMangCongViec() {
        return mangCongViec;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.txtContentWork.setText(mangCongViec.get(position).getCongViec());
        holder.txtContentTime.setText(mangCongViec.get(position).getThoiGian());
    }

    @Override
    public int getItemCount() {
        if (mangCongViec.size() <= 0 || mangCongViec == null){
            return 0;
        }
        return mangCongViec.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView txtContentWork, txtContentTime;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txtContentWork = itemView.findViewById(R.id.txtContentWork);
            txtContentTime = itemView.findViewById(R.id.txtContentTime);

        }
    }
}
