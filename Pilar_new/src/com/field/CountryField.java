package com.field;

import com.game.Player;

public class CountryField extends Field {
    public static final CountryField FRANCE = new CountryField("France");
    public static final CountryField SPAIN = new CountryField("Spain");
    public static final CountryField ITALY = new CountryField("Italy");
    public static final CountryField USA = new CountryField("USA");
    public static final CountryField CANADA = new CountryField("Canada");
    public static final CountryField INDIA = new CountryField("India");
    public static final CountryField CHINA = new CountryField("China");
    public static final CountryField JAPAN = new CountryField("Japan");
    public static final CountryField BRAZIL = new CountryField("Brazil");
    public static final CountryField ARGENTINA = new CountryField("Argentina");
    public static final CountryField COLUMBIA = new CountryField("Colimbia");
    public static final CountryField VENEZUELA = new CountryField("Venezuela");
    public static final CountryField GERMANY = new CountryField("Germany");
    public static final CountryField AUSTRIA = new CountryField("Austria");
    public static final CountryField GREAT_BRITAIN = new CountryField("Great Britain");
    public static final CountryField NETHERLANDS = new CountryField("Netherlands");
    public static final CountryField DENMARK = new CountryField("Denmark");
    public static final CountryField BELGIUM = new CountryField("Belgium");
    public static final CountryField NORWAY = new CountryField("Norway");
    public static final CountryField SWEDEN = new CountryField("Sweden");
    public static final CountryField FINLAND = new CountryField("Finland");
    public static final CountryField UAE = new CountryField("UAE");
    public static final CountryField KUWAIT = new CountryField("Kuwait");
    public static final CountryField QATAR = new CountryField("Qatar");
    public static final CountryField LUXEMBOURG = new CountryField("Luxembourg");
    public static final CountryField VATICAN = new CountryField("Vatican");
    public static final CountryField SINGAPORE = new CountryField("Singapore");
    public static final CountryField MONACO = new CountryField("Monaco");
    public static final CountryField AUSTRALIA = new CountryField("Australia");
    public static final CountryField NEW_ZEALAND = new CountryField("New Zealand");
    public static final CountryField SOUTH_AFRICA = new CountryField("South Africa");

    private Player owner;
    private Union union;

    private CountryField(String name) {
        super(name);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        if (this.owner != null) {
            this.owner.getCountryFields().remove(this);
        }
        this.owner = owner;
        owner.getCountryFields().add(this);
        union.checkOwner();
    }

    public Union getUnion() {
        return union;
    }

    protected void setUnion(Union union) {
        this.union = union;
    }
}
