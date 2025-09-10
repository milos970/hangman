
package ponuka;




public record Skore (String name, int points) {


    @Override
    public String toString() {
        return """
            **************************************
            meno: %s
            body: %d
            **************************************
            """.formatted(this.name, this.points);
    }
};

    
    
    

