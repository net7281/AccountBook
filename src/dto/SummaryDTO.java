package dto;

public class SummaryDTO {
	
	private String month;
	private int inAmount;
	private int outAmount;
	private int totalAmount;
	
	public SummaryDTO() {
	}
	
	public SummaryDTO(String month, int inAmount, int outAmount) {
		super();
		this.month = month;
		this.inAmount = inAmount;
		this.outAmount = outAmount;
		this.totalAmount = inAmount - outAmount;
	}


	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getInAmount() {
		return inAmount;
	}
	public void setInAmount(int inAmount) {
		this.inAmount = inAmount;
	}
	public int getOutAmount() {
		return outAmount;
	}
	public void setOutAmount(int outAmount) {
		this.outAmount = outAmount;
	}
	public int getTotalAmount() {
		return totalAmount;
	}



	@Override
	public String toString() {
		return "SummaryDTO [inAmount=" + inAmount + ", outAmount=" + outAmount + ", totalAmount=" + totalAmount + "]";
	}



	
}
