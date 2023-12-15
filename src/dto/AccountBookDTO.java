package dto;

public class AccountBookDTO {
	
	private int seq;		// 번호
	private String type;	// 수입/지출
	private int amount;		// 금액
	private String category;// 카테고리
	private String place;	// 사용처
	private String memo;	// 메모
	private String date;	// 날짜
	
	
	public AccountBookDTO() {
		
	}
	
	// seq 제외
	public AccountBookDTO(String type, int amount, String category, String place, String memo, String date) {
		super();
		this.type = type;
		this.amount = amount;
		this.category = category;
		this.place = place;
		this.memo = memo;
		this.date = date;
	}
	
	// seq 포함
	public AccountBookDTO(int seq, String type, int amount, String category, String place, String memo, String date) {
		super();
		this.seq = seq;
		this.type = type;
		this.amount = amount;
		this.category = category;
		this.place = place;
		this.memo = memo;
		this.date = date;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return seq + ", " + type + ", " + amount + ", " + category
				+ ", " + place + ", " + memo + ", " + date;
	}

	
	
}
