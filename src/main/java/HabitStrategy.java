/*
 * Copyright (c) 2023
 * author: ac-f
 * email: fantasy1621821@gmail.com
 * website: https://ac-f.io/
 */

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HabitStrategy implements StrategyInterface{
  @Override
  public List<Individual> makeStrategy(Individual individual, List<Individual> targetIndividualList) {
    Comparator<Individual> order = Comparator.comparingInt(target -> {
      Set<String> set = new HashSet<>(individual.getHabits());
      set.retainAll(target.getHabits());
      return set.size();
    });
    return targetIndividualList
            .stream()
            .sorted(order.reversed())
            .toList();
  }

  @Override
  public void getStrategyResult(Individual individual, Individual targetIndividual) {
    Set<String> habit = new HashSet<>(individual.getHabits());
    var h = targetIndividual.getHabits();
    habit.retainAll(h);
    System.out.println("他們的共同興趣是：" + String.join(", ", habit));
  }
}
