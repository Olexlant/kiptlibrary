package com.Kipfk.Library.appuser;

import com.Kipfk.Library.appbook.AppBook;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class TakenBooks {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private AppBook book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;


    private LocalDate takenat;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
