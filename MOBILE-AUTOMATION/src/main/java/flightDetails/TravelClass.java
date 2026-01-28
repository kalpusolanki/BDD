package flightDetails;

public enum TravelClass {
    ECONOMY("Economy",1),
    BUSINESS("Business",2),
    FIRST("FIRST",3);

    private final int tier;
    private String className;


        TravelClass(String className,int tier)
        {
            this.className=className;
            this.tier=tier;
        }

        public String getClassName(){
            return className;
        }
    public int getTier(){
        return tier;
    }
}
