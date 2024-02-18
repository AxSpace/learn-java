package com.kylin.learn.guave.beans;

/**
 * @author kylin
 * @classname Person
 * @date 2024/2/18 14:44
 */
public class Person implements Comparable<Person> {
    private String lastName;
    private String firstName;
    private int zipCode;

    public Person(){

    }

    private Person(Builder builder) {
        setLastName(builder.lastName);
        setFirstName(builder.firstName);
        setZipCode(builder.zipCode);
    }

    @Override
    public int compareTo(Person other) {
        int cmp = lastName.compareTo(other.lastName);
        if (cmp != 0) {
            return cmp;
        }
        cmp = firstName.compareTo(other.firstName);
        if (cmp != 0) {
            return cmp;
        }
        return Integer.compare(zipCode, other.zipCode);
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    public static final class Builder {
        private String lastName;
        private String firstName;
        private int zipCode;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder zipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
