import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MatchmakingSystem {
  private final List<Individual> individuals = new ArrayList<>();
  private final String strategyType = "HABIT_BASE";

  public void match() {
    for (Individual individual : individuals) {
      var targetIndividuallist = individuals.stream()
              .filter(matchIndividual -> !Objects.equals(matchIndividual.getId(), individual.getId()))
              .toList();
      var resultList = individual.makeStrategy(targetIndividuallist, strategyType, false);
      var msg = MessageFormat.format("對{0}來說， 最佳的配對為： {1}", individual.getId(), resultList.get(0).getId());
      System.out.println(msg);
      switch (strategyType) {
        //TODO FORCE
        case "DISTANCE_BASE":
          var distance = individual.getCoords().getDistance(resultList.get(0).getCoords());
          System.out.println("他們的距離是：" + distance);
          break;
        case "HABIT_BASE":
          Set<String> habit = new HashSet<>(individual.getHabits());
          var h = resultList.get(0).getHabits();
          habit.retainAll(h);
          System.out.println("他們的共同興趣是：" + String.join(", ", habit));
          break;
      }
      System.out.println("===================================");
    }

  }

  public void addIndividual(Individual individual) {
    this.individuals.add(individual);
  }

}
