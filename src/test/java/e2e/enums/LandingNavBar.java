package e2e.enums;

import lombok.Getter;

@Getter
public enum LandingNavBar {
    ABOUT("About"),
    PRICING("Pricing"),
    DEMO("Demo"),
    CONTACT("Contact");

    public final String value;
    LandingNavBar(String value) {
        this.value = value;
    }
}
