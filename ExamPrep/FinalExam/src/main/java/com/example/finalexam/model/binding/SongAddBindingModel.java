package com.example.finalexam.model.binding;

import com.example.finalexam.model.entity.Style;
import com.example.finalexam.model.entity.enums.StyleName;
import com.example.finalexam.model.validation.UniqueName;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class SongAddBindingModel {
    @NotBlank
    @UniqueName
    @Size(min = 3, max = 20)
    private String performer;
    @NotBlank
    @Size(min = 2, max = 20)
    private String title;
    @NotNull
    @Positive
    private Integer duration;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate releaseDate;
    @NotNull
    private StyleName style;

    public SongAddBindingModel() {
    }

    public String getPerformer() {
        return performer;
    }

    public SongAddBindingModel setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongAddBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongAddBindingModel setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public SongAddBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public StyleName getStyle() {
        return style;
    }

    public SongAddBindingModel setStyle(StyleName style) {
        this.style = style;
        return this;
    }
}
