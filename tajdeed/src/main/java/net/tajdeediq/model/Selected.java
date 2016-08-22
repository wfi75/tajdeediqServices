package net.tajdeediq.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the selected database table.
 * 
 */
@Entity
@Table(name="selected")
@NamedQuery(name="Selected.findAll", query="SELECT s FROM Selected s")
public class Selected implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=5000)
	private String body;

	@Column(nullable=false)
	private Timestamp date;

	@Column(nullable=false, length=1000)
	private String ingress;

	@Column(nullable=false, length=500)
	private String title;

	//bi-directional many-to-one association to Writer
	@ManyToOne
	@JoinColumn(name="writerId", nullable=false)
	private Writer writer;

	public Selected() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getIngress() {
		return this.ingress;
	}

	public void setIngress(String ingress) {
		this.ingress = ingress;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Writer getWriter() {
		return this.writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}

}