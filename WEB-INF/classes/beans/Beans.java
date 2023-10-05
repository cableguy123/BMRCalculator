package beans;

public class Beans {
  private int result_id;
  private int user_id;
  private String meal_date;
  private float meal_calories;
  private float bmr;
  private float tdee;
  private String result;
  public Beans() {

  }
  // setter
  public void setResult_id(int result_id) {
    this.result_id = result_id;
  }
  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }
  public void setMeal_date(String meal_date) {
    this.meal_date = meal_date;
  }
  public void setMeal_calories(float meal_calories) {
    this.meal_calories = meal_calories;
  }
  public void setBmr(float bmr) {
    this.bmr = bmr;
  }
  public void setTdee(float tdee) {
    this.tdee = tdee;
  }
  public void setResult(String result) {
    this.result = result;
  }
  // getter 
  public int getResult_id() {
    return result_id;
  }
  public int getUser_id() {
    return user_id;
  }
  public String getMeal_date() {
    return meal_date;
  }
  public float getMeal_calories() {
    return meal_calories;
  }
  public float getBmr() {
    return bmr;
  }
  public float getTdee() {
    return tdee;
  }
  public String getResult() {
    return result;
  }
}
