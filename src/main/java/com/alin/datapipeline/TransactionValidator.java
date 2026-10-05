package com.alin.datapipeline;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TransactionValidator {

    private final Set<String> validCountries = new HashSet<>(Arrays.asList(
            "AF", "AL", "DZ", "AS", "AD", "AO", "AI", "AQ", "AG", "AR",
            "AM", "AW", "AU", "AT", "AZ", "BS", "BH", "BD", "BB", "BY",
            "BE", "BZ", "BJ", "BM", "BT", "BO", "BQ", "BA", "BW", "BV",
            "BR", "IO", "BN", "BG", "BF", "BI", "CV", "KH", "CM", "CA",
            "KY", "CF", "TD", "CL", "CN", "CX", "CC", "CO", "KM", "CG",
            "CD", "CK", "CR", "CI", "HR", "CU", "CW", "CY", "CZ", "DK",
            "DJ", "DM", "DO", "EC", "EG", "SV", "GQ", "ER", "EE", "SZ",
            "ET", "FK", "FO", "FJ", "FI", "FR", "GF", "PF", "TF", "GA",
            "GM", "GE", "DE", "GH", "GI", "GR", "GL", "GD", "GP", "GU",
            "GT", "GG", "GN", "GW", "GY", "HT", "HM", "VA", "HN", "HK",
            "HU", "IS", "IN", "ID", "IR", "IQ", "IE", "IM", "IL", "IT",
            "JM", "JP", "JE", "JO", "KZ", "KE", "KI", "KP", "KR", "KW",
            "KG", "LA", "LV", "LB", "LS", "LR", "LY", "LI", "LT", "LU",
            "MO", "MG", "MW", "MY", "MV", "ML", "MT", "MH", "MQ", "MR",
            "MU", "YT", "MX", "FM", "MD", "MC", "MN", "ME", "MS", "MA",
            "MZ", "MM", "NA", "NR", "NP", "NL", "NC", "NZ", "NI", "NE",
            "NG", "NU", "NF", "MK", "MP", "NO", "OM", "PK", "PW", "PS",
            "PA", "PG", "PY", "PE", "PH", "PN", "PL", "PT", "PR", "QA",
            "RE", "RO", "RU", "RW", "BL", "SH", "KN", "LC", "MF", "PM",
            "VC", "WS", "SM", "ST", "SA", "SN", "RS", "SC", "SL", "SG",
            "SX", "SK", "SI", "SB", "SO", "ZA", "GS", "SS", "ES", "LK",
            "SD", "SR", "SJ", "SE", "CH", "SY", "TW", "TJ", "TZ", "TH",
            "TL", "TG", "TK", "TO", "TT", "TN", "TR", "TM", "TC", "TV",
            "UG", "UA", "AE", "GB", "US", "UM", "UY", "UZ", "VU", "VE",
            "VN", "VG", "VI", "WF", "EH", "YE", "ZM", "ZW"
    ));

    // Check if a single transaction is valid
    // It is valid if it does not return any of the error resons
    public boolean validateTransaction(Transaction transaction) {
        return getValidationError(transaction) == null;
    }

    // Check if the transaction error returns an error type
    // Use the enum class you created and check in which type it falls under
    // Then use this function above to check if transaction is valid or not
    public ValidationError getValidationError(Transaction transaction){

        if (transaction.getId() <= 0) {
            return ValidationError.INVALID_ID;
        }
        if (transaction.getUserId() <= 0) {
            return ValidationError.INVALID_USER_ID;
        }
        if (transaction.getAmount() <= 0){
            return ValidationError.INVALID_AMOUNT;
        }
        if (transaction.getCountry() == null  || !validCountries.contains(transaction.getCountry())) {
            return ValidationError.INVALID_COUNTRY;
        }
        if (transaction.getTimestamp() == null) {
            return ValidationError.INVALID_TIMESTAMP;
        }
        return null;
    }
}

