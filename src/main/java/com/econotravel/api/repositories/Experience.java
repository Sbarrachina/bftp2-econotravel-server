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

    private int price;

    private int duration;

    private String accessibility;

    private String description;

    private String label;


    public Experience(String name, int price, int duration, String accessibility, String description, String label) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.accessibility = accessibility;
        this.description = description;
        this.label = label;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return price == that.price && Objects.equals(id, that.id) && Objects.equals(name, that.name)
                && Objects.equals(duration, that.duration) && Objects.equals(accessibility, that.accessibility) && Objects.equals(description, that.description) && Objects.equals(label, that.label);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, duration, accessibility, description, label);
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
                '}';
    }
}

