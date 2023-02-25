package domain;

import adapter.in.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

public class ConvertJavaObjectToJson {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        HerosCreationDTO dto = new HerosCreationDTO(new CaracteristiquesDto(SpecialiteDto.Tank, RareteDto.Commun));

        try {
            mapper.writeValue(new File("offre.json"), dto);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
