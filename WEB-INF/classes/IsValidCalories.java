public class IsValidCalories {
    public boolean isValidCalories(String calories) {
        return calories.matches("\\d+") && Integer.parseInt(calories) >= 0 && Integer.parseInt(calories) <= 5000;
    }
}
