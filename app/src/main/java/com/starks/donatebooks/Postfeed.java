package com.starks.donatebooks;

/**
 * Created by RCP on 5/8/2018.
 */

public class Postfeed {
    String postId;
    String strBookName;
    String strLoc;
    String strCategory;
    String strSubcat;
    String Description;
    String Cinfo;

    public Postfeed() {
    }

    public Postfeed(String postId, String strBookName, String strLoc, String strCategory, String strSubcat, String description, String cinfo) {
        this.postId = postId;
        this.strBookName = strBookName;
        this.strLoc = strLoc;
        this.strCategory = strCategory;
        this.strSubcat = strSubcat;
        this.Description = description;
        this.Cinfo = cinfo;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getStrBookName() {
        return strBookName;
    }

    public void setStrBookName(String strBookName) {
        this.strBookName = strBookName;
    }

    public String getStrLoc() {
        return strLoc;
    }

    public void setStrLoc(String strLoc) {
        this.strLoc = strLoc;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrSubcat() {
        return strSubcat;
    }

    public void setStrSubcat(String strSubcat) {
        this.strSubcat = strSubcat;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCinfo() {
        return Cinfo;
    }

    public void setCinfo(String cinfo) {
        Cinfo = cinfo;
    }



}
