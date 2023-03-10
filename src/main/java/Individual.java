/*
 * Copyright (c) 2023
 * author: ac-f
 * email: fantasy1621821@gmail.com
 * website: https://ac-f.io/
 */

import java.util.*;

public class Individual {
  //attr
  private Integer id;
  private Gender gender;
  private Integer age;
  private String intro;
  private Set<String> habits;
  private Coords coords;

  public Individual(Integer id, Gender gender, Integer age, String intro, Set<String> habits, Coords coords) {
    this.id = id;
    this.gender = gender;
    this.age = age;
    this.intro = intro;
    this.habits = habits;
    this.coords = coords;
  }

  // operation
  public List<Individual> makeStrategy(List<Individual> individuals, StrategyInterface strategy, Boolean isReverse) {
    var list = strategy.makeStrategy(this, individuals);
    if (isReverse) Collections.reverse(list);
    return list;
  }

  public void getStrategyResult(Individual targetIndividual, StrategyInterface strategy) {
    strategy.getStrategyResult(this, targetIndividual);
  }

  // getter & setter
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    if (id <= 0) {
      throw new IllegalArgumentException("id必須大於0");
    }
    this.id = id;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setAge(Integer age) {
    if (age <= 18) {
      throw new IllegalArgumentException("age必須大於等於18");
    }
    this.age = age;
  }

  public Integer getAge() {
    return age;
  }

  public void setIntro(String intro) {
    if (intro.length() < 0 || intro.length() >= 200) {
      throw new IllegalArgumentException("intro必須介於0 ~ 200");
    }
    this.intro = intro;
  }

  public String getIntro() {
    return intro;
  }

  public void setHabits(Set<String> habits) {
    this.habits = habits;
  }

  public Set<String> getHabits() {
    return habits;
  }

  public Coords getCoords() {
    return coords;
  }

  public void setCoords(Coords coords) {
    this.coords = coords;
  }
}
