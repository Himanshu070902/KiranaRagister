package in.sp.main;

public class MonthlyReport {
	private double totalCredits;
    private double totalDebits;
    private double netFlow;
	public double getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(double totalCredits) {
		this.totalCredits = totalCredits;
	}
	public double getTotalDebits() {
		return totalDebits;
	}
	public void setTotalDebits(double totalDebits) {
		this.totalDebits = totalDebits;
	}
	public double getNetFlow() {
		return netFlow;
	}
	public void setNetFlow(double netFlow) {
		this.netFlow = netFlow;
	}
}
