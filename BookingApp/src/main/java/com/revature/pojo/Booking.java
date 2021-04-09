package com.revature.pojo;

public class Booking {
	public int c_id;
	public String start_date ;
	public String end_date;
	public int room_number;
	public String room_type;
	public int balance;
	
	@Override
	public String toString() {
		return "Booking [c_id=" + c_id + ", start_date=" + start_date + ", end_date=" + end_date + ", room_number="
				+ room_number + ", room_type=" + room_type + ", balance=" + balance + "]";
	}

	public Booking(int c_id, String start_date, String end_date, int room_number, String room_type, int balance) {
		super();
		this.c_id = c_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.room_number = room_number;
		this.room_type = room_type;
		this.balance = balance;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + c_id;
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + room_number;
		result = prime * result + ((room_type == null) ? 0 : room_type.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (balance != other.balance)
			return false;
		if (c_id != other.c_id)
			return false;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (room_number != other.room_number)
			return false;
		if (room_type == null) {
			if (other.room_type != null)
				return false;
		} else if (!room_type.equals(other.room_type))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		return true;
	}




	

	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getc_id() {
		return c_id;
	}

	public void setc_id(int c_id) {
		this.c_id = c_id;
	}

	public String getstart_date () {
		return start_date ;
	}

	public void setstart_date (String start_date ) {
		this.start_date  = start_date ;
	}

	public String getend_date() {
		return end_date;
	}

	public void setend_date(String end_date) {
		this.end_date = end_date;
	}

	public int getroom_number() {
		return room_number;
	}

	public void setroom_number(int room_number) {
		this.room_number = room_number;
	}

	public String getroom_type() {
		return room_type;
	}

	public void setroom_type(String room_type) {
		this.room_type = room_type;
	}


	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
