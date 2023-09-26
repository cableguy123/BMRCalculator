public class Calculator {
	private double bmr;
	private double tdee;
	private String result = null;

	public void setBmr(String user_gender, String user_age, String user_height, String user_weight) {
		if(user_gender.equals("Male")) {
			bmr = 13.397 * Float.parseFloat(user_weight) + 4.799 * Float.parseFloat(user_height) - 5.677 * Integer.parseInt(user_age) + 88.362;
		} else if(user_gender.equals("Female")) {
			bmr = 9.247 * Float.parseFloat(user_weight) + 3.098 * Float.parseFloat(user_height) - 4.33 * Integer.parseInt(user_age) + 447.593;
		}
	}

	public double getBmr() {
		return bmr;
	}

	public void setTdee(int actLv) {
		if(actLv == 1) {
			tdee = getBmr() * 1.2;
		} else if(actLv == 2) {
			tdee = getBmr() * 1.375;
		} else if(actLv == 3) {
			tdee = getBmr() * 1.55;
		} else if(actLv == 4) {
			tdee = getBmr() * 1.725;
		} else if(actLv == 5) {
			tdee = getBmr() * 1.9;
		}
	}

	public double getTdee() {
		return tdee;
	}

	public void setResult(double calories) {
		if(calories > getTdee()) {
			result = String.format("%.3f",(calories - getTdee())) + " Calories over.";
		} else if(getTdee() > calories) {
			result = String.format("%.3f",(getTdee() - calories)) + " Calories not enough.";
		}
	}

	public String getResult() {
		return result;
	}
}
