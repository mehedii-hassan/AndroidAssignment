
package com.example.galleryappdemo.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("promoted_at")
    @Expose
    private String promotedAt;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("blur_hash")
    @Expose
    private String blurHash;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("alt_description")
    @Expose
    private Object altDescription;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("categories")
    @Expose
    private List<Object> categories = null;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;
    @SerializedName("current_user_collections")
    @Expose
    private List<Object> currentUserCollections = null;
    @SerializedName("sponsorship")
    @Expose
    private Object sponsorship;
    @SerializedName("topic_submissions")
    @Expose
    private TopicSubmissions topicSubmissions;
    @SerializedName("user")
    @Expose
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPromotedAt() {
        return promotedAt;
    }

    public void setPromotedAt(String promotedAt) {
        this.promotedAt = promotedAt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBlurHash() {
        return blurHash;
    }

    public void setBlurHash(String blurHash) {
        this.blurHash = blurHash;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getAltDescription() {
        return altDescription;
    }

    public void setAltDescription(Object altDescription) {
        this.altDescription = altDescription;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public Object getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(Object sponsorship) {
        this.sponsorship = sponsorship;
    }

    public TopicSubmissions getTopicSubmissions() {
        return topicSubmissions;
    }

    public void setTopicSubmissions(TopicSubmissions topicSubmissions) {
        this.topicSubmissions = topicSubmissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
