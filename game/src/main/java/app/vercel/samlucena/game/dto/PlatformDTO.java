package app.vercel.samlucena.game.dto;

import app.vercel.samlucena.game.entities.GameReview;
import app.vercel.samlucena.game.entities.Platform;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PlatformDTO {

    private Long id;
    private String name;
    private Set<GameReviewDTO> reviews = new HashSet<>();
    public PlatformDTO(){}

    public PlatformDTO(Platform entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public PlatformDTO(Platform entity, Set<GameReview> reviews){
        this(entity);
        reviews.forEach(rev -> this.reviews.add(new GameReviewDTO(rev)));
    }


    public PlatformDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<GameReviewDTO> getReviews() {
        return reviews;
    }
}
