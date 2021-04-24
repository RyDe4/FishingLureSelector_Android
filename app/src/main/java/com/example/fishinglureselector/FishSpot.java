package com.example.fishinglureselector;

public class FishSpot {

    private String name;
    private int typeCode; // Lake/Pond = 0, River/Creek = 1
    private int size; // very small = 0, small = 1, medium = 2, large = 3, very large = 4
    private int bottom; // boulders = 0, rocks = 1, pebbles = 2, hard mud = 3, soft mud = 4, sand = 5

    public FishSpot(String name, int typeCode, int size, int bottom) {
        this.name = name;
        this.typeCode = typeCode;
        this.size = size;
        this.bottom = bottom;
    }
    
    public FishSpot() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setGenerateTypeCode(String spotType) {
        if(spotType.equals("Lake/Pond")){
            this.typeCode = 0;
        } else {
            this.typeCode = 1;
        }
    }

    public int getSize() {
        return size;
    }

    public void setGenerateSize(String size) {
        if(size.equals("Very Small")) {
            this.size = 0;
        } else if (size.equals("Small")) {
            this.size = 1;
        } else if (size.equals("Medium")) {
            this.size = 2;
        } else if (size.equals("Large")) {
            this.size = 3;
        } else {
            this.size = 4;
        }
    }

    public int getBottom() {
        return bottom;
    }

    public void setGenerateBottom(String bottom) {
        if(bottom.equals("boulders")) {
            this.bottom = 0;
        } else if (bottom.equals("rocks")) {
            this.bottom = 1;
        } else if (bottom.equals("pebbles")) {
            this.bottom = 2;
        } else if (bottom.equals("hard mud")) {
            this.bottom = 3;
        } else if (bottom.equals("soft mud")) {
            this.bottom = 4;
        } else {
            this.bottom = 5;
        }
    }
}
