package nl.workingtalentapp.library.domein;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;


@Entity
public class Boek implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String title;
	private String isbn;
	private String thumbnailUrl;
	private String authors;
	private String categories;
	private String status;
	private int pageCount;
	private int copies;
	private int available;

//	private int n_o_copies;
//	private String imageUrl;

	@Column(nullable = false, updatable = false)
	private String bookCode;

	public Boek() {}

	public Boek(Long id, String title, String isbn, String thumbnailUrl, String authors, String categories, String status, int pageCount, int copies, int available, String bookCode) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.thumbnailUrl = thumbnailUrl;
		this.authors = authors;
		this.categories = categories;
		this.status = status;
		this.pageCount = pageCount;
		this.copies = copies;
		this.available = available;
		this.bookCode = bookCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	@Override
	public String toString() {
		return "Boek{" +
				"id=" + id +
				", title='" + title + '\'' +
				", isbn='" + isbn + '\'' +
				", thumbnailUrl='" + thumbnailUrl + '\'' +
				", authors=" + authors +
				", categories=" + categories +
				", status='" + status + '\'' +
				", pageCount=" + pageCount +
				", copies=" + copies +
				", available=" + available +
				", bookCode='" + bookCode + '\'' +
				'}';
	}
}
