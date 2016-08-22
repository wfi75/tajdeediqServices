package net.tajdeediq.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the writers database table.
 * 
 */
@Entity
@Table(name="writers")
@NamedQuery(name="Writer.findAll", query="SELECT w FROM Writer w")
public class Writer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=500)
	private String imageUrl;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, length=100)
	private String site;

	//bi-directional many-to-one association to Selected
	@OneToMany(mappedBy="writer")
	private List<Selected> selecteds;

	public Writer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<Selected> getSelecteds() {
		return this.selecteds;
	}

	public void setSelecteds(List<Selected> selecteds) {
		this.selecteds = selecteds;
	}

	public Selected addSelected(Selected selected) {
		getSelecteds().add(selected);
		selected.setWriter(this);

		return selected;
	}

	public Selected removeSelected(Selected selected) {
		getSelecteds().remove(selected);
		selected.setWriter(null);

		return selected;
	}

}