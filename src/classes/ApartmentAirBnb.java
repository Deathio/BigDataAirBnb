package src.classes;

import org.joda.time.LocalDate;

public class ApartmentAirBnb {
    private String id;
    public String apartmentName;
    public Host hostInfo;
    public Neighbourhood neighbourhoodInfo;
    public String latitude;
    public String longitude;
    public String apartmentType;
    public int price;
    public int minimum_nights;
    public int number_of_reviews;
    public LocalDate lastReview;
    public Double reviews_per_month;
    public String calculated_host_listings_count;
    public String availability_365;

    public Double getReviews_per_month() {
        return reviews_per_month != null ? reviews_per_month : 0;
    }

    public ApartmentAirBnb(String id, String apartmentName, String hostId, String hostName, String neighbourhoodGroup,
            String neighbourhood, String latitude, String longitude, String apartmentType, String price,
            String minimum_nights,
            String number_of_reviews, String lastReview, String reviews_per_month,
            String calculated_host_listings_count,
            String availability_365) {

        this.id = id;
        this.apartmentName = apartmentName;
        this.hostInfo = new Host(hostId, hostName);
        this.neighbourhoodInfo = new Neighbourhood(neighbourhoodGroup, neighbourhood);
        this.latitude = latitude;
        this.longitude = longitude;
        this.apartmentType = apartmentType;
        this.price = Integer.parseInt(price);
        this.minimum_nights = Integer.parseInt(minimum_nights);
        this.number_of_reviews = Integer.parseInt(number_of_reviews);
        this.lastReview = lastReview != "" ? defineCalendar(lastReview) : null;
        this.reviews_per_month = reviews_per_month != "" ? Double.parseDouble(reviews_per_month) : null;
        this.calculated_host_listings_count = calculated_host_listings_count;
        this.availability_365 = availability_365;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%d,%d,%d,%s,%s,%s,%s\n", id, apartmentName, hostInfo,
                neighbourhoodInfo, latitude, longitude, apartmentType, price, minimum_nights, number_of_reviews,
                lastReview != null ? printTheActualDate() : "", reviews_per_month != null ? reviews_per_month : "",
                calculated_host_listings_count, availability_365);
    }

    public LocalDate defineCalendar(String date) {
        String[] splitDate = date.split("-");

        return new LocalDate(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));
    }

    public String printTheActualDate() {
        return lastReview != null ? lastReview.toString("dd/MM/YYYY") : "";
    }
}
