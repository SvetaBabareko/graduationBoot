package org.babareko.graduationBoot.model;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
@Setter
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Vote extends AbstractEntity{
    @ManyToOne(fetch = FetchType.LAZY)
  //  @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "date_vote", nullable = false)
    private @NotNull LocalDate dateVote;

    public Vote(Integer id, User user, Restaurant restaurant, @NotNull LocalDate dateVote) {
        super(id);
        this.user = user;
        this.restaurant = restaurant;
        this.dateVote = dateVote;
    }
}
