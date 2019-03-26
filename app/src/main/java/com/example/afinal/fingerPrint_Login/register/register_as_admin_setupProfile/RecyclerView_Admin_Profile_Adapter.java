package com.example.afinal.fingerPrint_Login.register.register_as_admin_setupProfile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afinal.R;

import java.util.ArrayList;

class RecyclerView_Admin_Profile_Adapter extends RecyclerView.Adapter<RecyclerView_Admin_Profile_Adapter.InsideHolder> implements View.OnClickListener{

    private Context mContext;

    private ArrayList<AdminDetail> adminDetails;

     int j=0;




    public RecyclerView_Admin_Profile_Adapter(Context context, ArrayList<AdminDetail> adminDetails) {

        this.mContext = context;
        this.adminDetails = adminDetails;

    }

    @NonNull
    @Override
    public InsideHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View rootView = LayoutInflater.from(mContext).inflate(R.layout.cardview_admin_profile,viewGroup,false);


        //return null;

        return new InsideHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull InsideHolder insideHolder, int i) {

        String ss = adminDetails.get(i).getImageViewPath();

       j =i;


        if(insideHolder.checkBox.isChecked()){

        }
//        insideHolder.imageViewList.setImageResource(getItemId());

//        final int j =i;
//        insideHolder.checkBox.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
//            @Override
//            public void onViewAttachedToWindow(View v) {
//
//
//                boolean checkBoxCheck = ((CheckBox)v).isChecked();
//
//                if(checkBoxCheck){
//                    Log.i("checkkLocation", "11 checkBox = " +adminDetails.get(j).isCheckBox());
//
//                    adminDetails.get(j).setCheckBox(true);
//
//                    Log.i("checkkLocation", "12 checkBox = " +adminDetails.get(j).isCheckBox());
//
//                }
//            }
//
//            @Override
//            public void onViewDetachedFromWindow(View v) {
//
//            }
//        });



        int id = mContext.getApplicationContext().getResources().getIdentifier(ss,null, mContext.getPackageName());

        if(i==2) {

            Log.i("checkkLocation", "9 location " +adminDetails.get(i).getTextShow());
        }
        insideHolder.imageViewList.setImageResource(id);
        insideHolder.textViewList.setText(adminDetails.get(i).getTextShow());

    }

    @Override
    public int getItemCount() {
        return adminDetails.size();
    }

    @Override
    public void onClick(View v) {



    }

    public class InsideHolder extends RecyclerView.ViewHolder {

        public TextView textViewList;
        public ImageView imageViewList;

        public CheckBox checkBox;

        public InsideHolder(@NonNull View itemView) {
            super(itemView);

            textViewList = itemView.findViewById(R.id.admin_Profile_CardView_textViewiD);
            imageViewList = itemView.findViewById(R.id.admin_Profile_CardView_imageViewid);

            checkBox = itemView.findViewById(R.id.admin_Profile_CardView_checkBox);

            checkBox.setOnClickListener((View.OnClickListener) this);

//            checkBox.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    boolean checkBoxCheck = ((CheckBox)v).isChecked();
//
//                if(checkBoxCheck){
//                    Log.i("checkkLocation", "11 checkBox = " +adminDetails.get(j).isCheckBox());
//
//                    adminDetails.get(j).setCheckBox(true);
//
//                    Log.i("checkkLocation", "12 checkBox = " +adminDetails.get(j).isCheckBox());
//
//                }
//
//
//                }
//            });
        }


    }
}
