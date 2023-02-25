package adapter.in;

public class HerosCreationDTO {
    public CaracteristiquesDto caracteristiquesDto;

    public HerosCreationDTO(CaracteristiquesDto caracteristiquesDto) {
        this.caracteristiquesDto = caracteristiquesDto;
    }

    public HerosCreationDTO() {
    }

    @Override
    public String toString() {
        return "HerosCreationDTO{" +
                "caracteristiquesDto=" + caracteristiquesDto +
                '}';
    }
}
