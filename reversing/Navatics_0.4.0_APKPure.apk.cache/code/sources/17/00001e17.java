package com.senseplay.sdk.model.location;

/* loaded from: classes2.dex */
public class LocationUser {
    private String distance;
    private int is_me;
    private int is_online;
    private String lat;
    private String lng;
    private UserProfile profile;

    public int getIs_me() {
        return this.is_me;
    }

    public void setIs_me(int i) {
        this.is_me = i;
    }

    public int getIs_online() {
        return this.is_online;
    }

    public void setIs_online(int i) {
        this.is_online = i;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public String getLng() {
        return this.lng;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public UserProfile getProfile() {
        return this.profile;
    }

    public void setProfile(UserProfile userProfile) {
        this.profile = userProfile;
    }
}