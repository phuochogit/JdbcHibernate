package util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class PrefixIdGeneratorGiangVien implements IdentifierGenerator {

    private static final long PREFIX = 2021010258L; // Fixed numeric prefix

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        // Get the maximum ID from the database
        Long maxId = (Long) session.createQuery("select coalesce(max(id), :prefix) from GiangVien")
                .setParameter("prefix", PREFIX - 1) // Use PREFIX - 1 to handle the case where no records exist
                .uniqueResult();

        if (maxId != null) {
            // Extract the current numeric part from the maxId
            Long numericPart = maxId - PREFIX; 
            // Increment the numeric part and format it
            return PREFIX + numericPart + 1;
        }
        // If no IDs are present, start with the first number
        return PREFIX + 1;
    }
}
