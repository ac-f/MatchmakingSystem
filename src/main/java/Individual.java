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
  public List<Individual> makeStrategy(List<Individual> individuals, String strategy, Boolean isReverse) {
    List<Individual> list = new ArrayList<>();
    Comparator<Individual> order = null;
    switch (strategy) {
      //TODO FORCE: 行為變動性 行為擴充性
      case "DISTANCE_BASE" -> order = Comparator.comparing(individual -> this.getCoords().getDistance(individual.getCoords()));

      case "HABIT_BASE" -> {
        order = Comparator.comparingInt(individual -> {
          Set<String> set = new HashSet<>(this.getHabits());
          set.retainAll(individual.getHabits());
          return set.size();
        });
        order = order.reversed();
      }
    }
    assert order != null;
    if (isReverse) order.reversed();
    return individuals
            .stream()
            .sorted(order)
            .toList();
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
