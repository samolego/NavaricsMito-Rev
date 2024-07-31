package com.senseplay.sdk.model.slam;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SlamInfo {
    private List<float[]> matrix = new ArrayList();
    private List<float[]> points = new ArrayList();
    private List<int[]> polygons = new ArrayList();

    public List<float[]> getMatrix() {
        return this.matrix;
    }

    public void setMatrix(List<float[]> list) {
        this.matrix = list;
    }

    public List<float[]> getPoints() {
        return this.points;
    }

    public void setPoints(List<float[]> list) {
        this.points = list;
    }

    public List<int[]> getPolygons() {
        return this.polygons;
    }

    public void setPolygons(List<int[]> list) {
        this.polygons = list;
    }
}