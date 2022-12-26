package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Specialite {
    Tank,
    Assassin,
    Mage,

    Specialite() {};

    public String get_specialite() {
        return this.name();
    }
}
