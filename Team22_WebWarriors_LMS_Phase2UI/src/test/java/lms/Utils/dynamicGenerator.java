package lms.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dynamicGenerator {
	
	public static String generateProgramNameForEdit() {
        String baseProgName = "WebWQa";
        String timestamp = generateTimestamp();
        String uniqueName = baseProgName + timestamp;
        return uniqueName;
    }

    public static String generateProgramNameForDelete() {
        String baseProgName = "DelWQa";
        String timestamp = generateTimestamp();
        String uniqueName = baseProgName + timestamp;
        return uniqueName;
    }
    
    public static String generatebatchNameForAdd() {
        String baseBatchName = "AddWebQa";
        String timestamp = generateTimestamp();
        String uniqueName = baseBatchName + timestamp;
        return uniqueName;
    }

    private static String generateTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date now = new Date();
        return sdf.format(now);
    }
    
}


