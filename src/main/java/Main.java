/*
 * Copyright (c) 2023
 * author: ac-f
 * email: fantasy1621821@gmail.com
 * website: https://ac-f.io/
 */

import java.util.Set;

public class Main {
  public static void main(String[] args) {
    MatchmakingSystem system = new MatchmakingSystem();
    //加入Individual
    system.addIndividual(new Individual(1, Gender.MALE, 25, "大家好我是AC", Set.of("打球","跳舞", "想成為範例"), new Coords(1, 1)));
    system.addIndividual(new Individual(2, Gender.MALE, 26, "大家好我是水球潘", Set.of("玩音樂", "寫程式"), new Coords(3, 5)));
    system.addIndividual(new Individual(3, Gender.MALE, 27, "大家好我是很想加入的Jacky", Set.of("想成為範例", "寫程式", "打球"), new Coords(8, 2)));
    system.addIndividual(new Individual(4, Gender.FEMALE, 26, "大家好我是Winnie", Set.of("唱歌", "跳舞", "滑雪"), new Coords(8, 9)));
    system.addIndividual(new Individual(5, Gender.FEMALE, 26, "大家好我是柔密", Set.of("寫程式", "桌遊"), new Coords(1, 3)));
    system.match();
  }
}
