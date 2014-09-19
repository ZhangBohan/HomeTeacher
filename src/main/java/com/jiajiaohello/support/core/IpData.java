package com.jiajiaohello.support.core;

/**
 * User: bohan
 * Date: 9/19/14
 * Time: 2:19 PM
 */
public class IpData {
    private String country;
    private String countryId;
    private String area;
    private Integer areaId;
    private String region;
    private Integer regionId;
    private String city;
    private Integer cityId;
    private String county;
    private Integer countyId;

    @Override
    public String toString() {
        return "Data{" +
                "country='" + country + '\'' +
                ", countryId=" + countryId +
                ", area='" + area + '\'' +
                ", areaId=" + areaId +
                ", region='" + region + '\'' +
                ", regionId=" + regionId +
                ", city='" + city + '\'' +
                ", cityId=" + cityId +
                ", county='" + county + '\'' +
                ", countyId=" + countyId +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }
}
