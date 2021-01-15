// -------------------------------------------------------
// Assignment 3
// Written by: Philippe Carrier  -  id 40153985
// For COMP 248 Section P – Fall 2019
// --------------------------------------------------------

/**
 * Class that build a CPU instance
 *
 * @author Philippe Carrier
 * @since 11/04/2019
 */

public class CPU {

//    The generation of the CPU
    private final int generation;
//    The series of the CPU
    private final String series;
//    The price of the CPU
    private double price;
//    The speed of the CPU
    private final double speed;
//    The launch date of the CPU
    private final String launchDate;
//    Whether the CPU support SGX
    private final boolean isSGXSupported;

//    The possible values of the CPU's series
    private final String[] CPUSeries = new String[]{"i3", "i5", "i7", "i9"};

    public CPU() {
        this.generation = 1;
        this.series = "i3";
        this.price = 117.00;
        this.speed = 2.93;
        this.launchDate = "Q1'10";
        this.isSGXSupported = false;
    }

    public CPU(
            int generation,
            String series,
            double speed,
            boolean isSGXSupported,
            double price,
            String launchDate) {

//        Speed value validation
        if (speed <= 0)
            throw new IllegalArgumentException("The speed value must be a positive real number.");

//        Generation value validation
        if (generation < 1 || generation > 10)
            throw new IllegalArgumentException("The CPU generation must be a value between 1 and 10.");

//        Series value validation
        for (int i = 0; i < CPUSeries.length; i++) {
            if (CPUSeries[i].equals(series))
                break;
            if (i == CPUSeries.length - 1)
                throw new IllegalArgumentException("The CPU series must be either i3, i5, i7 or i9.");
        }

        this.generation = generation;
        this.series = series;
        this.speed = speed;
        this.isSGXSupported = isSGXSupported;
        this.price = price;
        this.launchDate = launchDate;
    }

    /**
     * Returns the generation of the CPU
     *
     * @return  the CPU's generation
     */
    public int getGeneration() {
        return generation;
    }

    /**
     * Returns the series of the CPU
     *
     * @return  the CPU's series
     */
    public String getSeries() {
        return series;
    }

    /**
     * Returns the price of the CPU
     *
     * @return  the CPU's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the CPU
     *
     * @param price the new price value
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the speed of the CPU
     *
     * @return  The CPU's speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Returns the launch date of the CPU
     *
     * @return  The CPU's launch date
     */
    public String getLaunchDate() {
        return launchDate;
    }

    /**
     * Returns if the CPU support SGX
     *
     * @return  True or False
     */
    public boolean getIsSGXSupported() {
        return isSGXSupported;
    }

    /**
     *  Method that determine the price of the CPU depending on the amount of time since the launch
     *  date that has passe.
     *
     * @param sQuarterYear  The current year and quarter
     * @return  the current Price of the CPU
     */
    double priceNow(String sQuarterYear) {
        String[] dates1 = launchDate.split("'");
        String[] dates2 = sQuarterYear.split("'");

        int quarterDiff = dates2[0].compareTo(dates1[0]);
        int yearDiff = dates2[1].compareTo(dates1[1]);

        if (yearDiff < 0 || yearDiff == 0 && quarterDiff <= 0) {
            return price;
        }

        int totalExcessQuarter = quarterDiff + yearDiff * 4;

        double newPrice = (price * (100 - totalExcessQuarter * 2)) / 100;

        return newPrice > 0 ? newPrice : 0;
    }

    /**
     * Returns the specification of the CPU values in a string format
     *
     * @return  The specification of the CPU
     */
    public String toString() {
        return String.format("This CPU is " +
                generation + "th generation " +
                series + " (" +
                speed + "GHz)" +
                ", launched: " + launchDate +
                " with price: %.2f USD. " +
                "SGX is " + (isSGXSupported ? "" : "not ") +
                "supported.", price);
    }

    /**
     * Returns whether the otherCPU is equal to this CPU
     *
     * @param otherCPU  The CPU with which to compare the values.
     * @return  True or False
     */
    boolean equals(CPU otherCPU) {
        return this.generation == otherCPU.getGeneration()
                && this.series.equalsIgnoreCase(otherCPU.getSeries())
                && this.isSGXSupported == otherCPU.getIsSGXSupported();
    }

    /**
     * Returns whether the CPU has a higher generation than the otherCPU
     *
     * @param otherCPU  The CPU with which to compare the generation
     * @return  true or false
     */
    boolean isHigherGeneration(CPU otherCPU) {
        return this.generation > otherCPU.getGeneration();
    }

}
