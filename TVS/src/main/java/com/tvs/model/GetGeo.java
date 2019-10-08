package com.tvs.model;

public class GetGeo {

	private int lat;
	private int lng;
	
	protected GetGeo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected GetGeo(int lat, int lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public int getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getLng() {
		return lng;
	}

	public void setLng(int lng) {
		this.lng = lng;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lat;
		result = prime * result + lng;
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
		GetGeo other = (GetGeo) obj;
		if (lat != other.lat)
			return false;
		if (lng != other.lng)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GetGeo [lat=" + lat + ", lng=" + lng + "]";
	}
}
