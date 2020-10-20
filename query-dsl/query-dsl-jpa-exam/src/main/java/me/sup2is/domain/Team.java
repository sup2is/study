package me.sup2is.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    private String name;

    public static Team createTeam(String name) {
        Team team = new Team();
        team.name = name;
        return team;
    }

    public void addMember(Member member) {
        this.members.add(member);
        member.setTeam(this);
    }

}
