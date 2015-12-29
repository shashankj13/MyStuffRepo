package com.yash.mobileproj.domain;

public class MobileDetails {

		private String phonename;
		private int id;
		private String color;
		private int price;
		private String description;
		
		
		public String getPhonename() {
			return phonename;
		}
		@Override
		public String toString() {
			return "MobileDetails [phonename=" + phonename + ", id=" + id
					+ ", color=" + color + ", price=" + price
					+ ", description=" + description + "]";
		}
		public void setPhonename(String phonename) {
			this.phonename = phonename;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
}
