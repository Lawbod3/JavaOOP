public enum GeoPoliticalZone {
    NorthCentral("benue", "fct","kogi","kwara","nasarawa","niger","plateu"),
    NorthEast("adamawa","bauchi","borno","gombe","taraba","yobe"),
    NorthWest("kaduna","kano","katsina","kebbi","sokoto","jigawa","zamfara"),
    SouthSouth("akwa-ibom","bayelsa","cross-river","delta","edo","rivers"),
    SouthWest("lagos", "oyo", "ogun", "ondo","osun", "ekiti"),
    SouthEast("abia","anambra","ebonyi","enugu","imo");
    private final String[] states;

    GeoPoliticalZone(String... states) {
        this.states = states;
    }

    public String[] getStates() {
        return states;
    }
    public static GeoPoliticalZone fromState(String input) {
        for(GeoPoliticalZone geoPoliticalZone : GeoPoliticalZone.values()) {
            for(String state : geoPoliticalZone.getStates() ) {
                if(state.equals(input))return geoPoliticalZone;
            }
        }
        return null;
    }


}
