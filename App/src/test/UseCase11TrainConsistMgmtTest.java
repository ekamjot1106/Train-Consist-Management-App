package test;

import main.UseCase11TrainConsisntMgmt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmtTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsisntMgmt.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsisntMgmt.validateTrainID("TRAIN12"));
        assertFalse(UseCase11TrainConsisntMgmt.validateTrainID("TRN12A"));
        assertFalse(UseCase11TrainConsisntMgmt.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsisntMgmt.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsisntMgmt.validateCargoCode("PET-ab"));
        assertFalse(UseCase11TrainConsisntMgmt.validateCargoCode("PET123"));
        assertFalse(UseCase11TrainConsisntMgmt.validateCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsisntMgmt.validateTrainID("TRN-123"));
        assertFalse(UseCase11TrainConsisntMgmt.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsisntMgmt.validateCargoCode("PET-Ab"));
        assertFalse(UseCase11TrainConsisntMgmt.validateCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsisntMgmt.validateTrainID(""));
        assertFalse(UseCase11TrainConsisntMgmt.validateCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(UseCase11TrainConsisntMgmt.validateTrainID("TRN-1234X"));
        assertFalse(UseCase11TrainConsisntMgmt.validateCargoCode("PET-ABC"));
    }
}