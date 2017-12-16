package com.fmi.edu.online.bus.tickets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "Ticket")
public class TicketDto {

	@Id
	@GeneratedValue
	private String id;

	@Column(nullable = false)
	private String busId;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private String createdOn;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private String expiresOn;

	@Column(nullable = false)
	@SerializedName(value = "checked")
	private boolean isChecked;

	public TicketDto() {
	}

	public TicketDto(String busId, String createdOn, boolean isChecked) {
		setBusId(busId);
		setCreatedOn(createdOn);
		setChecked(isChecked);
	}

	public TicketDto(String ticketId, String busId, String createdOn, boolean isChecked) {
		this(busId, createdOn, isChecked);
		setId(ticketId);
	}

	public TicketDto(Ticket ticket) {
		setBusId(ticket.getBusId());
		setCreatedOn(ticket.getCreatedOn().toString());
		setChecked(ticket.isChecked());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(String expiresOn) {
		this.expiresOn = expiresOn;
	}

	@Override
	public String toString() {
		return "TicketDto [id=" + id + ", busId=" + busId + ", localDateTime=" + createdOn + ", isChecked=" + isChecked
				+ "]";
	}

}
