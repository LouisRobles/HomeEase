package com.example.homeease;

public class Worker {
    private String name;
    private String category;
    private float rating;
    private int reviews;
    private int jobs;
    private String price;
    private int imageResource;

    public Worker(String name, String category, float rating, int reviews, int jobs, String price, int imageResource) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.reviews = reviews;
        this.jobs = jobs;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public float getRating() { return rating; }
    public int getReviews() { return reviews; }
    public int getJobs() { return jobs; }
    public String getPrice() { return price; }
    public int getImageResource() { return imageResource; }
}
