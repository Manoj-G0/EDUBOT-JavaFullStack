class MyCities {
    enum City {
        CLEVELAND(421048),
        NEW_YORK(8336817),
        LOS_ANGELES(3976322);

        private int population;

        City(int population) {
            this.population = population;
        }

        public int getPopulation() {
            return population;
        }
    }

    public static void main(String[] args) {
        for (City city : City.values()) {
            System.out.println("The population of " + city.name().toLowerCase().replace('_', ' ') + " is " + city.getPopulation());
        }
    }
}
