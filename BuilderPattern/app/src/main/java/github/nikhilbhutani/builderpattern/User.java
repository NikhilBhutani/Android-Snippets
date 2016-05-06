package github.nikhilbhutani.builderpattern;

/**
 * Created by Nikhil Bhutani on 5/7/2016.
 */
public class User {

    private String firstName;  //required
    private String lastName;   //required
    private int age;       //optional
    private String phone;   //optional
    private String address;  //optional

    //Instantiates a new user
    public User(UserBuilder builder)
    {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address= builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public static class UserBuilder
    {
        private String firstName;  //required
        private String lastName;   //required
        private int age;       //optional
        private String phone;   //optional
        private String address;  //optional


        //Instantiates a new User Builder
        UserBuilder(String firstName, String lastName)
        {
             this.firstName = firstName;
             this.lastName = lastName;

        }

        public UserBuilder age(int age) {
           this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address=address;
            return this;
        }

///This is code is thread safe because we created the create then checked for the invariants
        public User build()
        {
            User user = new User(this);
            if(user.getAge()>120)
            {
                throw new IllegalStateException("Age out of range");
            }
            return user;
        }



       //this is code snippet below for build method is not thread safe, please avoid using it this way

       /*
       public User build()
       {

           if(this.age>120)
           {
               throw new IllegalStateException("Age out of range");
           }
           return new User(this);
       }
      */
    }

}
