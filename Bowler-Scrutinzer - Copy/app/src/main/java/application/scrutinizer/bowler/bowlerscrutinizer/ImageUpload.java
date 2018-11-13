package application.scrutinizer.bowler.bowlerscrutinizer;

import com.google.firebase.database.Exclude;

public class ImageUpload {

    public String name;
    public  String url;
    private String mKey;

    public ImageUpload() {
        //empty constructor needed
    }

    public ImageUpload(String name , String imageUrl){

        if (name.trim().equals("")) {
            name = "No Name";
        }

        this.name = name;
        this.url = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}
