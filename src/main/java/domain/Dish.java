package domain;

public class Dish {
    private String dish;



    private String cuisine;
    private String category;
    private String difficulty;

    public Dish() {
    }
    public Dish(String dish, String cuisin, String category, String difficulty) {

    }
    public Dish(String dish) {
        this.dish = dish;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    @Override
    public String toString() {
        return "Dishe{" +
                "dish='" + dish + '\'' +
                ", cuisin='" + cuisine + '\'' +
                ", category='" + category + '\'' +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}

