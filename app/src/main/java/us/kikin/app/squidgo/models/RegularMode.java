package us.kikin.app.squidgo.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fvelazquez on 1/5/16.
 */
public class RegularMode {

    @SerializedName("maps")
    private List<Stage> stages = new ArrayList<>();
    @SerializedName("rules.en")
    private String ruleName;
    @SerializedName("rules.jp")
    private String ruleNameJapanese;

    public RegularMode() {}

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleNameJapanese() {
        return ruleNameJapanese;
    }

    public void setRuleNameJapanese(String ruleNameJapanese) {
        this.ruleNameJapanese = ruleNameJapanese;
    }
}
