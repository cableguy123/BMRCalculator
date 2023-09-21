package Beans;

public class Beans {
  private int resultID;
  private int userID;
  private String mealDate;
  private String mealCalories;
  private int bmr;
  private int tdee;
  private String result;
  // setter
  public void setResultID(int resultID) {
    this.resultID = resultID;
  }
  public void setUserID(int userID) {
    this.userID = userID;
  }
  public void setMealDate(String mealDate) {
    this.mealDate = mealDate;
  }
  public void setMealCalories(String mealCalories) {
    this.mealCalories = mealCalories;
  }
  public void setBmr(int bmr) {
    this.bmr = bmr;
  }
  public void setTdee(int tdee) {
    this.tdee = tdee;
  }
  public void setResult(String result) {
    this.result = result;
  }
  // getter 
  public int getResultID() {
    return resultID;
  }
  public int getUserID() {
    return userID;
  }
  public String getMealDate() {
    return mealDate;
  }
  public String getMealCalories() {
    return mealCalories;
  }
  public int getBmr() {
    return bmr;
  }
  public int getTdee() {
    return tdee;
  }
  public String getResult() {
    return result;
  }
}
