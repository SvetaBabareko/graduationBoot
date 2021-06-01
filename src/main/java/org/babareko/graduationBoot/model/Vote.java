package org.babareko.graduationBoot.model;

import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vote extends AbstractEntity{
    private User user;
    private Restaurant restaurant;
    private LocalDateTime dateVote;
}
