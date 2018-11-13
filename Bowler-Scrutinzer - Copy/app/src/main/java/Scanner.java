import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.FileNotFoundException;

import application.scrutinizer.bowler.bowlerscrutinizer.AnalyseActivity;


/**
 * Created by Huma on 6/1/2018.
 */

public class Scanner {

    public Bitmap decodeBitmapUri(AnalyseActivity ctx , Uri uri) throws FileNotFoundException {

        int targetW = 1000;
        int targetH = 1000;

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(ctx.getContentResolver().openInputStream(uri), null, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        int scaleFactor = Math.min(photoW/targetW , photoH/targetH);
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;

        return BitmapFactory.decodeStream(ctx.getContentResolver()
                .openInputStream(uri) , null , bmOptions );

    }



}



