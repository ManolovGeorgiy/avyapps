package e2e.enums;

import lombok.Getter;

@Getter
public enum FooterLinks {
    ABOUT("About"),
    PRICING("Pricing"),
    DEMO("Demo"),
    CONTACT("Contact"),
    PRIVACY_POLICY("Privacy Policy"),
    TERMS_AND_CONDITIONS("Terms & Conditions"),
    HELP("Help"),
    FACEBOOK("facebook"),
    TWITTER("twitter"),
    LINKEDIN("linkedIn");

    private final String value;

    FooterLinks(String value) {
        this.value = value;
    }
}
