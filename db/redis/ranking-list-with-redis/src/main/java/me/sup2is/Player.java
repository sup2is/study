package me.sup2is;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class Player implements Serializable {

    private String name;
    private Long score;

}
