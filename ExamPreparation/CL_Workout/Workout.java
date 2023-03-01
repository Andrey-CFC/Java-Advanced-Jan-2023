package ExamPreparation.CL_Workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise) {
        if (this.exerciseCount > this.exercises.size()) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return this.exercises.removeIf(e -> e.getName().equals(name) && e.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream().filter(e ->  e.getName().equals(name) && e.getMuscle().equals(muscle)).findAny().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).orElse(null);
    }

    public int getExerciseCount(){
        return this.exercises.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(this.type).append(System.lineSeparator());
        this.exercises.forEach(exercise -> sb.append(exercise.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
