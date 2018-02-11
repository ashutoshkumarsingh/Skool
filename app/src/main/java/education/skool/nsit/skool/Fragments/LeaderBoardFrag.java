package education.skool.nsit.skool.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import education.skool.nsit.skool.Models.LeaderModel;
import education.skool.nsit.skool.R;

public class LeaderBoardFrag extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;


    public LeaderBoardFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_leader_board, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_learderboard);
        recyclerView.setHasFixedSize(true);


        mLayoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new GridAdapter();
        recyclerView.setAdapter(mAdapter);
        return  view;

    }


        public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

            private List<LeaderModel> leaderModels;

            public GridAdapter() {
                leaderModels = new ArrayList<>();
                leaderModels.add(new LeaderModel("Amit", "60%", R.drawable.paytm));
                leaderModels.add(new LeaderModel("Rakesh", "70%", R.drawable.paytm));
                leaderModels.add(new LeaderModel("Vidhushi", "80%", R.drawable.paytm));
                leaderModels.add(new LeaderModel("Arun", "65%", R.drawable.paytm));
                leaderModels.add(new LeaderModel("Pawan", "75%", R.drawable.paytm));
                leaderModels.add(new LeaderModel("Abhi", "85%", R.drawable.paytm));
                leaderModels.add(new LeaderModel("Ashu", "63%", R.drawable.paytm));
                leaderModels.add(new LeaderModel("Gatum", "67%", R.drawable.paytm));
                leaderModels.add(new LeaderModel("Dev", "72%", R.drawable.paytm));


            }

            @Override
            public GridViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                Context context = viewGroup.getContext();
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.layout_list_item, viewGroup, false);


                return new GridViewHolder(view);
            }

            @Override
            public void onBindViewHolder(GridViewHolder gridViewHolder, int i) {
                LeaderModel leaderModel = leaderModels.get(i);
                gridViewHolder.bindData(leaderModel);
            }

            @Override
            public int getItemCount() {
                return leaderModels.size();
            }

            public class GridViewHolder extends RecyclerView.ViewHolder {

                private TextView name;
                private TextView score;
                private ImageView paytmImage;

                public GridViewHolder(View itemView) {
                    super(itemView);
                    name = (TextView) itemView.findViewById(R.id.leaderBoardName);
                    score = (TextView) itemView.findViewById(R.id.leaderBoardPercentage);
                    paytmImage = (ImageView) itemView.findViewById(R.id.paytmLogo);

                }

                public void bindData(LeaderModel leaderModel) {
                    name.setText(leaderModel.leaderBoardName);
                    score.setText(leaderModel.leaderBoardSCore);
                    paytmImage.setImageResource(leaderModel.paytmImage);
                }
            }


        }



    }
