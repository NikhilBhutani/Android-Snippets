package github.nikhilbhutani.usinggson;

/**
 * Created by Nikhil Bhutani on 5/17/2016.
 */
public class MyPOJO {

    private String country;
    private String population;

  /*  public MyPOJO(String country, String population)
    {
        this.country = country;
        this.population = population;

    }
*/
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

}
