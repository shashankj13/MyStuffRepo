package shashank.program.PLM;



public class Books {
	private int bookId;
	private String bookTitle;
	private String authorName;
	private Person person=null;

	public Books(int bookId, String bookTitle, String authorName) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Books(String bookTitle, String authorName) {
		super();
		this.bookTitle = bookTitle;
		this.authorName = authorName;
	}
	@Override
	public int hashCode() {

		return bookId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (bookId != other.bookId)
			return false;
		return true;
	}
}
