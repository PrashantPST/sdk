package core.immutable;

class Address {
    private String country;
    private String city;

    Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    String getCountry() {
        return country;
    }

    String getCity() {
        return city;
    }
}
