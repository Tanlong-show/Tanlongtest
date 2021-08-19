package com.example.demo.domain;

import java.util.Date;

public class TbVideo {
    private Integer videoId;

    private String videoTitle;

    private Date videoUploadTime;

    private String videoImgUrl;

    private String videoMovieUrl;

    private Integer videoSize;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public Date getVideoUploadTime() {
        return videoUploadTime;
    }

    public void setVideoUploadTime(Date videoUploadTime) {
        this.videoUploadTime = videoUploadTime;
    }

    public String getVideoImgUrl() {
        return videoImgUrl;
    }

    public void setVideoImgUrl(String videoImgUrl) {
        this.videoImgUrl = videoImgUrl == null ? null : videoImgUrl.trim();
    }

    public String getVideoMovieUrl() {
        return videoMovieUrl;
    }

    public void setVideoMovieUrl(String videoMovieUrl) {
        this.videoMovieUrl = videoMovieUrl == null ? null : videoMovieUrl.trim();
    }

    public Integer getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(Integer videoSize) {
        this.videoSize = videoSize;
    }
}