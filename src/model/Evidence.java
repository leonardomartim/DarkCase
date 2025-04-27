package model;

public class Evidence {
    private String description;
    private String type; // Tipo da evidência (física, testemunhal, etc.)

    // Construtor
    public Evidence(String description, String type) {
        this.description = description;
        this.type = type;
    }

    // Getter para a descrição da evidência
    public String getDescription() {
        return description;  // Retorna a descrição da evidência
    }

    // Getter para o tipo da evidência
    public String getType() {
        return type;  // Retorna o tipo da evidência
    }

    // Método toString para representação da evidência
    @Override
    public String toString() {
        return "Evidence{" +
                "description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
