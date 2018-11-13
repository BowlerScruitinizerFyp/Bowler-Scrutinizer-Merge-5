import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import application.scrutinizer.bowler.bowlerscrutinizer.ImageUpload;
import application.scrutinizer.bowler.bowlerscrutinizer.R;


public class ImageAdapter extends RecyclerView.Adapter <ImageAdapter.ImageViewHolder> {


    private Context mContext;
    private List<ImageUpload> mUploads;

    public ImageAdapter(Context context, List<ImageUpload> uploads) {
        mContext = context;
        mUploads = uploads;
    }


    @NonNull
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ImageAdapter.ImageViewHolder holder, final int position) {

        final ImageUpload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getName());
        Picasso.with(mContext)
                .load(uploadCurrent.getUrl())
                .fit()
                .centerCrop()
                .into(holder.imageView);


//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Upload uploadCurrent = mUploads.get(position);
//                Picasso.with(mContext)
//                        .load(uploadCurrent.getImageUrl())
//                        .fit()
//                        .centerCrop()
//                        .into(holder.imv1);
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;
        public ImageView imv1;

        public ImageViewHolder(View itemView) {

            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
            //  imv1 = itemView.findViewById(R.id.fullimage);





        }





    }
}


