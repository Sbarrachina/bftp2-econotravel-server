package com.econotravel.api.repositories;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "experiences")

public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int duration;
    private String accessibility;
    @Lob
    private String description;
    @Lob
    private String label;
    private String image;


    public Experience(Long id,String name, int price, int duration, String accessibility, String description, String label, String image) {
        this.id= id;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.description = description;
        this.accessibility = accessibility;
        this.label = label;
        this.image = image;
    }



    public Experience() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return price == that.price && Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(duration, that.duration) && Objects.equals(accessibility, that.accessibility) && Objects.equals(description, that.description) && Objects.equals(label, that.label)&& Objects.equals(image, that.image);

    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, duration, accessibility, description, label,image);
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", accessibility=" + accessibility +
                ", description=" + description +
                ", label=" + label +
                ", image=" + image +

                '}';
    }
}

