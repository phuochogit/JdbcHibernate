package util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrefixIdGeneratorEnterprises implements IdentifierGenerator {

    private static final String PREFIX = "202101"; // Fixed numeric prefix
    private static final int NUMERIC_PART_LENGTH = 4; // Length of the numeric part after the prefix

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        // Define a regex pattern to extract the numeric part of the ID
        Pattern pattern = Pattern.compile(PREFIX + "(\\d+)");
        
        // Query to get the maximum ID with the given prefix
        String maxId = (String) session.createQuery("select coalesce(max(id), :prefix) from Enterprises")
                .setParameter("prefix", PREFIX + "0") // Default value to handle empty case
                .uniqueResult();

        if (maxId != null) {
            // Extract the numeric part using regex
            Matcher matcher = pattern.matcher(maxId);
            Integer numericPart = 0;
            if (matcher.find()) {
                // Extract the numeric part from the ID
                String numericStr = matcher.group(1);
                numericPart = Integer.parseInt(numericStr);
            }
            // Increment the numeric part and format it
            String nextIdNumericPart = String.format("%0" + NUMERIC_PART_LENGTH + "d", numericPart + 1);
            return PREFIX + nextIdNumericPart;
        }
        // If no IDs are present, start with the first number
        return PREFIX + String.format("%0" + NUMERIC_PART_LENGTH + "d", 1); // Start with the first number
    }
}
