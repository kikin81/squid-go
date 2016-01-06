package us.kikin.app.squidgo.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fvelazquez on 1/5/16.
 */
public class Stage {

    @SerializedName("nameEN")
    private String name;
    @SerializedName("nameJP")
    private String japaneseName;

    public Stage() {}

    public String getJapaneseName() {
        return japaneseName;
    }

    public void setJapaneseName(String japaneseName) {
        this.japaneseName = japaneseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
